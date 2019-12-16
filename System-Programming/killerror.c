#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <errno.h>

void main(){
	int ret;
	ret=kill(1,SIGKILL);
	if(ret)
		perror("kill");
}
