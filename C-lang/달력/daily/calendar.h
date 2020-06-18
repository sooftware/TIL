#include <stdio.h>

#define JANUARY 31		// 1월 날짜
#define FEBRUARY 28		// 2월날짜
#define MARCH 31		// 3월날짜
#define APRIL 30		// 4월날짜
#define MAY 31			// 5월날짜
#define JUNE 30			// 6월날짜
#define JULY 31			// 7월날짜
#define AUGUST 31		// 8월날짜
#define SEPTEMBER 30	// 9월날짜
#define OCTOBER 31		// 10월날짜
#define NOVEMBER 30		// 11월날짜
#define DECEMBER 31		// 12월날짜
#define FIRSTYEAR 1		// 1년
#define FIRSTMONTH 1	// 1월
#define FIRSTDATE 1		// 1일
#define MONDAY 1
#define TUESDAY 2
#define WEDNESDAY 3
#define THURSDAY 4
#define FRIDAY 5
#define SATURDAY 6
#define SUNDAY 7

struct _calendar {
	int monthToPrint, yearToPrint;
	int howManyDate;
}cal;

void inputToPrint(struct _calendar *cal);
int calculateDateDifference(struct _calendar *cal);
int calculateYearDifferenceToDate(struct _calendar *cal);
int calculateMonthDifferenceToDate(struct _calendar *cal);
int findFistDay(struct _calendar *cal);
void printCalendar(struct _calendar *cal);
void findHowManyDate(struct _calendar *cal);
int howManyLeapYear(struct _calendar *cal);

/* 해당 월이 몇일까지 있는지 계산 */
void findHowManyDate(struct _calendar *cal) {
	if (cal->monthToPrint == 1) {
		cal->howManyDate = JANUARY;
	}
	else if (cal->monthToPrint == 2) {
		cal->howManyDate = FEBRUARY;
	}
	else if (cal->monthToPrint == 3) {
		cal->howManyDate = MARCH;
	}
	else if (cal->monthToPrint == 4) {
		cal->howManyDate = APRIL;
	}
	else if (cal->monthToPrint == 5) {
		cal->howManyDate = MAY;
	}
	else if (cal->monthToPrint == 6) {
		cal->howManyDate = JUNE;
	}
	else if (cal->monthToPrint == 7) {
		cal->howManyDate = JULY;
	}
	else if (cal->monthToPrint == 8) {
		cal->howManyDate = AUGUST;
	}
	else if (cal->monthToPrint == 9) {
		cal->howManyDate = SEPTEMBER;
	}
	else if (cal->monthToPrint == 10) {
		cal->howManyDate = OCTOBER;
	}
	else if (cal->monthToPrint == 11) {
		cal->howManyDate = NOVEMBER;
	}
	else if (cal->monthToPrint == 12) {
		cal->howManyDate = DECEMBER;
	}
	else {
		printf("findHowManyDate Has ERROR!!!\n\n");
	}
}

/* 출력하고 싶은 년도와 월을 입력받는 함수 */
void inputToPrint(struct _calendar *cal) {
	int error = 0;

	printf("출력하고 싶은 년도를 입력하세요. : ");
	do {
		if (error) {
			printf("=====ERROR!!=====\n");
			printf(" 다시 입력하세요\n");
			printf("출력하고 싶은 년도를 입력하세요. : ");
			error = 0;
		}
		else {
			scanf_s("%d", &(cal->yearToPrint));
			error = 1;
		}
	} while (cal->yearToPrint < 1);

	error = 0;

	printf("출력하고 싶은 월을 입력하세요 : ");
	do {
		if (error) {
			printf("=====ERROR!!=====\n");
			printf(" 다시 입력하세요\n");
			printf("출력하고 싶은 월을 입력하세요 : ");
			error = 0;
		}
		else {
			scanf_s("%d", &(cal->monthToPrint));
			error = 1;
		}
	} while (cal->monthToPrint < 1 || cal->monthToPrint > 12);

	return;
}

/* 입력받은 년,월과 1년1월1일과의 날짜차이 최종 계산 함수 */
int calculateDateDifference(struct _calendar *cal) {
	int dateDifference = 0;

	/* 최종적인 날짜차이 = (년도차이->날짜차이) + (월차이->날짜차이) + (사이에있는윤년의개수) */
	dateDifference = calculateYearDifferenceToDate(cal) + calculateMonthDifferenceToDate(cal) + howManyLeapYear(cal);

	return dateDifference;
}

/* 입력받은 년도와 1년과의 년도차이를 날짜차이로 바꿔주는 함수 */
int calculateYearDifferenceToDate(struct _calendar *cal) {
	int yearDifferenceToDate = 0;

	yearDifferenceToDate = 365 * (cal->yearToPrint - FIRSTYEAR);	// 서기가 0년이아니라 1년이므로 FIRSTYEAR을 빼준다

	return yearDifferenceToDate;
}

