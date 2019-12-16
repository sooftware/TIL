#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

static pthread_mutex_t the_mutex = PTHREAD_MUTEX_INITIALIZER;
int x = 0;

void *start_thread(void *message){
	int t;
	for(;;){
//		pthread_mutex_lock(&the_mutex);
		t=x;
		t++;
		printf("%s%d\n",(const char *)message,t);
		sleep(1);
		x=t;
//		pthread_mutex_unlock(&the_mutex);
//		sleep(0);
	}
}

int main(void){
	pthread_t t1, t2;

	pthread_create(&t1, NULL, start_thread, (void*) "Thread1:");
	pthread_create(&t2, NULL, start_thread, (void*) "Thread2:");

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);

	return 0;
}
