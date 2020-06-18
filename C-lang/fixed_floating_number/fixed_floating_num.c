/*
광운대학교 전자통신공학과
2014707073 김수환
컴퓨터구조 HomeWork
*/

#include <stdio.h>
#include <stdlib.h>

#define FIXED_INT_NUM 15
#define FIXED_FLOAT_NUM 16
#define FLOAT_EXP_NUM 8
#define FLOAT_MANTISSA 23
#define TRUE 1
#define FALSE 0

typedef int boolean;
typedef unsigned int INT;
typedef struct fixed {
	INT sign_bit;
	INT integer_bit[15];
	INT float_bit[16];
	int float_shift;
}Fix;

typedef struct floating {
	INT sign_bit;
	INT exponent_bit[8];
	INT mantissa_bit[23];
}Float;

Fix* float_to_fixed(float n);			/* 유리수를 fixed number로 변환 */
float fixed_to_float(Fix *f);			/* fixed number를 유리수로 변환 */
void print_fixed(Fix *f);				/* fixed number print */
Float* float_to_Floating(float n);		/* 유리수를 Floating number로 변환 */
void print_Floating(Float *F);			/* Floating number 프린트 */
float Floating_to_float(Float *F);		/* Floating number를 유리수로 변환 */
Float* fixed_to_Floating(Fix *f);		/* fixed => Floating */
Fix* Floating_to_fixed(Float *F);		/* Floating => fixed */

int main(void) {
	float n = 0.0;

	printf("INPUT NUM : ");
	scanf_s("%f", &n);

	Fix *f_origin = float_to_fixed(n);
	Float *F_origin = float_to_Floating(n);

	printf("##### BEFORE #####\n\n");
	print_fixed(f_origin);
	print_Floating(F_origin);

	Fix *f_change = Floating_to_fixed(F_origin);
	Float *F_change = fixed_to_Floating(f_origin);

	printf("\n\n##### AFTER #####\n\n");
	print_fixed(f_change);
	print_Floating(F_change);

	free(f_origin);
	free(F_origin);
	free(f_change);
	free(F_change);

	return 0;
}

Fix* Floating_to_fixed(Float *F) {
	float n = Floating_to_float(F);
	return float_to_fixed(n);
}

Float* fixed_to_Floating(Fix *f) {
	float n = fixed_to_float(f);
	return float_to_Floating(n);
}

void print_Floating(Float *F) {
	printf("\n\nFLOATING : %d ", F->sign_bit);
	for (int i = FLOAT_EXP_NUM - 1; i >= 0; i--) {
		printf("%d ", F->exponent_bit[i]);
	}
	for (int i = FLOAT_MANTISSA - 1; i >= 0; i--) {
		printf("%d ", F->mantissa_bit[i]);
	}
	printf("\n\n");
}

float Floating_to_float(Float *F) {
	int shift = 0;
	float n = 0;
	float float_num = 1.0;
	boolean integer = TRUE;

	for (int i = 0; i < FLOAT_EXP_NUM; i++) {
		if (F->exponent_bit[i])
			shift += (1 << i);
	}
	
	n += (1 << shift);
	shift--;
	for (int i = FLOAT_MANTISSA - 1; i >= 0; i--) {
		if (integer) {
			if (F->mantissa_bit[i]) {
				n += (1 << shift);
				shift--;
			}
			shift--;
			if (shift < 0) integer = FALSE;
		}
		else {
			float_num /= 2;
			if (F->mantissa_bit[i]) {
				n += float_num;
			}
		}
	}
	printf("n=%f\n", n);
	return n;
}

