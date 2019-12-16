#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void main(){
	pid_t pid;
	printf("Before Kill\n");
	pid=fork();
	if(pid)
		kill(0,SIGKILL);
	else
		pause();
	printf("After Kill\n");
}
