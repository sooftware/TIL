package Server;

public class SharedArea {
	String msg=null;	/* 클라이언트의 메세지 */
	boolean isReady=false;	/* 스레드 동기화를 위한 변수 */
	int clientNum=0;	/* 현재 연결된 클라이언트 숫자 */
}