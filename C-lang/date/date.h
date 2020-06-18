#include <stdio.h>

#define january 31
#define february 28
#define march 31
#define april 30
#define may 31
#define june 30
#define july 31
#define august 31
#define september 30
#define october 31
#define november 30
#define december 31

struct _compareDate {
	int born_Year, born_Month, born_Date;
	int compare_Year, compare_Month, compare_Date;
}date;

void inputDateUserWereBorn(struct _compareDate *date);
void inputDateToCompare(struct _compareDate *date);
int calculateYear(struct _compareDate *date);
int calculateDifferenceDate(struct _compareDate *date);
int bornMoveTo_7_1(struct _compareDate *date);
int compareMoveTo_7_1(struct _compareDate *date);
int howManyLeapYear(struct _compareDate *date);

/* 태어난 날짜 입력 받는 함수 */
void inputDateUserWereBorn(struct _compareDate *date) {
	printf("Enter a year you were born : ");
	scanf_s("%d", &(date->born_Year));
	do {
		printf("Enter a month you were born (1~12) : ");
		scanf_s("%d", &(date->born_Month));
	} while (date->born_Month <0 || date->born_Month>12);
	do {
		printf("Enter a date you were born (1~31) : ");
		scanf_s("%d", &(date->born_Date));
	} while (date->born_Date<0 || date->born_Date>31);

	return;
}

/* 비교할 날짜 입력 받는 함수 */
void inputDateToCompare(struct _compareDate *date) {
	do {
		printf("Enter a year compare to  : ");
		scanf_s("%d", &(date->compare_Year));
	} while (date->compare_Year < date->born_Year);
	do {
		printf("Enter a month compare to (1~12) : ");
		scanf_s("%d", &(date->compare_Month));
	} while (date->compare_Month<0 || date->compare_Month>12);
	do {
		printf("Enter a date compare to : (1~31)");
		scanf_s("%d", &(date->compare_Date));
	} while (date->compare_Date<0 || date->compare_Date>31);

	return;
}


/* 년도 차이를 계산하는 함수 */
int calculateYear(struct _compareDate *date) {
	int difference_Year = 0;

	difference_Year = (date->compare_Year) - (date->born_Year);

	return difference_Year;
}

