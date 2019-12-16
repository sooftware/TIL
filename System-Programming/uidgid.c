#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	uid_t uid;
	gid_t gid;

	uid=getuid();
	gid=getgid();
	printf("User ID = %d,Group ID=%d\n",uid,gid);
	return 0;
}
