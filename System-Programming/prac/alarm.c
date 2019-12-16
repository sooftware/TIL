#include <stdio.h>
#include <unistd.h>
#include <unistd.h>
#include <signal.h>

void alarm_handler(int signum){
	printf("Five seconds passed!\n");
}

void main(){
	signal(SIGALRM, alarm_handler);
	alarm(1);
	for(;;);

}
