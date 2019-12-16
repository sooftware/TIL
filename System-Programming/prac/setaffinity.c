#define _GNU_SOURCE
#include <stdio.h>
#include <sched.h>
#include <limits.h>
#include <unistd.h>

void main(){
	cpu_set_t cs;
	int cpus = 0,cpu,ret;
	unsigned int i;
	pid_t pid;

	CPU_ZERO(&cs);
	sched_getaffinity(0, sizeof(cs), &cs);
	for(i=0;i<CPU_SETSIZE;i++){
		if(CPU_ISSET(i, &cs))
			cpus++;
	}
	printf("Total No. of CPUS: %d\n", cpus);

	printf("Input SET_CPU No. 0~%d: ",cpus-1);
	scanf("%d",&cpu);
	CPU_ZERO(&cs);
	CPU_SET(cpu,&cs);
	pid=getpid();
	ret=sched_setaffinity(pid,sizeof(cpu_set_t),&cs);
	if(ret==-1){
		perror("sched_setaffinity");
		return;
	}
	for(i=0;i<UINT_MAX;i++);
}
