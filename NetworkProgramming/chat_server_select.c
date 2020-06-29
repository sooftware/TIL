////////////////////////////////////////////////////////////////////////
// OS         : Ubuntu 20.04 LTS 64bits                               //
// Author     : Soohwan Kim                                           //
// Student ID : 2014707073                                            //
// Department : Electronic and Communication Engineering              //
// -------------------------------------------------------------------//
// Title : Multi-Chatting Server (Select)                             //
// Description : Implementation of multi-chatting server using selece //
////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#define TRUE 1
#define FALSE 0
#define BACKLOG 5
#define MAX_CLIENT 128
#define MAX_ID_LENGTH 32
#define PORTNUM 3500
#define SOCK_SETSIZE 1021
#define BUF_SIZE 512
#define NEW_USER_SIGN ("[NEW_USER]")
#define QUIT_SIGN ("QUIT")
#define SHOW_SIGN ("@show\n")
typedef int boolean;

void join(char *msg);
boolean startswith(char *buf, char *start);
void show(int sockfd);
void user_quit(int sockfd, char *name);
int get_index_by_name(char *name);

int client_count = 0;
char client_ids[MAX_CLIENT][MAX_ID_LENGTH];
int client_socks[MAX_CLIENT];


int main(int argc, char **argv) {
	int listen_fd, client_fd;
	socklen_t addrlen;
	int fd_num;
	int maxfd = 0;
	int sockfd;
	char buf[BUF_SIZE], msg[BUF_SIZE];
	fd_set readfds, allfds;

	struct sockaddr_in server_addr, client_addr;

	if ((listen_fd = socket(PF_INET, SOCK_STREAM, 0)) == -1) {
		perror("socket error");
		return -1;
	}
	memset((void *)&server_addr, '\0', sizeof(server_addr));
	server_addr.sin_family = AF_INET;
	server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
	server_addr.sin_port = htons(PORTNUM);

	if (bind(listen_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) == -1) {
		perror("bind error");
		return -1;
	}
	if (listen(listen_fd, BACKLOG) == -1) {
		perror("listen error");
		return -1;
	}

	FD_ZERO(&readfds);
	FD_SET(listen_fd, &readfds);

	maxfd = listen_fd;

	while(TRUE) {
		allfds = readfds;
		fd_num = select(maxfd + 1, &allfds, (fd_set *)0, (fd_set *)0, NULL);

		if (FD_ISSET(listen_fd, &allfds)) {
			addrlen = sizeof(client_addr);
			client_fd = accept(listen_fd, (struct sockaddr *)&client_addr, &addrlen);
			client_socks[client_count++] = client_fd;

			FD_SET(client_fd, &readfds);

			if (client_fd > maxfd)
				maxfd = client_fd;

			continue;
		}

		for (int i = 0; i <= maxfd; i++) {
			sockfd = i;

			if (FD_ISSET(sockfd, &allfds)) {
				memset(buf, '\0', BUF_SIZE);
				if (read(sockfd, buf, BUF_SIZE) <= 0) {
					close(sockfd);
					FD_CLR(sockfd, &readfds);
				}
				else {
					if (startswith(buf, NEW_USER_SIGN)) {
						join(buf);						
					}
					else{
						strcpy(msg, buf);
						char *name = strtok(buf, " ");
						char *content = strtok(NULL, "");

						if (!strcmp(content, QUIT_SIGN)) {
							user_quit(sockfd, name);

							close(sockfd);
							FD_CLR(sockfd, &readfds);
							break;
						}
						else if (!strcmp(content, SHOW_SIGN)) {
							show(sockfd);
						}
						else {
							for (int ci = 0; ci < client_count; ci++) {
								write(client_socks[ci], msg, strlen(msg));
							}
						}
					}
				}
				if (--fd_num <= 0)
					break;
			}
		}

	}

	return 0;
}


boolean startswith(char *buf, char *start) {
	int length = strlen(start);

	for (int i = 0; i < length; i++) {
		if (buf[i] != start[i])
			return FALSE;
	}
	return TRUE;
}


void join(char *msg) {
	memset(client_ids[client_count], '\0', MAX_ID_LENGTH);

	for (int i = 10; i < strlen(msg); i++)
		client_ids[client_count -1][i - 10] = msg[i];

	for (int i = 0; i < client_count; i++) {
		sprintf(msg, "%s is IN\n", client_ids[client_count - 1]);
		write(client_socks[i], msg, strlen(msg));
	}

	return;
}


void show(int sockfd) {
	char usernum_msg[BUF_SIZE];
	char msg[BUF_SIZE];
	
	memset(usernum_msg, '\0', BUF_SIZE);
	memset(msg, '\0', BUF_SIZE);

	sprintf(usernum_msg, "Currentlly connected user num : %d\n", client_count);
	strcpy(msg, usernum_msg);
	strcat(msg, "The client that you are currently connected to is ");

	for (int i = 0; i < client_count; i++) {
		strcat(msg, client_ids[i]);
		strcat(msg, " ");
	}
	strcat(msg, "\n");
	write(sockfd, msg, strlen(msg));

	return;
}


void user_quit(int sockfd, char *name) {
	char msg[BUF_SIZE];
	int i = 0;

	for (i = 0; i < client_count; i++) {
		if (i != sockfd) {
			sprintf(msg, "%s is out !!\n", name);
			write(client_socks[i], msg, strlen(msg));
		}
	}

	int index = get_index_by_name(name);

	for (int i = 0; i < client_count; i++) {
		printf("[%d]: %s\n", i, client_ids[i]);
	}

	for (i = index; i < client_count - 1; i++) {
		client_socks[i] = client_socks[i + 1];
		strcpy(client_ids[i], client_ids[i + 1]);
	}

	memset(client_ids[i], '\0', MAX_ID_LENGTH);
	client_count--;

	for (int i = 0; i < client_count; i++) {
		printf("[%d]: %s\n", i, client_ids[i]);
	}
	return;
}


int get_index_by_name(char *name) {
	for (int i = 0; i < client_count; i++) {
		if (!strcmp(name, client_ids[i]))
			return i;
	}
	return -1;
}
