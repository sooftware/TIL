#include <stdio.h>	/* standard input output */
#include <unistd.h>	/* read()을 위한 #include */
#include <fcntl.h>	/* open()을 위한 #include */
#include <errno.h>	/* perror()를 위한 #include */
#include <stdlib.h>	/* exit()을 위한 #include */

#define HEX 16	/* Hexa 표기를 위한 define */


/* filename[1]에 hewview로 볼 파일이름을넘겨받는다 */
/* argv[0]은 프로그램명을 의미하고, argv[1]부터 넘겨받음 */
int main(int argc, char* filename[]){	
	int fd, fd2;		/* open한 file을 저장하는 변수 */
	unsigned char buf;	/* 파일로부터 1char 단위로 읽어서 받을 변수 */	
	unsigned int count=0;	/* 1씩 증가하며 경우를 나눠주기 위한 변수 */
	char str[HEX];	/* buf를 16개 단위로 저장해서 %x형식으로 */
			/* 출력이 끝나면 char단위로 출력하는 변수 */

	fd = open(filename[1], O_RDONLY);	/* open() 읽기만 하면 되므로, O_RDONLY 옵션 */
	fd2 = open("copy", O_CREAT, O_APPEND, S_IRWXU);

	/* open error 발생시, 에러 알림과 프로그램 종료 */
	if(fd == -1 || fd2 == -1){	
		perror("open");
		exit(0);
	}

	

	/* 파일을 끝까지 읽을때까지 반복 */
	while(read(fd, &buf, sizeof(unsigned char)) > 0){
		write(fd2, &buf, sizeof(buf));
	}

	return 0;
}
