`#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

void main(){
	pid_t pid,i;
	for(i=1;i<5;i++){
		pid=fork();
		if(pid)
			;
		else
			pause();
	}
	printf("Before Kill Group\n");
	system("ps -jf");
	killpg(getpgid(getpid()),SIGKILL);
	printf("After Kill Group\n");
	system("ps -jf");

}
