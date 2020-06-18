#include "BinaryTree.h"

void main()
{
	BinTree tree;
	TNode *a, *b, *c, *d, *e, *f, *g, *h, *i, *j, *k, *l, *m, *n, *o, *p, *q, *r, *s;

	// 노드 생성  (Test)
	//           A
	//       B       C
	//     D   E   F   G
	//    H I J K L M N O
	//	         Q       P
	//          R S
	s = newNode('S', NULL, NULL);
	r = newNode('R', NULL, NULL);
	q = newNode('Q', r, s);
	p = newNode('P', NULL, NULL);
	o = newNode('O', NULL, p);
	n = newNode('N', NULL, NULL);
	m = newNode('M', NULL, NULL);
	l = newNode('L', NULL, NULL);
	k = newNode('K', NULL, q);
	j = newNode('J', NULL, NULL);
	i = newNode('I', NULL, NULL);
	h = newNode('H', NULL, NULL);
	d = newNode('D', h, i);
	e = newNode('E', j, k);
	f = newNode('F', l, m);
	g = newNode('G', n, o);
	b = newNode('B', d, e);
	c = newNode('C', f, g);
	a = newNode('A', b, c);

	// 트리 생성
	tree.root = a;

	// 기본적인 정보 출력
	printf("노드 개수 = %d\n", getCount( &tree ));
	printf("단말 개수 = %d\n", getLeafCount( &tree ));
	printf("트리 높이 = %d\n\n", getHeight( &tree ));

	// 트리 순회
	printInOrder( &tree );
	printPreOrder( &tree );
	printPostOrder( &tree );
	printLevelOrder( &tree );

	// 완전이진트리 여부 검사
	isFullTree(&tree);

	// 레벨 계산
	calcLevel(&tree, a);
	calcLevel(&tree, b);
	calcLevel(&tree, c);
	calcLevel(&tree, d);
	calcLevel(&tree, e);
	calcLevel(&tree, f);
	calcLevel(&tree, g);
	calcLevel(&tree, h);
	calcLevel(&tree, i);
	calcLevel(&tree, j);
	calcLevel(&tree, k);
	calcLevel(&tree, l);
	calcLevel(&tree, m);
	calcLevel(&tree, n);
	calcLevel(&tree, o);
	calcLevel(&tree, p);
	calcLevel(&tree, q);
	calcLevel(&tree, r);
	calcLevel(&tree, s);
}