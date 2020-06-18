#ifndef CIRCULAR_QUEUE_H
#define CIRCULAR_QUEUE_H

#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE	100

#include "BinaryNode.h"		// 구조체 사용시 헤더파일 포함.
#define Element	TNode*
#define printElem(e)	printf("[%c] ", e->data)

typedef struct CircularQueue {
	Element	data[MAX_QUEUE_SIZE];	// 요소의 배열
	int	front;					
	int	rear;					
} Queue;

extern void		error( char* str );
extern void		initQueue( Queue* s );
extern int		isEmpty( Queue* s );
extern int		isFull( Queue* s );
extern void		enqueue ( Queue* s, Element e );
extern Element	dequeue ( Queue* s );
extern Element	peek ( Queue* s );
extern int		size( Queue* s );
extern void		display ( Queue* s, char* msg );

#endif

