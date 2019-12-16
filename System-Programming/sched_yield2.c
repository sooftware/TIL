#include <stdio.h>
#include <limits.h>
#include <sched.h>
#include <time.h>
#define NANO_PER_SEC 100000000.0

void main(){
	int i,j,k;
	struct timespec start,end;
	double start_sec,end_sec;

	for(i=0;i<INT_MAX;i++){
		clock_gettime(CLOCK_REALTIME, &start);
		for(j=0;j<0x003FFFFF;j++){
			k=j;
			sched_yield();
		}
		clock_gettime(CLOCK_REALTIME,&end);
		start_sec=start.tv_sec+start.tv_nsec/NANO_PER_SEC;
		end_sec=end.tv_sec+end.tv_nsec/NANO_PER_SEC;
		printf("Elapsed time(%d) :%f\n",i,end_sec-start_sec);
	}

}
