#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>

static void signal_handler(int signo){
	if(signo==SIGINT)
		printf("Caught SIGINT!\n");
	else if(signo==SIGTERM)
		printf("Caught SIGTERM\n");
	else{
		fprintf(stderr,"Unexpected signal!\n");
		exit(EXIT_FAILURE);
	}
	exit(EXIT_SUCCESS);
}

int main(){
	if(signal(SIGINT, signal_handler)==SIG_ERR){
		fprintf(stderr,"Can`t handle SIGINT!\n");
		exit(EXIT_FAILURE);
	}
	if(signal(SIGTERM, signal_handler)==SIG_ERR){
		fprintf(stderr,"Can`t handle SIGTERM!\n");
		exit(EXIT_FAILURE);
	}


	if(signal(SIGPROF, SIG_DFL)==SIG_ERR){
		fprintf(stderr,"Can`t handle PROF!\n");
		exit(EXIT_FAILURE);
	}
	if(signal(SIGHUP,SIG_IGN)==SIG_ERR){
		fprintf(stderr,"Can`t handle SIGHUP!\n");
		exit(EXIT_FAILURE);
	}
	for(;;)
		pause();
	return 0;
}
