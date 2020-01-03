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

    def backward(self, dh_next, dc_next):
        Wx, Wh, b = self.params
        x, h_prev, c_prev, i, f, g, o , c_next = self.cache

        tanh_c_next = np.tanh(c_next)

        ds = dc_next+(dh_next*o) * (1-tanh_c_next**2)

        dc_prev = ds * f

        di = ds * g
        df = ds * c_prev
        dg = ds * i
        do = dh_next * tanh_c_next

        di *= i * (1 - i)  # dSigmoid
        df *= f * (1 - f)  # dSigmoid
        do *= o * (1 - o)  # dSigmoid
        dg *= (1 - g ** 2)  # dtanh

        dA = np.hstack((df, dg, di, do))

        dWh = np.dot(h_prev.T, dA)
        dWx = np.dot(x.T, dA)
        db = dA.sum(axis=0)

        self.grads[0][...] = dWx
        self.grads[1][...] = dWh
        self.grads[2][...] = db

        dx = np.dot(dA, Wh.T)
        dh_prev = np.dot(dA, Wh.T)

        return dx, dh_prev, dc_prev