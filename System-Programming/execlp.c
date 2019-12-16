#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(void){
	int ret;

	ret=execlp("ls","ls","-l",NULL);
	if(ret==-1)
		perror("execlp");

	return 1;
}
