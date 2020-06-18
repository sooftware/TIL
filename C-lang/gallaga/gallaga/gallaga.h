/*

## 2018년 2학년 1학기 소프트웨어설계 프로젝트
## 광운대학교 전자통신공학과
## 2014707073 김수환
## c언어로 구현해본 갤러그

*/
#include <stdio.h>
#include <conio.h>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#include <process.h>

/* Define */
#define TRUE 1							// 참  (보통 변수이름이 실행되는 경우)
#define FALSE 0							// 거짓(보통 변수이름이 실행되지 않는 경우)
#define random() (float)rand()/RAND_MAX	// 0~1 까지의 난수 발생을 위한 define
#define LEFT 75							// 왼쪽 방향키 ASCII CODE define
#define RIGHT 77						// 오른쪽 방향키 ASCII CODE define
#define SPACE 32						// SPACE 키 ASCII CODE define
#define PAUSE 112						// p 키 ASCII CODE define ( 게임 일시정지 )
#define CHEATKEY 97						// a 키 ASCII CODE define ( 게임 진행 확인을 위해 보스모드로 넘기기 및 클리어를 위함 )
#define ESC 27							// ESC ASCII CODE define ( 게임 끝내기 )
#define user_y_end 23					// STAGE1 USER Y좌표
#define user_y_start 1					// STAGE1 Y좌표 시작값 ( 즉 Y : 1~23이 게임화면 )
#define user_x_start 1					// STAGE1 X좌표 시작값 
#define user_x_end 55					// STAGE1 X좌표 끝값 ( 즉 X : 1~55가 게임화면 )
#define user_x_center 27				// STAGE1 X좌표 센터
#define user_y_center 11				// STAGE1 Y좌표 센터
#define move_x 1						// x로 움직이는 만큼 define ( 수정의 편의를 위함 )
#define missile_velocity 20				// 미사일 속도를 조정해줄 값 Sleep의 parameter로 들어감 즉 클수록 느려짐
#define BOSSMODE_Y_END 33				// BOSS STAGE Y 끝 값
#define BOSSMODE_Y_CENTER 16			// BOSS STAGE Y 센터
#define time_x 65						// Map Draw를 위한 define
#define time_y 3						// Map Draw를 위한 define
#define easy_mode_menu 60				// Map Draw를 위한 define
#define puts_easymode_y 1				// Map Draw를 위한 define
#define puts_time_y 3					// Map Draw를 위한 define
#define puts_besttime_y 5				// Map Draw를 위한 define
#define puts_life_y 9					// Map Draw를 위한 define
#define puts_life_x 65					// Map Draw를 위한 define
#define puts_item_y 11					// Map Draw를 위한 define
#define puts_SPACE_y 15					// Map Draw를 위한 define
#define puts_M_y 16						// Map Draw를 위한 define
#define puts_P_y 17						// Map Draw를 위한 define
#define puts_ESC_y 18					// Map Draw를 위한 define
#define PUTS_BOSSMODE_MENU 3			// Map Draw를 위한 define
#define PUTS_BOSSMODE_TIME 5			// Map Draw를 위한 define
#define PUTS_BOSSMODE_BESTTIME 7		// Map Draw를 위한 define
#define PUTS_BOSSMODE_LIFE 13			// Map Draw를 위한 define
#define PUTS_BOSSMODE_ITEM 16			// Map Draw를 위한 define
#define PUTS_BOSSMODE_SPACE 22			// Map Draw를 위한 define
#define PUTS_BOSSMODE_M 24				// Map Draw를 위한 define
#define PUTS_BOSSMODE_P 26				// Map Draw를 위한 define
#define PUTS_BOSSMODE_ESC 28			// Map Draw를 위한 define
#define BOSSMODE_Y_END 33				// BOSS STAGE Y 끝값
#define item1_x_end 45					// 첫번째 아이템 움직이는 범위의 끝값
#define item1_x_start 10				// 첫번째 아이템 움직이는 범위의 시작값
#define item2_3_x_end 55				// 두번째 아이템 움직이는 범위의 끝값
#define item2_3_x_start 1				// 두번째 아이템 움직이는 범위의 시작값
#define Beginning_Life 3				// User Life를 3부터 시작
#define End_Life 0						// Life가 0 되면 끝내게 하기 위함
#define Item_Velocity 2					// Item의 속도 조절 Sleep paramer
#define SOL   1567.982					// Beep함수로 미사일 발사시마다 나는 효과음 (솔)
#define TIME 100						// Beep함수의 음 지속시간
/* Define */

/* 함수 선언 */
void gotoxy(int x, int y);							// gotoxy함수 선언
char Menu();										// 게임시작 메뉴화면
char Game_Start();									// 1. 게임시작 선택시 진행되는 화면
void Time_Count();									// 진행시간을 count해주는 함수
void Map_Draw_Stage1(struct gallaga *gal);			// Stage1 Map Draw 함수
void OBSTACLE_COORD(struct gallaga *gal);			// Stage1의 장애물들의 좌표를 저장하는 함수
void EASY_MODE_STAGE1_CLEAR(struct gallaga *gal);	// Stage1(Easy)에서 장애물들의 격파 및 클리어를 담당하는 함수
void Draw_Life(struct gallaga *gal);				// Life의 증가 및 감소에 따른 Life표시를 해주는 함수
void Minus_Life(struct gallaga *gal);				// User가 컴퓨터의 공격에 맞을 시 Life Minus를 해주는 함수
void EASY_MODE_STAGE1(struct gallaga *gal);			// Easy Mode 게임화면에 해당하는 함수(메인함수) 여러 함수들이 여기서 실행된다
void MAP_DRAW_BOSSSTAGE();							// BOSS STAGE Map Draw 함수
void FAIL();										// FAIL시 게임이 끝났음을 표시해주는 함수
void ITEM_ACT(struct gallaga *gal);					// ITEM을 발동하는 함수
void MAP_DRAW_HARD_STAGE1();						// BOSS STAGE Map Draw(Hard) 함수
void Time_Count_BOSSSTAGE(struct gallaga *gal);		// Boss STAGE 시간 count 함수
void Draw_Life_BOSSSTAGE(struct gallaga *gal);		// Boss STAGE Life를 그리는 함수
void Minus_Life_BOSSSTAGE(struct gallaga *gal);		// Minus Life (Boss Stage)
void BOSSSTAGE_START(struct gallaga *gal);			// BOSS STAGE 시작시 실행되는 함수 (기본적인 설정을 해줌)
int BOSS_CLEAR(struct gallaga *gal);				// BOSS CLEAR시 1을 반환해주는 함수
void BOSSSTAGE(struct gallaga *gal);				// BOSS STAGE 게임화면에 해당하는 함수(메인함수) 여러 함수들이 여기서 실행된다
void BOSS_MOVE(struct gallaga *gal);				// BOSS가 좌우로 계속 왔다갔다 하게 해주는 함수이자 BOSS 스킬이 실행되는 함수이자 BOSS 색깔변경
void SKILL_TIME(struct gallaga *gal);				// 10초가 지난 후에 SKILL을 중지해주는 함수
void BOSSSTAGE_HARD(struct gallaga *gal);			// BOSS STAGE HARD에 해당하는 함수
void HOW_PLAY();									// 게임방법을 보여주는 함수
void HARD_MODE_STAGE1(struct gallaga *gal);			// STAGE1H(HARD)에 해당하는 함수
void RANKING_EASY(struct gallaga *gal);				// EASY CLEAR시 RANKING을 매기는 함수
void SHOW_RANKING_EASY(struct gallaga *gal);		// EASY RANKING을 보여주는 함수
void RANKING_HARD(struct gallaga *gal);				// HARD CLEAR시 RANKING을 매기는 함수
void SHOW_RANKING_HARD(struct gallaga *gal);		// HARD RANKING을 보여주는 함수
char select_rank();									// USER가 EASY와 HARD 랭킹중 어느 것을 볼지 고르는 함수
void Game_Option(struct gallaga *gal);				// 게임속도 조절을 위한 게임옵션에 해당하는 함수
void start();										// 게임 접속시 실행되는 화면
void variable_initiate(struct gallaga *gal);		// 구조체 변수 초기화해주는 함수
/* 함수 선언 */


