import numpy as np
from sigmoid import Sigmoid
from affine import Affine

class TwoLayerNet:
    def __init__(self, input_size, hidden_size, output_size):
        I, H, O = input_size, hidden_size, output_size

        # weight와 bias 초기화
        W1 = np.random.randn(I, H) # IxH
        b1 = np.random.randn(H) # 각 행에 bias1 플러스
        W2 = np.random.randn(H, O)  # HxO
        b2 = np.random.randn(O) # 각 행에 bias2 플러스

        # Layer 생성
        self.layers = [
            Affine(W1, b1),
            Sigmoid(),
            Affine(W2, b2)
        ]

        self.params = list()
        for layer in self.layers:
            self.params += layer.params # Affine + Sigmoid + Affine

    # 추론
    def predict(self, x):
        for layer in self.layers:
            x = layer.forward(x)
        return x