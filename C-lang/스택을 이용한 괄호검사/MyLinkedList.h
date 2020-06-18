/*
*			2019-01-28~2019-01-29
*			KwangWoon University 2014707073 김수환
*			c언어로 구현한 LinkedList
*/
#include <stdio.h>
#include <stdlib.h>

/* data와 다음 노드 reference 저장할 구조체  */
typedef struct __node {
	int data;
	struct __node *next;
}Node;

/* 리스트 head와 tail 즉, 처음과 끝을 저장할 구조체 */
typedef struct __linkedlist {
	Node* head;
	Node* current;
}LinkedList;

void InitiateList(LinkedList *list);						//	list 초기화
Node* MakeNode();											//	새로운 Node 생성
void AddLinkedListEnd(LinkedList *list, int data);			//	list 끝에 요소 추가
void ShowLinkedList(LinkedList *list);						//	list의 모든 요소 출력
void FreeLinkedList(LinkedList *list);						//	list 동적할당 해제
void RemoveAllElements(LinkedList *list);					//	list의 모든 요소 삭제
void AddLinkedList(LinkedList *list, int index, int data);	//	원하는 index에 list 요소 삽입
void DeleteLinkedList(LinkedList *list, int index);			//	원하는 index list 요소 삭제
int GetLinkedList(LinkedList *list, int index);			//	원하는 index list 요소 get

/* 리스트 초기화 */
void InitiateList(LinkedList *list) {
	list->head = NULL;
	list->current = NULL;
}

/* 새로운 노드를 만들고 해당 노드 포인터를 반환 */
Node* MakeNode() {
	return (Node*)calloc(1, sizeof(Node));
}

/* 리스트 끝에 데이터 추가 */
void AddLinkedListEnd(LinkedList *list,int data) {
	/* 첫 데이터 삽입이라면 */
	if (list->head == NULL) {
		list->head = MakeNode();
		list->head->data = data;
		list->current = list->head;
	}	
	/* 보통(첫 데이터 삽입이 아니라면) */
	else {
		list->current->next = MakeNode();	//	노드를 생성하고, 현재리스트의 다음 주소에 노드 주소 저장
		list->current->next->data = data;	//	새로 만든 노드의 데이터에 추가할 값 저장
		list->current = list->current->next;	//	현재 노드를 새로 생성한 노드로 변경
		list->current->next = NULL;		//	새로 생성한 노드의 다음 노드에 NULL
	}
}

/* 리스트의 요소들을 화면에 보여주는 함수 */
void ShowLinkedList(LinkedList *list) {
	list->current = list->head;
	
	while (1) {
		if (list->head == NULL) {
			printf("list에 값이 없습니다!");
			return;
		}
		else if (list->current->next == NULL) {
			printf("%d\n", (int)list->current->data);
			return;
		}
		else {
			printf("%d\n", list->current->data);
			list->current = list->current->next;
		}
	}
}

/* 동적할당한 리스트 해제 담당 함수 */
void FreeLinkedList(LinkedList *list) {
	list->current = list->head;

	while (1) {
		if (list->head == NULL) {
			printf("해제할 list가 없습니다");
		}
		else if (list->current->next == NULL) {
			free(list->current);
			return;
		}
		else {
			Node *buf = list->current->next;
			free(list->current);
			list->current = buf;
		}
	}
}

/* 리스트의 모든 요소를 삭제하는 함수 */
void RemoveAllElements(LinkedList *list) {
	FreeLinkedList(list);
	InitiateList(list);

	return;
}

/* 리스트의 원하는 인덱스에 데이터를 삽입하는 함수 */
void AddLinkedList(LinkedList *list,int index,int data) {
	int i = 0;
	Node *buf;
	Node *new;

	// 리스트current를 head로 초기화
	list->current = list->head;
	// current를 삽입하고자 하는
	// index 바로 앞까지 옮김
	for (i = 0; i < index - 1; i++) {
		list->current = list->current->next;
	}
	// 노드를 새로 생성해서 임시로 기억
	new = MakeNode();
	// 기존의 list의 next를 임시로 기억
	buf = list->current->next;
	// 새로 만든 노드를 next로 연결
	list->current->next = new;
	// 새로 만든 노드의 next를 buf에
	// 기억해놨던 기존 next로 설정
	list->current->next->next = buf;
	// 새로 만든 노드에 data 삽입
	list->current->next->data = data;

	return;
}

/* 해당 index의 list 삭제 */
void DeleteLinkedList(LinkedList *list, int index) {
	int i = 0;
	Node *buf;

	// 리스트current를 head로 초기화
	list->current = list->head;
	// current를 삭제하고자 하는
	// index 바로 앞까지 옮김
	for (i = 0; i < index - 1; i++) {
		list->current = list->current->next;
	}
	// buf에 삭제할 Node를 넣는다 (동적할당 해제를 위함)
	buf = list->current->next;
	// 삭제하고자 하는 Node의 next에
	// 삭제하고자 하는 Node의 다음 Node
	// 주소를 넣어준다.
	list->current->next = list->current->next->next;
	// 삭제할 Node 동적할당 해제
	free(buf);

	return;
}

/* 해당 index의 data값을 받아오는 함수 */
int GetLinkedList(LinkedList *list,int index) {
	int i = 0;
	// 리스트current를 head로 초기화
	list->current = list->head;
	// current를 Get하고자 하는
	// index까지 옮김
	for (i = 0; i < index; i++) {
		list->current = list->current->next;
	}
	return list->current->data;
}
