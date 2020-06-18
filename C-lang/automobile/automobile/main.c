/*
2014707073 김수환
9주차 소프트웨어설계 실습 및 과제
*/
#include "automobile.h"
#include <time.h>

/* 함수들을 쓰기 위한 include */

void main() {
	srand((unsigned)time(NULL));
	user_setting(&automobile_moving, &obs);
	system("cls");
	draw_map();
	draw_obstacle(&obs);
	obs_sorting(&obs);
	automobile_move(&automobile_moving, &automobile_coord, &obs);

	return;
}
