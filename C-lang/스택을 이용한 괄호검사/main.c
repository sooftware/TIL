/*
*				KwangWoon University 전자통신공학과
*				2014707073 김수환
*				자료구조 Hw1 : c언어 Stack을 이용한 괄호 검사
*/

#define _CRT_SECURE_NO_WARNINGS		// fopen() 함수 ERROR 제거를 위한 define
#include "ArrayStack.h"

void parentheses_open(Stack *stack,Stack *check_stack, char open);											/*	 '(','{','[' case에 실행되는 함수	 */
void parentheses_close(Stack *stack, char open, char close);							/*	')','}',']' case에 실행되는 함수	 */
void asterisk_case(Stack *stack, boolean *bMLineCmt);									/*		 '*' case에 실행되는 함수		 */
void slash_case(Stack *stack, boolean *bLineCmt, boolean *bMLineCmt,Element memory);	/*		 '/' case에 실행되는 함수	     */
int bracketChecker(char* filename);													/*	넘겨받은 파일명의 파일 괄호검사 실행함수	 */		

/* main 함수 */
void main()
{
	//	각종 코드로 혹시 안 돌아가는 예외상황이 있는지를 체크 (( {{
	/* * {{[[   */
	// '''
	// "'"
	// ({[/
	/* ([/{[*/
	/*	*i/*i(({/[]]}/*oi*k/
	*****)(/*
	'''	{{{
	"	(({{]]]))/	//[/[/][/() {}
	*/
	printf("\n=============== 가지고 있는 c코드들로 TEST ===============\n\n");
	bracketChecker("ArrayStack.h");
	bracketChecker("ArrayStack.c");
	bracketChecker("3000LineTest.c");
	bracketChecker("main.c");
	bracketChecker("automobile.h");
	bracketChecker("InverseMatrix.c");
	bracketChecker("MyLinkedList.h");
	bracketChecker("stack.h");
	bracketChecker("queue.h");
	bracketChecker("tree.h");
	printf("\n\n=============== 일부러 오류내고 TEST ===============\n\n");
	bracketChecker("test.txt");
}

/*	넘겨받은 파일명의 파일 괄호검사 실행함수	 */
int bracketChecker(char* filename) {
	int nLine = 1, nChar = 0;	//	검사한 코드의 line수와 char수를 세는 변수로 사용.
	int parenthesesCount = 0;	//	( { [ 가 몇번이나
	//	bSingle -> '	bDouble -> "	bLineCmt -> //	bMLineCmt -> /*~*/
	boolean bSingle, bDouble, bLineCmt, bMLineCmt;	 
	char	ch;
	Stack	stack,check_stack;	//	stack은 ( { [ 가 들어가는 스택이고, check_stack은 / * 와 같은
								//	주석이나 따옴표와 같은 예외상황을 체크하기 위한 스택
	FILE *fp = fopen(filename, "r");
	Element memory = NULL;	//	직전에 왔던 값을 기억하기 위한 변수

	if (fp == NULL)
		error("Error: The file does not exist.\n");

	initStack(&stack);
	initStack(&check_stack);
	bSingle = bDouble = bLineCmt = bMLineCmt = FALSE;

	while ((ch = getc(fp)) != EOF) {
		nChar++;
		switch (ch) {
		case '"':
			if (!bSingle && !bMLineCmt && !bLineCmt) {
				if (bDouble) {
					bDouble = FALSE;		//	"가 앞에 나왔으면 쌍이 나왔으므로 bDouble 해제 //// test용 -> ( (((((
				}
				else bDouble = TRUE;
			}
			break;

		case 39:	// '의 아스키코드.  ''' 으로 했더니 오류가 나서 ASCII CODE로 함
			if (!bDouble && !bMLineCmt && !bLineCmt) {
				if (bSingle) {
					bSingle = FALSE;
				}
				else bSingle = TRUE;
			}
			break;

		case '/':
			if (!bLineCmt && !bSingle && !bDouble) {	//   ~~~ // /*와 같은 경우를 방지하기 위해. bLineCmt가 실행되고 난 뒤의 bMLineCmt는 예외처리를 해줘야 한다.
				slash_case(&check_stack, &bLineCmt, &bMLineCmt,memory);
			}
			break;

		case '*':
			asterisk_case(&check_stack, &bMLineCmt);
			break;

		case '\n':
			nLine++;
			bLineCmt = FALSE;	//	개행 문자 나왔으면 어쨌든 // 주석 모드 해제
			break;

		case '(': case '{':	case '[':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	따옴표, 주석 아닐때만 (,{,[ 를 집어넣는다.
				parenthesesCount++;	//	괄호들이 몇번이나 들어갔는지를 세어보고 싶어서 count
				parentheses_open(&stack,&check_stack, ch);
			}
			break;

			/* 아래부터는 닫는 부분 */

		case ')':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	따옴표, 주석 아닐때만 ),},] 를 집어넣는다.
				parentheses_close(&stack, '(', ')');
			}
			break;

		case '}':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	따옴표, 주석 아닐때만 ),},] 를 집어넣는다.
				parentheses_close(&stack, '{', '}');
			}
			break;

		case ']':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	따옴표, 주석 아닐때만 ),},] 를 집어넣는다.
				parentheses_close(&stack, '[', ']');
			}
			break;
		}
		memory = ch;
	}

	fclose(fp);
	printf("\n[%s] File check result:\n", filename);
	if (!isEmpty(&stack)) {
		printf("  Error found (#line=%d, #char=%d)\n\n", nLine, nChar);
		display(&stack, filename);
	}
	else
		printf("  Ok (#line=%d, #char=%d)\n", nLine, nChar);
	
	printf("\n  짝 맞은 괄호 갯수 : %d\n\n", parenthesesCount);
	fclose(fp);

	return isEmpty(&stack);
}

