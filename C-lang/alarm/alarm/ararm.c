#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <time.h>	/* 시간 및 날짜 관련 #include */
#include <string.h>	/* 문자열 관련 #include */

void main() {
	FILE* file;	// 파일 입출력
	struct tm* now = NULL;	// time에서 제공하는 구조체
	time_t now_t = NULL;	
	time(&now_t);	//	현재시간 저장
	char str[100] = {NULL,};

	now = localtime(&now_t);	//	각 지역별 시간으로 업데이트

	int year = now->tm_year + 1900;	//	현재 년도인데, 1900년도부터 count하므로, + 1900
	int month = now->tm_mon+1;	//	0~11로 저장이 되어있기 떄문에 +1
	int day = now->tm_mday;	//	그냥 현재 날짜
	int hour = now->tm_hour;	//	현재 시간
	int minute = now->tm_min;	// 현재 분
	char s1[5];
	char read[100] = { NULL, };

	file = fopen("test.txt", "w");	// 파일 쓰기모드로 open
	if (hour > 12) {	//	시간이 12가 넘으면 오후 및 12를 빼줌!
		hour -= 12;
		strcat(str, "오후 ");
	}
	else strcat(str, "오전 ");
	sprintf(s1, "%d", hour);	// int형을 char 배열로 변경
	strcat(str, s1);
	strcat(str, " : ");
	sprintf(s1, "%d", minute);	// int형을 char 배열로 변경
	strcat(str, s1);
	strcat(str, "  ");
	sprintf(s1, "%d", year);	// int형을 char 배열로 변경
	strcat(str, s1);
	if(month>10)
		strcat(str, "-0");
	else
		strcat(str, "-");
	sprintf(s1, "%d", month);	// int형을 char 배열로 변경
	strcat(str, s1);
	strcat(str, "-");
	sprintf(s1, "%d", day);	// int형을 char 배열로 변경
	strcat(str, s1);
	strcat(str, "\n\0");
	fwrite(str, sizeof(char) * 100, 1, file);

	fclose(file);

	file = fopen("test.txt", "r");

	time(&now_t);	//	현재시간 저장
	now = localtime(&now_t);	//	각 지역별 시간으로 업데이트

	year = now->tm_year + 1900;
	month = now->tm_mon + 1;
	day = now->tm_mday;
	hour = now->tm_hour;
	minute = now->tm_min;
	
	for (int i = 0; i < 100; i++) {
		str[i] = NULL;
	}

	if (hour > 12) {
		hour -= 12;
		strcat(str, "오후 ");
	}
	else strcat(str, "오전 ");
	sprintf(s1, "%d", hour);
	strcat(str, s1);
	strcat(str, " : ");
	sprintf(s1, "%d", minute);
	strcat(str, s1);
	strcat(str, "  ");
	sprintf(s1, "%d", year);
	strcat(str, s1);
	if (month > 10)
		strcat(str, "-0");
	else

		strcat(str, "-");
	sprintf(s1, "%d", month);
	strcat(str, s1);
	strcat(str, "-");
	sprintf(s1, "%d", day);
	strcat(str, s1);
	strcat(str, "\n\0");

	fread(read, sizeof(char), 100, file);
	printf("텍스트 저장 : %s\n",read);
	printf("현재 : %s\n", str);

	fclose(file);

	return;
}