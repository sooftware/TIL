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