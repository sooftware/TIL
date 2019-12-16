#include <stdio.h>
#include <time.h>

void main(){
	struct tm *t;
	time_t timer = time(NULL);
	t = localtime(&timer);
	printf("year : %d\n", t->tm_year + 1900);
	printf("month : %d\n", t->tm_mon + 1);
	printf("day : %d\n", t->tm_mday);
	return;
}
