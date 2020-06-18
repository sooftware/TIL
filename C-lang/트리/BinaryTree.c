/*
		KwangWoon University
		전자통신공학과 2014707073 김수환
		자료구조 및 알고리즘 Homework#2
*/

#include "BinaryTree.h"
#include "CircularQueue.h"	// 레벨순회: 제공된 circular queue 코드 활용

// ===============================================================
// 개인 편의를 위한 정의들
#define TRUE 1
#define FALSE 0
#define isNULL(n)	(n == NULL)
#define notNULL(n)	(n != NULL)
#define isExist(q)	!isEmpty(&q)
#define LineAlignment	printf("\n")
#define nulloc(e)	e = NULL;
#define SHIFT(n)	(1<<n)
#define and &&
#define or ||


typedef int boolean;

void initTree( BinTree* t )	{ nulloc(t->root); }

//================================================================
// 트리의 기본적인 정보 계산
int	getCount(BinTree* t)	{ return countNode(t->root); }
int	getLeafCount(BinTree* t){ return countLeaf(t->root); }
int	getHeight(BinTree* t)	{ return calcHeight(t->root); }

//================================================================
// 트리의 순회
void printInOrder(BinTree* t)	{ printf("   inorder: "); inorder(t->root); printf("\n"); }
void printPreOrder(BinTree* t)	{ printf("  preorder: "); preorder(t->root); printf("\n"); }
void printPostOrder(BinTree* t)	{ printf(" postorder: "); postorder(t->root);  printf("\n"); }

/* 레벨 순회 */
void printLevelOrder(BinTree* t) {
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;

	if (isNULL(t)) return;
	printf("levelorder: ");
	enqueue(&q, ptr);
	while (isExist(q)) {
		ptr = dequeue(&q);
		printf("[%c] ",ptr->data);
		if (ptr->left)
			enqueue(&q, ptr->left);
		if (ptr->right)
			enqueue(&q, ptr->right);
	}
	LineAlignment;
}

//================================================================
// 완전이진트리 여부 검사
boolean isFullTree(BinTree* t) {
	boolean ret = TRUE;
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;
	boolean flag = TRUE;	//	순서대로 진행중일때 TRUE!
							//	순서대로 진행됐지만, NULL이 나온 순간 FALSE!
							//	FALSE일때 레벨순회를 하여, 만약 데이터가 존재한다면 완전이진트리가 아니다!

	if (isNULL(t))
		return TRUE;

	enqueue(&q, ptr);
	while (isExist(q)) {
		ptr = dequeue(&q);
		if (flag) {
			if (notNULL(ptr->left and notNULL(ptr->right))) {
				enqueue(&q, ptr->left);
				enqueue(&q, ptr->right);
			}
			else if (isNULL(ptr->left) and notNULL(ptr->right)) {
				ret = FALSE;
				break;
			}
			else if (notNULL(ptr->left) and isNULL(ptr->right)) {
				enqueue(&q, ptr->left);
				flag = FALSE;
			}
			else if (isNULL(ptr->left) and isNULL(ptr->right)) {
				flag = FALSE;
			}
		}
		else {
			if (notNULL(ptr->left) or notNULL(ptr->right)) {
				ret = FALSE;
				break;
			}
		}
	}

	if (ret) printf("\n완전 이진 트리입니다.\n\n");
	else printf("\n완전 이진 트리가 아닙니다.\n\n");
	return ret;
}

//================================================================
// 노드의 레벨 계산
int calcLevel(BinTree* t, TNode* n) {
	int level = 0;
	boolean memory_update = TRUE;
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;
	TNode *memory = NULL;
	if (isNULL(t)) return level;

	enqueue(&q, ptr);
	level++;
	while (isExist(q)) {
		ptr = dequeue(&q);
		if (memory == ptr) {
			memory_update = TRUE;
			level++;
		}

		if (ptr == n) break;
		
		if (ptr->left) {
			if (memory_update) {
				memory = ptr->left;
				memory_update = FALSE;
			}
			enqueue(&q, ptr->left);
		}
		if (ptr->right) {
			if (memory_update) {
				memory = ptr->right;
				memory_update = FALSE;
			}
			enqueue(&q, ptr->right);
		}
	}

	if (level > 0) printf("%c : 노드의 레벨은 %d.\n",n->data , level);
	else printf("트리에 없는 노드입니다.\n");

	return level;

}