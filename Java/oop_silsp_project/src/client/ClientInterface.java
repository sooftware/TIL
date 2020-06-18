package client;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅프로그램 클라이언트 인터페이스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

public interface ClientInterface {
	public static final int SERVER_PORT=7000;
	public static final int CLIENT_PORT=7000;
	public static final String SERVER_IP="10.20.30.246";
	public static final String CMD_QUIT="QUIT";
	
	public static final int FRAME_WIDTH=1280;
	public static final int FRAME_HEIGHT=720;
}
