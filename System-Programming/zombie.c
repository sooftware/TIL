#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
int main(void) {
	pid_t pid;
	int i=0;
	pid = fork();
	i+=20;
	if (pid > 0) {
		printf("I am the parent of pid=%d!\n", getpid());
		sleep(30);
	}
	else if (!pid) {
		printf ("I am the child of pid=%d!\n", getpid());
	}
	else if (pid == -1)
		perror ("fork");
	return 1;
}

