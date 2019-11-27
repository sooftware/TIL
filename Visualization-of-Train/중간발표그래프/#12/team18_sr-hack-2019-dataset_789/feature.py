import torch
import numpy as np
import librosa
import wavio
from scipy.fftpack import dct

PRE_EMPHASIZE = 0.97
FRAME_SIZE = 0.025
FRAME_STRIDE = 0.01
SAMPLE_RATE = 16000
N_FFT = 512

def _pre_emphaesize(filepath):
    signal = np.memmap(filepath, dtype = 'h', mode = 'r')
    emphasized_signal = np.append(signal[0], signal[1:] - PRE_EMPHASIZE * signal[:-1])
    return emphasized_signal

def _framing(emphasized_signal):
    frame_length, frame_step = FRAME_SIZE * SAMPLE_RATE, FRAME_STRIDE * SAMPLE_RATE  # Convert from seconds to samples
    signal_length = len(emphasized_signal)
    frame_length = int(round(frame_length))
    frame_step = int(round(frame_step))
    num_frames = int(np.ceil(float(np.abs(signal_length - frame_length)) / frame_step))  # Make sure that we have at least 1 frame

    pad_signal_length = num_frames * frame_step + frame_length
    z = np.zeros((pad_signal_length - signal_length))
    pad_signal = np.append(emphasized_signal, z) # Pad Signal to make sure that all frames have equal number of samples without truncating any samples from the original signal

    indices = np.tile(np.arange(0, frame_length), (num_frames, 1)) + np.tile(np.arange(0, num_frames * frame_step, frame_step), (frame_length, 1)).T
    frames = pad_signal[indices.astype(np.int32, copy=False)]
    return frames, frame_length

def _windowing(frames, frame_length):
    frames *= np.hamming(frame_length)
    return frames

def _stft(frames):
    mag_frames = np.absolute(np.fft.rfft(frames, N_FFT))  # Magnitude of the FFT
    pow_frames = ((1.0 / N_FFT) * ((mag_frames) ** 2))  # Power Spectrum
    return pow_frames

def _filter_bank(pow_frames, n_mel = 40):
    low_freq_mel = 0
    high_freq_mel = (2595 * np.log10(1 + (SAMPLE_RATE / 2) / 700))  # Convert Hz to Mel
    mel_points = np.linspace(low_freq_mel, high_freq_mel, n_mel + 2)  # Equally spaced in Mel scale
    hz_points = (700 * (10**(mel_points / 2595) - 1))  # Convert Mel to Hz
    bin = np.floor((N_FFT + 1) * hz_points / SAMPLE_RATE)

    fbank = np.zeros((n_mel, int(np.floor(N_FFT / 2 + 1))))
    for m in range(1, n_mel + 1):
        f_m_minus = int(bin[m - 1])   # left
        f_m = int(bin[m])             # center
        f_m_plus = int(bin[m + 1])    # right

        for k in range(f_m_minus, f_m):
            fbank[m - 1, k] = (k - bin[m - 1]) / (bin[m] - bin[m - 1])
        for k in range(f_m, f_m_plus):
            fbank[m - 1, k] = (bin[m + 1] - k) / (bin[m + 1] - bin[m])
    filter_banks = np.dot(pow_frames, fbank.T)
    filter_banks = np.where(filter_banks == 0, np.finfo(float).eps, filter_banks)  # Numerical Stability
    filter_banks = 20 * np.log10(filter_banks)  # dB
    return filter_banks

# Mel-filterbank
def Mel_filterbank(filepath, n_mels = 40):
    emphasized_signal = _pre_emphaesize(filepath)
    frames, frame_length = _framing(emphasized_signal)
    frames = _windowing(frames, frame_length)
    pow_frames = _stft(frames)
    filter_banks = _filter_bank(pow_frames, n_mel = n_mels)
    filter_banks -= (np.mean(filter_banks, axis=0) + 1e-8)
    feat = torch.FloatTensor(filter_banks)
    return feat

# 네이버 피쳐
def get_spectrogram_feature(filepath):
  (rate, width, sig) = wavio.readwav(filepath)
  sig = sig.ravel()

  stft = torch.stft(torch.FloatTensor(sig),
                      N_FFT,
                      hop_length = int(0.01*SAMPLE_RATE),
                      win_length = int(0.030*SAMPLE_RATE),
                      window = torch.hamming_window(int(0.030*SAMPLE_RATE)),
                      center = False,
                      normalized = False,
                      onesided = True)

  stft = (stft[:,:,0].pow(2) + stft[:,:,1].pow(2)).pow(0.5);
  amag = stft.numpy();
  feat = torch.FloatTensor(amag)
  feat = torch.FloatTensor(feat).transpose(0, 1)

  return feat

# librosa 멜스펙트로그램
def get_librosa_melspectrogram(filepath, n_mels = 128):
    hop_length = 128
    sig, sr = librosa.core.load(filepath, SAMPLE_RATE)
    mel_spectrogram = librosa.feature.melspectrogram(sig, n_mels = n_mels, n_fft = N_FFT, hop_length = hop_length)
    mel_spectrogram = torch.FloatTensor(mel_spectrogram).transpose(0, 1)
    return mel_spectrogram

def get_librosa_mfcc(filepath, n_mfcc = 40):
    hop_length = 128
    sig, sr = librosa.core.load(filepath, SAMPLE_RATE)
    mfccs = librosa.feature.mfcc(y = sig, sr = sr, hop_length = 128, n_mfcc = n_mfcc, n_fft = N_FFT)
    mfccs = torch.FloatTensor(mfccs).transpose(0, 1)
    return mfccs

# Moon-Sung-Woo Feature
def get_melspectrogram_feature(filepath):
    data = np.memmap(filepath, dtype = 'h', mode = 'r')
    speech_samples_norm = data / np.max(data)
    winlen = int(SAMPLE_RATE * .03)  # Window size of 30 ms
    specX = librosa.stft(speech_samples_norm, win_length = winlen)
    Xdb = librosa.amplitude_to_db(abs(specX), ref = np.max)
    feat = torch.FloatTensor(Xdb)
    feat = torch.FloatTensor(feat).transpose(0, 1)
    return feat