/* 시간 계산에 사용되는 변수들 */
time_t s1, s2, s3, s4, s5;

/* 구조체 정의 */
struct gallaga {
	int item1_x, item2_x, item3_x, item1_go, item2_go, item3_go;
	int flight_x;
	int missile, missile_x, missile_y;
	int computer_attack_x_coord[30];
	int Life, Game_End;
	int EASYMODE_obs_x[3][14];
	int EASYMODE_obs_y[3];
	int CLEAR_CONDITION[14];
	int missile_stop;
	int EASYMODE_STAGE1_CLEAR;
	int CLEAR_CONDITION_SUM;
	int missile_distinguish;
	int BOSS_missile_y;
	float attack_number;
	int flag, for_flag;
	int BOSS_COORD_X1, BOSS_COORD_X2;
	int BOSS_HP;
	int ITEM1, ITEM2, ITEM3;
	int KEY_CONTRARY, ATTACK_NUMBER_PLUS;
	int FOR_TIME;
	int overlap;
	int STAGE1_TIME;
	int TOTAL_TIME;
	char ID_EASY[10][20];
	int USER_NUM_EASY;
	int USER_TIME_EASY[10];
	int USER_RANKING_EASY[10];
	char ID_HARD[10][20];
	int USER_NUM_HARD;
	int USER_TIME_HARD[10];
	int USER_RANKING_HARD[10];
	int GAME_SPEED;
};
/* 구조체 정의 */

struct gallaga gal;

/* 함수 정의 */
void gotoxy(int x, int y) {
	COORD Pos;
	Pos.X = x;
	Pos.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void variable_initiate(struct gallaga *gal) {
	gal->USER_NUM_EASY = 0;
	gal->USER_NUM_HARD = 0;
	gal->GAME_SPEED = 0;
	for (int j = 0; j < 10; j++) {
		for (int i = 0; i < 20; i++) {
			gal->ID_EASY[j][i] = '0';
			gal->ID_HARD[j][i] = '0';
		}
	}
}

void Map_Draw_Stage1(struct gallaga *gal) {
	int i = 0;
	int buffer = 0, sec = 0, minute = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, puts_easymode_y);
	puts("Easy Mode");
	gotoxy(easy_mode_menu, puts_time_y);
	puts("time : ");
	gotoxy(easy_mode_menu, puts_life_y);
	puts("Life : ");
	gotoxy(easy_mode_menu, puts_item_y);
	puts("Item : ");
	gotoxy(easy_mode_menu, puts_SPACE_y);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, puts_M_y);
	puts("M : Item use");
	gotoxy(easy_mode_menu, puts_P_y);
	puts("P : Pause");
	gotoxy(easy_mode_menu, puts_ESC_y);
	puts("ESC : Quit");

	for (i = 0; i < user_y_end + 1; i++) {
		gotoxy(57, i); puts("│");
	}

	gotoxy(57, 7);
	printf("├──────────");

	gotoxy(57, 13);
	printf("├──────────");

	gotoxy(3, 2);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //x좌표 1 4  9 12  17 20  25 28  33 36  41 44  49 52
	gotoxy(3, 4);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //55,4
	gotoxy(3, 6);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //55,2
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

void start() {
	for (int i = 0; i < 20; i++) {
		Sleep(200);
		if (i % 2) {
			gotoxy(1, 1);
			puts("");
			puts("     ■■■            ");
			puts("   ■      ■       ■ ■ ");
			puts("   ■                ■ ■                    ");
			puts("   ■                ■ ■              ");
			puts("   ■    ■■  ■■  ■ ■   ■■    ■■   ■■         ");
			puts("   ■      ■ ■  ■  ■ ■ ■  ■  ■  ■ ■  ■");
			puts("     ■■■    ■■■  ■ ■ ■■■  ■■   ■■■  ");
			puts("                                        ■ ");
			puts("                                     ■■ ");
		}
		else {
			gotoxy(1, 1);
			puts("");
			puts("     □□□            ");
			puts("   □      □       □ □ ");
			puts("   □                □ □                    ");
			puts("   □                □ □              ");
			puts("   □    □□  □□  □ □   □□    □□   □□         ");
			puts("   □      □ □  □  □ □ □  □  □  □ □  □");
			puts("     □□□    □□□  □ □ □□□  □□   □□□  ");
			puts("                                        □ ");
			puts("                                     □□ ");
		}
	}
	system("cls");

	return;
}

char Menu() {
	char menu_select;

	puts("");
	puts("     ■■■            ");
	puts("   ■      ■       ■ ■                             ┍─ ─ ─ ─ ─ ─ ─ ─┓");
	puts("   ■                ■ ■                            │  1. 게임시작          │");
	puts("   ■                ■ ■                            │─ ─ ─ ─ ─ ─ ─ ─│");
	puts("   ■    ■■  ■■  ■ ■   ■■    ■■   ■■      │  2. 랭킹확인          │");
	puts("   ■      ■ ■  ■  ■ ■ ■  ■  ■  ■ ■  ■     │─ ─ ─ ─ ─ ─ ─ ─│");
	puts("     ■■■    ■■■  ■ ■ ■■■  ■■   ■■■    │  3. 게임옵션          │");
	puts("                                        ■            │─ ─ ─ ─ ─ ─ ─ ─│");
	puts("                                     ■■             │  4. 게임종료          │");
	puts("                                                      ┖─ ─ ─ ─ ─ ─ ─ ─┛ \n");
	puts("                                    KwangWoon University 소프트웨어설계 프로젝트");
	puts("                                                               2014707073 김수환");

	do {
		menu_select = _getch();
	} while (menu_select<'1' || menu_select>'4');
	system("cls");

	return menu_select;
}

char Game_Start() {
	char select_mode = '0';


	puts("");
	puts("     ■■■            ");
	puts("   ■      ■       ■ ■                             ┍─ ─ ─ ─ ─ ─ ─ ─┓");
	puts("   ■                ■ ■                            │  1. EASY MODE         │");
	puts("   ■                ■ ■                            │─ ─ ─ ─ ─ ─ ─ ─│");
	puts("   ■    ■■  ■■  ■ ■   ■■    ■■   ■■      │  2. HARD MODE         │");
	puts("   ■      ■ ■  ■  ■ ■ ■  ■  ■  ■ ■  ■     │─ ─ ─ ─ ─ ─ ─ ─│");
	puts("     ■■■    ■■■  ■ ■ ■■■  ■■   ■■■    │  3. 게임방법          │");
	puts("                                        ■            ┖─ ─ ─ ─ ─ ─ ─ ─┛");
	puts("                                     ■■ ");
	puts("\n");
	puts("                                    KwangWoon University 소프트웨어설계 프로젝트");
	puts("                                                               2014707073 김수환");

	do {
		select_mode = _getch();
	} while (select_mode<'1' || select_mode>'3');
	//return select_mode;
	system("cls");

	return select_mode;
}

