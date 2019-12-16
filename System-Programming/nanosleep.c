#include <time.h>
#include <stdio.h>

void main(){
	struct timespec req={.tv_sec=0,.tv_nsec=200};
	int ret;
	/* sleep for 200ns */
	ret=nanosleep(&req,NULL);
	if(ret)
		perror("nanosleep");
}
