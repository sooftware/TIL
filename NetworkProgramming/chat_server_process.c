#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <pthread.h>
#define TRUE 1
#define FALSE 0
#define INIT_SIZE 8
#define BUF_SIZE 256
#define MAX_CLIENT 128
#define MAX_ID_LENGTH 32
#define PORTNUM 3500
#define BACKLOG 5
#define NEW_USER_SIGN ("[NEW_USER]")
#define EXIT_SIGN ("EXIT")
#define SHOW_SIGN ("@show\n")
#define KEY 2014
typedef int boolean;
typedef struct SharedArea {
	int client_count;
	int flag[MAX_CLIENT];
	char msg[MAX_CLIENT][BUF_SIZE];
}SharedArea;
pthread_mutex_t mutex;
int client_socks[MAX_CLIENT];
char client_ids[MAX_CLIENT][MAX_ID_LENGTH];

void* broadcast(void *shm);
void recv_msg(int client_sock, int index, void *shm);
void send_msg(char *msg, int client_count, int index);
boolean startswith(char *buf, char *start);
void join(char *msg, int index, void *shm);
void show(int index, char *name, char *content, void *shm);
void disconnect(int disconnect_index, void *shm);
void user_exit(char *msg, char *name, void *shm, int index);
int get_index_by_name(char *name, void *shm);