/* 입력받은 월과의 1월과의 월차이를 날짜차이로 바꿔주는 함수 */
int calculateMonthDifferenceToDate(struct _calendar *cal) {
	int MonthDifferenceToDate = 0;

	if (cal->monthToPrint == 1) {
		MonthDifferenceToDate = 0;
	}else if(cal->monthToPrint == 2){
		MonthDifferenceToDate = JANUARY;
	}else if (cal->monthToPrint == 3) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY);
	}else if (cal->monthToPrint == 4) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH);
	}else if (cal->monthToPrint == 5) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL);
	}else if (cal->monthToPrint == 6) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY);
	}else if (cal->monthToPrint == 7) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE);
	}else if (cal->monthToPrint == 8) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY);
	}else if (cal->monthToPrint == 9) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST);
	}else if (cal->monthToPrint == 10) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER);
	}else if (cal->monthToPrint == 11) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER + OCTOBER);
	}else if (cal->monthToPrint == 12) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER + OCTOBER + NOVEMBER);
	}else {
		printf("calculateMonthDifferenceToDate Has ERROR!!!\n\n");
	}

	return MonthDifferenceToDate;
}

/* 해당 년,월의 1일이 무슨 요일인지 찾는 함수 */
int findFistDay(struct _calendar *cal) {
	int DateDifference = 0;
	int whatDay = 0;
	/* 몇일 차이나는지 계산해주는 함수 */
	DateDifference = calculateDateDifference(cal);	// DateDifference에는 1년 1월 1일과의 날짜차이만큼의 수가 들어감

	/* 월 */
	if ((DateDifference%7) == 0) {
		whatDay = MONDAY;
	}
	/* 화 */
	else if ((DateDifference % 7) == 1){
		whatDay = TUESDAY;
	}
	/* 수 */
	else if ((DateDifference % 7) == 2) {
		whatDay = WEDNESDAY;
	}
	/* 목 */
	else if ((DateDifference % 7) == 3) {
		whatDay = THURSDAY;
	}
	/* 금 */
	else if ((DateDifference % 7) == 4) {
		whatDay = FRIDAY;
	}
	/* 토 */
	else if ((DateDifference % 7) == 5) {
		whatDay = SATURDAY;
	}
	/* 일 */
	else if ((DateDifference % 7) == 6) {
		whatDay = SUNDAY;
	}
	else {
		printf("findFirstDay Has ERROR!!!");
	}

	return whatDay;
}

/* 최종적으로 달력을 출력하는 함수 */
void printCalendar(struct _calendar *cal) {
	int whatDay = 0;
	int presentDay = 0;
	int februaryLeapYear = 0;

	findHowManyDate(cal);
	whatDay = findFistDay(cal);

	/* 출력하려는 월이 2월이고 윤년이라면 */
	if ((cal->monthToPrint == 2)) {
		if (((cal->yearToPrint % 4 == 0) && (cal->yearToPrint % 100 != 0)) || (cal->yearToPrint % 400 == 0)) {
			februaryLeapYear++;
		}
	}
	 
	/* 위에서 출력하려는 월이 2월이고 윤년이라면 februaryLeapYear==1이므로 */
	/* +1이 될 것이고, 아니라면 0이므로 똑같을 것 */
	cal->howManyDate += februaryLeapYear;

	printf("\n\n");
	printf("\t%d년 %d월 CALENDAR\n\n",cal->yearToPrint,cal->monthToPrint);
	printf("\t일\t월\t화\t수\t목\t금\t토\n");

	
	/* for문을 해당 월만큼돌면서 */
	/* 토요일까지 날짜를 찍고 개행을 해준다. */
	/* i==0일때는 시작 요일에 따라 \t의 개수가 틀려지므로 맞춰준다 */
	
	if (whatDay == MONDAY) {
		presentDay = MONDAY;
		for (int i = 0; i <= (cal->howManyDate);i++) {
			/* 맨처음 */
			if (i==0) {
				printf("\t ");
			}
			else {
				printf("\t%d",i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == TUESDAY){
		presentDay = TUESDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* 맨처음 */
			if (i == 0) {
				printf("\t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == WEDNESDAY) {
		presentDay = WEDNESDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* 맨처음 */
			if (i == 0) {
				printf("\t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == THURSDAY) {
		presentDay = THURSDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* 맨처음 */
			if (i == 0) {
				printf("\t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == FRIDAY) {
		presentDay = FRIDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* 맨처음 */
			if (i == 0) {
				printf("\t \t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == SATURDAY) {
		presentDay = SATURDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* 맨처음 */
			if (i == 0) {
				printf("\t \t \t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == SUNDAY) {
		presentDay = SUNDAY;
		for (int i = 1; i <= (cal->howManyDate); i++) {

			printf("\t%d", i);

			if (presentDay == SATURDAY) {
				printf("\n");
				presentDay++;
			}
			else if (presentDay == SUNDAY) {
				presentDay = MONDAY;
			}
			else {
				presentDay++;
			}
		}
	}

	return;
}

/* 윤년이 얼마나 있었는지 계산해주는 함수 */
int howManyLeapYear(struct _calendar *cal) {
	int numOfLeapYear = 0;

	for (int i = 1; i <= (cal->yearToPrint);i++) {
		/* 윤년조건 */
		if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
			numOfLeapYear++;
		}
	}

	return numOfLeapYear;
}