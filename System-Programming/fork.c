#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t pid;	//

	pid=fork();	//	child process면 0을 return 해준다 아니면 0보다 큰 값.
	if(pid>0)	//	0보다 크니까 child 아니니까 부모겠지 뭐
		printf("\nI am parent of pid=%d!\n",pid);

	else if(!pid)	//	pid가 0이면 실행되는 곳 -> child
		printf("I am the child!\n",pid);
	else if(pid == -1)
		perror("fork");
	return -1;
}
