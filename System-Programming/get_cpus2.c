#define _GNU_SOURCE
#include <stdio.h>
#include <sched.h>

void main(){
	cpu_set_t cs;
	int cpus=0,i;
	CPU_ZERO(&cs);
	sched_getaffinity(0,sizeof(cs),&cs);

	for(i=0;i<CPU_SETSIZE;i++){
		if(CPU_ISSET(i,&cs))
			cpus++;
	}
	printf("Total No. of CPUs :%d\n",cpus);
}
