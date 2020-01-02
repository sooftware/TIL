import numpy as np

class LSTM:
    def __init__(self, Wx, Wh, b):
        self.params = [Wx, Wh, b]
        self.grads = [np.zeros_like(Wx), np.zeros_like(Wh), np.zeros_like(b)]
        self.cache = None

    def forward(self, x, h_prev, c_prev):
        Wx, Wh, b = self.params
        N, H = h_prev.shape  # N : mini-batch size, H : hidden size

        # Affine Transformation
        # x : NxD, Wx : Dx4H, h_prev : NxH, Wh : Hx4H, affine : Nx4H
        affine = np.matmul(x, Wx) + np.matmul(h_prev, Wh) + b

        # slice
        f = affine[:, :H]
        g = affine[:, H:2*H]
        i = affine[:, 2*H:3*H]
        o = affine[:, 3*H:]

        f = np.sigmoid(f)
        g = np.tanh(g)
        i = np.sigmoid(i)
        o = np.sigmoid(o)

        c_next = f * c_prev + g * i
        h_next = o * np.tanh(c_next)

        self.cache = (x, h_prev, c_prev, i, f, g, o, c_next)
        return h_next, c_next