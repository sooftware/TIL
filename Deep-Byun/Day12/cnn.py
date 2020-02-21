import torch.nn as nn

class BaseCNN(nn.Module):
    def __init__(self):
        super(BaseCNN, self).__init__()
        self.conv = nn.Sequential(
            nn.Conv2d(in_channels=1, out_channels=9, kernel_size=3),
            nn.ReLU(True),
            nn.Conv2d(in_channels=9, out_channels=16, kernel_size=3),
            nn.ReLU(True),
            nn.MaxPool2d(2, 2),
            nn.Linear(12*12*16, 128),
            nn.ReLU(True),
            nn.Linear(128, 64),
            nn.ReLU(True),
            nn.Linear(64, 128),
            nn.LogSoftmax(dim = 1)
        )

    def forward(self, x):
        x = self.conv(x)