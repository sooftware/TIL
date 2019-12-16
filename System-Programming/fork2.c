#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t pid;

	pid=fork();

	if(pid>0){
		printf("parent my pid=%d\n",getpid());
		sleep(10);
	}else if(!pid){
		printf("child my pid=%d\n",getpid());
		sleep(10);
	}else if(pid==-1){
		perror("fork");
	}

	return 1;
}
