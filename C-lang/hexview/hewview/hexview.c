/*
*	KwangWoon University
*	전자통신공학과 2014707073 김수환
*	2019년도 1학기 시스템프로그래밍 Homework#1
*/

#include <stdio.h>	/* standard input output */
#include <unistd.h>	/* read()을 위한 #include */
#include <fcntl.h>	/* open()을 위한 #include */
#include <errno.h>	/* perror()를 위한 #include */
#include <stdlib.h>	/* exit()을 위한 #include */

#define HEX 16	/* Hexa 표기를 위한 define */


/* filename[1]에 hewview로 볼 파일이름을넘겨받는다 */
/* argv[0]은 프로그램명을 의미하고, argv[1]부터 넘겨받음 */
int main(int argc, char* filename[]) {
	int fd;		/* open한 file을 저장하는 변수 */
	unsigned char buf;	/* 파일로부터 1char 단위로 읽어서 받을 변수 */
	unsigned int count = 0;	/* 1씩 증가하며 경우를 나눠주기 위한 변수 */
	char str[HEX];	/* buf를 16개 단위로 저장해서 %x형식으로 */
			/* 출력이 끝나면 char단위로 출력하는 변수 */

	fd = open(filename[1], O_RDONLY);	/* open() 읽기만 하면 되므로, O_RDONLY 옵션 */

	/* open error 발생시, 에러 알림과 프로그램 종료 */
	if (fd == -1) {
		perror("open");
		exit(0);
	}

	/* 파일을 끝까지 읽을때까지 반복 */
	while (read(fd, &buf, sizeof(unsigned char)) > 0) {
		str[count % HEX] = buf; /* index가 0~15를 반복해야 하므로 */

		/* 0 16 32 ... 16단위로 끊기 위함 */
		if (!(count % HEX)) {
			printf("\n%.8x: %.2x", count, buf);
		}
		/* 이 외의 경우 */
		else {
			/* 2로 나눔 => " " : 띄어쓰기 해주기 위함 */
			if (count % 2)
				printf("%.2x", buf);
			else
				printf(" %.2x", buf);
		}
		/* 15 30 45 ... 줄을 개행하기 전에 저장한 16개의 char를 출력 */
		if (count % HEX == 15 && count != 0) {
			printf(" ");
			for (int i = 0; i < HEX; i++) {
				/* 출력가능한 ASCII 코드 범위의 경우 */
				if (str[i] > 31 && str[i] < 127)
					printf("%c", str[i]);
				/* 출력 불가능한 ASCII 코드 범위의 경우 */
				else
					printf(".");
			}
		}

		count++;
	}
	close(fd);

	return 0;
}