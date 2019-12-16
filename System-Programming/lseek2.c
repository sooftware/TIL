#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

void main(){
	int fd,ret;
	unsigned char wdata[256];
	unsigned char rdata;
	int i;
	fd=open("./lseekfile",O_CREAT | O_RDWR | O_TRUNC, 0644);
	if(fd==-1){
		perror("open");
		exit(-1);
	}
	for(i=0;i<256;i++){
		wdata[i]=i;
	}
	write(fd,wdata,sizeof(wdata));

	lseek(fd,0,SEEK_SET);
	read(fd,&rdata,1);
	printf("0,SEEK_SET:%d\n",rdata);
	lseek(fd,128,SEEK_SET);
	read(fd,&rdata,1);
	printf("128,SEEK_SET:%d\n",rdata);
	lseek(fd,-1,SEEK_END);
	ret=read(fd,&rdata,1);
	if(ret==-1){
		perror("read");
	}
	printf("0,SEEK_END:%d read = %d\n",rdata, ret);
	close(fd);
}