Float* float_to_Floating(float n) {
	Float *F = (Float*)malloc(sizeof(Float));
	boolean flag = FALSE;
	int mantissa_index = FLOAT_MANTISSA-1;

	if (n < 0) F->sign_bit = 1;
	else F->sign_bit = 0;

	Fix *f = float_to_fixed(n);

	n -= (int)n;

	/* fixed로 바꾼 n을 mantissa에 저장 */
	for (int i = FIXED_INT_NUM - 1; i >= 0; i--) {
		if (!flag && !(f->integer_bit[i])) continue;
		else {
			if (!flag) {
				flag = TRUE;
				continue;
			}
			F->mantissa_bit[mantissa_index--] = f->integer_bit[i];
		}
	}

	for (int i = FIXED_FLOAT_NUM - 1; i >= 0; i--) {
		float shift = 1;
		for (int j = 0; j < (FIXED_FLOAT_NUM - i); j++) {
			shift /= 2;
		}
		if (n >= shift) {
			F->mantissa_bit[mantissa_index--] = 1;
			n -= shift;
		}
		else {
			F->mantissa_bit[mantissa_index--] = 0;
		}
	}

	/* 나머지는 0으로 초기화 */
	for (int i = mantissa_index; i >=0 ; i++) {
		F->mantissa_bit[i] = 0;
	}


	/* Exponent */

	int exp = f->float_shift;
	for (int i = FLOAT_EXP_NUM - 1; i > exp; i--) {
		F->exponent_bit[i] = 0;
	}

	for (int i = exp; i >= 0; i--) {
		if (exp >= (1 << i)) {
			F->exponent_bit[i] = 1;
			exp -= (1 << i);
		}
		else if (i == 0 && exp == 1) {
			F->exponent_bit[0] = 1;
		}
		else {
			F->exponent_bit[i] = 0;
		}
	}

	free(f);

	return F;
}

void print_fixed(Fix *f) {
	printf("FIXED : %d ", f->sign_bit);
	for (int i = FIXED_INT_NUM - 1; i >= 0; i--) {
		printf("%d ", f->integer_bit[i]);
	}
	for (int i = FIXED_FLOAT_NUM - 1; i >= 0; i--) {
		printf("%d ", f->float_bit[i]);
	}
	printf("\n\n");
}

float fixed_to_float(Fix *f) {
	float n = 0;
	float shift = 1;
	/* 2진수 -> 정수부분 변환 */
	for (int i = (FIXED_INT_NUM - 1); i >= 0; i--) {
		if (i == 0 && f->integer_bit[i] == 1) {
			n += 1;
		}
		else if (f->integer_bit[i] == 1) {
			n += (1 << i);
		}
	}

	/* 2진수 소수점 -> 10진수 소수점 변환 */
	for (int i = (FIXED_FLOAT_NUM - 1); i >= 0; i--) {
		shift /= 2;
		if (f->float_bit[i]) {
			n += shift;
		}
	}

	if (f->sign_bit) n = 0 - n;

	return n;
}

Fix* float_to_fixed(float n) {
	Fix *f = (Fix*)malloc(sizeof(Fix));
	boolean flag = FALSE;

	if (n < 0) f->sign_bit = 1;
	else f->sign_bit = 0;

	int int_num = (int)n;
	float float_num = n - int_num;
	f->float_shift = -1;

	/* 정수부분 2진수 변환 */
	for (int i = FIXED_INT_NUM - 1; i >= 0; i--) {
		if (int_num > (1 << i)) {
			if (!flag) {
				flag = TRUE;
				f->float_shift++;
			}
			f->integer_bit[i] = 1;
			int_num -= (1 << i);
			if (flag) f->float_shift++;
		}
		else if (i==0 && int_num == 1) {
			if (!flag) {
				flag = TRUE;
				f->float_shift++;
			}
			f->integer_bit[0] = 1;
		}
		else {
			if (flag) f->float_shift++;
			f->integer_bit[i] = 0;
		}
	}

	/* 소수점 부분 2진수 변환 */
	for (int i = FIXED_FLOAT_NUM - 1; i >= 0; i--) {
		float shift=1;
		for (int j = 0; j < (FIXED_FLOAT_NUM - i); j++) {
			shift /= 2;
		}

		if (float_num >= shift) {
			f->float_bit[i] = 1;
			float_num -= shift;
		}
		else {
			f->float_bit[i] = 0;
		}
	}
	
	return f;
}