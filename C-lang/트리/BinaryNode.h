#ifndef BINARY_NODE_H
#define BINARY_NODE_H

#include <stdio.h>
#include <stdlib.h>

// 구조체 사용시 헤더파일 포함.
#define TreeData int
#define printTData(e) printf("[%c] ", e)

typedef struct BinTrNode {
	TreeData			data;		// 데이터 필드
	struct BinTrNode*	left;		// 왼쪽 자식
	struct BinTrNode*	right;		// 오른쪽 자식
} TNode;

extern TNode* newNode(TreeData val, TNode* l, TNode* r);
extern int	isLeaf(TNode* n);

extern int	countNode(TNode *n);
extern int	countLeaf(TNode *n);
extern int	calcHeight(TNode *n);

extern void	inorder(TNode *n);
extern void	preorder(TNode *n);
extern void	postorder(TNode *n);

#endif

