#include <stdio.h>
#include <sys/time.h>

void main(){
	struct timeval tv;
	int ret;
	ret=gettimeofday(&tv, NULL);
	if(ret)
		perror("gettimeofday");
	else
		printf("seconds=%ld useconds=%ld\n",
		(long)tv.tv_sec, (long)tv.tv_usec);
}
