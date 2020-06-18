#include "date.h"

struct _compareDate date;

void main() {
	inputDateUserWereBorn(&date);
	inputDateToCompare(&date);

	printf("## 태어난 날짜 : %d년 %d월 %d일\n", date.born_Year, date.born_Month, date.born_Date);
	printf("## 비교할 날짜 : %d년 %d월 %d일\n", date.compare_Year, date.compare_Month, date.compare_Date);
	printf("## 두 날짜의 차이 : %d\n\n\n", calculateDifferenceDate(&date));

	return;
}

