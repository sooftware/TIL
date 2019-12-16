#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

void main(){
	int fd;
	unsigned int word=1720;
	size_t count;
	ssize_t nr;

	fd=open("./partialwritefile",O_WRONLY | O_CREAT | O_TRUNC,0644);
	if(fd==-1){
		perror("open");
		exit(0);
	}
	count=sizeof(word);
	printf("%ld",count);
	nr=write(fd,&word,count);
	if(nr==-1)
		perror("write");
	else if(nr!=count)
		printf("Partial write\n");
	close(fd);
}
