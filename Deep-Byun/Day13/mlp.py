import torch.nn as nn

class Mlp(nn.Module):
    def __init__(self, dropout_p):
        super(Mlp, self).__init__()
        self.layer = nn.Sequential(
            nn.Linear(28 * 28, 512),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(512),
            nn.Linear(512, 256),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(256),
            nn.Linear(256, 256),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(256),
            nn.Linear(256, 128),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(128),
            nn.Linear(128, 64),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(64)
        )
        self.classifier = nn.Sequential(
            nn.Linear(64, 32),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(32),
            nn.Linear(32, 16),
            nn.Hardtanh(0, 20, inplace=True),
            nn.BatchNorm1d(16),
            nn.Linear(16, 10),
            nn.Hardtanh(0, 20, inplace=True),
            nn.LogSoftmax(dim=1)
        )
        self.dropout = nn.Dropout(dropout_p)

    def forward(self, x):
        x = self.dropout(x)
        x = self.layer(x)
        y_hat = self.classifier(x)
        return y_hat