#include <unistd.h>
#include <stdio.h>
#include <signal.h>

void alarm_handler(int signum){
	printf("Five seconds passed!\n");

	signal(SIGALRM, alarm_handler);
}

void main(){
	signal(SIGALRM, alarm_handler);
	alarm(5);
}
