#include <stdio.h>
#include <unistd.h>
#include <errno.h>

void main(){
	int ret;
	errno=0;

	ret=nice(10);
	if(ret == -1 && errno!=0)
		perror("nice");
	else
		printf("nice value is now %d\n",ret);
}
