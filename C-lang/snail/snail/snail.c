#include <stdio.h>
#include <stdlib.h>

#define TRUE 1 
#define FALSE 0
#define ERROR -1
#define SNAIL_SIZE 5

typedef int boolean;

int up(int *arr,int x, int y,int recur);
int down(int *arr, int x, int y, int recur);
int left(int *arr, int x, int y, int recur);
int right(int *arr, int x, int y, int recur);
void snail(int *arr);
void arr_print(int *arr);

int main(void) {


	return 0;
}

int up(int *arr,int x,int y,int recur) {
	int mov=
	for (int i = 0; i <= recur; i++) {
		arr[x][y]=
	}

	return y;
}

void snail(int *arr) {
	int size;
	if (SNAIL_SIZE % 2) size = SNAIL_SIZE;
	else size = (SNAIL_SIZE + 1);
	int x, y, recur;
	
	x = y = size;
	recur = (size / 2) + 1;

	for (int i = 0; i < recur; i++) {
		y = up(arr, x, y, i);
		x = left(arr, x, y, i);
		y = down(arr, x, y, i);
		x = right(arr, x, y, i);
	}
	up(arr, y, i);
}

void arr_print(int *arr) {
	for (int i = 0; i < SNAIL_SIZE; i++) {
		for (int j = 0; j < SNAIL_SIZE; j++) {
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
}
