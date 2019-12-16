#include <stdio.h>
#include <stdlib.h>

#define MAX_BIT 8
#define TRUE 1
#define FALSE 0

typedef int boolean;

int input();
int input_div();
void trans_binary(int *binary, int num);
void print_binary(int *binary);
int* binary_sub(int *binary1, int *binary2);
int binary_length(int *binary);
int* tailor(int *divisor, int div_length, int left);
boolean can_div(int* dividend, int *divisor,int left);
int* divide(int *dividend, int *divisor);
int binary_to_decimal(int *binary);

int main(void) {
	int num = input();
	int div = input_div();
	int binary[MAX_BIT] = { 0, };
	int binary_div[MAX_BIT] = { 0, };
	int result[MAX_BIT] = { 0, };

	trans_binary(&binary, num);
	trans_binary(&binary_div, div);

	print_binary(&binary);
	print_binary(&binary_div);

	int *rest = divide(binary, binary_div);
	printf("\n## 2진수 나머지\n");
	print_binary(rest);
	printf("\n## 10진수 나머지\n");
	printf("%d\n", binary_to_decimal(rest));

	free(rest);

	return 0;
}

int binary_to_decimal(int *binary) {
	int dec = 0;
	for (int i = 0; i < MAX_BIT; i++) {
		if (binary[i] == 1) dec += (1 << (MAX_BIT - i - 1));
	}
}

int* divide(int *dividend, int *divisor) {
	int len_end = binary_length(dividend);
	int len_sor = binary_length(divisor);
	int compare_size = 1;
	int *quotient = (int*)malloc(sizeof(int)*MAX_BIT);
	int zero_left = 0;

	/* 총 8번! 몫! */
	for (int i = 0; i < MAX_BIT; i++) {
		if (compare_size < len_sor) {
			quotient[i] = 0;
			compare_size++;
		}
		else if (compare_size == len_sor) {
			if (can_div(dividend, tailor(divisor, binary_length(divisor), zero_left), MAX_BIT - binary_length(dividend))) {
				quotient[i] = 1;
				int *for_free = dividend;
				dividend = binary_sub(dividend, tailor(divisor,binary_length(divisor),zero_left));
				free(for_free);
			}
			else {
				quotient[i] = 0;
			}
			zero_left++;
			compare_size++;
		}
		else {
			if (can_div(dividend, tailor(divisor, binary_length(divisor), zero_left), zero_left)) {
				quotient[i] = 1;
				int *for_free = dividend;
				dividend = binary_sub(dividend, tailor(divisor, binary_length(divisor), zero_left));
				free(for_free);
			}
			else {
				quotient[i] = 0;
			}
			zero_left++;
		}
	}

	printf("## 2진수 몫");
	print_binary(quotient);

	free(divisor);
	free(quotient);

	return dividend;
}

boolean can_div(int* dividend,int *divisor,int left) {
	int *test = tailor(divisor, binary_length(divisor), left);

	if (binary_length(dividend) > binary_length(test)) return TRUE;

	for (int i = 0; i < MAX_BIT; i++) {
		if (dividend[i] == 0 && test[i] == 1) {
			free(test);
			return FALSE;
		}
		else if (dividend[i] == 1 && test[i] == 0) {
			free(test);
			return TRUE;
		}
	}
	free(test);
	return TRUE;
}

int* tailor(int *divisor, int div_length,int left) {
	int* test = (int*)malloc(sizeof(int)*MAX_BIT);
	int d_start = MAX_BIT - div_length;
	for (int i = 0; i < left; i++) {
		test[i] = 0;
	}
	for (int i = left; i < left + div_length; i++) {
		test[i] = divisor[d_start++];
	}
	for (int i = left + div_length; i < MAX_BIT; i++) {
		test[i] = 0;
	}
	return test;
}

int binary_length(int *binary) {
	int start = MAX_BIT - 1;
	int length = 0;
	for (int i = 0; i < MAX_BIT; i++) {
		if (binary[start - i] == 1) length = i + 1;
	}
	return length;
}

int* binary_sub(int *binary1, int *binary2) {
	int* result = (int*)malloc(sizeof(int)*MAX_BIT);
	int start = MAX_BIT - 1;
	for (int i = 0; i < MAX_BIT; i++) {
		// 1-1
		if (binary1[start-i] == 1 && binary2[start-i] == 1) {
			result[start-i] = 0;
		}
		// 1-0
		else if (binary1[start - i] == 1 && binary2[start - i] == 0) {
			result[start - i] = 1;
		}
		// 0-1
		else if (binary1[start - i] == 0 && binary2[start - i] == 1) {
			result[start - i] = 1;
			int k = 1;
			while (TRUE) {
				if (binary1[start - i - k] == 1) {
					binary1[start - i - k] = 0;
					break;
				}
				else {
					binary1[start - i - k++] = 1;
				}
			}
		}
		// 0-0
		else if (binary1[start - i] == 0 && binary2[start - i] == 0) {
			result[start - i] = 0;
		}
	}
	return result;
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
	scanf("%d", &div);
	return div;
}

int input() {
	int num = 0;
	boolean userInputError = FALSE;

	do {
		if (!userInputError) {
			printf("INPUT DECIMAL NUMBER : ");
			scanf("%d", &num);
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