/* easy mode stage 1에 해당하는 함수 */
void EASY_MODE_STAGE1(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0;
	int x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;


	/* 구조체 변수들을 초기화 */
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION[i] = 0;
	}
	gal->missile_distinguish = 0;
	gal->flight_x = 27;
	gal->missile = 0;
	gal->item1_x = 10;
	gal->item2_x = 55;
	gal->item3_x = 1;
	gal->item1_go = 1;
	gal->item2_go = 1;
	gal->item3_go = 1;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->EASYMODE_STAGE1_CLEAR = 0;
	gal->missile_stop = 0;
	gal->ITEM1 = 1;
	gal->ITEM2 = 1;
	gal->ITEM3 = 1;
	gal->attack_number = 0.2;
	/* 구조체 변수들을 초기화 */
	Map_Draw_Stage1(gal);
	OBSTACLE_COORD(gal);

	/* 게임 시작 및 time count 시작 지점 */
	gotoxy(gal->flight_x, user_y_end);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("Ж");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, user_y_center);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, user_y_center);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, user_y_center);
	puts("        ");
	time(&s1);
	/* 게임 시작 및 time count 시작 지점 */


	while (1) {	// while 문 시작
		Time_Count();
		Draw_Life(gal);
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob < gal->attack_number) { // 확률로 적 공격 개수를 조정하는 곳 (#define attack_number 조정으로 개수 변경 가능)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 좌표까지 랜덤으로 좌표를 찍는다

														/* 처음 시작할때 예외처리 */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */

		/* 크게 for문 2개를 돌려서 아이템, 컴퓨터의 공격, 미사일 발사, 키 입력을 통한 움직임을 구현 */
		for (i = 8; i < 16; i++) {	// 1차 for문
			Time_Count();
			gotoxy(12, 12); printf("                         ");
			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return 1;
			}

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 만약 키 입력을 받는다면 아래의 if문을 실행한다 */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* 방향키 같은 경우는 int값의 범위를 넘어가기 때문에 두번을 설정해줘야 한다 */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // 전에 있던 Ж를 지운다
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // 전에있던 Ж를 지운다
							printf(" ");
							break;
						}
					default:
						break;
					}
				}

				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;

					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;

					case ESC:
						return;
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			}

			/* 키 입력이 없다면 아래의 else문을 실행한다 */
			else {
				Time_Count();

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아이템 움직이는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("◆");
						}
						else {
							puts("◇");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x++;
					}
					if (gal->ITEM2) {
						gal->item2_x--;
					}
					if (gal->ITEM3) {
						gal->item3_x++;
					}
				}
				/*1,3번 아이템과 2번 아이템은 방향이 반대로 움직인다*/

				/* gal->missile_distinguish는 미사일이 발사 중일때 또 미사일을 발사 못하게 하는 변수이다 */
				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
								EASY_MODE_STAGE1_CLEAR(gal);
							}
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						ITEM_ACT(gal);

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (gal->EASYMODE_STAGE1_CLEAR) {
							system("cls");
							gotoxy(25, 10);
							printf("***CLEAR***");
							time(&s2);
							gal->STAGE1_TIME = difftime(s2, s1);
							system("pause");
							return;
						}

					}
				}
				/* 미사일 발사 부분 끝 */

				/*↓↓↓ 컴퓨터 공격 부분 ↓↓↓*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 8);
					printf("I");
					gotoxy(attack_x[1][j], i + 7);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 15) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[1][k], user_y_end);
						printf(" ");
					}
				}
				if (i == 15) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1차 for문 종료

		for (i = 16; i < 24; i++) {	// 2차 for문 시작
			Time_Count();
			gotoxy(12, 12); printf("                         ");

			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 키 입력을 받는다면 if 문 실행 */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // 전에 있던 Ж를 지운다
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // 전에있던 Ж를 지운다
							printf(" ");
							break;
						}
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			} // 키 입력일 경우 끝

			  /*키 입력이 없을 경우*/
			else {
				Time_Count();

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아이템 움직이는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("◆");
						}
						else {
							puts("◇");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x--;
					}
					if (gal->ITEM2) {
						gal->item2_x++;
					}
					if (gal->ITEM3) {
						gal->item3_x--;
					}
				}
				/* 아이템 움직이는 부분 끝 */

				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
							EASY_MODE_STAGE1_CLEAR(gal);
						}
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					ITEM_ACT(gal);

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (gal->EASYMODE_STAGE1_CLEAR) {
						system("cls");
						gotoxy(25, 10);
						printf("***CLEAR***");
						time(&s2);
						gal->STAGE1_TIME = difftime(s2, s1);
						system("pause");
						return;
					}
				}


				/* 미사일 발사 부분 끝 */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ↓↓↓ 컴퓨터 공격 부분 ↓↓↓ */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I들의 좌표를 gal 구조체에 넘겨준다 */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *들의 좌표를 gal 구조체에 넘겨준다
				}
				if (i == user_y_end) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[0][k], user_y_end);
						printf(" ");
					}
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 8);
					printf("I");
					gotoxy(attack_x[1][j], i - 9);
					printf("  ");
				}
				if (i == user_y_end) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2차 for문 종료

	}// while문 종료	
	return;
}

/*경과시간을 알려주는 함수*/
void Time_Count() {
	int minute = 0, sec = 0;
	int buffer = 0;

	time(&s2);

	buffer = difftime(s2, s1);
	minute = buffer / 60;
	sec = buffer % 60;
	if (buffer < 60) {
		gotoxy(time_x, time_y);
		printf("%d초", sec);
	}

	else {
		gotoxy(time_x, time_y);
		printf("     ");
		gotoxy(time_x, time_y);
		printf("%d분%d초", minute, sec);
	}



	return;
}

/* 적 공격에 맞으면 Life가 줄어들게 하는 함수 */
void Minus_Life(struct gallaga *gal) {
	int i = 0;
	int protect_overlap = 0;

	for (i = 0; i < 25; i++) {
		/* ( 컴퓨터 공격 좌표-1 ) <= 비행기 좌표 >= ( 컴퓨터 공격 좌표+1 ) 이면 Life가 줄어든다 */
		if (gal->computer_attack_x_coord[i] == gal->flight_x
			|| gal->computer_attack_x_coord[i] + 1 == gal->flight_x)
		{
			if (protect_overlap == FALSE) {
				protect_overlap = TRUE;
				gal->Life--;
				gotoxy(gal->flight_x, user_y_end);
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
				printf("Ж");
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
			}
		}
	}

	/* 라이프가 0이 되면 게임을 끝나게 해줄 곳 */
	if (gal->Life <= End_Life) {
		gal->Game_End = TRUE;
	}

	return;
}

/* 현재 Life의 상황을 그려주는 함수 */
void Draw_Life(struct gallaga *gal) {
	int i = 0;
	for (i = 0; i < gal->Life; i++) {
		gotoxy(puts_life_x + 2 * i, puts_life_y);
		printf("♥");
	}
	gotoxy(puts_life_x + 2 * i, puts_life_y);
	printf("  ");

	return;
}

/* EASYMODE STAGE1의 장애물들의 좌표를 저장하는 함수 */
void OBSTACLE_COORD(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < 3; i++) {
		gal->EASYMODE_obs_x[i][0] = 2;
		gal->EASYMODE_obs_x[i][1] = 5;
		gal->EASYMODE_obs_x[i][2] = 10;
		gal->EASYMODE_obs_x[i][3] = 13;
		gal->EASYMODE_obs_x[i][4] = 18;
		gal->EASYMODE_obs_x[i][5] = 21;
		gal->EASYMODE_obs_x[i][6] = 26;
		gal->EASYMODE_obs_x[i][7] = 29;
		gal->EASYMODE_obs_x[i][8] = 34;
		gal->EASYMODE_obs_x[i][9] = 37;
		gal->EASYMODE_obs_x[i][10] = 42;
		gal->EASYMODE_obs_x[i][11] = 45;
		gal->EASYMODE_obs_x[i][12] = 50;
		gal->EASYMODE_obs_x[i][13] = 53;
	}
	gal->EASYMODE_obs_y[0] = 5;
	gal->EASYMODE_obs_y[1] = 3;
	gal->EASYMODE_obs_y[2] = 1;

	return;
}

