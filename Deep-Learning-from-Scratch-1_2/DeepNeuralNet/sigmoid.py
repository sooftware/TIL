import numpy as np

class Sigmoid:
    def __init__(self):
        self.params = list()
        
    def forward(self, x):
        return 1 / (1 + np.exp(-x))