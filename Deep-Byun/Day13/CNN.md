# Introduction to CNN

## 영상신호처리 vs 컴퓨터 비전

소자를 다루는게 영상신호처리, 이걸 이용해서 뭔가를 만드는게 컴퓨터 비전  
  
## Filter  
  
신호및시스템, DSP 등에서 일차원에서의 필터를 배웠지만,  
이미지는 2차원에서의 필터라고 생각하면 된다  
  
X축 필터, Y축 필터 등 많은 필터가 존재한다.  

* CNN Building Blocks

n = { (n + 2p - f) / s } + 1
  
p : padding  
s : stride  
  
### Padding  
정보의 손실을 막기 위함  
  
### Stride
   
몇 칸씩 건너 뛰느냐 (default 1)

### Pooling
  
Max Pooling, Average Pooling을 많이 쓴다  
보통 피쳐가 많으면 Average Pooling을 쓴다고 한다  
=> 또한 MaxPooling은 파라미터가 없다    

### Kernel (Filter)
  
필터사이즈는 보통 홀수로 둔다.  
=> 왜냐하면 홀수여야 중앙값이 있다 !! -> 은근 중요한 팁 !!  
==> 홀수 by 홀수    
  
### Channel  
  
몇 개의 필터를 사용할 것인지,,  
64개의 채널이면 64개의 필터로 64개의 아웃풋이 나오는 Convolution  


## CNN을 왜 쓰는가??
  
### Filter Sharing & Local Sparsity  
  
파라미터가 매우 적어진다. (필터를 재탕한다)  
=> Filter size가 3 by 3 이면 파라미터는 9개일 뿐 !!  
  
