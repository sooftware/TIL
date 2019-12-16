#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){
	int status;
	pid_t pid, pid2;
	pid=fork();
	if(!pid) {
		sleep(10);
		return 1;
	}
	pid2=waitpid(pid,&status,0);

	if(pid2==-1)
		perror("waidpid");
	else{
		printf("pid=%d\n", pid2);
		if(WIFEXITED(status))
			printf("NOrmal termination with exit status=%d\n",
			WEXITSTATUS(status));
		if(WIFSIGNALED(status))
			printf("Killed by signal=%d%s\n",
				WTERMSIG(status),WCOREDUMP(status) ? "dumped core" :"");
	}
	return 0;
}