/* 스테이지를 클리어 하기 위한 조건 함수 */
void EASY_MODE_STAGE1_CLEAR(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < 14; i++) {
		/* 미사일의 좌표가 장애물 좌표에서 +2까지의 범위에 있다면 실행 */
		if (gal->missile_x == gal->EASYMODE_obs_x[0][i] || gal->missile_x == gal->EASYMODE_obs_x[0][i] + 1
			|| gal->missile_x == gal->EASYMODE_obs_x[0][i] + 2)
		{
			/* 미사일이 첫째줄에 왔을때 이 때, CLEAR_CONDITION[i]에 따라서 미사일을 제어한다 */
			/* 즉, 0일때는 첫째줄 까지, 첫째줄을 없앴다면 값이 1로 변해 두번째 줄까지 가는 것이 가능하고, */
			/* 그 다음에는 두번째 줄 까지만 갈 수 있고, 두번째 줄에 가면 CLEAR_CONDITION[i]값이 2가 되어 3번째 줄까지 갈 수 있다 */
			if (gal->missile_y == gal->EASYMODE_obs_y[0] && gal->CLEAR_CONDITION[i] == 0) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 1;
			}
			if (gal->missile_y == gal->EASYMODE_obs_y[1] && gal->CLEAR_CONDITION[i] == 1) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 2;
			}
			if (gal->missile_y == gal->EASYMODE_obs_y[2] && gal->CLEAR_CONDITION[i] == 2) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 3;
			}
		}
	}
	gal->CLEAR_CONDITION_SUM = 0;
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION_SUM += gal->CLEAR_CONDITION[i];
	}

	/* 게임 클리어 조건 */
	/* □을 다 부수기 위해서는gal->CLEAR_CONDITION[i]의 합이 42가 되야 하므로  */
	if (gal->CLEAR_CONDITION_SUM == 42) {
		gal->EASYMODE_STAGE1_CLEAR = TRUE;
	}

	return;
}

void MAP_DRAW_BOSSSTAGE() {
	int i = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_MENU);
	puts("BOSS STAGE");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_TIME);
	puts("time : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_LIFE);
	puts("Life : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_ITEM);
	puts("Item : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_SPACE);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_M);
	puts("M : Item use");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_P);
	puts("P : Pause");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_ESC);
	puts("ESC : Quit");

	for (i = 0; i < BOSSMODE_Y_END + 1; i++) {
		gotoxy(57, i); puts("│");
	}

	gotoxy(57, 11);
	printf("├──────────");

	gotoxy(57, 19);
	printf("├──────────");

	return;
}

void Draw_Life_BOSSSTAGE(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < gal->Life; i++) {
		gotoxy(puts_life_x + 2 * i, PUTS_BOSSMODE_LIFE);
		printf("♥");
	}
	gotoxy(puts_life_x + 2 * i, PUTS_BOSSMODE_LIFE);
	printf("  ");

	return;
}

void Time_Count_BOSSSTAGE(struct gallaga *gal) {
	int minute = 0, sec = 0;
	int buffer = 0;

	time(&s2);
	buffer = difftime(s2, s1) + gal->STAGE1_TIME;
	minute = buffer / 60;
	sec = buffer % 60;
	if (buffer < 60) {
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("%d초", sec);
	}

	else {
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("     ");
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("%d분%d초", minute, sec);
	}
	return;
}

void Minus_Life_BOSSSTAGE(struct gallaga *gal) {
	int i = 0;
	int protect_overlap = 0;

	for (i = 0; i < 25; i++) {
		/* ( 컴퓨터 공격 좌표-1 ) <= 비행기 좌표 >= ( 컴퓨터 공격 좌표+1 ) 이면 Life가 줄어든다 */
		if (gal->computer_attack_x_coord[i] == gal->flight_x
			|| gal->computer_attack_x_coord[i] + 1 == gal->flight_x)
		{
			if (protect_overlap == FALSE) {
				protect_overlap = TRUE;
				gal->Life--;
				gotoxy(gal->flight_x, BOSSMODE_Y_END);
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
				printf("Ж");
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
			}
		}
	}

	/* 라이프가 0이 되면 게임을 끝나게 해줄 곳 */
	if (gal->Life <= End_Life) {
		gal->Game_End = TRUE;
	}

	return;
}

void BOSSSTAGE_START(struct gallaga *gal) {
	gotoxy(gal->flight_x, BOSSMODE_Y_END);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("Ж");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("        ");
	time(&s1);

	return;
}

void FAIL() {
	system("cls");
	gotoxy(20, 5);
	printf("□□□□□□□    □□□□□□□\n");
	gotoxy(20, 6);
	printf("      □                □\n");
	gotoxy(20, 7);
	printf("      □                □\n");
	gotoxy(20, 8);
	printf("      □                □\n");
	gotoxy(20, 9);
	printf("      □                □\n");
	gotoxy(20, 10);
	printf("      □       □       □              다음 기회에...\n");
	gotoxy(20, 1);
	system("pause");

	return;
}

int BOSS_CLEAR(struct gallaga *gal) {
	int CLEAR = 0;

	if (gal->missile_x >= gal->BOSS_COORD_X1 && gal->missile_x <= gal->BOSS_COORD_X2 && gal->missile_y == 15) {
		gal->missile_stop = TRUE;
		gal->BOSS_HP--;
		gotoxy(gal->missile_x, 15); printf(" ");
	}

	if (gal->BOSS_HP <= 0) {
		CLEAR = 1;
	}


	return CLEAR;
}

void ITEM_ACT(struct gallaga *gal) {
	float prob = 0;

	if ((gal->item1_x == gal->missile_x || gal->item1_x == gal->missile_x - 1) && gal->missile_y == 1) {
		gal->ITEM1 = 0;
		gotoxy(gal->item1_x, 1); printf("  ");
		gal->item1_x = 60;

		prob = random();
		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("라이프를 얻었습니다!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("↑");
			gotoxy(12, 12); printf("↑ 스킬을 얻었습니다!!");
		}
		else if (prob > 0.9 && prob < 1) {
			gal->CLEAR_CONDITION_SUM = 42;
		}
	}
	if ((gal->item2_x == gal->missile_x || gal->item2_x == gal->missile_x - 1) && gal->missile_y == 3) {
		gal->ITEM2 = 0;
		gotoxy(gal->item2_x, 3); printf("  ");
		gal->item2_x = 60;
		prob = random();
		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("라이프를 얻었습니다!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("↑");
			gotoxy(12, 12); printf("↑ 스킬을 얻었습니다!!");
		}
		else if (prob > 0.9 && prob < 1) {
			gal->CLEAR_CONDITION_SUM = 42;
		}
	}
	if ((gal->item3_x == gal->missile_x || gal->item3_x == gal->missile_x - 1) && gal->missile_y == 5) {
		gal->ITEM3 = 0;
		gotoxy(gal->item3_x, 5); printf("  ");
		gal->item3_x = 60;
		prob = random();

		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("라이프를 얻었습니다!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("↑");
			gotoxy(12, 12); printf("↑ 스킬을 얻었습니다!!");
		}

		else if (prob > 0.9 && prob < 1) {
			gal->EASYMODE_STAGE1_CLEAR = TRUE;
		}
	}

	return;
}

