## Data 
    
|Category|hours|
|----|----|  
|train|2000h|  
|valid|10h|  
|test|16h|     
  
## Feature  
|Parameter|Use|   
|----|:----:|  
|feature_size|40|
|feature_extraction|log mel|  
|frame_length|10ms|   
  
  
## Hyperparameters
  
|Hyperparameter|Use|  
|----|:----:|  
|encoder_layer_size|3|  
|decoder_layer_size|2|  
|hidden_size|256|  
|batch_size|32|  
|teacher_forcing|1.0 & 0.9|  

## Performance  
  
### No Language Model
|teacher forcing (%)|clean WER (%)|noisy WER (%)|  
|:---:|:---:|:---:|  
|100|16.2|19.0|   
|90|14.1|16.5|   
   
### Apply Language Model
|teacher forcing (%)|clean WER (%)|noisy WER (%)|  
|:---:|:---:|:---:|  
|100|12.6|14.7|   
|90|10.3|12.0|   

|Model|clean WER (%)|noisy WER(%)|  
|:---:|:---:|:---:|  
|CLDNN-HMM (SOTA)|8.0|8.9|  
|LAS + Sampling + LM Rescoring|10.3|12.0|  