int main(int argc, char *argv[]) {
	int server_sock, client_sock;
	struct sockaddr_in server, client;
	int client_size;
	int shmid;
	SharedArea shared_area;
	void* shm;
	pthread_t t_id;
	pid_t pid;

	if ((shmid = shmget((key_t)KEY, sizeof(shared_area), IPC_CREAT|0666)) == -1) {
		puts("shared memory error");
		return -1;
	}

	shm = shmat(shmid, (void*)0, 0);
	(*(SharedArea*)shm).client_count = 0;
	memset((*(SharedArea*)shm).flag, FALSE, MAX_CLIENT);
	for (int i = 0; i < MAX_CLIENT; i++)
		memset((*(SharedArea*)shm).msg[i], '\0', BUF_SIZE);

	server_sock = socket(PF_INET, SOCK_STREAM, 0);

	memset(&server, 0, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	server.sin_port = htons(PORTNUM);

	if (bind(server_sock, (struct sockaddr*)&server, sizeof(server)) == -1) {
		perror("bind error");
		exit(1);
	}

	if (listen(server_sock, BACKLOG) == -1) {
		perror("listend error");
		exit(1);
	}

	pthread_create(&t_id, NULL, broadcast, (void*)shm);

	while (TRUE) {
		client_size = sizeof(client);
		client_sock = accept(server_sock, (struct sockaddr*)&client, &client_size);
		client_socks[(*(SharedArea*)shm).client_count++] = client_sock;

		if ((pid = fork()) == 0) {
			recv_msg(client_sock, (*(SharedArea*)shm).client_count - 1, shm);	
		}
	}

	close(server_sock);
	return 0;
}


void* broadcast(void *shm) {
	char buf[BUF_SIZE];
	char *name, *content;

	while (TRUE) {
		for (int i = 0; i < (*(SharedArea*)shm).client_count; i++) {
			if ((*(SharedArea*)shm).flag[i]) {

				if (startswith((*(SharedArea*)shm).msg[i], NEW_USER_SIGN)){
					join((*(SharedArea*)shm).msg[i], i, shm);
				}
				else{
					strcpy(buf, (*(SharedArea*)shm).msg[i]);
					name = strtok((*(SharedArea*)shm).msg[i], " ");
					content = strtok(NULL, "");

					if (!strcmp(content, SHOW_SIGN)) {
						show(i, name, content, shm);
					}
					else if (!strcmp(content, EXIT_SIGN)) {
						user_exit(buf, name, shm, i);
					}
					else{
						send_msg(buf, (*(SharedArea*)shm).client_count, i);
					}
				}
				(*(SharedArea*)shm).flag[i] = FALSE;
			}
		}
	}

	return NULL;
}


void send_msg(char *msg, int client_count, int index) {
	for (int i = 0; i < client_count; i++) {
		if (i != index) {
			pthread_mutex_lock(&mutex);
			write(client_socks[i], msg, strlen(msg));
			pthread_mutex_unlock(&mutex);
		}
	}

}


void recv_msg(int client_sock, int index, void *shm) {
	int length;
	char msg[BUF_SIZE];

	while ((length = read(client_sock, msg, sizeof(msg))) != 0) {
		memset((*(SharedArea*)shm).msg[index], '\0', BUF_SIZE);
		strcpy((*(SharedArea*)shm).msg[index], msg);
		(*(SharedArea*)shm).flag[index] = TRUE;	
		memset(msg, '\0', BUF_SIZE);
	}

	return;
}


boolean startswith(char *buf, char *start) {
	int length = strlen(start);

	for (int i = 0; i < length; i++) {
		if (buf[i] != start[i])
			return FALSE;
	}
	return TRUE;
}


void join(char *msg, int index, void *shm) {
	char send_msg[BUF_SIZE];

	pthread_mutex_lock(&mutex);
	memset(client_ids[index], '\0', MAX_ID_LENGTH);

	for (int i = 10; i < strlen(msg); i++) {
		client_ids[index][i - 10] = msg[i];
	}

	sprintf(send_msg, "%s is IN\n", client_ids[index]);
	for (int i = 0; i < (*(SharedArea*)shm).client_count; i++) {
		if (i != index) {
			write(client_socks[i], send_msg, strlen(send_msg));
		}
	}
	memset(msg, '\0', BUF_SIZE);
	pthread_mutex_unlock(&mutex);

	return;
}


void show(int index, char *name, char *content, void *shm) {
	char msg[BUF_SIZE];
	int client_index = get_index_by_name(name, shm);
	char usernum_msg[BUF_SIZE];

	sprintf(usernum_msg, "Currently connected user num : %d\n", (*(SharedArea*)shm).client_count);
	strcpy(msg, usernum_msg);
	strcat(msg, "The client that you are currently connected to is ");

	for (int i = 0; i < (*(SharedArea*)shm).client_count; i++) {
		strcat(msg, client_ids[i]);
		strcat(msg, " ");
	}
	strcat(msg, "\n");
	write(client_socks[index], msg, strlen(msg));

	return;
}


int get_index_by_name(char *name, void *shm) {
	for (int i = 0; i < (*(SharedArea*)shm).client_count; i++) {
		if (!strcmp(name, client_ids[i]))
			return i;
	}
	return -1;
}


void user_exit(char *msg, char *name, void *shm, int index) {
	int client_index = get_index_by_name(name, shm);

	pthread_mutex_lock(&mutex);
	for (int i = 0; i < (*(SharedArea*)shm).client_count; i++) {
		if (i != index) {
			sprintf(msg, "%s is out !!\n", name);
			write(client_socks[i], msg, strlen(msg));
		}
	}
	pthread_mutex_unlock(&mutex);
	disconnect(client_index, shm);
}


void disconnect(int disconnect_index, void *shm) {
	int i = 0;
	
	pthread_mutex_lock(&mutex);
	for (i = disconnect_index; i < (*(SharedArea*)shm).client_count - 1; i++) {
		client_socks[i] = client_socks[i + 1];
		strcpy(client_ids[i], client_ids[i + 1]);
		strcpy((*(SharedArea*)shm).msg[i], (*(SharedArea*)shm).msg[i + 1]);
	}
	
	client_socks[i] = -1;
	//(*(SharedArea*)shm).flag[disconnect_index] = FALSE;

	memset((*(SharedArea*)shm).msg[i], '\0', MAX_ID_LENGTH);
	memset(client_ids[i], '\0', MAX_ID_LENGTH);
	(*(SharedArea*)shm).client_count--;
	pthread_mutex_unlock(&mutex);

	return;
}



