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
|teacher_forcing ratio|clean WER (%)|noisy WER (%)|  
|---|:---:|:---:|  
|1.0|16.2|19.0|   
|0.9|14.1|16.5|   
   
### Apply Language Model
|teacher_forcing ratio|clean WER (%)|noisy WER (%)|  
|---|:---:|:---:|  
|1.0|12.6|14.7|   
|0.9|10.3|12.0|   
