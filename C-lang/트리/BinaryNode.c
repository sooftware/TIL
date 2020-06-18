/*
		KwangWoon University
		전자통신공학과 2014707073 김수환
		자료구조 및 알고리즘 Homework#2
*/

#include "BinaryNode.h"

// ================================================
// 개인 편의를 위한 정의들
#define TRUE 1
#define FALSE 0
#define MAX(a,b)	((a) > (b) ? (a) : (b))
#define SUM(a,b)	(a + b)
#define isNULL(n)	(n == NULL)
#define notNULL(n)	(n != NULL)
#define and	&&
typedef int boolean;

/* 단말노드 여부 반환 */
boolean	isLeaf(TNode* n) {
	return (isNULL(n->left) and isNULL(n->right)); 
}

/* 새로운 노드 생성 */
TNode* newNode(TreeData val, TNode* l, TNode* r) {
	TNode* n = (TNode*) malloc(sizeof(TNode));
	n->data = val;
	n->left = l;
	n->right = r;
	return n;
}

/* 트리의 노드 개수 계산 */
int countNode(TNode *n) {
	if (isNULL(n)) return 0;
	return 1 + SUM(countNode(n->left), countNode(n->right));
}

/* 트리의 단말노드 개수 계산 */
int countLeaf(TNode *n) {
	if (isNULL(n)) return 0;
	else if (isNULL(n->left) and isNULL(n->right)) return 1;
	else return SUM(countLeaf(n->left), countLeaf(n->right));
}

/* 트리의 높이 계산 */
int calcHeight(TNode *n) {
	if (isNULL(n)) return 0;
	else return 1 + MAX(calcHeight(n->left),calcHeight(n->right));
}

/* 중위 순회 */
void inorder(TNode *n) {
	if (notNULL(n)) {
		inorder(n->left);
		printTData(n->data);
		inorder(n->right);
	}
}

/* 전위 순회 */
void preorder(TNode *n) {
	if (isNULL(n)) return;
	printTData(n->data);
	preorder(n->left);
	preorder(n->right);
}

/* 후위 순회 */
void postorder(TNode *n) {
	if (isNULL(n)) return;
	postorder(n->left);
	postorder(n->right);
	printTData(n->data);
}