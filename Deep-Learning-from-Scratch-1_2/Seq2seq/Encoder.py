import numpy as np
import torch.nn as nn

class Encoder:
    def __init__(self, vocab_size, wordvec_size, hidden_size):
        V, D, H = vocab_size, wordvec_size, hidden_size
        rn = np.random.randn

        enbed_W = (rn(V, D) / 100).astype('f')
        lstm_Wx = ((rn(D, 4*H)) / np.sqrt(D)).astype('f')
        lstm_Wh = ((rn(H, 4 * H)) / np.sqrt(H)).astype('f')
        lstm_b = np.zeros(4*H).astype('f')
        self.embed = nn.Embedding(enbed_W)
        self.lstm =