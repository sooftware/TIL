#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>

int main(){
	pid_t pid;
	pid = fork();

	if(pid > 0){
		printf("\nparent remains 30 seconds..\n");
		sleep(30);
	}
	else if(!pid)
		exit(0);
	else if(pid < 0)
		perror("fork");

	return 0;
}
