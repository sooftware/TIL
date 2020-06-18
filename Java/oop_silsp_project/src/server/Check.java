package server;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 명령어 체크 클래스
 *  2014707073 전자통신공학과 김수환
 */


import java.util.Iterator;
import java.util.Set;

public class Check  implements ServerInterface{
	SharedArea sArea;	// 공유메모리 객체
	
	public Check() {
		sArea=null;
	}
	
	/* 강퇴명령인지 체크하는 메서드 */
	public boolean checkBanUser(String command){
		/* BAN이 들어오면 true 반환 */
		if (command.equalsIgnoreCase(CMD_BAN)) {	
			return true;	
		}
		return false;
	}	
	
	/* 접속종료를 했는지 알려주는 메서드 */
	public boolean checkUserOut() {
		if (sArea.msg.toString().equalsIgnoreCase(CMD_QUIT)) {
			return true;
		} else
			return false;
	}
	
	/* 서버 종료 키워드가 들어왔는지 확인 */
	public boolean checkServerExit(String command) {
		if (command.equalsIgnoreCase(CMD_EXIT)) {
			sArea.exit = true;
			return true;
		}
		return false;
	}

	/* 현재 클라이언트 목록 키워드가 들어왔는지 확인 */
	public boolean checkShow(String command) {
		if (command.equalsIgnoreCase(CMD_SHOW)) {
			return true;
		}
		return false;
	}	
	
	/* 해당 ID가 존재하는지 체크하는 메서드 */
	public boolean checkIdExist(String id){
		/* Key를 Set으로 변환 -> Iterator를 위한 변환 */
		Set<String> ipToSet = sArea.client.keySet();		
		
		/* clientIP용 Iterator */
		Iterator it = ipToSet.iterator();									
		
		/* id에 해당하는 Key가 있는지를 검사 */
		while(it.hasNext()){
			if(id.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	

	/* 들어온 ip가 이미 있었던 ip인지 검사 */
	public boolean checkIpExist(String ip) {
		/* Key를 Set으로 변환 -> Iterator를 위한 변환 */
		Set<String> idToSet = sArea.client.keySet();
		
		/* clientIP용 Iterator */
		Iterator it = idToSet.iterator();
		
		/* ip에 해당하는 Key가 있는지 검사 */
		while (it.hasNext()) {
			if (ip.equals(sArea.client.get(it.next())))
				return true;
		}
		return false;
	}

	/* 공유메모리 Set 메서드 */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
