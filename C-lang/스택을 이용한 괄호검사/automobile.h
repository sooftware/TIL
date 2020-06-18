/*
2014707073 김수환
2018년도 1학기 9주차 소프트웨어설계 실습 및 과제
*/

#include <stdio.h>
#include <windows.h>
#include <stdlib.h>
#include <conio.h>

#define random_column() rand()%3+1 // 1~3
#define random_coord() (rand()%30+1)*2 //  1~60
#define random_velocity() rand()%100+1
#define end_of_map 62
#define bottom_of_track 9
#define top_of_track 2
/*
랜덤으로 장애물의 세로의 길이를 위해 #define random_column() rand()%3+1
랜덤으로 장애물의 x좌표를 위해 #define random_coord() (rand()%30+1)*2
랜덤으로 자동차의 속도를 구현해주기 위해 Sleep안에 들어갈 변수를 위한 #define random_velocity()
*/

/* 구조체 선언 */

/* 자동차의 움직임을 정해줄 키와 남은 기름 구조체 */
struct automobile_moving {
	char forward, up, down, backward;
	int oil;
	int velocity;
}automobile_moving;

/* 자동차의 좌표를 저장해줄 구조체 */
struct automobile_coord {
	int x_coord;
	int y_coord;
}automobile_coord;

/* 장애물에 관련된 변수들을 저장해줄 구조체 */
struct obstacle {
	int coord[5];
	int num;
	int x_coord[10], y_coord[10];
}obstacle;

struct automobile_moving automobile_moving;
struct automobile_coord automobile_coord;
struct obstacle obs;

/* 함수 선언 */
void gotoxy(int x, int y);
void user_setting(struct automobile_moving *automobile_moving, struct obstacle *obs); // 유저에게 세팅값을 입력받는 함수
void draw_map(); // 맵을 그려주는 함수
void automobile_move(struct automobile_moving *automobile_moving, struct automobile_coord *automobile_coord, struct obstacle *obs); // 자동차를 움직여줄 함수
void draw_obstacle(struct obstacle *obstacle); // 장애물을 그려줄 함수
void obs_sorting(struct obstacle *obs); // 장애물 좌표들을 크기순으로 정렬해주는 함수

