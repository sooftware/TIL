/*
									2019-03-23 ~ 2019-03-24
									KwangWoon University 2014707073 김수환
									c언어로 구현하는 Tree
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX 30
#define TRUE 1
#define FALSE 0

typedef char element;
typedef int boolean;

typedef struct __node {
	char name[MAX];
	struct __node *left;
	struct __node *right;
	struct __node *top;
}Node;

typedef struct __tree {
	Node *seed;
	Node *current;
}Tree;

/* 트리의 시발점을 만드는 함수 */
void Seed(Tree *tree);

/* 트리의 노드를 만드는 함수 */
Node* MakeNode();

/* 유저에게 문자열을 입력받는 함수 */
void InputString(char str[]);

/* 트리의 현재위치에서 하위 트리 생성 */
void MakeSubTree(Tree *tree);

/* 현재위치(current)의 트리 동적할당 해제 */
void DeleteCurrentTree(Tree *tree);

/* 현재위치의 하위 트리를 동적할당 해제 */
void DeleteSubTree(Tree *tree);

/* 트리 작동 확인용 */
void TestTree(Tree *tree);

/* 유저에게 보여주는 UI */
int ShowChoiceList();

/* 새로운 노드를 만들고 해당 노드 포인터를 반환 */
Node* MakeNode() {
	return (Node*)calloc(1, sizeof(Node));
}

/* 트리 seed를 만드는 함수 */
void Seed(Tree *tree) {
	tree->seed = MakeNode();
	printf("Seed Name : ");
	InputString(tree->seed->name);
	tree->seed->left = NULL;
	tree->seed->right = NULL;
	tree->seed->top = NULL;
	return;
}

/* 하위 트리를 만드는 함수 */
void MakeSubTree(Tree *tree) {
	if (tree->current->left != NULL) {
		printf("Left Tree Exist!!\n");
	}
	else {
		tree->current->left = MakeNode();
		tree->current->left->top = tree->current;
		printf("Left Tree Name : ");
		while (getchar() != '\n');
		InputString(tree->current->left->name);
	}
	if (tree->current->right != NULL) {
		printf("Right Tree Exist!!\n");
	}
	else {
		tree->current->right = MakeNode();
		tree->current->right->top = tree->current;
		printf("Right Tree Name : ");
		InputString(tree->current->right->name);
	}
	return;
}



/* 문자열을 입력받아서 char 배열에 넣어주는 함수 */
void InputString(char str[]) {
	char ch = '\0';
	int i = 0;
	while (ch != '\n') {
		ch = getchar();
		str[i++] = ch;
	}
	return;
}

/* Tree 이름을 print하는 함수 */
void PrintName(Tree tree) {
	char ch = '\0';
	int i = 0;
	while(1){
		printf("%c", tree.current->name[i++]);
		if (tree.current->name[i] == '\n') {
			printf("\n");
			return;
		}
	}
}

/* 하위 폴더를 printf */
void PrintSubTree(Tree tree) {
	char ch = '\0';
	int i = 0;

	if (tree.current->left == NULL || tree.current->right == NULL) {
		puts("\n하위 폴더가 없습니다!!\n");
		return;
	}

	while (1) {
		if (tree.current->left->name[i] == '\n') {
			printf("\t");
			break;
		}
		printf("%c", tree.current->left->name[i++]);
	}
	i = 0;
	while (1) {
		if (tree.current->right->name[i] == '\n') {
			printf("\n");
			break;
		}
		printf("%c", tree.current->right->name[i++]);
	}
}

/* Tree 동작확인용 */
void TestTree(Tree *tree) {
	tree->current = tree->seed;
	int choice = 0;

	while (TRUE) {
		do {
			choice = ShowChoiceList();
		} while (choice < 1 || choice>8);

		switch (choice) {
		case 1:
			tree->current = tree->current->left;
			break;
		case 2:
			tree->current = tree->current->right;
			break;
		case 3:
			PrintSubTree(*tree);
			break;
		case 4:
			MakeSubTree(tree);
			break;
		case 5:
			tree->current = tree->current->top;
			break;
		case 6:
			DeleteSubTree(tree);
			break;
		case 7:
			PrintName(*tree);
			break;
		case 8:
			DeleteCurrentTree(tree);
			return;
		}
	}
}

/* 선택용 list */
int ShowChoiceList() {
	int choice;
	puts("\n>>> 1. 왼쪽 Tree로 진입\n");
	puts(">>> 2. 오른쪽 Tree로 진입\n");
	puts(">>> 3. 하위 Tree 출력\n");
	puts(">>> 4. 하위 Tree 만들기\n");
	puts(">>> 5. 상위 Tree로\n");
	puts(">>> 6. 하위 Tree 삭제\n");
	puts(">>> 7. 현재 Tree 출력\n");
	puts(">>> 8. 종료\n");
	scanf_s("%d", &choice);
	return choice;
}

/* 현재 current tree 동적할당 해제 */
void DeleteCurrentTree(Tree *tree){
	free(tree->current);
}

/* 현재 current tree의 sub tree 동적할당 해제 */
void DeleteSubTree(Tree *tree) {
	free(tree->current->left);
	free(tree->current->right);
	return;
}