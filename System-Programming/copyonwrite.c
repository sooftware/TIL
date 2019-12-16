#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t pid;
	int i=100;
	pid=fork();

	if(pid>0){
		i+=10;
		printf("P : i=%d\n",i);
	}else if(!pid){
		i+=20;
		printf("C:i=%d\n",i);
	}else if(pid==-1){
		perror("fork");
	}
	printf("i=%d\n",i);
	return 1;
}
