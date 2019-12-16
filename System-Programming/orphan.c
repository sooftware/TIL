#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
int main(void) {
	pid_t pid;
	pid = fork();
	if (pid > 0) {
		printf("I am the PID of the Parent=%d!\n", getpid());
	}
	else if (!pid) {
		printf("I am the PID of the Child=%d!\n", getpid());
		printf("I am the PPID of the Child=%d!\n", getppid());
		sleep(10);
		printf("I am the PPID of the Child=%d!\n", getppid());
	}
	else if (pid == -1)
		perror ("fork");
	return 1;
}
