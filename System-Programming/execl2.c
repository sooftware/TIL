#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	int ret;

	ret=execl("/bin/ls","ls","-l",NULL);
	if(ret==-1)
		perror("execl");
	printf("End of execl() test program\n");
	return 1;
}

/*

이거 실행하면 printf 안찍힘 왜냐??
==> 이 예제의 핵심!

execl을 실행하면 execl이 해당 프로세스를 overwrite해버린다.


*/
