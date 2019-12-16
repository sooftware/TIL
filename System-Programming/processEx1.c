#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

void main(){
	printf("My pid = %d\n",getpid());
	getchar();
}

/*

리눅스에서는 unistd라는게 필요하다. -> unix standatd 줄임말
sys/types -> getpid()가  return하는 리턴 값이 pid타입인데,
이를 사람이 보기 불편하니, 보기 편하게 알아서 바꿔주는 것인듯. 
-> define으로 되어있다함.

pid는 unsigned int로 define 되어 있을 것.

쉽게말하면 내가 int형 boolean 쓰듯이 pid로 쓴거 원래대로 바꿔주는 거인듯.:

*/
