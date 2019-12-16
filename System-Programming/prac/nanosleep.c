#include <stdio.h>
#include <time.h>

void main(){
	struct timespec ts = {.tv_sec=0, .tv_nsec=200};
	int ret=0;
	ret=nanosleep(&ts,NULL);
	if(ret)
		perror("nanosleep");
}
