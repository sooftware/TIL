import numpy as np
from baseRNN import RNN

class TimeRNN:
    def __init__(self, Wx, Wh, b, stateful=False):
        self.params = [Wx, Wh, b]
        self.grads = [np.zeros_like(Wx, np.zeros_like(Wh), np.zeros_like(b))]
        self.layers = None

        # RNN의 마지막 Hidden State와 dh를 저장하는 변수
        self.h, self.dh = None, None
        # RNN의 은닉 상태를 유지해야 할지를 결정하는 변수
        # stateful 이 True면, 은닉 상태 유지, stateful이 False면 은닉 상태 초기화
        self.stateful = stateful

    # RNN의 Hidden State 설정
    def set_state(self, h):
        self.h = h

    # RNN의 Hidden State 초기화
    def reset_state(self):
        self.h = None

    def forward(self, xs):
        Wx, Wh, b = self.params
        # N : 미니배치
        # T : 시계열 데이터의 수
        # D : 입력 벡터 차원 수
        N, T, D = xs.shape  # xs.shape = NxTxD
        D, H = Wx.shape  # Wx.shape = DxH

        self.layers = list()
        # hs는 Hidden State들의 집합
        hs = np.empty((N, T, H), dtype='f')

        # RNN 계층 처음 호출 시 워소 모두 0으로 초기화
        # or stateful == False 일 때도 0으로 초기화
        if not self.stateful or self.h is None:
            self.h = np.zeros((N,H), dtype='f')

        for t in range(T):
            layer = RNN(*self.params)
            # xs[:,t,:].shape == NxD
            # RNN.forward()에서 x는 NxD, Wx는 DxH 였던 점 기억
            self.h = layer.forward(xs[:,t,:], self.h)
            hs[:, t, :] = self.h
            self.layers.append(layer)

        return hs

    # Truncated BPTT
    def backward(self, dhs):
        Wx, Wh, b = self.params
        N, T, H = dhs.shape
        D, H = Wx.shape

        dxs = np.empty((N, T, D), dtype='f')
        dh = 0  # 맨 처음 dh는 0 (Truncated BPTT이기 때문)
        grads = [0, 0, 0]  # [dWx, dWh, db] 초기화

        for t in reversed(range(T)):
            layer = self.layers[t]
            dx, dh = layer.backward(dhs[:, t, :] + dh) # 합산된 기울기
            dxs[:, t, :] = dx

            # RNN.grads -> [dWx, dWh, db]
            for i, grad in enumerate(layer.grads):
                grads[i] += grad

        for i, grad in enumerate(grads):
            self.grads[i][...] = grad
        # 마지막 Differentiate Hidden State
        # 현재는 필요없지만 뒤에서 seq2seq에 필요하기 때문에 저장
        self.dh = dh
        return dxs