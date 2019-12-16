#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	int ret;

	ret=execl("/bin/ls","ls","-il",NULL);
	if(ret==-1)
		perror("execl");
	return 1;
}

/*

/bin/ls 폴더에서 ls -l 수행한 결과를 출력 

*/
