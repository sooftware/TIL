#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
	int status;
	pid_t pid;
	if(!fork()){ // child
		printf("Child PID = %d\n",getpid());
		sleep(10);
		return 1;
	}
	pid=wait(&status);
	if(pid==-1)
		perror("wait");

	// 밑으로 parent

	printf("Parent PID=%d, wait() return pid=%d\n",getpid(),pid);
	if(WIFEXITED(status))
		printf("NOrmal termination with exit status=%d\n",WEXITSTATUS(status));
	if(WIFSIGNALED(status))
		printf("KIlled by signal=%d%s\n",WTERMSIG(status),
			WCOREDUMP(status) ? " (dumped core)" :"");
	return 0;
}
