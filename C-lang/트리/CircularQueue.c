#include "CircularQueue.h"

void error( char* str ) {
	fprintf(stderr, "%s\n", str);
	exit(1);
};

void initQueue( Queue* q )	{ q->front = q->rear = 0; ; }
int isEmpty( Queue* q )		{ return q->front == q->rear;; }
int isFull( Queue* q )		{ return (q->rear+1)%MAX_QUEUE_SIZE == q->front; }
int size( Queue* q )		{ return ((q->rear-q->front)+MAX_QUEUE_SIZE)%MAX_QUEUE_SIZE; }

void enqueue( Queue* q, Element val ) {
	if( isFull(q) ) error("  큐 포화 에러");
	q->rear = (q->rear+1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = val;
}
Element dequeue( Queue* q ) {	
	if( isEmpty(q) ) error("  큐 공백 에러");
	q->front = (q->front+1) % MAX_QUEUE_SIZE;
	return q->data[q->front];
}
Element peek( Queue* q ){
	if( isEmpty(q) ) error("  큐 공백 에러");
	return q->data[(q->front+1) % MAX_QUEUE_SIZE];
}
void display( Queue* q, char* msg ) {	
	int i, maxi = q->rear;
	if (q->front >=  q->rear) maxi += MAX_QUEUE_SIZE;
	printf( "%s[%2d]= ", msg, size(q));
	for( i = q->front+1 ; i<=maxi ; i++ )
		printElem(q->data[i%MAX_QUEUE_SIZE]);
	printf( "\n");
}