/* 함수 정의 */
void gotoxy(int x, int y) {
	COORD Pos;
	Pos.X = x;
	Pos.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void user_setting(struct automobile_moving *automobile_moving, struct obstacle *obs) {
	int i = 0;

	printf("플레이어 세팅\n");
	printf("플레이어 입력 전진 Key : ");
	scanf_s(" %c", &automobile_moving->forward);

	printf("플레이어 입력 up Key : ");
	scanf_s(" %c", &automobile_moving->up);

	printf("플레이어 입력 down Key : ");
	scanf_s(" %c", &automobile_moving->down);

	printf("플레이어 입력 backward Key : ");
	scanf_s(" %c", &automobile_moving->backward);

	printf("장애물 개수 입력 : ");
	scanf_s(" %d", &obs->num);

	return;
}

void automobile_move(struct automobile_moving *automobile_moving, struct automobile_coord *automobile_coord, struct obstacle *obs) {
	char key;
	int obs_coord_num = 0;
	int i = 0;
	int oil_count = 0;
	int velocity = 0;
	////////////
	automobile_coord->x_coord = 0;
	automobile_coord->y_coord = 5;
	automobile_moving->oil = 10;
	// 처음 자동차의 좌표를 (0,5)로 설정해주고, 처음 자동차의 기름을 10으로 설정
	velocity = random_velocity();

	while (1) {
		///////////
		gotoxy(0, 11);
		printf("남은 기름 : ");
		for (i = 0; i < automobile_moving->oil; i += 2) {
			gotoxy(i + 10, 11);
			printf("★");
		}
		gotoxy(automobile_moving->oil + 10, 11);
		printf("  ");
		///////////// 처음에는 별 5개의 기름에서 시작하다가 키 값을 10번 입력받을때마다 하나씩 줄어드게 한다.

		_kbhit(); // visual studio 2015 에서는 _kbhit라 이렇게 씀
		key = _getch();
		oil_count++; // 키를 입력받을때마다 oil_count를 ++한다.
		if (oil_count == 10) {
			automobile_moving->oil = automobile_moving->oil - 2;
			oil_count = 0;
		}// 키를 10번 입력받을 때마다 automobile_moving->oil이 2씩 줄어든다
		//////
		if (automobile_moving->oil == 0) {
			system("cls");
			gotoxy(10, 10);
			printf("탈출에 실패하였습니다!!!!");
			gotoxy(10, 11);
			system("pause");
			return;
		}
		///////// 자동차의 기름이 0이되면 탈출이 실패하고 게임을 끝낸다

		/////////////
		if (automobile_coord->x_coord < obs->x_coord[0]) {
			obs_coord_num = 0;
		}
		for (i = 0; i < obs->num; i++) {
			if (automobile_coord->x_coord == obs->x_coord[i]) {
				obs_coord_num = i;
			}
		}
		for (i = 1; i < obs->num + 1; i++) {
			if (automobile_coord->x_coord < obs->x_coord[i] && automobile_coord->x_coord > obs->x_coord[i - 1]) {
				obs_coord_num = i;
			}
		}
		/////////////
		/*
		void obs_sorting(struct obstacle *obs) 함수로 장애물의 좌표들을 x좌표 기준으로 오름차순으로 정렬을 해놨으므로,
		현재 자동차의 위치에 따라 obs_coord_num의 값을 변경해준다. obs_coord_num은 obs->x_coord[]와 obs->y_coord[]의 몇번째 값인지를 알려줄 값이다.
		즉 obs->x_coord[obs_coord_num], obs->y_coord[obs_coord_num]을 이용하여, 장애물을 만났을 때 움직이지 못하도록 처리한다.
							l							l						l						l
		obs_coord_num=0		l    obs_coord_num=1		l	obs_coord_num=2		l	obs_coord_num=3		l
							l							l						l						l
		장애물의 위치		1(장애물)					2						3						4 ... 이런식
		*/
		//////
		if (key == automobile_moving->backward) { // 왼쪽 즉 뒤로 이동
			if (automobile_coord->x_coord == 0) { // 왼쪽 끝일때의 예외처리
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);  // 자동차의 좌표로 gotoxy로 이동해준다.
				Sleep(10 * velocity); // 움직임을 조금씩 끊어주기 위해 Sleep을 씀
				printf("♠");
			}
			else if (automobile_coord->x_coord - 2 == obs->x_coord[obs_coord_num - 1] && automobile_coord->y_coord <= obs->y_coord[obs_coord_num - 1]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("♠");
			} // 장애물을 만났을때 이동 못하도록 처리
			else {// 위의 두가지 경우를 제외한 경우 뒤로 이동
				automobile_coord->x_coord = automobile_coord->x_coord - 2;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // 움직임을 조금씩 끊어주기 위해 Sleep을 씀
				printf("♠");
				gotoxy(automobile_coord->x_coord + 2, automobile_coord->y_coord); // 그전에 있던
				printf(" "); // ♠을 지워줌
			}
		}
		else if (key == automobile_moving->forward) { // 오른쪽 즉 앞으로 이동
			///
			if (automobile_coord->x_coord + 2 == obs->x_coord[obs_coord_num] && automobile_coord->y_coord <= obs->y_coord[obs_coord_num]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("♠");
			}// 장애물을 만났을때 이동 못하도록 처리

			///
			else {
				automobile_coord->x_coord = automobile_coord->x_coord + 2;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // 움직임을 조금씩 끊어주기 위해 Sleep을 씀
				printf("♠");
				gotoxy(automobile_coord->x_coord - 2, automobile_coord->y_coord); // 그전에 있던
				printf(" "); // ♠을 지워줌
			}
			if (automobile_coord->x_coord == end_of_map) { // 게임이 승리할 조건 자동차가 끝에 다다르면 승리
				system("cls");
				gotoxy(10, 10);
				printf("탈출에 성공하였습니다!!!!");
				gotoxy(10, 11);
				system("pause");
				return;
			}
		}
		else if (key == automobile_moving->up) { // 위로 이동하는 함수
			if (automobile_coord->y_coord == top_of_track) { // 트랙보다 위로 가면 안되므로 예외처리
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("♠");
			}
			else if (automobile_coord->x_coord == obs->x_coord[obs_coord_num] && automobile_coord->y_coord - 1 <= obs->y_coord[obs_coord_num]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("♠");
			}// 위에 장애물이 있을 때 못 움직이도록 설정
			else {
				automobile_coord->y_coord = automobile_coord->y_coord - 1;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("♠");
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord + 1); // 그전에 있던
				printf(" "); // ♠을 지워줌
			}// 위의 두 경우를 제외하고는 위로 이동하도록 설정
		}
		else if (key == automobile_moving->down) { // 밑으로 이동
			if (automobile_coord->y_coord == bottom_of_track) { // 트랙보다 밑으로 가면 안되므로 예외처리
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // 움직임을 조금씩 끊어주기 위해 Sleep을 씀
				printf("♠");
			}
			else {
				automobile_coord->y_coord = automobile_coord->y_coord + 1;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // 움직임을 조금씩 끊어주기 위해 Sleep을 씀
				printf("♠");
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord - 1); // 그전에 있던
				printf(" "); // ♠을 지워줌
			}
		}
	}
	return;
}

