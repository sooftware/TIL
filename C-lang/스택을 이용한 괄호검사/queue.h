/*
*			2019-03-07
*			KwangWoon University 2014707073 김수환
*			c언어로 구현한 Queue
*/

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_SIZE 20	/* Queue 최대용량 */

typedef int boolean; 
typedef int object;
typedef struct __queue{
	int ptr; /* Queue 포인터(쌓여있는 요소의 개수-1) */
	object *queue; /* 스택 첫 요소에 대한 포인터 (배열포인터) */
}Queue;


void CreateQueue(Queue *q); /* MAX_SIZE의 공백큐를 생성한다 */
void InitQueue(Queue *q);   /* 큐를 초기화한다 */
boolean IsEmpty(Queue *q);  /* 큐가 비어있으면 TRUE */
boolean IsFull(Queue *q);   /* 큐가 다 차있으면 TRUE */
int Peek(Queue *q);         /* 큐의 꼭대기 Data를 return 없으면 -1 */
void EnQueue(Queue *q, object data);  /* 큐의 끝에 data 추가 */
int DeQueue(Queue *q);  /* 큐의 맨 앞에 있는 data를 반환하고 삭제 */
void PrintQueue(Queue *q);        /* 큐의 모든 요소를 print */
void TerminateQueue(Queue *q);    /* 큐 동적할당 해제 */
int Size(Queue *q);               /* 큐의 사이즈 return */
int Search(Queue *q); 	          /* 찾고자하는 data의 큐에서의 index return */

/* MAX_SIZE의 공백큐를 생성한다 */
void CreateQueue(Queue *q){
	q->ptr=0;
	q->queue=calloc(MAX_SIZE,sizeof(object));
	if(q->queue==NULL){
		printf("## Queue 생성 실패!!\n\n");
	}
	return;
}

/* 큐를 초기화한다 */
void InitQueue(Queue *q){
	q->ptr=0;
	return;
}

/* 큐가 비어있으면 TRUE */
boolean IsEmpty(Queue *q){
	if(q->ptr==0){
		return TRUE;
	}
	return FALSE;
}

/* 큐가 다 차있으면 TRUE */
boolean IsFull(Queue *q){
	if(Size(q)==MAX_SIZE){
		return TRUE;
	}
	return FALSE;
}

/* 큐의 끝에 data 추가 */
void EnQueue(Queue *q, object data){
	if (IsFull(q)) {
		printf("## 큐가 이미 꽉 차 있습니다!!\n\n");
		return;
	}
	q->queue[q->ptr++]=data;
	return;
}

/* 큐의 맨 앞에 있는 data를 반환하고 삭제 (핵심) */
int DeQueue(Queue *q){
	if (IsEmpty(q)) {
		printf("## 큐가 비어있습니다\n\n");
		return -1;
	}

	int result=q->queue[0];
	
	for(int i=0;i<q->ptr;i++){
		q->queue[i]=q->queue[i+1];
	}
	q->ptr--;
	return result;	
}

/* 큐의 꼭대기 Data를 return 없으면 -1 */
int Peek(Queue *q){
	if(IsFull){
		return q->queue[MAX_SIZE-1];
	}
	return -1;
}

/* 큐의 모든 요소를 print */
void PrintQueue(Queue *q){
	printf("## Queue의 모든 요소\n\n");
	for(int i=0;i<q->ptr;i++){
		printf("%d ",q->queue[i]);
	}
	printf("\n");
	return;
}

/* 큐의 사이즈(요소 개수) return */
int Size(Queue *q){
	return q->ptr;
}

/* 큐 동적할당 해제 */
void TerminateQueue(Queue *q){
	if(q->queue != NULL){
		free(q->queue);
		q->ptr=0;	
	}
	return;
}

/* 찾고자 하는 data의 큐에서의 index return,없으면 -1 */
int Search(Queue *q){
	object data=0;
	boolean find=FALSE;
	int index=0;

	do{
		printf("## 찾고싶은 data : ");
		scanf("%d",&data);

		for(int i=0;i<q->ptr;i++){
			if(q->queue[i]==data){
				return i;		
			}
		}
		printf("\n## 해당 data가 없습니다!! 다시 입력해주세요!\n\n");
	}while(!find);
	return 0;
}












