#ifndef BINARY_TREE_H
#define BINARY_TREE_H

#include "BinaryNode.h"

typedef struct BinaryTree {
	TNode*	root;
} BinTree;

extern void initTree( BinTree* t );

// 트리의 기본적인 정보 계산
extern int	getCount(BinTree* t);
extern int	getLeafCount(BinTree* t);
extern int	getHeight(BinTree* t);

// 트리 순회
extern void printInOrder(BinTree* t);
extern void printPreOrder(BinTree* t);
extern void printPostOrder(BinTree* t);
extern void printLevelOrder(BinTree* t);

// 완전이진트리 여부 검사
extern int isFullTree(BinTree* t);

// 노드의 레벨 계산
extern int calcLevel(BinTree* t, TNode* n);

#endif

