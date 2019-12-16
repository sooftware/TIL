#include <stdio.h>
#include <sys/time.h>
#include <sys/resource.h>

void main(){
	int ret;
	ret=getpriority(PRIO_PROCESS, 0);
	printf("nice valus is %d\n",ret);
	ret=setpriority(PRIO_PROCESS,0,10);
	if(ret==-1)
		perror("setpriority");
	printf("change nice valus is %d\n",getpriority(PRIO_PROCESS,0));
	return;
}
