#include <stdio.h>
#include <time.h>

void main(){
	clockid_t clocks[]={
	CLOCK_REALTIME, CLOCK_MONOTONIC, CLOCK_PROCESS_CPUTIME_ID,
	CLOCK_THREAD_CPUTIME_ID, CLOCK_MONOTONIC_RAW, (clockid_t)-1};
	int i;
	for(i=0;clocks[i] != (clockid_t)-1;i++){
		struct timespec ts;
		int ret;
		ret=clock_gettime(clocks[i], &ts);
		if(ret)
			perror("clock_Gettime");
		else
			printf("clock=%d sec=%ld nsec=%ld\n",
			clocks[i], ts.tv_sec,ts.tv_nsec);
	}

	return;
}
