#include <stdio.h>
#include <limits.h>
#include <sched.h>
#include <time.h>

void main(){
	int i,j,k;
	clock_t start,end;
	for(int i=0;i<INT_MAX;i++){
		start=clock();
		for(int j=0;j<0x003FFFFF;j++){
			k=j;
		//	sched_yield();
		}
		end=clock();
		printf("Elapsed time(%d) : %f\n", i, (double)(end-start)/CLOCKS_PER_SEC);
	}


	return;
}
