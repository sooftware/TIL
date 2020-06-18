#include <stdio.h>
#include <stdlib.h>

void init(int **arr, int n);
int input();
int **make_arr(int n);
void first(int **arr, int start, int *x, int *y, int *num, int *recur);
void second(int **arr, int start, int *x, int *y, int *num, int *recur);
void print_arr(int **arr, int n);
void free_arr(int **arr, int n);

int main() {
	int n = 0;
	int start = 0;
	int x=0, y=0;
	int num = 1;
	int recur = 0;
	int **arr;

	// 입력받는 함수
	n = input();

	// 동적할당 함수
	arr = make_arr(n);

	// 초기화 함수 -> 0으로
	init(arr, n);

	recur = n - 1;
	start = (n / 2);
	x = y = start;
	arr[start][start] = num;

	// ↗ ↓ ← ↗ ↓ ← ↗ ↓ ← ... 수행
	first(arr, start, &x, &y, &num, &recur);

	y = x = start;
	recur = n - 1;

	// ↙ ↑ → ↙ ↑ → ↙ ↑ → ... 수행
	second(arr, start, &x, &y, &num, &recur);

	// 배열 print
	print_arr(arr, n);
	// 동적할당 해제
	free_arr(arr, n);

	return 0;
}

void free_arr(int **arr,int n) {
	for (int i = 0; i < n; i++) {
		free(arr[i]);
	}
	free(arr);
}

void print_arr(int **arr,int n) {
	printf("\n");
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d\t", arr[i][j]);
		}
		printf("\n");
	}
}

void second(int **arr, int start, int *x, int *y, int *num, int *recur) {
	// cross second
	for (int i = 0; i < start; i++) {
		arr[++(*y)][--(*x)] = ++(*num);
	}

	while (*recur > 0) {
		// up
		for (int i = 0; i < *recur; i++) {
			arr[--(*y)][*x] = ++(*num);
		}
		--(*recur);


		// right
		for (int i = 0; i < *recur; i++) {
			arr[*y][++(*x)] = ++(*num);
		}
		--(*recur);

		// cross left
		for (int i = 0; i < *recur; i++) {
			arr[++(*y)][--(*x)] = ++(*num);
		}
		--(*recur);
	}
}

void first(int **arr,int start,int *x,int *y,int *num,int *recur) {
	// cross first
	for (int i = 0; i < start; i++)
		arr[--(*y)][++(*x)] = ++(*num);

	while (*recur > 0) {
		// down
		for (int i = 0; i < *recur; i++) {
			arr[++(*y)][(*x)] = ++(*num);
		}
		--(*recur);

		// left
		for (int i = 0; i < *recur; i++) {
			arr[(*y)][--(*x)] = ++(*num);
		}
		--(*recur);

		// cross right
		for (int i = 0; i < *recur; i++) {
			arr[--(*y)][++(*x)] = ++(*num);
		}
		--(*recur);
	}
}

int **make_arr(int n) {
	int **arr = (int**)malloc(sizeof(int*)*n);
	for (int i = 0; i < n; i++) {
		arr[i] = (int*)malloc(sizeof(int)*n);
	}
	return arr;
}

int input() {
	int n = 0;
	do {
		printf("Odd Number : ");
		scanf_s("%d", &n);
	} while (n % 2 == 0);
	return n;
}

void init(int **arr,int n) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arr[i][j] = 0;
		}
	}
}