#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void main(){
	sigset_t sigset;

	sigfillset(&sigset);

	sigprocmask(SIG_SETMASK, &sigset, NULL);

	puts("before kill()");
	kill(getpid(),SIGSEGV);
	kill(getpid(),SIGINT);
	puts("after kill()");
}
