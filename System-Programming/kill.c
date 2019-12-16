#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void main(){
	printf("Before kill\n");
	kill(getpid(),SIGKILL);
	printf("After Kill\n");
}
