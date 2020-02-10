# logit
odds에 log를 붙여 확률의 비율을 표현하는 방법  
* log + Odds
[0, 무한대)의 범위를 가진 odd에  Log를 취하여 [-무한대, 무한대]의 범위를 갖도록 해줌  

logit을 softmax에 먹여주면 확률이 나옴 !!  
레이어의 마지막은 항상 Softmax를 먹여야 확률이 나온다 !!

# Convolution VS Correlation
![cvsc](https://lh3.googleusercontent.com/proxy/OEwJIzF1Zx0DiZAM8AooAb8RDLn6qzTjlvq5rqWS35HH8pXDXgldaLgM9WEqxeAYoq2chcDn_xBrw2KH7QuQwspk3mkBILd5q6-QM9kj3zKAe_82jN84Whrif7iVBn7BVqbCK56R4VhVyL7nuh8yKNIYSgvqS5AsXeSQoNdS44nAcAQ3BuOcCDoR)
컨볼루션은 어떤 필터를 통과했을때 결과를 말해주는 식  
먹일때 순서대로 먹이려고 뒤집는다 !!!  

예를 들어서, "안녕하세요" 라는 음성이라면 어떤 필터에 먹일 때,  
"요세하녕안" 이라고 먹여야지 안녕하세요 순서로 먹일 수 있다.  

Convolution과 Correlation은 뒤집느냐 안 뒤집느냐의 차이이다. 

Correlation 같은 위치끼리 곱해서 얼마나 닮아있는지를 구한다.  
=> Correlation은 신호에 노이즈가 섞여있어도 탐지하기 쉽다 !!  

그래서 Correlation Filter는 뒤집으지 않은 필터로 서로 곱하면서 유사도를 구한다.  
(반대로 Convolution은 필터를 뒤집어 준 채로 곱해준다)  

### Softmax의 Backpropagation은 모든 입력이 관여한다.  

![_](https://postfiles.pstatic.net/MjAyMDAyMTBfMjgg/MDAxNTgxMzM1NDI3OTMz.gYAVUqhCgDqz_PK0UD1EUvgSDRQiKvJoNiNUqbSlL-gg.jc4-HeWk15rlL1l8hjGHweaftQMafjZ6X_KWPMYIFuIg.JPEG.sooftware/KakaoTalk_20200210_204912872_01.jpg?type=w773)

![__](https://postfiles.pstatic.net/MjAyMDAyMTBfNzcg/MDAxNTgxMzM1NDI3ODk4.Ajkuz1VD7f2TDVY-GrSfFihuhW1NVNMIgXUuh0LnMxIg.mpjneOEDyxXEkDEwBhTwCZJQ4dSUmfsGBc2MdASlG5Eg.JPEG.sooftware/KakaoTalk_20200210_204912872_02.jpg?type=w773)
