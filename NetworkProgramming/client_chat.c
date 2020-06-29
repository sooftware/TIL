#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<arpa/inet.h>
#include<sys/socket.h>
#include<pthread.h>
#include<time.h>
#define TRUE 1
#define BUF_SIZE 512
#define INIT_SIZE 32
#define PORTNUM 3500
#define NEW_USER_SIGN ("[NEW_USER]")
#define QUIT_SIGN ("QUIT")

void* send_msg(void* arg);
void* recv_msg(void* arg);

char name[INIT_SIZE] = "[DEFALT]";     
char client_ip[INIT_SIZE];            


int main(int argc, char *argv[])
{
	int sock;
	struct sockaddr_in server;
	pthread_t send_thread, recv_thread;
	void* thread_return;

	if (argc != 3)
	{
		printf(" client.c requires : %s <ip> <name>\n", argv[0]);
		exit(1);
	}

	sprintf(name, "[%s]", argv[2]);
	sprintf(client_ip, "%s", argv[1]);

	sock = socket(PF_INET, SOCK_STREAM, 0);
	memset(&server, 0, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = inet_addr(argv[1]);
	server.sin_port = htons(PORTNUM);

	if (connect(sock, (struct sockaddr*)&server, sizeof(server)) == -1) {
		perror("connect");
		exit(1);
	}

	pthread_create(&send_thread, NULL, send_msg, (void*)&sock);
	pthread_create(&recv_thread, NULL, recv_msg, (void*)&sock);

	pthread_join(send_thread, &thread_return);
	pthread_join(recv_thread, &thread_return);

	close(sock);
	return 0;
}


void* send_msg(void* arg) {
	int sock = *((int*)arg);
	char temp[BUF_SIZE];
	char msg[BUF_SIZE + INIT_SIZE];
	char info[BUF_SIZE];

	sprintf(info, "%s%s", NEW_USER_SIGN, name);
	write(sock, info, strlen(info));
	puts("Welcome to Soohwan1s Chat !!\n");

	while (TRUE) {
		fgets(temp, BUF_SIZE, stdin);

		if (!strcmp(temp, "@quit\n") || !strcmp(temp, "@QUIT\n")) {
			puts("Terminate..");
			sprintf(msg, "%s %s", name, QUIT_SIGN);
			write(sock, msg, strlen(msg));

			close(sock);
			exit(1);
		}

		sprintf(msg, "%s %s", name, temp);
		write(sock, msg, strlen(msg));
	}
	return NULL;
}

void* recv_msg(void* arg) {
	int sock = *((int*)arg);
	char msg[BUF_SIZE];
	int length;

	while (TRUE) {
		length = read(sock, msg, BUF_SIZE);
		if (length == -1)
			return (void*)-1;

		msg[length] = 0;
		fputs(msg, stdout);
	}
	return NULL;
}


