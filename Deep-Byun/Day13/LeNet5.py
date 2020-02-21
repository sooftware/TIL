import torch.nn as nn

class LeNet5(nn.Module):
    def __init__(self):
        self.conv = nn.Sequential(
            nn.Conv2d(in_channels=1, out_channels=6, kernel_size=5, padding=2),
            nn.AvgPool2d(kernel_size=2, stride=2),
            nn.Sigmoid(),
            nn.Conv2d(in_channels=6, out_channels=16, kernel_size=5),
            nn.AvgPool2d(kernel_size=2, stride=2),
            nn.Sigmoid(),
            nn.Conv2d(in_channels=16, out_channels=120, kernel_size=5),
            nn.Sigmoid()
        )
        self.fc = nn.Sequential(
            nn.Linear(in_features=120, out_features=84),
            nn.Linear(in_features=84, out_features=10),
            nn.LogSoftmax(dim=-1)
        )

    def forward(self, x):
        x = self.conv(x)
        y_hat = self.fc(x)
        return y_hat