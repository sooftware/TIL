/*

## 2018년 2학년 1학기 소프트웨어설계 프로젝트
## 광운대학교 전자통신공학과
## 2014707073 김수환
## c언어로 구현해본 갤러그

*/

#include <stdio.h>
#include "gallaga.h"
#pragma comment(lib,"winmm.lib")
#include <mmsystem.h>

struct gallaga gal;

void main() {
	char key = NULL;
	char Game_Mode = 0;
	int i = 0;
	char RANK_MODE = NULL;

	/* 변수들 초기화 */
	variable_initiate(&gal);

	/* 시간에 따른 랜덤 난수 발생을 위함 */
	srand((unsigned)time(NULL));

	/* BGM  재생 */
	PlaySound(TEXT("gallaga.wav"), NULL, SND_ASYNC | SND_LOOP);
	start();

	/* 순서도 실행 */
	while (1) {
		/* 시작화면 크기 설정 */
		system("mode con cols=81 lines=25");
		/* 메뉴화면 */
		key = Menu();
		switch (key) {
		case '1':
			/* 게임모드 선택화면 */
			Game_Mode = Game_Start();
			switch (Game_Mode) {
			case '1':
				/* 이지모드 STAGE1 실행 */
				EASY_MODE_STAGE1(&gal);
				system("cls");
				/* 이지모드 BOSS STAGE 실행 */
				if (gal.EASYMODE_STAGE1_CLEAR) {
					BOSSSTAGE(&gal);
					if (BOSS_CLEAR(&gal)) {
						RANKING_EASY(&gal);
						system("cls");
						SHOW_RANKING_EASY(&gal);
					}
				}
				break;
			case '2':
				HARD_MODE_STAGE1(&gal);
				system("cls");
				if (gal.EASYMODE_STAGE1_CLEAR) {
					BOSSSTAGE_HARD(&gal);
					if (BOSS_CLEAR(&gal)) {
						RANKING_HARD(&gal);
						system("cls");
						SHOW_RANKING_HARD(&gal);
					}
				}
				break;
			case '3':
				system("mode con cols=85 lines=30");
				HOW_PLAY();
				break;
			}
			break;
		case '2':
			RANK_MODE = select_rank();
			switch (RANK_MODE) {
			case '1':
				SHOW_RANKING_EASY(&gal);
				break;
			case '2':
				SHOW_RANKING_HARD(&gal);
				break;
			}
			break;
		case '3':
			Game_Option(&gal);
			break;
		case '4':
			PlaySound(NULL, NULL, NULL);
			return;
		}
		system("cls");
	}

	PlaySound(NULL, NULL, NULL);
	return;
}