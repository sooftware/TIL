#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#define MAX_THREAD_NUM 100

pthread_mutex_t m_lock = PTHREAD_MUTEX_INITIALIZER;

int total = 0;

void *factorial(void *param){
	int *n = (int*)param;
	int n_fac = 1;

	for(int i = *n; i > 0; i--)
		n_fac *= i;

	printf("n = %d : %d! = %d\n", *n,*n, n_fac);
	pthread_mutex_lock(&m_lock);
	total += n_fac;
	pthread_mutex_unlock(&m_lock);
}

int main(int argc, char *argv[]){
	int num = 0;
	int *arr;

	if(argc != 2) {
		printf("argument must have one\n");
		return 0;
	}

	num = atoi(argv[1]);
	arr = (int*)malloc(num*sizeof(int));
	pthread_t thread_id[num];

	for(int i = 0; i < num ; i++)
		arr[i] = i + 1;

	for(int i = 0; i < num; i++)
		pthread_create(&thread_id[i], NULL, factorial, (void*)&arr[i]);

	for(int i = 0; i < num; i++)
		pthread_join(thread_id[i], NULL);

	pthread_mutex_destroy(&m_lock);
	printf("total : %d\n", total);

	return 0;
}
