#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>

static void sigint_handler(int signo){
	printf("caught SIGINT!\n");
	exit(EXIT_SUCCESS);
}

int main(){
	printf("test");
	if(signal(SIGINT, sigint_handler)==SIG_ERR){
		fprintf(stderr,"Can`t handle SIGINT!\n");
		exit(EXIT_FAILURE);
	}
	for(;;){
		printf("IN");
		pause();
	}
	return 0;
}
