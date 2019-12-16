#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void main(){
	sigset_t set, oset, pset;
	
	sigemptyset(&set);
	sigaddset(&set,SIGINT);
	sigprocmask(SIG_BLOCK,&set,&oset);

	printf("Before Kill\n");
	kill(getpid(), SIGINT);
	printf("After Kill\n");

	sigprocmask(SIG_UNBLOCK, &set,&oset);
	printf("Program End\n");
}