void BOSS_MOVE(struct gallaga *gal) {
	SKILL_TIME(gal);

	/* 보스 색깔 */
	if (gal->BOSS_HP < 140 && gal->BOSS_HP >90) {
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
		if (gal->overlap == 0) {
			gal->KEY_CONTRARY = 1;
			gal->overlap = 1;
			gotoxy(15, 20); printf("10초간 키가 반대로 작동합니다!!!");
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}

	if (gal->BOSS_HP <= 90 && gal->BOSS_HP > 40) {
		gal->FOR_TIME = 0;
		gal->overlap = 0;
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
		if (gal->overlap == 0) {
			gal->ATTACK_NUMBER_PLUS = 1;
			if (gal->ATTACK_NUMBER_PLUS) {
				gal->attack_number = 0.6;
				gotoxy(15, 20); printf("적의 공격양이 증가합니다!!!");
			}
			gal->overlap = 1;
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}
	if (gal->BOSS_HP <= 40) {
		gal->FOR_TIME = 0;
		gal->overlap = 0;
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 12);
		if (gal->overlap == 0) {
			gal->KEY_CONTRARY = 1;
			gal->ATTACK_NUMBER_PLUS = 1;
			gal->overlap = 1;
			if (gal->ATTACK_NUMBER_PLUS) {
				gal->attack_number = 0.6;
				gotoxy(15, 20); printf("적의 공격양이 증가합니다!!!");
			}
			gotoxy(15, 21);     printf(" 키가 반대로 작동합니다!!!");
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}
	/* 보스 움직임 구현 */
	/* flag 값 변환 */
	if (gal->for_flag == 0) {
		gal->flag = 1;
		gal->for_flag++;
	}
	else if (gal->for_flag == 1) {
		gal->flag = 2;
		gal->for_flag++;
	}
	else if (gal->for_flag == 2) {
		gal->flag = 1;
		gal->for_flag++;
	}
	else if (gal->for_flag == 3) {
		gal->flag = 0;
		gal->for_flag = 0;
	}
	/* flag 값 변환 */

	/* BOSS */
	/* 왼쪽 */
	if (gal->flag == 0) {
		gotoxy(20, 1);       printf("□□□□□□□   ");
		gotoxy(18, 2);     printf("□□□□□□□□□   ");
		gotoxy(16, 3);   printf("□□□□□□□□□□□   ");
		gotoxy(14, 4);  printf("□□□□□□□□□□□□   ");
		gotoxy(14, 5); printf("□□□□□□□□□□□□□   ");
		gotoxy(14, 6); printf("□□■□□□□□□□■□□   ");
		gotoxy(14, 7); printf("□□■■■□□□■■■□□   ");
		gotoxy(15, 8);  printf("*□■■■■■■■■■□*   ");
		gotoxy(17, 9);    printf("*□□□■■■□□□*   ");
		gotoxy(18, 10);    printf("□■□□■□□■□  ");
		gotoxy(18, 11);    printf("□□■□■□■□□  ");
		gotoxy(18, 12);    printf("□□■□■□■□□   ");
		gotoxy(18, 13);    printf("□□■□■□■□□  ");
		gotoxy(19, 14);     printf("*□□□□□□□*   ");
		gotoxy(22, 15);        printf("□□□□□   ");
		gal->BOSS_COORD_X1 = 14;
		gal->BOSS_COORD_X2 = 40;
	}

	/* 가운데 */
	if (gal->flag == 1) {

		gotoxy(19, 1); printf("  ");
		gotoxy(17, 2); printf("  ");
		gotoxy(15, 3); printf("  ");
		gotoxy(13, 4); printf("  ");
		gotoxy(13, 5); printf("  ");
		gotoxy(13, 6); printf("  ");
		gotoxy(13, 7); printf("  ");
		gotoxy(14, 8); printf("  ");
		gotoxy(16, 9); printf("  ");
		gotoxy(17, 10); printf("  ");
		gotoxy(17, 11); printf("  ");
		gotoxy(17, 12); printf("  ");
		gotoxy(17, 13); printf("  ");
		gotoxy(18, 14); printf("  ");
		gotoxy(21, 15); printf("  ");

		gotoxy(22, 1);       printf("□□□□□□□   ");
		gotoxy(20, 2);     printf("□□□□□□□□□  ");
		gotoxy(18, 3);   printf("□□□□□□□□□□□   ");
		gotoxy(16, 4);  printf("□□□□□□□□□□□□   ");
		gotoxy(16, 5); printf("□□□□□□□□□□□□□   ");
		gotoxy(16, 6); printf("□□■□□□□□□□■□□   ");
		gotoxy(16, 7); printf("□□■■■□□□■■■□□   ");
		gotoxy(17, 8);  printf("*□■■■■■■■■■□*   ");
		gotoxy(19, 9);    printf("*□□□■■■□□□*   ");
		gotoxy(20, 10);    printf("□■□□■□□■□   ");
		gotoxy(20, 11);    printf("□□■□■□■□□   ");
		gotoxy(20, 12);    printf("□□■□■□■□□   ");
		gotoxy(20, 13);    printf("□□■□■□■□□   ");
		gotoxy(21, 14);     printf("*□□□□□□□*   ");
		gotoxy(24, 15);        printf("□□□□□   ");
		gal->BOSS_COORD_X1 = 16;
		gal->BOSS_COORD_X2 = 42;
	}

	/* 오른쪽 */
	if (gal->flag == 2) {
		gotoxy(23, 1); printf("  ");
		gotoxy(21, 2); printf("  ");
		gotoxy(19, 3); printf("  ");
		gotoxy(17, 4); printf("  ");
		gotoxy(17, 5); printf("  ");
		gotoxy(17, 6); printf("  ");
		gotoxy(17, 7); printf("  ");
		gotoxy(18, 8); printf("  ");
		gotoxy(20, 9); printf("  ");
		gotoxy(21, 10); printf("  ");
		gotoxy(21, 11); printf("  ");
		gotoxy(21, 12); printf("  ");
		gotoxy(21, 13); printf("  ");
		gotoxy(22, 14); printf("  ");
		gotoxy(25, 15); printf("  ");

		gotoxy(24, 1);       printf("□□□□□□□    ");
		gotoxy(22, 2);     printf("□□□□□□□□□     ");
		gotoxy(20, 3);   printf("□□□□□□□□□□□   ");
		gotoxy(18, 4);  printf("□□□□□□□□□□□□   ");
		gotoxy(18, 5); printf("□□□□□□□□□□□□□   ");
		gotoxy(18, 6); printf("□□■□□□□□□□■□□    ");
		gotoxy(18, 7); printf("□□■■■□□□■■■□□   ");
		gotoxy(19, 8);  printf("*□■■■■■■■■■□*    ");
		gotoxy(21, 9);    printf("*□□□■■■□□□*    ");
		gotoxy(22, 10);    printf("□■□□■□□■□   ");
		gotoxy(22, 11);    printf("□□■□■□■□□   ");
		gotoxy(22, 12);    printf("□□■□■□■□□   ");
		gotoxy(22, 13);    printf("□□■□■□■□□   ");
		gotoxy(23, 14);     printf("*□□□□□□□*   ");
		gotoxy(26, 15);        printf("□□□□□    ");
		gal->BOSS_COORD_X1 = 18;
		gal->BOSS_COORD_X2 = 44;
	}
	/* 보스 움직임 구현 */
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

void SKILL_TIME(struct gallaga *gal) {
	double buffer = 0;

	time(&s4);

	buffer = difftime(s4, s3);


	if (buffer > 9) {
		if (gal->KEY_CONTRARY) {
			gal->KEY_CONTRARY = 0;
			gotoxy(15, 20); printf("                                          ");
			gotoxy(15, 21); printf("                                          ");
		}
		if (gal->ATTACK_NUMBER_PLUS) {
			gal->ATTACK_NUMBER_PLUS = 0;
			gal->attack_number = 0.3;
			gotoxy(15, 20); printf("                                          ");
			gotoxy(15, 21); printf("                                          ");
		}
	}

	return;
}

void BOSSSTAGE(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0, x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	system("mode con cols=80 lines=35");
	MAP_DRAW_BOSSSTAGE();

	/* 구조체 변수들을 초기화 */
	gal->flight_x = 27;
	gal->missile = 0;
	gal->Game_End = 0;
	gal->missile_stop = 0;
	gal->flag = 1;
	gal->for_flag = 0;
	gal->missile_distinguish = 0;
	gal->BOSS_HP = 200;
	gal->KEY_CONTRARY = 0;
	gal->ATTACK_NUMBER_PLUS = 0;
	gal->attack_number = 0.3;
	gal->FOR_TIME = 0;
	gal->overlap = 0;
	/* 구조체 변수들을 초기화 */

	BOSSSTAGE_START(gal);

	while (1) {
		Time_Count_BOSSSTAGE(gal);
		Draw_Life_BOSSSTAGE(gal);
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob <= gal->attack_number) { // 확률로 적 공격 개수를 조정하는 곳 (#define attack_number 조정으로 개수 변경 가능)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 좌표까지 랜덤으로 좌표를 찍는다

														/* 처음 시작할때 예외처리 */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */

		/* 크게 for문 2개를 돌려서 아이템, 컴퓨터의 공격, 미사일 발사, 키 입력을 통한 움직임을 구현 */

		BOSS_MOVE(gal);

		for (i = 17; i < 26; i++) {	// 1차 for문
			Time_Count_BOSSSTAGE(gal);

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 만약 키 입력을 받는다면 아래의 if문을 실행한다 */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* 방향키 같은 경우는 int값의 범위를 넘어가기 때문에 두번을 설정해줘야 한다 */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
							}
						}
						break;
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
							}
						}
						break;

					default:
						break;
					}
				}



				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case ESC:
						return;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			}

			/* 키 입력이 없다면 아래의 else문을 실행한다 */
			else {
				Time_Count_BOSSSTAGE(gal);

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* gal->missile_distinguish는 미사일이 발사 중일때 또 미사일을 발사 못하게 하는 변수이다 */
				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (BOSS_CLEAR(gal)) {
							system("cls");
							gotoxy(25, 10);  printf("***CLEAR***");
							time(&s5);
							gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;

							system("pause");
							return;
						}

					}
				}
				/* 미사일 발사 부분 끝 */

				/*↓↓↓ 컴퓨터 공격 부분 ↓↓↓*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 9);
					printf("I");
					gotoxy(attack_x[1][j], i + 8);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 25) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf(" ");
					}
				}
				if (i == 24) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1차 for문 종료

		BOSS_MOVE(gal);

		for (i = 26; i < 35; i++) {	// 2차 for문 시작
			Time_Count_BOSSSTAGE(gal);

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 키 입력을 받는다면 if 문 실행 */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			} // 키 입력일 경우 끝

			  /*키 입력이 없을 경우*/
			else {
				Time_Count_BOSSSTAGE(gal);

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (BOSS_CLEAR(gal)) {
						system("cls");
						gotoxy(25, 10);  printf("***CLEAR***");
						time(&s5);
						gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
						system("pause");
						return;
					}
				}


				/* 미사일 발사 부분 끝 */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ↓↓↓ 컴퓨터 공격 부분 ↓↓↓ */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I들의 좌표를 gal 구조체에 넘겨준다 */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *들의 좌표를 gal 구조체에 넘겨준다
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 9);
					printf("I");
					gotoxy(attack_x[1][j], i - 10);
					printf("  ");
				}
				if (i == BOSSMODE_Y_END + 1) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf("  ");
					}
				}
				if (i == BOSSMODE_Y_END) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2차 for문 종료

		BOSS_MOVE(gal);
	}// while문 종료	
	return;
}

