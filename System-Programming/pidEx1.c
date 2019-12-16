#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdint.h>

int main(){
	printf("My pid=%jd\n",(intmax_t)getpid());
	printf("Parent`s pid=%jd\n",(intmax_t)getppid());
	return 1;
}
