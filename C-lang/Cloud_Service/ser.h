/*
   *	2019-07-12  ~  2019-07-18
   *	University	:	Kwangwoon University
   *	Department	:	Electronic Communication Engineering
   *	Student No	:	2014707073
   *	Name		:	Kim-Soo-Hwan
   *
   *	Project		:	Cloud-Service using Unix Network Programming
   *	Header		:	ser.h
   *	Role		:	Header of Server
*/

#include					<dirent.h>
#define null				('\0')
#define SUCCESS				(0)
#define ERROR				(-1)	
#define TRUE				(1)
#define FALSE				(0)
#define END_SIGNAL			("end")
#define PERMISSION			(0777)
#define PATH_LENGTH			(64)
#define USER_ID_LENGTH		(10)
#define FILENAME_LENGTH		(12)
#define SERVICE_LENGTH		(10)
#define END_LENGTH			(4)
#define SER_FD_LENGTH		(128)
#define SER_PATH			("/home/soohwankim/cloud/s_storage/")
#define DIR_PERMISSION		(00777)

typedef int    boolean;
typedef struct __user {
		char		user_id[USER_ID_LENGTH];
		char		filename[FILENAME_LENGTH];
		char		service[SERVICE_LENGTH];
}User;
typedef struct __cloudFile {
		char		filename[FILENAME_LENGTH];
		off_t		size;
		char		end[END_LENGTH];
}cFile;

void		s_login(int sockfd, User* user);
void 		s_filename(int sockfd, User *user);
void		s_select(int sockfd);
int			Show(int sockfd, User *user);
void		array_clear(char *arr, int size);
void		sig_chld(int signo);
char*		s_fd(char *user_id, char *filename);
int 		recv_user(int sockfd, User *user);


/*		(server) client에게서 User Struct를 받는 Func		*/

int recv_user(int sockfd, User *user) {
	return recv(sockfd, user, sizeof(struct __user), 0);
}

/*		(server) File list를 보내는 Func		*/

int Show(int sockfd, User *user) {
	DIR* 					dp = NULL;
	struct dirent*			entry = NULL;
	struct stat				buf;
	struct __cloudFile		file;
	char 					path[PATH_LENGTH] = SER_PATH;

	strcat(path, user->user_id);
	if( (dp = opendir(path)) == NULL ) 
		err_quit("s_transmit_filelist: server terminated prematurely\n");
	
	printf("USER ID : %s\n", user->user_id);
	strcpy(file.end, "\0\0\0\0");
	while( (entry = readdir(dp)) != NULL ) {
		lstat(entry->d_name, &buf);
		if(S_ISREG(buf.st_mode)){
			strcpy(file.filename, entry->d_name);
			printf("filename : %s\n", file.filename);
			printf("filesize : %ld\n", buf.st_size);
			file.size = buf.st_size;
			send(sockfd, &file, sizeof(struct __cloudFile), 0);
		}
	}
	strcpy(file.end, END_SIGNAL);
	send(sockfd, &file, sizeof(struct __cloudFile), 0);
	closedir(dp);
	return SUCCESS;
}


/*		배열을 비우는 Func		*/

void array_clear(char *arr, int size) {
	for( int i = 0 ; i < size ; i++ )
		arr[i] = null;
}


/*		user_id로 Directory를 생성하는 Func		*/

int Mkdir(char user_id[]) {
	char		path[PATH_LENGTH] = SER_PATH;
	strcat(path, user_id);
	if( mkdir(path, PERMISSION) == ERROR && errno != EEXIST ) {
		puts("Directory already Exist!!\n");
		return ERROR;
	}
	return SUCCESS;
}


/*		Signal Handle Func		*/

void sig_chld(int signo) {
	pid_t		pid;
	int			stat;

	pid = wait(&stat);
	printf("child %d terminated!!\n", pid);
	
	return;
}


/*		Server fd를 만드는 Func			*/

char *s_fd(char *user_id, char *filename) {
	char			buf[SER_FD_LENGTH];
	char*			fd;
	unsigned int	len;

	strcat(buf, SER_PATH);
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
