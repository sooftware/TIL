////////////////////////////////////////////////////////////////////////
// OS         : Ubuntu 20.04 LTS 64bits                               //
// Author     : Soohwan Kim                                           //
// Studend ID : 2014707073                                            //
// Department : Electronic and Communication Engineering              //
// ------------------------------------------------------------------ //
// Title : Multi-Chatting Server (Thread)                             //
// Description: Implementation of multi-chatting server using threads //
////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <pthread.h>
#define TRUE 1
#define FALSE 0
#define INIT_SIZE 32
#define BUF_SIZE 256
#define MAX_CLIENT 128
#define MAX_ID_LENGTH 32
#define PORTNUM 3500
#define BACKLOG 5
#define NEW_USER_SIGN ("[NEW_USER]")
#define QUIT_SIGN ("QUIT")
#define SHOW_SIGN ("@show\n")
typedef int boolean;

void * multi_chat(void *arg);
int get_index_by_name(char *name);
boolean startswith(char *buf, char *start);
void join(char *msg);
void show(char *msg, char *name, char *content);
void user_quit(char *msg, char *name);
void send_msg(char *msg, char *name, char *content, int length);
void disconnect(int disconnect_index);

int client_count = 0;
char client_ids[MAX_CLIENT][MAX_ID_LENGTH];
int client_socks[MAX_CLIENT];
pthread_mutex_t mutex;


int main(int argc, char *argv[]) {
	int server_sock, client_sock;
	struct sockaddr_in server, client;
	int client_size;
	pthread_t t_id;
	pthread_mutex_init(&mutex, NULL);

	/* Server Setting */

	server_sock = socket(PF_INET, SOCK_STREAM, 0);
	memset(&server, 0, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	server.sin_port = htons(PORTNUM);

	/* Bind */

	if (bind(server_sock, (struct sockaddr*)&server, sizeof(server)) == -1) {
		perror("bind error");
		exit(1);
	}

	/* Listen */

	if (listen(server_sock, BACKLOG) == -1) {
		perror("listen error");
		exit(1);
	}

	/* Accepts multi client using threads */

	while (TRUE) {
		client_size = sizeof(client);
		client_sock = accept(server_sock, (struct sockaddr*)&client, &client_size);

		pthread_mutex_lock(&mutex);
		client_socks[client_count++] = client_sock;
		pthread_mutex_unlock(&mutex);

		pthread_create(&t_id, NULL, multi_chat, (void*)&client_sock);
		pthread_detach(t_id);
	}

	close(server_sock);
	return 0;
}


void* multi_chat(void *arg) {
	char **tokens, **temp, *name, *content;
	int client_sock = *((int*)arg);
	int length = 0, num_tokens;
	char msg[BUF_SIZE];

	while ((length = read(client_sock, msg, sizeof(msg))) != 0) {

		if (startswith(msg, NEW_USER_SIGN)){
			join(msg);
		}
		else{
			name = strtok(msg, " ");
			content = strtok(NULL, "");

			if (!strcmp(content, SHOW_SIGN)){
				show(msg, name, content);
			}
			else if(!strcmp(content, QUIT_SIGN)) {
				user_quit(msg, name);
			}
			else {
				send_msg(msg, name, content, length);
			}
			memset(name, '\0', strlen(name));
			memset(content, '\0', strlen(name));
		}
		memset(msg, '\0', BUF_SIZE);
	}

	close(client_sock);
	return NULL;
}


int get_index_by_name(char *name) {
	for (int i = 0; i < client_count; i++) {
		if (!strcmp(name, client_ids[i])){
			return i;
		}
	}
	return -1;
}


boolean startswith(char *buf, char *start) {
	int length = strlen(start);

	for (int i = 0; i < length; i++){
		if (buf[i] != start[i])
			return FALSE;
	}
	return TRUE;
}


void join(char *msg) {
	pthread_mutex_lock(&mutex);
	memset(client_ids[client_count], '\0', MAX_ID_LENGTH);

	for (int i = 10; i < strlen(msg); i++) {
		client_ids[client_count - 1][i - 10] = msg[i];
	}

	for (int i = 0; i < client_count; i++) {
		sprintf(msg, "%s is IN\n", client_ids[client_count - 1]);
		write(client_socks[i], msg, strlen(msg));
	}

	pthread_mutex_unlock(&mutex);
}


void show(char *msg, char *name, char *content) {
	int client_index = get_index_by_name(name);
	char *usernum_msg;

	sprintf(usernum_msg, "Currently connected user num : %d\n", client_count);
	strcpy(msg, usernum_msg);
	strcat(msg, "The client that you are currently connected to is ");

	for (int i = 0; i < client_count; i++) {
		strcat(msg, client_ids[i]);
		strcat(msg, " ");
	}
	strcat(msg, "\n");
	write(client_socks[client_index], msg, strlen(msg));

	return;
}


void user_quit(char *msg, char *name) {
	int client_index = get_index_by_name(name);

	pthread_mutex_lock(&mutex);
	for (int i = 0; i < client_count; i++) {
		if (i != client_index) {
			sprintf(msg, "%s is out !!\n", name);
			write(client_socks[i], msg, strlen(msg));
		}
	}
	pthread_mutex_unlock(&mutex);
	disconnect(client_index);

	return;
}


void send_msg(char *msg, char *name, char *content, int length) {
	pthread_mutex_lock(&mutex);
	for (int i = 0; i < client_count; i++) {
		sprintf(msg, "%s %s", name, content);
		write(client_socks[i], msg, length);
	}
	pthread_mutex_unlock(&mutex);

	return;
}


void disconnect(int disconnect_index) {
	int i = 0;
	pthread_mutex_lock(&mutex);

	for (i = disconnect_index; i < client_count - 1; i++) {
		client_socks[i] = client_socks[i + 1];
		strcpy(client_ids[i], client_ids[i + 1]);
	}

	client_socks[i] = -1;
	memset(client_ids[i], '\0', MAX_ID_LENGTH);
	client_count--;
	pthread_mutex_unlock(&mutex);

	return;
}





