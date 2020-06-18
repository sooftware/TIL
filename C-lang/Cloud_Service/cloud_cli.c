/*
   *	2019-07-12 ~ 2019-07-18
   *	University  : 	Kwangwoon University
   *	Department  : 	Electronic Communication Engineering
   *	Student No 	: 	2014707073
   *	Name 		: 	Kim-Soo-Hwan
   *	
   *	Project		: 	Cloud-Service using Unix Network Programming
   *	Function	: 	cloud_cli.c
   *	Role		:	Main of Client
*/

#define CRT_SECURE_NO_WARNINGS		/* To ignore some Warnings */
#include		"unp.h"				/* include UnixNetworkProgramming Header */
#include		"cli.h"				/* include the Header I created */

void 	start_cloud(int sockfd);				/* 	Start Cloud-Service */
int 	Upload(int sockfd, User *user);			/* 	Upload 	*/
int		Download(int sockfd, User *user);		/* 	Download  */

/*	Main of Client	*/

int main(int argc, char **argv){
	int 				sockfd;
	struct sockaddr_in	servaddr;

	/* if you don`t give IP. it ends */

	if(argc != 2)
		err_quit("usage: tcpcli <IPaddress>\n");

	puts("Program start...\n");
	
	/* Connect */

	sockfd = Socket(AF_INET, SOCK_STREAM, 0);
	bzero(&servaddr, sizeof(servaddr));
	servaddr.sin_family = AF_INET;
	servaddr.sin_port = htons(SERV_PORT);
	Inet_pton(AF_INET, argv[1], &servaddr.sin_addr);
	Connect(sockfd, (SA *) &servaddr, sizeof(servaddr));
	puts("Connected with Server!!\n\n");

	start_cloud(sockfd);	/*	Cloud-Service Start	*/

	Close(sockfd);
	puts("Exit Complete!!\n");
	return SUCCESS;
}

void start_cloud(int sockfd){
	User		user;
	boolean		start = TRUE;

	puts("Start Cloud-Service!!\n\n");
	c_login(sockfd, &user);

	while(TRUE){
		c_select(sockfd, &user);

		if(start) {
			Mkdir(user.user_id);
			start = FALSE;
		}

		// upload
		if((!strcmp(user.service, "1")) || (!strcmp(user.service, "upload"))){
			Upload(sockfd, &user);
		}
		// download
		else if(!strcmp(user.service, "2") || (!strcmp(user.service,"download"))){
			Download(sockfd, &user);	
		}
		// show list
		else if((!strcmp(user.service, "3")) || (!strcmp(user.service, "show"))){
			send_user(sockfd, &user);
			Show(sockfd, &user);
		}
		else if((!strcmp(user.service, "4")) || (!strcmp(user.service, "exit"))){
			puts("Existing... \n");
			return;
		}else{
			puts("You entered incorrectly!! ");
			puts("Please Re-Enter!! ");
			continue;
		}
	}
}


/*		(client) Upload Func		*/

int Upload(int sockfd, User *user){
	int			fd;
	char		buf[MAXLINE];

	puts("Start Upload Service!!");
	c_filename(sockfd, user);

	fd = open(user->filename, O_RDONLY);

	if(fd == ERROR){
		perror("open");
		exit(SUCCESS);
	}

	send_user(sockfd, user);

	puts("Uploading...");
	while( read(fd, &buf, MAXLINE) > 0 ){
		Writen(sockfd, buf, MAXLINE);
		array_clear(buf, MAXLINE);
	}
	puts("Upload Complete!! ");
	Writen(sockfd, END_SIGNAL, MAXLINE);
	return SUCCESS;
}


/*		(client) Download Func		*/

int Download(int sockfd, User *user) {
	int				create;
	char			buf[MAXLINE];
	ssize_t			n;
	char*			cli_fd;

	puts("Start Download Service!!");
	c_filename(sockfd, user);

	send_user(sockfd, user);

	cli_fd = c_fd(user->user_id, user->filename);
	create = open( cli_fd, O_WRONLY | O_CREAT | O_APPEND, DIR_PERMISSION );

	if( create == ERROR ) {
		perror("open");
		err_quit("open: Server terminated prematurely\n");
	}

again:
	while( ( n = read(sockfd, buf, MAXLINE) ) > 0 ) {
		if(!strcmp(buf, END_SIGNAL)) {
			printf("%s Download Complete!!\n", user->filename);
			break;
		}
		Write(create, buf, MAXLINE);
		array_clear(buf, MAXLINE);
	}
	if( (n < 0) && (errno == EINTR) )
		goto again;
	else if( n < 0 )
		err_sys("Upload: read error\n");

	close(create);
	free(cli_fd);
	return SUCCESS;
}









