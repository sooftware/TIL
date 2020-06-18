/*
				2019-02-20~2019-02-21
				KwangWoon University 2014707073 김수환
				c언어로 구현한 Stack
*/

#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int max;	/* 최대용량 */
	int ptr;	/* 스택포인터 (쌓여있는 요소의 개수) */
	int *stk;	/* 스택 첫 요소에 대한 포인터 (배열포인터) */
}Stack;

/* 스택 초기화 */
int Initialize(Stack *s);

/* 스택에 데이터 Push */
void Push(Stack *s, int data);

/* 스택에서 데이터 Pop */
int Pop(Stack *s);

/* 스택 비우기 */
void Clear(Stack *s);

/* 스택의 최대 용량 */
int Capacity(Stack *s);

/* 스택이 비어있는지 확인 */
int IsEmpty(Stack *s);

/* 스택이 꽉 차 있는지 확인 */
int IsFull(Stack *s);

/* 스택에서 데이터 검색 */
int Search(Stack *s,int data);

/* 스택 모든 요소 출력 */
void Print(Stack *s);

/* 스택 종료 및 동적할당 해제 */
void Terminate(Stack *s);

/* 스택 Peek */
int Peek(Stack *s);

/* 스택에 들어있는 요소 개수 */
int Size(Stack *s);

/* Stack 변수 초기화 함수 */
int Initialize(Stack *s) {
	printf("Stack 최대용량 : ");
	scanf("%d", &s->max);
	s->ptr = 0;
	s->stk = calloc(s->max, sizeof(int));
	if (s->stk == NULL) {
		s->max = 0;
		printf("## Stack 배열 생성 실패!!");
		return -1;
	}
	return 0;
}

/* Stack이 비어있는지 확인 함수 */
int IsEmpty(Stack *s) {
	if (s->ptr == 0) return 1;
	else return 0;
}

/* Stack이 꽉 차 있는지 확인 함수 */
int IsFull(Stack *s) {
	if (s->ptr == s->max) {
		return 1;
	}
	else return 0;
}

/* Stack의 최대 용량 */
int Capacity(Stack *s) {
	return s->max;
}

/* Stack에 Push */
void Push(Stack *s,int data) {
	if (s->ptr < s->max) {
		/* 스택이 가르키는 배열에서 s->ptr(쌓여있는 개수) index에 데이터 추가 */
		s->stk[s->ptr] = data;
		s->ptr++;
	}
	else {
		printf("## Stack이 꽉 차 있습니다!!\n");
	}
	return;
}

/* Stack에서 Pop */
int Pop(Stack *s) {
	if (s->ptr == 0) {
		printf("## Stack에 들어있는 요소가 없습니다!!\n");
		return -1;
	}
	return s->stk[--s->ptr];
}

/* Stack 해제 */
void Terminate(Stack *s){
	if(s->stk!=NULL){
		free(s->stk);
		s->max=s->ptr=0;
	}
	return;
}

/* Stack 출력 */
void Print(Stack *s){
	int i=0;

	if(s->ptr!=0){
		for(i=0;i<s->ptr;i++){
			printf("%d ", s->stk[i]);
		}
	}else{
		printf("### Print할 Stack이 없습니다.\n");
	}
	return;
}

/* Stack 비우기 */
void Clear(Stack *s){
	s->ptr=0; // Stack Terminate와는 다르게
		  // 최대용량은 유지한다.
	return;
}

/* Stack 검색 */
int Search(Stack *s,int data){
	int i;
	for(i=0;i<s->ptr;i++){
		if(s->stk[i]==data)
			return i+1;
	}
	return -1;
}

/* Stack Peek (꼭대기 엿보기) */
int Peek(Stack *s){
	if(s->ptr==s->max){
		return s->stk[s->ptr-1];
	}
	return -1;
}

/* Stack 요소 개수  */
int Size(Stack *s){
	return s->ptr;
}