/* 게임방법 출력 함수 */
void HOW_PLAY() {
	int i = 2;
	char key = '0';

	system("cls");
	gotoxy(i, 1); printf("==========================GAME MENUAL==========================");
	gotoxy(i, 2); printf("<목표>");
	gotoxy(i, 3); printf("STAGE 1 : 적 미사일을 피해 빠른시간 안에 (□,■)을 모두 제거");
	gotoxy(i, 4); printf("BOSS STAGE : BOSS가 죽을 때까지 공격");
	gotoxy(i, 6); printf("<게임방법>");
	gotoxy(i, 7); printf("1) Easy mode, Hard mode를 설정하세요.");
	gotoxy(i, 8); printf("tip) Hard mode는 적 미사일이 매우 많습니다!!");
	gotoxy(i, 10); printf("2) 우측 하단에 표시된 기본 설정 key를 이용해서 게임을 진행하세요.");
	gotoxy(i, 11); printf("(-> : 우측 이동, <- : 좌측 이동, SPACE : 미사일 발사, M : 아이템 사용)");
	gotoxy(i, 13); printf("3) 게임 진행 중 잠시 멈추시고 싶으시면 P KEY를 이용하시면 됩니다");
	gotoxy(i, 15); printf("4) 적 미사일(I)에 맞으면 Life(♥)가 1개 감소합니다");
	gotoxy(i, 17); printf("5) 미사일을 이용해 Item(◆,◇)을 맞추면 아이템 사용이 가능합니다");
	gotoxy(i, 18); printf("   45%% - Life 증가, 45%% - ↑스킬, 10%% - 이지모드 클리어");
	gotoxy(i, 20); printf("6) BOSS는 체력 상황에 따라 색깔이 변합니다");
	gotoxy(i, 21); printf("   (색깔이 변할때 10초간 스킬을 사용합니다)");
	gotoxy(i, 23); printf("7) 게임 클리어시 RANKING에 저장될 ID를 입력해주세요.");
	gotoxy(i, 24); printf("8) 미사일은 한번에 하나씩만 발사 가능합니다.");
	gotoxy(i, 28); printf("뒤로 돌아가시려면 SPACE BAR를 눌러주세요.");

	do {
		key = _getch();
	} while (key != SPACE);


	switch (key) {
	case SPACE:
		system("cls");
		return;
	}
}

void HARD_MODE_STAGE1(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0;
	int x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	/* 구조체 변수들을 초기화 */
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION[i] = 0;
	}
	gal->missile_distinguish = 0;
	gal->flight_x = 27;
	gal->missile = 0;
	gal->item1_x = 10;
	gal->item2_x = 55;
	gal->item3_x = 1;
	gal->item1_go = 1;
	gal->item2_go = 1;
	gal->item3_go = 1;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->EASYMODE_STAGE1_CLEAR = 0;
	gal->missile_stop = 0;
	gal->ITEM1 = 1;
	gal->ITEM2 = 1;
	gal->ITEM3 = 1;
	gal->attack_number = 0.4;
	/* 구조체 변수들을 초기화 */
	MAP_DRAW_HARD_STAGE1();
	OBSTACLE_COORD(gal);

	/* 게임 시작 및 time count 시작 지점 */
	gotoxy(gal->flight_x, user_y_end);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("Ж");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, user_y_center);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, user_y_center);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, user_y_center);
	puts("        ");
	time(&s1);
	/* 게임 시작 및 time count 시작 지점 */


	while (1) {	// while 문 시작
		Time_Count();
		Draw_Life(gal);
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob < gal->attack_number) { // 확률로 적 공격 개수를 조정하는 곳 (#define attack_number 조정으로 개수 변경 가능)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 좌표까지 랜덤으로 좌표를 찍는다

														/* 처음 시작할때 예외처리 */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */

		/* 크게 for문 2개를 돌려서 아이템, 컴퓨터의 공격, 미사일 발사, 키 입력을 통한 움직임을 구현 */
		for (i = 8; i < 16; i++) {	// 1차 for문
			Time_Count();
			gotoxy(12, 12); printf("                         ");
			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 만약 키 입력을 받는다면 아래의 if문을 실행한다 */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* 방향키 같은 경우는 int값의 범위를 넘어가기 때문에 두번을 설정해줘야 한다 */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // 전에 있던 Ж를 지운다
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // 전에있던 Ж를 지운다
							printf(" ");
							break;
						}
					default:
						break;
					}
				}

				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;

					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;

					case 'A':
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			}

			/* 키 입력이 없다면 아래의 else문을 실행한다 */
			else {
				Time_Count();

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아이템 움직이는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("◆");
						}
						else {
							puts("◇");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x++;
					}
					if (gal->ITEM2) {
						gal->item2_x--;
					}
					if (gal->ITEM3) {
						gal->item3_x++;
					}
				}
				/*1,3번 아이템과 2번 아이템은 방향이 반대로 움직인다*/

				/* gal->missile_distinguish는 미사일이 발사 중일때 또 미사일을 발사 못하게 하는 변수이다 */
				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
								EASY_MODE_STAGE1_CLEAR(gal);
							}
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						ITEM_ACT(gal);

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (gal->EASYMODE_STAGE1_CLEAR) {
							system("cls");
							gotoxy(25, 10);
							printf("***CLEAR***");
							time(&s2);
							gal->STAGE1_TIME = difftime(s2, s1);
							system("pause");
							return;
						}

					}
				}
				/* 미사일 발사 부분 끝 */

				/*↓↓↓ 컴퓨터 공격 부분 ↓↓↓*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 8);
					printf("I");
					gotoxy(attack_x[1][j], i + 7);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 15) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[1][k], user_y_end);
						printf(" ");
					}
				}
				if (i == 15) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1차 for문 종료

		for (i = 16; i < 24; i++) {	// 2차 for문 시작
			Time_Count();
			gotoxy(12, 12); printf("                         ");

			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 키 입력을 받는다면 if 문 실행 */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // 전에 있던 Ж를 지운다
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
							gotoxy(gal->flight_x, user_y_end); // 이동한 좌표로 찍는다
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("Ж");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // 전에있던 Ж를 지운다
							printf(" ");
							break;
						}
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("↑ 스킬 발동!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("↑");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case 'A':
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			} // 키 입력일 경우 끝

			  /*키 입력이 없을 경우*/
			else {
				Time_Count();

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아이템 움직이는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("◆");
						}
						else {
							puts("◇");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("◇");
						}
						else {
							puts("◆");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x--;
					}
					if (gal->ITEM2) {
						gal->item2_x++;
					}
					if (gal->ITEM3) {
						gal->item3_x--;
					}
				}
				/* 아이템 움직이는 부분 끝 */

				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
							EASY_MODE_STAGE1_CLEAR(gal);
						}
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					ITEM_ACT(gal);

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (gal->EASYMODE_STAGE1_CLEAR) {
						system("cls");
						gotoxy(25, 10);
						printf("***CLEAR***");
						time(&s2);
						gal->STAGE1_TIME = difftime(s2, s1);
						system("pause");
						return;
					}
				}


				/* 미사일 발사 부분 끝 */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ↓↓↓ 컴퓨터 공격 부분 ↓↓↓ */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I들의 좌표를 gal 구조체에 넘겨준다 */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *들의 좌표를 gal 구조체에 넘겨준다
				}
				if (i == user_y_end) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[0][k], user_y_end);
						printf(" ");
					}
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 8);
					printf("I");
					gotoxy(attack_x[1][j], i - 9);
					printf("  ");
				}
				if (i == user_y_end) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2차 for문 종료

	}// while문 종료	
	return;
}

