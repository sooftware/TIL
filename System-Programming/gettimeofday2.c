#include <stdio.h>
#include <sys/time.h>

void main(){
	struct timeval tv;
	int ret;
	ret=gettimeofday(&tv,NULL);
	if(ret)
		perror("gettimeofday");
	else
		for(;;){
			gettimeofday(&tv,NULL);
			printf("seconds=%ld useconds=%ld\w",(long)tv.tv_sec,(long)tv.tv_usec);
		}

}
