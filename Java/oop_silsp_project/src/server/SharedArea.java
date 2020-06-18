package server;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 공유메모리 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 각기 다른 클래스에서의 공유 영역 */
public class SharedArea {
	HashMap<String, String> client;
	byte[] msg;
	boolean isReady; 
	boolean exit; 
	Check ck;

	public SharedArea() {
		client = new HashMap();	// <ID,IP>
		msg = new byte[512];			// Server에서 Receive와 Sender가 공유하는 메세지 
		isReady = false;						// 스레드 동기화를 위한 변수
		exit = false;								// 서버 종료를 위한 변수
		ck = new Check();					// Server나 user 명령어를 체크하기 위한 객체 생성
	}
}