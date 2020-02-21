import torch.optim as optim
import torch.nn as nn
import torch
import time
from tqdm import trange
from torch.utils.data import DataLoader
from torchvision import datasets, transforms
from mlp import Mlp
import logging, sys
logger = logging.getLogger('root')
FORMAT = "[%(asctime)s %(filename)s:%(lineno)s - %(funcName)s()] %(message)s"
logging.basicConfig(stream=sys.stdout, level=logging.DEBUG, format=FORMAT)
logger.setLevel(logging.INFO)
if torch.cuda.is_available():
    device = torch.device('cuda')
else:
    device = torch.device('cpu')

def load_dataset(batch_size=12, mean=0.5, std=1):
    transform = transforms.Compose([
        transforms.ToTensor(),
        transforms.Normalize((mean,), (std,))
    ])
    train_dataset = datasets.MNIST('../mnist_data/', transform=transform, download=True, train=True)
    valid_dataset = datasets.MNIST('../mnist_data/', transform=transform, download=True, train=False)

    train_loader = DataLoader(dataset=train_dataset, batch_size=batch_size, shuffle=True)
    valid_loader = DataLoader(dataset=valid_dataset, batch_size=batch_size, shuffle=True)

    return train_loader, valid_loader

if __name__ == '__main__':
    max_epochs = 10
    batch_size = 12

    train_loader, valid_loader = load_dataset(batch_size=batch_size, mean=0.5, std=1)

    model = Mlp(dropout_p=0.5)

    optimizer = optim.Adam(model.parameters(), lr=0.001)
    criterion = nn.NLLLoss(reduction='sum').to(device)

    for epoch in range(max_epochs):
        begin = time.time()
        total_loss = 0.0
        total_time_step = len(train_loader)

        for time_step, (x, target) in enumerate(train_loader):
            optimizer.zero_grad()
            y_hat = model(x.view(x.size(0), -1))
            loss = criterion(y_hat, target)
            loss.backward()
            optimizer.step()

            if time_step % 100 == 0:
                correct = 0
                total = 0
                with torch.no_grad():
                    total_valid_loss = 0.0
                    for j, (valid_x, valid_target) in enumerate(valid_loader):
                        valid_output = model(valid_x.view(valid_x.size(0), -1))
                        if valid_output is None:
                            continue
                        valid_loss = criterion(valid_output, valid_target)
                        total_valid_loss += valid_loss
                        _, output_index = torch.max(valid_output, 1)
                        total += valid_target.size(0)
                        correct += (output_index == valid_target).sum().float()

                logger.info("epoch: {}/{}, step: {}/{}, val loss: {:.4f}, val Accuracy : {:.4f}".format(
                    epoch, max_epochs,
                    time_step, total_time_step,
                    total_valid_loss / len(valid_loader),
                    100 * correct / total
                ))