void draw_map() { // 트랙을 그려주는 함수
	int i = 0;

	for (i = 0; i <= end_of_map; i += 2) {
		gotoxy(i, 1);
		printf("■");
	}

	for (i = 0; i <= end_of_map; i += 2) {
		gotoxy(i, 10);
		printf("■");
	}
}

void draw_obstacle(struct obstacle *obs) { // 장애물을 랜덤으로 그려주는 함수
	int i = 0, j = 0;
	int column = 0, coord = 0;

	for (j = 0; j < obs->num; j++) {
		obs->x_coord[j] = 0;
		obs->y_coord[j] = 0;
	} // obs 값들 초기화


	for (j = 0; j < obs->num; j++) {
		column = random_column() + 1; // 장애물 세로 좌표로 2~4가 찍히도록 설정
		coord = random_coord(); // 장애물 x 좌표가 1~60으로 랜덤으로 찍히도록 설정 

		for (i = 2; i <= column; i++) {
			gotoxy(coord, i);
			printf("■");
		}
		/*
		즉, 랜덤으로 직힌 coord를 이용해
		(coord,2~column)까지 장애물이 찍힌다
		*/
		obs->x_coord[j] = coord;
		obs->y_coord[j] = column;

		for (i = j; i > 0; i--) {
			if (coord == obs->x_coord[i - 1]) {
				j--;
			}
		}		// coord값이 겹칠 경우를 생각하여 새로 생긴 coord값이 이 전의 coord값과 같으면 j를 하나 줄여줌으로써 다시 반복한다.
	}
}

void obs_sorting(struct obstacle *obs) { // obs->x_coord[j],obs->y_coord[j]를 오름차순으로 정렬 (코드짜는데 편의를 위함)
	int i = 0, j = 0;
	int buffer_x = 0, buffer_y = 0;

	for (i = 0; i < obs->num - 1; i++) {
		for (j = 0; j < obs->num - 1; j++) {
			if (obs->x_coord[j] > obs->x_coord[j + 1]) {
				buffer_x = obs->x_coord[j];
				obs->x_coord[j] = obs->x_coord[j + 1];
				obs->x_coord[j + 1] = buffer_x;

				buffer_y = obs->y_coord[j];
				obs->y_coord[j] = obs->y_coord[j + 1];
				obs->y_coord[j + 1] = buffer_y;
			}
		}
	}
	/*
	오름차순으로 sorting한다
	*/
	return;
}
