#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	const char *args[]={"ls","-l",NULL};
	int ret;

	ret=execv("/bin/ls",args);
	if(ret==-1)
		perror("execv");

	return 1;
}
