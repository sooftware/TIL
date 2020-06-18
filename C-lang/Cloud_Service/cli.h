/*
   *	2019-07-12 ~ 2019-07-18
   *	University	:	Kwangwoon University
   *	Department	:	Electronic Communication Engineering
   *	Student No	:	2014707073
   *	Name		:	Kim-Soo-Hwan
   *
   *	Project		:	Cloud-Service using Unix Network Programming
   *	Header		:	cli.h	
   *	Role		:	Header of Client (Collection of Function & Personal Definition)
*/

#pragma once
#include 					<dirent.h>
#define null 				('\0')
#define SUCCESS 			(0)
#define ERROR 				(-1)
#define TRUE 				(1)
#define FALSE				(0)
#define END_SIGNAL 			("end")
#define PERMISSION 			(0777)
#define USER_ID_LENGTH		(10)
#define FILENAME_LENGTH		(12)
#define SERVICE_LENGTH		(10)
#define END_LENGTH			(4)
#define CLI_PATH			("/home/soohwankim/cloud/c_storage/")
#define PATH_LENGTH			(64)
#define CLI_FD_LENGTH		(128)
#define DIR_PERMISSION		(00777)

typedef int 			boolean;

typedef struct 	__user {
		char 		user_id[USER_ID_LENGTH];
		char		filename[FILENAME_LENGTH];
		char		service[SERVICE_LENGTH];
}User;	

typedef struct __cloudFile {
		char		filename[FILENAME_LENGTH];	
		off_t		size;					
		char		end[END_LENGTH];
}cFile;

int			send_user(int sockfd, User *user);
int 		Mkdir(char user_id[]);
void 		array_clear(char arr[], int size);
int			c_login(int sockfd, User *user);
int			c_filename(int sockfd, User *user);
int			c_select(int sockfd, User *user);
int			Show(int sockfd, User *user);
char 		*c_fd(char *user_id, char *filename);

/*		(client) Server에 User 구조체를 보내는 Func		*/

int send_user(int sockfd, User *user) {
	return send(sockfd, user, sizeof(struct __user), 0);
}


/*		user_id로 Directory를 생성하는 Func		*/

int Mkdir(char user_id[]){
	char			path[PATH_LENGTH] = CLI_PATH;
	strcat(path, user_id);
	if(mkdir(path, PERMISSION) == ERROR && errno != EEXIST) {
		puts("Directory already Exist!!");
		return ERROR;
	}
	return SUCCESS;
}


/*	배열을 비우는 Func	*/

void array_clear(char arr[], int size) {
	for(int i = 0; i < size; i++)
		arr[i] = null;
}


/*	(client) 로그인 Func	*/

int c_login(int sockfd, User *user) {
	int			n = 0;

	printf("INPUT USER ID : ");
	while( (n = scanf("%s", user->user_id) <= 0) || (n >= USER_ID_LENGTH) ) 
		puts("Please Re-Enter");
	
	return SUCCESS;
}


/*	(client) filename을 보내는 Func	*/

int c_filename(int sockfd, User *user) {
	int			n = 0;

	printf("INPUT FILENAME : ");
	while( (n = (scanf("%s", user->filename) <= 0)) || ( n >= FILENAME_LENGTH) ) 
		puts("Please Re-Enter");

	return SUCCESS;
}


/*	(client) 서비스를 선택하는 FUnc	*/

int c_select(int sockfd, User *user) {
	int			n = 0;

	puts("Select Service\n");
	puts(">>> ①  Upload \n");
	puts(">>> ②  Download \n");
	puts(">>> ③  Show List\n");
	puts(">>> ④  Exit \n\n");
	printf("INPUT : ");
	if( ( n = scanf("%s", user->service) <= 0 ) || ( n >= SERVICE_LENGTH ) ) 
		puts("You didnot enter any String.");

	return SUCCESS;
}


/*	Cloud에 저장된 파일 목록을 보여주는 Func	*/

int Show(int sockfd, User *user) {
	struct __cloudFile		file;

	printf("> %s`s Cloud\n", user->user_id);
	strcpy(file.end, "\0\0\0\0");
	while( recv(sockfd, &file, sizeof(struct __cloudFile) , 0 ) > 0 ){
		if( !strcmp(file.end, END_SIGNAL) )
			break;
		printf("[Filename] %s\nSize : %ld bytes\n\n", file.filename, file.size);
	}
	puts("File list End\n\n");
	return SUCCESS;;
}


/*		(client) Client fd를 만드는 Func		*/
char *c_fd(char *user_id, char *filename) {
	char			buf[CLI_FD_LENGTH] = {null, };
	char*			fd;
	unsigned int	len;

	strcat(buf, CLI_PATH);
	strcat(buf, user_id);
	strcat(buf, "/");
	strcat(buf, filename);

	len = strlen(buf);

	fd = (char *)malloc( sizeof(char) * len );
	for( int i = 0; i < len; i++ )
		fd[i] = buf[i];

	return fd;
}


/*		End of Header		*/
/*		End of Header		*/
/*		End of Header		*/