void BOSSSTAGE_HARD(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0, x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	system("mode con cols=80 lines=35");
	MAP_DRAW_BOSSSTAGE();

	/* 구조체 변수들을 초기화 */
	gal->flight_x = 27;
	gal->missile = 0;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->missile_stop = 0;
	gal->flag = 1;
	gal->for_flag = 0;
	gal->missile_distinguish = 0;
	gal->BOSS_HP = 200;
	gal->KEY_CONTRARY = 0;
	gal->ATTACK_NUMBER_PLUS = 0;
	gal->attack_number = 0.4;
	gal->FOR_TIME = 0;
	gal->overlap = 0;
	/* 구조체 변수들을 초기화 */

	BOSSSTAGE_START(gal);

	while (1) {
		Time_Count_BOSSSTAGE(gal);
		Draw_Life_BOSSSTAGE(gal);
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob <= gal->attack_number) { // 확률로 적 공격 개수를 조정하는 곳 (#define attack_number 조정으로 개수 변경 가능)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 좌표까지 랜덤으로 좌표를 찍는다

														/* 처음 시작할때 예외처리 */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* 컴퓨터의 공격을 랜덤으로  찍히게 하는 곳 */

		/* 크게 for문 2개를 돌려서 아이템, 컴퓨터의 공격, 미사일 발사, 키 입력을 통한 움직임을 구현 */

		BOSS_MOVE(gal);

		for (i = 17; i < 26; i++) {	// 1차 for문
			Time_Count_BOSSSTAGE(gal);

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 만약 키 입력을 받는다면 아래의 if문을 실행한다 */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* 방향키 같은 경우는 int값의 범위를 넘어가기 때문에 두번을 설정해줘야 한다 */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						/* 키 반대 스킬이 활성화 안 됬을 때 */
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
							}
						}
						/* 키 반대 스킬이 활성화 됬을 때 */
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
							}
						}
						break;
					case RIGHT:
						/* 키 반대 스킬이 활성화 안 됬을 때 */
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
							}
						}
						/* 키 반대 스킬이 활성화 됬을 때 */
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
							}
						}
						break;

					default:
						break;
					}
				}



				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			}

			/* 키 입력이 없다면 아래의 else문을 실행한다 */
			else {
				Time_Count_BOSSSTAGE(gal);

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* gal->missile_distinguish는 미사일이 발사 중일때 또 미사일을 발사 못하게 하는 변수이다 */
				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (BOSS_CLEAR(gal)) {
							system("cls");
							gotoxy(25, 10);  printf("***CLEAR***");
							time(&s5);
							gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
							system("pause");
							return;
						}

					}
				}
				/* 미사일 발사 부분 끝 */

				/*↓↓↓ 컴퓨터 공격 부분 ↓↓↓*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 9);
					printf("I");
					gotoxy(attack_x[1][j], i + 8);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 25) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf(" ");
					}
				}
				if (i == 24) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1차 for문 종료

		BOSS_MOVE(gal);

		for (i = 26; i < 35; i++) {	// 2차 for문 시작
			Time_Count_BOSSSTAGE(gal);

			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* 미사일이 맨 끝에 다다랐을 때 지워주기 위한 for문 */

			/* 키 입력을 받는다면 if 문 실행 */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2만큼 오른쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // 전에있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2만큼 왼쪽으로 이동
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // 이동한 좌표로 찍는다
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("Ж");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // 전에 있던 Ж를 지운다
								printf(" ");
								break;
							}
						}
					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("※ 일시 정지 ※\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* 미사일을 쏘는 경우 */
			} // 키 입력일 경우 끝

			  /*키 입력이 없을 경우*/
			else {
				Time_Count_BOSSSTAGE(gal);

				/* 이 곳에서 Game_Speed를 조정한다 */
				Sleep(gal->GAME_SPEED);

				/* 아래의 if문은 미사일을 발사하는 것처럼 보이게 하는 부분 */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (BOSS_CLEAR(gal)) {
						system("cls");
						gotoxy(25, 10);  printf("***CLEAR***");
						time(&s5);
						gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
						system("pause");
						return;
					}
				}


				/* 미사일 발사 부분 끝 */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ↓↓↓ 컴퓨터 공격 부분 ↓↓↓ */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I들의 좌표를 gal 구조체에 넘겨준다 */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *들의 좌표를 gal 구조체에 넘겨준다
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 9);
					printf("I");
					gotoxy(attack_x[1][j], i - 10);
					printf("  ");
				}
				if (i == BOSSMODE_Y_END + 1) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf("  ");
					}
				}
				if (i == BOSSMODE_Y_END) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2차 for문 종료

		BOSS_MOVE(gal);
	}// while문 종료	
	return;

	return;
}

void MAP_DRAW_HARD_STAGE1() {
	int i = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, puts_easymode_y);
	puts("HARD Mode");
	gotoxy(easy_mode_menu, puts_time_y);
	puts("time : ");
	gotoxy(easy_mode_menu, puts_besttime_y);
	puts("Best time :");
	gotoxy(easy_mode_menu, puts_life_y);
	puts("Life : ");
	gotoxy(easy_mode_menu, puts_item_y);
	puts("Item : ");
	gotoxy(easy_mode_menu, puts_SPACE_y);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, puts_M_y);
	puts("M : Item use");
	gotoxy(easy_mode_menu, puts_P_y);
	puts("P : Pause");
	gotoxy(easy_mode_menu, puts_ESC_y);
	puts("ESC : Quit");

	for (i = 0; i < user_y_end + 1; i++) {
		gotoxy(57, i); puts("│");
	}

	gotoxy(57, 7);
	printf("├──────────");

	gotoxy(57, 13);
	printf("├──────────");

	gotoxy(3, 2);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //x좌표 1 4  9 12  17 20  25 28  33 36  41 44  49 52
	gotoxy(3, 4);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //55,4
	gotoxy(3, 6);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("□ □   □ □   □ □   □ □   □ □   □ □   □ □"); //55,2
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

