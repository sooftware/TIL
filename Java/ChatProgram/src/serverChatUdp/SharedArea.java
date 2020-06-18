package serverChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 서버 공유메모리 클래스 (UDP)
 * 소켓통신스터디
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 각기 다른 클래스에서의 공유 영역 */
public class SharedArea {
	HashMap<String,String> client = new HashMap();		//	<ID,IP>
	byte[] msg = new byte[512];	// Server에서 Receive와 Sender가 공유하는 메세지
	boolean isReady=false;		// msg가 새로 들어오면 true
	boolean exit=false;	// 서버 종료를 위한 변수
	Check ck = new Check();
}