#include "ArrayStack.h"

void error(char* str ) {
	fprintf(stderr, "%s\n", str);
	exit(1);
}

void initStack( Stack* s )	{
	s->top = -1;
	return;
}

boolean isEmpty( Stack* s )		{
	if (s->top == -1) return TRUE;
	else return FALSE;
}

boolean isFull( Stack* s )		{
	if (s->top == (MAX_STACK_SIZE-1))	return TRUE;
	else return FALSE;
}

int size( Stack* s ){
	if (isEmpty(s))	return ERROR;
	return s->top+1;
}

void push ( Stack* s, Element e ) {
	if (isFull(s)) {
		printf("\n현재 Stack이 꽉 차 있습니다!!\n");
	}else {
		s->data[++s->top] = e;
	}
	return;
}

Element pop ( Stack* s ) {	
	if (isEmpty(s)) {
		return ERROR;
	}
	else return s->data[s->top--];
}

Element peek ( Stack* s ){
	if (isEmpty(s))	return ERROR;
	else return s->data[s->top];
}

void display ( Stack* s, char* msg ) {
	printf("%s[%2d]\n", msg, size(s)) ;
	printf("현재 스택에 남은 요소들 : ");
	for (int i=0 ; i<=s->top ; i++ )
		printElem(s->data[i]);
	printf("\n");
}