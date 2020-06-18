package serverChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 서버 전역변수 인터페이스 (UDP)
 * 소켓통신스터디
 */

public interface ServerInterface {
	//	운영자 명령어
	public static final int ERROR=-1;
	public static final int EXIT=0;
	public static final int SHOW=1;
	public static final int BAN=2;
	public static final int USER_OUT=3;
	
	//	포트번호
	public static final int SERVER_PORT=4000;
	public static final int CLIENT_PORT=3000;
}