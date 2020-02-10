##### Check Overfitting for various n_neuron
import numpy as np
import torch
import torch.nn as nn
from torch.utils.data import DataLoader

from dataset import ToyDataset
from utils import dataset_generator, tester

np.random.seed(0)
torch.manual_seed(0)

x_train_data, y_train_data, x_test_data, y_test_data = dataset_generator()

class MlpClassifier(nn.Module):
    def __init__(self):
        super(MlpClassifier, self).__init__()
        self.fcn = nn.Sequential(
            nn.Linear(2, 10),
            nn.Linear(10, 8),
            nn.ReLU(),
            nn.Linear(8, 2)
        )

    def forward(self, inputs):
        return self.fcn(inputs)

device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
train_dataset = ToyDataset(inputs=x_train_data, targets=y_train_data)
test_dataset = ToyDataset(inputs=x_test_data, targets=y_test_data)
train_loader = DataLoader(train_dataset, batch_size = 32, shuffle = True, num_workers = 0, drop_last = False)
test_loader = DataLoader(test_dataset, batch_size = 32, shuffle = True, num_workers = 0, drop_last = False)

model = MlpClassifier()
loss_func = nn.CrossEntropyLoss()
optimizer = torch.optim.Adam(model.parameters(), lr = 0.01)

loss_arr = []

for epoch in range(100):
    print("Epoch%s start" % str(epoch))
    for x, y in train_loader:
        x = x.float().to(device)
        y = y.long().to(device)
        optimizer.zero_grad()
        output = model.forward(x)
        loss = loss_func(output, y)
        loss.backward()
        optimizer.step()
    loss_arr.append(loss.cpu().detach().numpy())

print(loss_arr)

trained_dict = model.state_dict()
tester(x_train_data, y_train_data, model, trained_dict)