/*	')','}',']' case에 실행되는 함수	 */
void parentheses_close(Stack *stack, char open, char close) {
	if (peek(stack) == open) {	//	짝 찾았다
		pop(stack);		//  빼자
	}
	else {		// 여기에 들어오면 오류임 error표시
		push(stack, close);	
	}
	return;
}

/*	 '(','{','[' case에 실행되는 함수	 */
void parentheses_open(Stack *stack,Stack *check_stack, char open) {
	if (peek(check_stack) == '/') {	//	만약 /( 와같은 문자가 연속되서 스택에 '/' '('가 온다면 오류가 날 수 있으므로,
		pop(check_stack);
		push(stack, open);	//	들어올 수 있는 '/' '*' '(' '{' '[' 에서 입력될 때 '/' 다음에 '*'나 '/'이 아니면 pop해버리기 위함
	}
	else {						//	'/'이 아니네?
		push(stack, open);		//	새로 들어온 괄호도 넣어둔다.
	}
	return;
}

/*		 '*' case에 실행되는 함수		 */
void asterisk_case(Stack *stack, boolean *bMLineCmt) {
	/* bMLineCmt가 시작됬다면 */
	if (*bMLineCmt) {		//	/* 주석 시작하고나서 *이 들어오면
		push(stack, '*');	//	일단 Stack에 넣는다. 
	}
	/* bMLineCmt가 시작이 안됬다면 */
	else {
		if (peek(stack) == '/') {	//	/*이 연속됬다면!
			*bMLineCmt = TRUE;	//	/* 주석이다!	
			push(stack, '*');	//  /*이 맞다는 것을 판단 했으면 다시 '/'와 '*'을	
								//	push 해준다.
		}	//	'*'가 들어왔는데 앞에가 '/'이 아니면, 그냥 넘어가면 됨. -> 따로 else 안해줌	
	}
	return;
}

/*		 '/' case에 실행되는 함수	     */
void slash_case(Stack *stack, boolean *bLineCmt, boolean *bMLineCmt,Element memory) {
	/* bMLineCmt가 시작됬다면 bMLineCmt를 끝낼 수 있는 부분이다. */
	if (*bMLineCmt) {
		if (memory == '*') {	//	/*이 시작되었고 앞에 *이 왔고 지금 / 이 왔으니 bMLineCmt를 끝낼 때가 됬다.
			pop(stack);	//	peek의 밑에도 '*'이 있는지를 보기 위해 pop()
			if (peek(stack) == '*') {		//	왜냐하면 /*/의 경우를 방지
				*bMLineCmt = FALSE;			//	/* ~ */를 끝내는 부분이다.
				while (pop(stack) != '/');	//	'/'이 나올때까지 pop()을 한다.
			}
			else {
				push(stack, '*');		//	/*/이다! bMLineCmt 끝낼때가 아니다. -> 빼낸 *를 다시 넣는다.
			}
		}
	}
	/* bMLineCmt가 시작 안 된 평소 부분 */
	else {
		if (peek(stack) == '/') {	//	// 이 연속됬다면!
			pop(stack);
			*bLineCmt = TRUE;	//	// 주석이다!
		}
		else {						//	꺼내봤더니 앞에께 /이 아니다!
			push(stack, '/');		//	방금 들어온 '/'도 스택에 넣어둔다.
		}
	}
	return;
}