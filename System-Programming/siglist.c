#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

static void sigint_handler(int signo){
	printf("Caught %s\n",sys_siglist[signo]);
	exit(EXIT_SUCCESS);
}

int main(){
	if(signal(SIGINT, sigint_handler) == SIG_ERR){
		fprintf(stderr,"can`t handle SIGINT!\n");
		exit(EXIT_FAILURE);
	}
	for(;;)
		pause();
	return 0;
}
