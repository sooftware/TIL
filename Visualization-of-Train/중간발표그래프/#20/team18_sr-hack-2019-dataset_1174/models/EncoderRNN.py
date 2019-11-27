import sys
import math
import torch.nn as nn

from .baseRNN import BaseRNN

class EncoderRNN(BaseRNN):
    r"""
    Applies a multi-layer RNN to an input sequence.

    Args:
        vocab_size (int): size of the vocabulary
        max_len (int): a maximum allowed length for the sequence to be processed
        hidden_size (int): the number of features in the hidden state `h`
        input_dropout_p (float, optional): dropout probability for the input sequence (default: 0)
        dropout_p (float, optional): dropout probability for the output sequence (default: 0)
        n_layers (int, optional): number of recurrent layers (default: 1)
        bidirectional (bool, optional): if True, becomes a bidirectional encodr (defulat False)
        rnn_cell (str, optional): type of RNN cell (default: gru)
        variable_lengths (bool, optional): if use variable length RNN (default: False)
        embedding (torch.Tensor, optional): Pre-trained embedding.  The size of the tensor has to match
            the size of the embedding parameter: (vocab_size, hidden_size).  The embedding layer would be initialized
            with the tensor if provided (default: None).
        update_embedding (bool, optional): If the embedding should be updated during training (default: False).

    Inputs: inputs, input_lengths
        - **inputs**: list of sequences, whose length is the batch size and within which each sequence is a list of token IDs.
        - **input_lengths** (list of int, optional): list that contains the lengths of sequences
            in the mini-batch, it must be provided when using variable length RNN (default: `None`)

    Outputs: output, hidden
        - **output** (batch, seq_len, hidden_size): tensor containing the encoded features of the input sequence
        - **hidden** (num_layers * num_directions, batch, hidden_size): tensor containing the features in the hidden state `h`

    Examples::

         >>> encoder = EncoderRNN(input_vocab, max_seq_length, hidden_size)
         >>> output, hidden = encoder(input)

    """

    def __init__(self, feature_size, hidden_size,
                 input_dropout_p=0, dropout_p=0,
                 n_layers=1, bidirectional=False, rnn_cell='gru', variable_lengths=False, diff_layer_size = 0):
        super(EncoderRNN, self).__init__(0, 0, hidden_size,
                input_dropout_p, dropout_p, n_layers, rnn_cell)

        self.variable_lengths = variable_lengths
        self.diff_layer_size = diff_layer_size
        self.conv = nn.Sequential(
            nn.Conv2d(1, 32, kernel_size=(41, 11), stride=(2, 2), padding=(20, 5)),
            nn.BatchNorm2d(32),
            nn.Hardtanh(0, 20, inplace=True),  # ReLU로 바꿔봄!!
            nn.Conv2d(32, 32, kernel_size=(21, 11), stride=(2, 1), padding=(10, 5)),
            nn.BatchNorm2d(32),
            nn.Hardtanh(0, 20, inplace=True), # ReLU로 바꿔봄!!,
        )

        feature_size = math.ceil((feature_size - 11 + 1 + (5*2)) / 2)
        feature_size = math.ceil(feature_size - 11 + 1 + (5*2))
        feature_size *= 32

        # Bidirectional이면 Num_layer는 2배이다!!

        self.rnn = self.rnn_cell(feature_size, hidden_size, n_layers,
                                 batch_first=True, bidirectional = bidirectional, dropout = dropout_p)

        '''
        GRU
        
        num_directions : bidirectional이면 2 아니면 1
        
        input1 : (L,N,H_in) H_in == input_size, L == sequence length
        input2 : (S,N,H_out) H_out == hidden_size, S == num_layer * num_directions if the RNN is bidirectional
        Output1 : (L,N,H_all) H_all == num_directions * hidden_size
        Output2 : (S,N,H_out) tensor containing the next hidden state for each element in the batch
        
        input1 -> input
        input2 -> h_0
        
        output1 -> output
        output2 -> h_n
        
        즉,
        output은 (feature_size,  Batch(?), Hidden_size)
        hidden은 (num_layers * num_directions, Batch(?), Hidden_size)
        -> print(output.shape)
        -> print(hidden.shape)
        
        hidden 은 context!! -> 주변 cell
        output 은 타겟!! -> 해당 cell
        '''


    def forward(self, input_var, input_lengths=None):
        """
        Applies a multi-layer RNN to an input sequence.

        Args:
            input_var (batch, seq_len): tensor containing the features of the input sequence.
            input_lengths (list of int, optional): A list that contains the lengths of sequences
              in the mini-batch

        Returns: output, hidden
            - **output** (batch, seq_len, hidden_size): variable containing the encoded features of the input sequence
                          => (32, 257, 512)
            - **hidden** (num_layers * num_directions, batch, hidden_size): variable containing the features in the hidden state h
                          => (16, 32, 512)
        """
        
        input_var = input_var.unsqueeze(1)
        x = self.conv(input_var)
        x = x.transpose(1, 2)
        x = x.contiguous()
        sizes = x.size()
        x = x.view(sizes[0], sizes[1], sizes[2] * sizes[3])
        if self.training:
            self.rnn.flatten_parameters()

        output, hidden = self.rnn(x)
        # 여기 수정 가능
        return output, hidden
