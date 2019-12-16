#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

void main(){
	int fd,ret;
	unsigned char wdata[256];
	unsigned char rdata;
	int i;

	fd=open("./preadfile",O_CREAT | O_RDWR | O_TRUNC, 0644);
	if(fd==-1){
		perror("open");
		exit(-1);
	}
	for(i=0;i<256;i++)	
		wdata[i]=i;
	write(fd,wdata,sizeof(wdata));
	pread(fd,&rdata,1,0);
	printf("pread 0:%d\n",rdata);
	pread(fd,&rdata,1,128);
	printf("pread 128:%d\n",rdata);
	pread(fd,&rdata,1,255);
	printf("pread 255:%d\n",rdata);
	close(fd);
}
