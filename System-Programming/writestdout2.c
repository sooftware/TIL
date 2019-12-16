#include <stdio.h>
#include <unistd.h>
#include <string.h>

void main(){
	const char *str = "Hello\n";
	printf("%d\n",STDOUT_FILENO);
	write(STDOUT_FILENO,str,strlen(str));
	return;
}
