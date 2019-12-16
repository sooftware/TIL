#include <errno.h>
#include <stdio.h>
#include <unistd.h>

int main(){
	int fd;
	//esint errno;
	//errno=0;
	if(fsync(fd)==-1)
		perror("fsync");
	printf("%d\n",errno);
}

/*

error가 나면(-1을 반환하면)
perror함수로 무슨 오류인지 확인한다.

*/
