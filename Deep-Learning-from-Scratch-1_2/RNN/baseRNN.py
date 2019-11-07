import numpy as np

# 2019-11-01
# Basic RNN
class BaseRNN:
    def __init__(self, Wx, Wh, b):
        self.params = [Wx, Wh, b]
        self.grads = [np.zeros_like(Wx), np.zeros_like(Wh), np.zeros_like(b)]
        self.cache = None

    #  아래 공식으로 forward
    #  h = tanh( h_pre * Wh_pre + xWx + bias )
    #  h_pre : 이전 계층의 output, x : input, b : bias
    def forward(self, x, h_pre):
        Wx, Wh, b = self.params
        h = np.matmul(x, Wx) + np.matmul(h_pre, Wh) + b # bias -> broadcasting
        h = np.tanh(h)
        self.cache = (x, h_pre, h) # for Backpropagation
        return h

    #  Backpropagation Comment Start ====
    #
    #  dh는 뒤의 블록으로부터 넘겨받는다
    #  덧셈 계산그래프:
    #  y = x + z -> dy/dx = 1 , dy/dz = 1
    #  => y * 1 = y이므로 그냥 그대로 넘겨준다.
    #
    #  행렬곱 계산그래프
    #  y = x * z -> dy/dx = z, dy/dz = x
    #  => y * dy/dx = yz , y * dy/dz = yx
    #
    # ====================== Comment End
    def backward(self, dh):
        Wx, Wh, b = self.params
        x,  h_pre, h = self.cache

        #  tanh = { ( exp(x) - exp(-x) ) / ( exp(x) + exp(-x) ) }
        #  dtanh = 1 - tanh^2
        dtanh = dh * (1 - h ** 2)
        #  + b 는 broadcasting이 되기 때문에
        #  Backpropagation 계산 시 그냥 넘겨주는게 아니라 총합으로 계산한다
        db = np.sum(dtanh, axis = 0)
        dWh = np.matmul(h_pre.T, dtanh)
        dh_pre = np.matmul(dtanh, Wh.T)
        dWx = np.matmul(x.T, dtanh)
        dx = np.matmul(dtanh, Wx.T)

        self.grads[0][...] = dWx # deepcopy using ...
        self.grads[1][...] = dWh # deepcopy using ...
        self.grads[2][...] = db # deepcopy using ...

        return dx, dh_pre