import numpy as np

class Affine:
    # 초기화
    def __init__(self, W, b):
        self.params = [W, b] # W는 weight, b는 bias

    # 순전파
    def forward(self, x):
        W, b = self.params
        # 행렬곱 + bias => 이때 + b 는 broadcasing 됨
        return np.matmul(x, W) + b