/* 이지모드 랭킹을 매기는 함수 */
void RANKING_EASY(struct gallaga *gal) {
	char ch = '0';
	int i = 0, j = 0, k = 0, l = 0, m = 0;
	int buffer = 0;
	char ch_buffer[20];

	gal->USER_NUM_EASY++;

	printf("INPUT USER NAME : ");
	while (ch != '\n') {
		ch = getchar();
		gal->ID_EASY[gal->USER_NUM_EASY - 1][i] = ch;
		i++;
	}

	/* USER_tIME에 순서대로 총 걸린 시간을 넣어준다 */
	gal->USER_TIME_EASY[gal->USER_NUM_EASY - 1] = gal->TOTAL_TIME;

	/* 시간 기준으로 오름차순으로 정렬 -> 즉, 짧은 시간순으로 랭크 */
	for (l = 0; l < gal->USER_NUM_EASY - 1; l++) {
		for (i = 0; i < gal->USER_NUM_EASY - 1; i++) {
			for (j = 0; j < gal->USER_NUM_EASY - 1; j++) {
				if (gal->USER_TIME_EASY[j] > gal->USER_TIME_EASY[j + 1]) {
					buffer = gal->USER_TIME_EASY[j];
					gal->USER_TIME_EASY[j] = gal->USER_TIME_EASY[j + 1];
					gal->USER_TIME_EASY[j + 1] = buffer;

					k = 0;
					for (m = 0; m < 20; m++) {
						ch_buffer[m] = '0';
					}
					while (ch_buffer[k] != '\n') {
						ch_buffer[k] = gal->ID_EASY[l][j];
						gal->ID_EASY[l][j] = gal->ID_EASY[l][j + 1];
						gal->ID_EASY[l][j + 1] = ch_buffer[k];
					}
				}
			}
		}
	}
	/* 이 과정이 끝나면 시간이 짧은 순서대로 ID는 gal->ID[0]부터, 시간은 gal->USER_TIME[0]부터 랭크된다 */

	return;
}

/* 이지모드 랭킹을 보여주는 함수 */
void SHOW_RANKING_EASY(struct gallaga *gal) {
	int i = 0, j = 0;
	int minute[10] = { 0, }, sec[10] = { 0, };
	int buffer[10] = { 0, };
	char ch = '0';

	for (i = 0; i < gal->USER_NUM_EASY; i++) {
		buffer[i] = gal->USER_TIME_EASY[i];
		minute[i] = buffer[i] / 60;
		sec[i] = buffer[i] % 60;
	}

	gotoxy(1, 1); printf("===================RANKING LIST (EASY)===================\n");
	for (i = 0; i < gal->USER_NUM_EASY; i++) {
		if (buffer[i] < 60) {
			gotoxy(1, i + 2);
			printf("%d위 ", i + 1);
			printf("%d초 ", sec[i]);
			j = 0;
			ch = '0';
			while (ch != '\n') {
				ch = gal->ID_EASY[i][j];
				printf("%c", ch);
				j++;
			}
		}
		else {
			printf("%d위 ", i + 1);
			printf("%d분 %d초", minute[i], sec[i]);
			j = 0;
			while (ch != '\n') {
				ch = gal->ID_EASY[i][j];
				printf("%c", ch);
				j++;
			}
		}
	}

	system("pause");
	return;

}

/* 하드모드 랭킹을 매기는 함수 */
void RANKING_HARD(struct gallaga *gal) {
	char ch = '0';
	int i = 0, j = 0, k = 0, l = 0, m = 0;
	int buffer = 0;
	char ch_buffer[20];

	gal->USER_NUM_HARD++;

	printf("INPUT USER NAME : ");
	while (ch != '\n') {
		ch = getchar();
		gal->ID_HARD[gal->USER_NUM_HARD - 1][i] = ch;
		i++;
	}

	/* USER_tIME에 순서대로 총 걸린 시간을 넣어준다 */
	gal->USER_TIME_HARD[gal->USER_NUM_HARD - 1] = gal->TOTAL_TIME;

	/* 시간 기준으로 오름차순으로 정렬 -> 즉, 짧은 시간순으로 랭크 */
	for (l = 0; l < gal->USER_NUM_HARD - 1; l++) {
		for (i = 0; i < gal->USER_NUM_HARD - 1; i++) {
			for (j = 0; j < gal->USER_NUM_HARD - 1; j++) {
				if (gal->USER_TIME_HARD[j] > gal->USER_TIME_HARD[j + 1]) {
					buffer = gal->USER_TIME_HARD[j];
					gal->USER_TIME_HARD[j] = gal->USER_TIME_HARD[j];
					gal->USER_TIME_HARD[j] = buffer;

					k = 0;
					for (m = 0; m < 20; m++) {
						ch_buffer[m] = '0';
					}
					while (ch_buffer[k] != '\n') {
						ch_buffer[k] = gal->ID_HARD[l][j];
						gal->ID_HARD[l][j] = gal->ID_HARD[l][j + 1];
						gal->ID_HARD[l][j + 1] = ch_buffer[k];
					}
				}
			}
		}
	}
	/* 이 과정이 끝나면 시간이 짧은 순서대로 ID는 gal->ID[0]부터, 시간은 gal->USER_TIME[0]부터 랭크된다 */

	return;
}

/* 하드모드 랭킹을 보여주는 함수 */
void SHOW_RANKING_HARD(struct gallaga *gal) {
	int i = 0, j = 0;
	int minute[10] = { 0, }, sec[10] = { 0, };
	int buffer[10] = { 0, };
	char ch = '0';

	for (i = 0; i < gal->USER_NUM_HARD; i++) {
		buffer[i] = gal->USER_TIME_HARD[i];
		minute[i] = buffer[i] / 60;
		sec[i] = buffer[i] % 60;
	}

	gotoxy(1, 1); printf("===================RANKING LIST (HARD)===================\n");
	for (i = 0; i < gal->USER_NUM_HARD; i++) {
		if (buffer[i] < 60) {
			gotoxy(1, i + 2);
			printf("%d위 ", i + 1);
			printf("%d초 ", sec[i]);
			j = 0;
			ch = '0';
			while (ch != '\n') {
				ch = gal->ID_HARD[i][j];
				printf("%c", ch);
				j++;
			}
		}
		else {
			printf("%d위 ", i + 1);
			printf("%d분 %d초", minute[i], sec[i]);
			j = 0;
			while (ch != '\n') {
				ch = gal->ID_HARD[i][j];
				printf("%c", ch);
				j++;
			}
		}
	}

	system("pause");
	return;

}

/* 랭크 보기 모드 선택 */
char select_rank() {
	char MODE = '0';

	puts("");
	puts("     ■■■            ");
	puts("   ■      ■       ■ ■                             ┍─ ─ ─ ─ ─ ─ ─ ─┓");
	puts("   ■                ■ ■                            │  1. EASY MODE RANK    │");
	puts("   ■                ■ ■                            │                       │");
	puts("   ■    ■■  ■■  ■ ■   ■■    ■■   ■■      │                       │");
	puts("   ■      ■ ■  ■  ■ ■ ■  ■  ■  ■ ■  ■     │                       │");
	puts("     ■■■    ■■■  ■ ■ ■■■  ■■   ■■■    │  2. HARD MODE RANK    │");
	puts("                                        ■            ┖─ ─ ─ ─ ─ ─ ─ ─┛");
	puts("                                     ■■ ");

	do {
		MODE = _getch();
	} while (MODE<'1' || MODE>'2');
	system("cls");

	return MODE;
}

void Game_Option(struct gallaga *gal) {

	gotoxy(20, 8);
	printf("GAME SPEED 숫자를 입력해주세요\n    (0~100의 숫자를 입력해주세요 숫자가 커질수록 속도가 느려집니다.)\n");
	scanf_s("%d", &(gal->GAME_SPEED));

	return;
}
/* 함수 정의 끝 */