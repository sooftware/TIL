#include <stdio.h>
#include <time.h>

void main(){
	time_t t;
	for(;;)
		printf("current time: %ld\r",(long)time(&t));
}
