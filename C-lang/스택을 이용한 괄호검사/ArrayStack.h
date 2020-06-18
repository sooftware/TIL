#pragma once
#include <stdio.h>
#include <stdlib.h>

#define MAX_STACK_SIZE 200	
#define Element	char 
#define printElem(e) printf("%c", e)
#define TRUE 1
#define FALSE 0		
#define ERROR -1	//	나오면 안 되는 결과가 나왔을 때 ERROR return

typedef int boolean;	//	TRUE, FALSE를 나타내는 변수 및 함수를 표시하기 위한 타입 재정의
typedef struct ArrayStack {
	Element	data[MAX_STACK_SIZE];
	int		top;
} Stack;

extern void error(char* str );
extern void initStack( Stack* s );
extern boolean isEmpty( Stack* s );
extern boolean isFull( Stack* s );
extern void push ( Stack* s, Element e );
extern Element pop ( Stack* s );
extern Element peek ( Stack* s );
extern int size( Stack* s );
extern void display ( Stack* s, char* msg );

// 괄호 갯수 13개 -> 제일 세기 쉬워서 제대로 동작하나 확인하기 위해 Test

