# Day6
오늘은 Likelihood에 대해 알아봅시다.
Linear Regression이 Polynomial이 포함된다고 보는 사람들도 있다.

1. Polynomial은 Linear Regression에서 조금 달라진 개념이구나.
2. 오버피팅

피쳐를 $x1, x2, x3$ 가 아닌, $x, x^2, x^3$과 같이 사용한다는 것만 다르다.

어떤 문제집의 문제를 Generalization이 아닌, 해당 문제의 풀이 과정 전체를 외워버리면,
다른 문제집을 봤을 때 문제를 풀지 못한다는 단점 => 오버피팅

## Overfitting
Overfitting : 노이즈까지 학습해버린다..

Regression의 목표는 새로 들어오는 데이터에 대해서 맞추는 것이지 트레이닝 데이터에 대해서 맞추는 것이 아니다.

트레이닝셋의 정확도가 테스트셋의 정확도와 차이가 너무 심하게 난다면 오버피팅 의심해야한다.

MNIST에서 히든 사이즈가 500만 되도 되는데 성능을 높이려고 1,000을 설정해버리면,  
오버피팅이 날 수 있다.   

오버피팅을 방지하는 방법은 역시 데이터셋을 많이 모으는 것이다 !!  
근본적으로 오버피팅이 발생하는 이유는 데이터셋이 적기 때문이다.  

그렇다면 데이터를 좀 더 넣어주면 해결이 될 텐데.. 어떻게 해야하느냐?
 => **Augmentation**을 적용하면 해결이 될 수 있다 !!

## Weight Decay

얘도 결국은 오버피팅을 방지하기 위해 나온 개념  
EMS에 패널티를 추가해준 개념 !!
차원이 늘어나는 거에 대해 Penalty를 준다 !!
=> 어떤 벡터의 파라미터가 너무 큰 값을 가지게 되면 패널티를 준다 
  
$\lambda$에 $log$를 씌운다  
=> 이 $\lambda$를 어떻게 정해주느냐도 learning rate처럼 되게 민감한 문제이다  

*  Weight Decay는 Gradient Descent를 적용하기 힘들다  
=> 동글동글한 cost 모양을 만들기가 힘들다  

## Probability & Likelihood  
논문 볼 때 더 높은 수준의 이해를 위해 확률을 확실히 합시다  

### Probability vs Likelihood  
Likelihood : 일어날 법한 정도
Probability : 확률  

둘이 뭐가 다를까?  
Probability는 내가 어떤 한 데이터를 뽑았을 때 관심있는 32-34g의 데이터를 뽑을 확률 !!
Likelihood는 어떤 Distribution에서 나올 확률이 크냐를 측정하기 위한 확률 !!

Probability는 이미 정규분포를 가지고 있는 상태 !!
Likelihood는 내가 가지고 있는 데이터가 어떤 모델(분포)에서 나올 확률이 높은지?

### Maximum Likelihood
아하! 그래서 데이터 하나하나에 대해서 어떤 모델이 가장 자신을 뽑을 확률이 높은지를  
평균을 내서 가장 확률이 높았던 모델을 뽑았다면? => 이게 모델을 선택하는 것이 된다  

MLE에서도 공부했듯이 우리가 한 Linear Regression은 Maximum Likelihood에 해당한다.  

Probability : $pr(data|distribution)$ 
Likelihood : $L(distribution|data)$

근데 Probability와 Likelihood의 식이 같다..??
왜일까??  여기에 대해서는 추후에 다시 와서 이해해볼 것

데이터의 각각의 Likelihood를 모두 곱해서 가장 큰 Likelihood를 구하자!
=> Maximum Likelihood Estimation !!

$log$를 취해주게 되면 미분이든 적분이든 뭐든 각각 해줘버리면 된다 !!  
경식이형이 열심히 유도한 결과 데이터의 평균이 최대가능도의 평균 값이 된다 !!
평균과 표준편차를 구하기 너무 쉽다 !! 그 데이터의 평균과 표준편차를 적용하면 된다 !!

MLE를 사용할 때 데이터의 평균과 표준편차를 모델의 평균과 표준편차로 사용하면 된다!

우리는 MLE & MAP를 Tom M. Mitchell 교수님이 설명하신 방식으로 접근해보자.
MAP의 가장 중요한 점은 prior를 적용했느냐 안했느냐가 가장 직관적으로 이해가 쉬움

prior 비율을 똑같이 주더라도 scalar를 얼마나 크게 주느냐에 따라 더 강조도 가능

### MLE vs MAP
둘의 차이는 Prior (사전지식) 의 유무라는 것 다시 한번 짚고 넘어갈 것 !!


## Activation Function

Linear한 부분만 가지고 레이어를 쌓으면 식을 전개해보면 결국은
하나의 층과 같다.    

+로 Sigmoid를 적용하게 되면 Outlier의 영향력을 조금 무시할 수 있게됨
그리고 확률의 개념을 도입하게 됨

