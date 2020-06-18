#include <stdio.h>
#include <stdlib.h>

#define MAX 10000
#define MAX_BIT 8
#define TRUE 1
#define FALSE 0

typedef int boolean;

int input();
int input_div();
void trans_binary(int *binary, int num);
void print_binary(int *binary);
void divide(int *binary, int *binary_div);
void sub_same_len(int *compare, int *div, int length, int compare_cursor);
void sub_diff_len(int *compare, int *div, int com_length, int div_length, int compare_cursor);

int main(void) {
	//int num = input();
	//int div = input_div();
	int num = 210;
	int div = 9;
	int binary[MAX_BIT] = { 0, };
	int binary_div[MAX_BIT] = { 0, };

	trans_binary(&binary, num);
	trans_binary(&binary_div, div);
	divide(&binary, &binary_div);

	return 0;
}

void divide(int *binary, int *binary_div) {
	int div_length = 0;
	int cursor = MAX_BIT-1;
	int morks_index = 0;
	int compare_cursor = MAX_BIT - 1;

	/*
	printf("binary : ");
	for (int i = 0; i < MAX_BIT; i++) {
		printf("%d ", binary[i]);
	}
	printf("\n");

	printf("binary_div : ");
	for (int i = 0; i < MAX_BIT; i++) {
		printf("%d ", binary_div[i]);
	}
	printf("\n");
	*/
	for (int i = 0; i < MAX_BIT; i++) {
		if (binary_div[MAX_BIT-i-1] == 1) div_length = i+1;
	}

	int *div = (int*)malloc(sizeof(int)*div_length);
	int *compare = (int*)malloc(sizeof(int)*div_length+1);
	int *morks = (int*)malloc(sizeof(int)*(cursor + 1));

	cursor -= (div_length - 1);
	
	for (int i = 0; i < div_length; i++) {
		div[i] = binary_div[MAX_BIT-1-i];
	}

	for (int i = 0; i < div_length; i++) {
		compare[i] = binary[i];
	}

	printf("length=%d\n", div_length);
	printf("div : ");
	for (int i = 0; i < div_length; i++) {
		printf("%d ", div[i]);
	}
	printf("\ncompare : ");
	for (int i = 0; i < div_length; i++) {
		printf("%d ", compare[i]);
	}
	printf("\n");

	int com_length = div_length;
	while (cursor > -1) {
		if (can_divide(div, compare, div_length, compare_cursor)) {
			sub_same_len(compare, div, div_length, compare_cursor--);
			morks[morks_index++] = 1;
			cursor--;
		}else if (com_length > div_length) {
			morks[morks_index++] = 1;
			sub_diff_len(compare, div, com_length, div_length, compare_cursor--);
			com_length--;
			cursor--;
		}
		else {
			morks[morks_index++] = 0;
			com_length++;
			cursor--;
		}

		printf("¸ò : ");
		for (int i = 0; i < morks_index; i++) {
			printf("%d ", morks[i]);
		}


		printf("\n");
		for (int i = 0; i < MAX_BIT; i++) {
			printf("%d ", compare[i]);
		}
	}
	free(div);
	free(compare);
	free(morks);
}

void sub_diff_len(int *compare, int *div, int com_length, int div_length,int compare_cursor) {
	int *result = (int*)malloc(sizeof(int)*com_length);

	for (int i = 0; i < div_length; i++) {
		if (compare[com_length - 1 - i] == 1 && div[div_length - 1 - i] == 1) {
			result[com_length - 1 - i] = 0;
		}
		else if (compare[com_length - 1 - i] == 1 && div[div_length - 1 - i] == 0) {
			result[com_length - 1 - i] = 1;
		}
		else if (compare[com_length - 1 - i] == 0 && div[div_length - 1 - i] == 1) {
			result[com_length - 1 - i] = 1;
			if (compare[com_length - 2 - i] == 1) compare[com_length - 2 - i] = 0;
			else {
				int k = 0;
				do {
					compare[com_length - 2 - i - k++] = 1;
				} while (compare[com_length - 2 - i - k] == 0);
				compare[com_length - 2 - i - k] = 0;
			}
		}
		else if (compare[com_length - 1 - i] == 0 && div[div_length - 1 - i] == 0) {
			result[com_length - 1 - i] = 0;
		}
	}
	result[0] = 0;
	for (int i = 0; i < div_length; i++) {
		//printf("%d ", result[i+1]);
		compare[compare_cursor - i - 1] = result[i];
	}
	printf("\n");
	free(result);
}

void sub_same_len(int *compare, int *div, int length,int compare_cursor) {
	int *result = (int*)malloc(sizeof(int)*length);

	for (int i = 0; i < length; i++) {
		if (compare[length - 1 - i] == 1 && div[length - 1 - i] == 1) {
			result[length - 1 - i] = 0;
		}
		else if (compare[length - 1 - i] == 1 && div[length - 1 - i] == 0) {
			result[length - 1 - i] = 1;
		}
		else if (compare[length - 1 - i] == 0 && div[length - 1 - i] == 1) {
			result[length - 1 - i] = 1;
			if (compare[length - 2 - i] == 1) compare[length - 2 - i] = 0;
			else {
				int k = 0;
				do {
					compare[length - 2 - i - k++] = 1;
				} while (compare[length - 2 - i - k] == 0);
				compare[length - 2 - i - k] = 0;
			}
		}
		else if (compare[length - 1 - i] == 0 && div[length - 1 - i] == 0) {
			result[length - 1 - i] = 0;
		}
	}
	for(int i = 0; i < length; i++) {
		//printf("%d ", result[i]);
		compare[compare_cursor - i] = result[i];
	}
	printf("\n");
	free(result);
}

boolean can_divide(int *div, int *compare,int div_length,int com_cursor) {
	boolean same = TRUE;
	printf("com_cursor : %d\n", com_cursor);
	printf("compare : ");
	for (int i = 0; i < div_length; i++) {
		printf("%d ", compare[i]);
	}
	printf("\ndiv : ");
	for (int i = 0; i < div_length; i++) {
		printf("%d ", div[i]);
	}
	printf("\n");

	for (int i = 0; i < div_length; i++) {
		if (compare[7-com_cursor+i] != div[i]) same = FALSE;
		if (compare[7 - com_cursor + i] == 1 && div[i] == 0) return TRUE;
		else if (compare[7 - com_cursor + i] == 0 && div[i] == 1) return FALSE;
	}
	return same;
}

void print_binary(int *binary) {
	for (int i = 0; i < MAX_BIT; i++) {
		printf("%d ", binary[i]);
	}
	printf("\n");
}

void trans_binary(int *binary, int num) {
	int j = MAX_BIT - 1;
	while (num != 1) {
		if (num % 2 == 1) {
			binary[j] = 1;
			num /= 2;
			if (num) {
				binary[j - 1] = 1;
			}
		}
		else {
			binary[j] = 0;
			num /= 2;
			if (num) {
				binary[j - 1] = 1;
			}
		}
		j--;
	}
}

int input_div() {
	int div = 0;
	printf("INPUT REST : ");
	scanf_s("%d", &div);
	return div;
}

int input() {
	int num = 0;
	boolean userInputError = FALSE;

	do {
		if (!userInputError) {
			printf("INPUT DECIMAL NUMBER : ");
			scanf_s("%d", &num);
			userInputError = TRUE;
		}
		else {
			printf("=====Error!!=====\n");
			printf("0~255 NUMBER PLEASE\n");
			userInputError = FALSE;
		}
	} while (num < 0 || num>255);

	return num;
}