/* 태어난 날짜를 해당 년도 7월1일과 얼마나 차이나는지 계산 */
int bornMoveTo_7_1(struct _compareDate *date) {
	int returnValue = 0;

	/*
	태어난 날짜가 7월 1일 기준으로 더 지난 날짜라면 즉, if (date->born_Month>7) 이라면,
	태어난 날짜 기준으로 7월 1일로 이동 후, 비교하려는 년도의 7월 1일과의 날짜 차이를 계산할 때
	결국은 빼주어야 하므로 returnValue를 음수값으로 변환해준다.

	반대로, 태어난 날짜가 7월 1일이 아직 안 된 날짜라면 즉, else의 경우라면
	태어난 날짜 기준으로 7월 1일로 이동한 후 비교하려는 년도의 7월 1일과의 날짜 차이를 계산할 때
	더해주어야 하므로, returnValue값을 그대로 둔다.
	*/
	if (date->born_Month>7) {
		if (date->born_Month == 8) {
			/* 해당 월 1일로 (date->born_Date - 1) 간 후 7월까지 각 달을 값을 더해줌 */
			/* 즉 7월 1일까지의 날짜 계산 */
			returnValue = (july + (date->born_Date - 1));	
		}
		else if (date->born_Month == 9) {
			returnValue = (july + august+ (date->born_Date - 1));
		}
		else if (date->born_Month == 10) {
			returnValue = (july + august + september + (date->born_Date - 1));
		}
		else if (date->born_Month == 11) {
			returnValue = (july +august +september +
				          +october + (date->born_Date - 1));
		}
		else if (date->born_Month == 12) {
			returnValue = (july +august + september +
				+october + november + (date->born_Date - 1));
		}
		returnValue = (-returnValue);	

		return returnValue;
	}
	else if (date->born_Month==7) {
		returnValue = date->born_Date - 1;
		returnValue = (-returnValue);
		
		return returnValue;
	}
	else {
		if (date->born_Month == 1) {
			/* 해당 월 1일로 (date->born_Date - 1) 간 후 7월까지 각 달을 값을 더해줌 */
			returnValue = (january + february + march + april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 2) {
			returnValue = (february +march + april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 3) {
			returnValue = (march +april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 4) {
			returnValue = (april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 5) {
			returnValue = (may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 6) {
			returnValue = (june - (date->born_Date - 1));
		}

		return returnValue;
	}
}

/* 비교할 날짜와 해당 년도 7월1일과 얼마나 차이나는지 계산 */
int compareMoveTo_7_1(struct _compareDate *date) {
	int returnValue = 0;

	/*
	비교할 날짜가 7월 1일보다 더 지난 날짜라면, 더해주어야 하므로 +
	7월 1일보다 덜 지난 날짜라면 빼주어야 하므로 -
	*/

	if (date->compare_Month > 7) {
		if (date->compare_Month == 8) {
			/* 해당 월 1일로 (date->compare_Date - 1) 간 후 7월까지 각 달을 값을 더해줌 */
			/* 즉 7월 1일까지의 날짜 계산 */
			returnValue = (july + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 9) {
			returnValue = (july + august + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 10) {
			returnValue = (july + august + september + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 11) {
			returnValue = (july + august + september +
				+ october + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 12) {
			returnValue = (july + august + september +
				+october + november + (date->compare_Date - 1));
		}

		return returnValue;
	}
	else if (date->compare_Month == 7) {
		returnValue = date->compare_Date - 1;

		return returnValue;
	}
	else {
		if (date->compare_Month == 1) {
			/* 해당 월 1일로 (date->born_Date - 1) 간 후 7월까지 각 달을 값을 더해줌 */
			returnValue = (january + february + march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 2) {
			returnValue = (february + march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 3) {
			returnValue = (march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 4) {
			returnValue = (april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 5) {
			returnValue = (may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 6) {
			returnValue = (june - (date->compare_Date - 1));
		}

		returnValue = (-returnValue);

		return returnValue;
	}
}

/* 최종적으로 계산해주는 함수 */
int calculateDifferenceDate(struct _compareDate *date) {
	int difference = 0;

	/* (차이나는 년도 x 365) + (비교하려는 날짜와 해당년도 7월1일과의 차이) + (태어난 날짜와 해당년도 7월 1일과의 차이) +1(태어난날) */
	difference = (365 * calculateYear(date)) + compareMoveTo_7_1(date) + bornMoveTo_7_1(date) + howManyLeapYear(date) +1;
	
	return difference;
}

/* 입력받은 두 날짜 사이에 윤년이 얼마나 있었는지 계산해주는 함수 */
int howManyLeapYear(struct _compareDate *date) {
	int numOfLeapYear = 0;

	for (int i = date->born_Year; i <= date->compare_Year; i++) {
		/* 태어난 월이 2월 이후라면 태어난 년도 윤년과는 상관x -> i==date->born_Year일 때는 skip */
		if (date->born_Month>2) {
			if (i == date->born_Year) {
				continue;
			}
			else {
				/* 비교하려는 월이 2월 이후라면 윤년과 상관o*/
				if (date->compare_Month>2) {
					/* 윤년이면 */
					if (((i % 4 == 0) && (i % 100 != 0)) || (i%400==0)) {
						numOfLeapYear++;
					}
				}
				/* 비교하려는 월이 2월이거나 2월 전이라면 윤년과 상관x */
				else {
					if (i == date->compare_Year) {
						continue;
					}
					/* 윤년이면 */
					if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
						numOfLeapYear++;
					}
				}
			}
		}
		/* 태어난 월이 2월 이전이라면 윤년관 상관o -> i==date->born_Year일 때도 포함 */
		else {
			/* 비교하려는 월이 2월 이후라면 윤년과 상관o*/
			if (date->compare_Month > 2) {
				/* 윤년이면 */
				if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
					numOfLeapYear++;
				}
			}
			/* 비교하려는 월이 2월이거나 2월 전이라면 윤년과 상관x */
			else {
				if (i == date->compare_Year) {
					continue;
				}
				/* 윤년이면 */
				if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
					numOfLeapYear++;
				}
			}
		}
	}

	return numOfLeapYear;
}