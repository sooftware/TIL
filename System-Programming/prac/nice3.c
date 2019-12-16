#include <stdio.h>
#include <unistd.h>
#include <errno.h>

void main(){
	pid_t pid;
	int ret,i,j;

	pid=fork();
	if(pid>0){
		ret=nice(10);
		if(ret==-1 && errno!=0)
			perror("nice");
		else{
			for(i=0;i<2047;i++){
				for(j=0;j<0x2FFFFFF;j++);
				printf("parent Process nice(10): %d\n",i);
			}
		}
	}else if(!pid){
		ret=nice(-10);
		if(ret==-1 && errno!=0)
			perror("nice");
		else{
			for(i=0;i<2047;i++){
				for(j=0;j<0x2FFFFFF;j++);
				printf("Child Process nice(-10): %d\n",i);
			}
		}
	}else if(pid == -1)
		perror("fork");

	return;
}
