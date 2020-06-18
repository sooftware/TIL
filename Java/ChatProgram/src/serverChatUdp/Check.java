package serverChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 서버 각종체크클래스 (UDP)
 * 소켓통신스터디
 */

import java.util.Iterator;
import java.util.Set;

public class Check  implements ServerInterface{
	SharedArea sArea;
	/* 강퇴명령인지 체크하는 메서드 */
	public boolean checkBanUser(String command){
		if (command.toUpperCase().equals("BAN")) {
			return true;
		}
		return false;
	}
	
	/* 해당 ID가 존재하는지 체크하는 메서드 */
	public boolean checkIdExist(String id){
		Set<String> ipToSet = sArea.client.keySet();		//	Key를 Set으로 변환 -> Iterator를 위한 변환
		Iterator it = ipToSet.iterator();									//	clientIP용 Iterator
		while(it.hasNext()){
			if(id.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	

	/* 들어온 ip가 이미 있었던 ip인지 검사 */
	public boolean checkIpExist(String ip) {
		Set<String> idToSet = sArea.client.keySet();		//	Key를 Set으로 변환 -> Iterator를 위한 변환
		Iterator it = idToSet.iterator();		//	clientIP용 Iterator
		while (it.hasNext()) {
			if (ip.equals(sArea.client.get(it.next())))
				return true;
		}
		return false;
	}
	
	/* 접속종료를 했는지 알려주는 메서드 */
	public boolean checkUserOut() {
		if (sArea.msg.toString().toUpperCase().equals("QUIT")) {
			return true;
		} else
			return false;
	}
	
	/* 서버 종료 키워드가 들어왔는지 확인 */
	public boolean checkServerExit(String command) {
		if (command.toUpperCase().equals("EXIT")) {
			sArea.exit = true;
			return true;
		}
		return false;
	}

	/* 현재 클라이언트 목록 키워드가 들어왔는지 확인 */
	public boolean checkShow(String command) {
		if (command.toUpperCase().equals("SHOW")) {
			return true;
		}
		return false;
	}


	/* Set & Get */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set & Get */
}
