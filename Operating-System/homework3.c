#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

pthread_mutex_t m_lock = PTHREAD_MUTEX_INITIALIZER;

void *t_func(void *data){
	int *count = (int*)data;
//	pthread_mutex_lock(&m_lock);
	for(int i = 0; i <100; i++)
		*count = *count + 1;
//	pthread_mutex_unlock(&m_lock);
}

int main(){
	pthread_t thread_id[100];
	int count = 0;
	
	for(int i = 0; i < 100; i++)
		pthread_create(&thread_id[i], NULL, t_func, (void*)&count);

	for(int i = 0; i < 100; i++)
		pthread_join(thread_id[i], NULL);

	pthread_mutex_destroy(&m_lock);

	printf("count : %d\n", count);

	return 0;
}
