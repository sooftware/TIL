#include <stdio.h>
#include <stdlib.h>

void main(){
	system("grep -c processor /proc/cpuinfo");
	return;
}
