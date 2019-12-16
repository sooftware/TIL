/*
*				KwangWoon University
*				2014707073 전자통신공학과 김수환
*				19년도 컴퓨터구조 Homework
*/
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define MAX_BIT 8
#define TRUE 1
#define FALSE 0

typedef int boolean;

int input_dividend();
int input_divisor();
void trans_binary(int *binary, int num);
void print_binary(int *binary);
int* binary_sub(int *binary1, int *binary2);
int binary_length(int *binary);
int* tailor(int *divisor, int div_length, int left);
boolean can_div(int* dividend, int *divisor, int left);
int* divide(int *dividend, int *divisor);
int binary_to_decimal(int *binary);
void print_quotient(char *binary);

int main(void) {
	int num = input_dividend();
	int div = input_divisor();
	int binary[MAX_BIT] = { 0, };
	int *dividend = &binary[0];
	int binary_div[MAX_BIT] = { 0, };
	int *divisor = &binary_div[0];
	int result[MAX_BIT] = { 0, };

	trans_binary(dividend, num);
	trans_binary(divisor, div);

	printf("\n## dividend [binary] : ");
	print_binary(dividend);
	printf("\n## divisor [binary] : ");
	print_binary(divisor);
	printf("\n\n");

	int *remainder = divide(binary, binary_div);
	printf("\n## remainder [binary] : ");
	print_binary(remainder);
	printf("\n## remainder [decimal] : ");
	printf("%d\n", binary_to_decimal(remainder));

	free(remainder);

	return 0;
}

int binary_to_decimal(int *binary) {
	int dec = 0;
	for (int i = 0; i < MAX_BIT; i++) {
		if (binary[i] == 1) dec += (1 << (MAX_BIT - i - 1));
	}
	return dec;
}

int* divide(int *dividend, int *divisor) {
	int len_end = binary_length(dividend);
	int len_sor = binary_length(divisor);
	int compare_size = 1;
	char *quotient = (char*)malloc(sizeof(char)*MAX_BIT);
	int zero_left = 0;

	for (int i = 0; i < MAX_BIT; i++)
		quotient[i] = 'x';

	/* 총 8번! 몫! */
	for (int i = 0; i < MAX_BIT; i++) {
		printf("## %d\n\n", i + 1);
		if (compare_size < len_sor) {
			quotient[i] = '0';
			print_quotient(quotient);
			compare_size++;
		}
		else if (compare_size == len_sor) {
			if (can_div(dividend, tailor(divisor, binary_length(divisor), zero_left), MAX_BIT - binary_length(dividend))) {
				quotient[i] = '1';
				print_quotient(quotient);
				dividend = binary_sub(dividend, tailor(divisor, binary_length(divisor), zero_left));
			}
			else {
				print_quotient(quotient);
				quotient[i] = '0';
			}
			zero_left++;
			compare_size++;
		}
		else {
			if (can_div(dividend, tailor(divisor, binary_length(divisor), zero_left), zero_left)) {
				quotient[i] = '1';
				print_quotient(quotient);
				dividend = binary_sub(dividend, tailor(divisor, binary_length(divisor), zero_left));
			}
			else {
				quotient[i] = '0';
				print_quotient(quotient);
			}
			zero_left++;
		}
	}

	printf("\n## quotient [binary] : ");
	for (int i = 0; i < MAX_BIT; i++)
		printf("%c ", quotient[i]);
	printf("\n");

	free(quotient);

	return dividend;
}

boolean can_div(int* dividend, int *divisor, int left) {
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

int* tailor(int *divisor, int div_length, int left) {
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

	printf("SUB\t  ");
	print_binary(binary1);
	printf("\t- ");
	print_binary(binary2);

	for (int i = 0; i < MAX_BIT; i++) {
		// 1-1
		if (binary1[start - i] == 1 && binary2[start - i] == 1) {
			result[start - i] = 0;
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
	printf("\t------------------\n\t  ");
	print_binary(result);
	printf("\n\n");

	return result;
}

void print_quotient(char *binary) {
	printf("quotient : ");
	for (int i = 0; i < MAX_BIT; i++) {
		printf("%c ", binary[i]);
	}
	printf("\n\n");
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

int input_divisor() {
	int div = 0;
	printf("## INPUT DIVISOR : ");
	scanf("%d", &div);
	return div;
}

int input_dividend() {
	int num = 0;
	boolean userInputError = FALSE;

	do {
		if (!userInputError) {
			printf("## INPUT DIVIDEND : ");
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
