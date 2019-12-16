#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main(){
	int fd;
	const char *str="Hello World!\n";
	size_t count;
	ssize_t nr;

	fd=open("./appendwritefile",O_WRONLY | O_CREAT | O_APPEND,0644);
	if(fd==-1){
		perror("open");
		exit(0);
	}
	count=strlen(str);
	nr=write(fd,str,count);
	if(nr==-1)
		perror("write");
	close(fd);
}
