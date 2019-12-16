#include <stdio.h>
#include <unistd.h>
#include <string.h>
#define BUFFER 256

void main(){
	char std[BUFFER];
	read(STDIN_FILENO,std,BUFFER);
	write(STDOUT_FILENO,std,strlen(std));

}
