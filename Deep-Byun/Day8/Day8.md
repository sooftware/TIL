# Neuron

## Activate Function

Sigmoid & tanh는 애매한걸 싫어한다 !!  
그래서 50% 정도의 확률일 때 굉장히 빠른 속도로 학습된다,  

### Sigmoid
![sigmoid](https://i.stack.imgur.com/inMoa.png)

### tanh
![tanh](https://postfiles.pstatic.net/MjAyMDAxMjRfNjgg/MDAxNTc5Nzk5NzE5ODQ0.vImogoUPDCjrjfVeJolwojU-_84Ph3BySArpblP6yAAg.Jc5d4tgSzHUUBK2waPtCiBuK3r3bjId4B4egU7_fAF8g.PNG.sooftware/image.png?type=w773)

People say, tanh superior than sigmoid !!   

### ReLU
![relu](https://cdn-images-1.medium.com/max/1026/0*n_ZGycAljU90iweS.png)
일단 이놈은 계산이 간편하다 !!  
=> Sigmoid나 tanh에 비해 연산이 5배 정도 빠르다고 한다  

근데 이놈은 x = 0에서 미분이 불가능하다.
근데 역전파를 어떻게 하지? => 맘놓고 쓰시오.
컴퓨터가 정확히 0.000000x가 나올 일은 거~~~~의 없다





