#include <stdio.h>
#include <unistd.h>
#include <string.h>

void main(){
	const char *std="Hello\n";
	write(2,std,strlen(std));
}
