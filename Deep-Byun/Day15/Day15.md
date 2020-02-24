# Convolution Neural Network
  
valid padding : padding을 안 줄 때 !!  
=> 프레임워크에서 valid = True 이면 padding이 없는 경우 !!  


## Transpose Convolution Layer
  
왜 트랜스포즈를 쓰느냐??  
=> Interpolation : 픽셀과 픽셀 사이에 중간값을 추가해줌으로써 이미지를 복원해줌  
=> Direct Convolution :   
  
Transpose Conv가 어디서 쓰일까?? : 디코더에서 쓰인다고 함.  
뭘 위한 디코더인가?? : 오토인코더에서 버터플라이 형태 중 왼쪾에서는 컨볼루션 레이어,   
오른쪽은 Transpose Conv를 사용하는 것.  
  
=> Generate Model을 만들 떄 많이 사용된다  
  
## Box and Whisker Plot  
  
### Mean  
  
Mean의 치명적인 단점 : 아웃라이어에 의해 많이 바뀔 수 있다.  
  
아웃라이어에 영향을 거의 받지 않는 Median을 많이 선호한다  
  
### Quartile  
  
![quartile](https://www.onlinemathlearning.com/image-files/xmedian-quartiles.png.pagespeed.ic.QqE7uKQxYQ.png)  
  
### IQR (Inter Quartile Range)  
  
상위 25% 에서 75%까지의 범위  
  
### 1.5 * IQR  
  
아웃라이어를 제외한 범위  
  
Boxplot은 Box와 1.5 * IQR 까지 수염(Whisker)을 그려준다  
  
## **HOG** (Histogram of Oriented Gradients) 
  
![hog](https://i.stack.imgur.com/qpgms.png)
  
Classic한 **Feature Extractor** 중의 하나이다.  

![fe](https://images.deepai.org/glossary-terms/1db68a74ce8c4eb083d76199aef2e051/feature-extraction.jpg)
  
좋은 피쳐란 ?   
:: Classifier가 거의 일을 하지 않아도 될 정도로 클래스간에 차이가 명확한 피쳐  
**"Good feature should be informative, invariant to noise and a set of transformationsm abd fast to compute."**  

컴퓨터 비전에서 가장 중요한 것은 Edge Detection이다.  

![edge-filter](https://lh3.googleusercontent.com/proxy/vIop6X3BG7d48dGDtCq7gv4vaZRNxBaZzw1Io9hSi7VlZ_ildAqRiCm1msLMXJx6Z-dveuSW3t6wnDliFborGM0xFdiM1PBUnEIyZ0IyR96FgB8GG6KWlMnOtvva_qLiAY7H3VOH_bPK3iUXSKP5FzMSPVeqKsE3-n9AySklKs356FlJRLglnbFLy-r0nTk3SZ3w1LAqa3nWG5xR61Pul09h1Usa50rHbNBluimqbaZE-EoKnJpescEQUygK57mIFa1B8C7qEfgVUisJT3PNn1j0KlOQxVfTPVK7XTJxuLU)  
  
이렇게 Edge-Detect한 값에 대해서, dx, dy 를 구한 뒤에  
arctangent(dy / dx) 를 구하면 변한 방향(?)을 알 수 있다.
  
![arctangent](data:image/png;base64,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)
  
8x8의 Hog의 Histogram  
![histogram](https://i.imgur.com/EbXbVQl.png)  
  
이러한 개 80칸이 있다고 하면, 80개의 Histogram  
  
## Block Normalization  
  
노이즈에 둔감해지기 위하여 Block 사이즈 만큼을 묶어서 Block 단위로 Normalization을 해준다.    
이 때, 각도만을 구하기 위해서는 벡터의 Normalization (유닛벡터화)를 해준다. (자신의 크기로 나눠준다)  
  
## HOG Feature
  
![hog-feature](https://www.learnopencv.com/wp-content/uploads/2016/12/hog-visualization.png)  
  
이렇게 HOG Feature를 넣어주게 되면, 그냥 Raw 한 데이터를 넣어주는 것보다 Nosie에 Robust한 피쳐를 넣어줄 수 있다.  
  
