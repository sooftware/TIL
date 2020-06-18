package serverChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 서버 수신 클래스 (UDP)
 * 소켓통신스터디
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;

public class UdpServerReceive extends Thread implements ServerInterface {
	private SharedArea sArea;

	/* Thread 동작 부분 start */
	/* Thread 동작 부분 start */
	/* Thread 동작 부분 start */
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(SERVER_PORT);
			while (true) {
				DatagramPacket packet = new DatagramPacket(sArea.msg, sArea.msg.length);
				socket.receive(packet);
				System.out.println(sArea.msg);
				/* 새로 들어온 ip인지 체크 */
				if (!sArea.ck.checkIpExist(packet.getAddress().getHostAddress().toString())) {
					newUser(packet);
				}
				synchronized (sArea) {
					// System.out.println(packet.getAddress() + "로부터 새로운 메세지
					// 수신");
					wakeSender(); // Sender 실행

					/* ip가 접속종료를 하였는지 체크 */
					if (sArea.ck.checkUserOut()) {
						userOut(packet, socket);
					}

					/* 종료 */
					if (sArea.exit) {
						sReceiveFinish();
						return;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Thread 동작 부분 End */
	/* Thread 동작 부분 End */
	/* Thread 동작 부분 End */

	/* 메세지를 받고난 후 Sender를 실행 */
	public void wakeSender() {
		synchronized (sArea) {
			sArea.isReady = true;
			sArea.notify();
			
		}
	}

	/* ip로 ID를 찾는 메서드 */
	public String findIdByIp(String ip) {
		Set<String> idToSet = sArea.client.keySet(); // Key를 Set으로 변환 ->
														// Iterator를 위한 변환
		Iterator it = idToSet.iterator(); // clientIP용 Iterator
		while (it.hasNext()) {
			String id = it.next().toString(); // 임시로 id에 클라이언트 ID를 기억한다
			if (ip.equals(sArea.client.get(id))) { // id로 clientIP의 IP값을 넘겨받은
													// ip와 비교하여
				return id; // 일치하는 ip를 찾는다면 해당 id를 return
			}
		}
		System.out.println("findIdByIp에서 ERROR!!"); // while에서 종료되지 않으면 오류이므로
													// sysout으로 확인
		return "ERROR";
	}

	/* 새로운 유저가 들어왔을 때 */
	public void newUser(DatagramPacket packet) {
		synchronized (sArea) {
			sArea.client.put(new String(sArea.msg).trim(), packet.getAddress().getHostAddress().toString());
			System.out.println(packet.getAddress().getHostAddress().toString() + " : 새로운 ip가 접속하였습니다.");
			/*
			 * 새로운 ip가 들어오면 Map 형태의 client에 ( <Key,Value> == <ID, IP> ) 새로
			 * <K,V>를 추가한다
			 */
		}
	}

	/* 유저 접속 종료 시 */
	public void userOut(DatagramPacket packet, DatagramSocket socket) {
		String outIP = packet.getAddress().toString();
		String outID = findIdByIp(outIP); // 접속종료하는 ip를 이용하여 id를 찾는다
		System.out.println("접속종료한 IP : " + outIP);
		System.out.println("접속종료한 ID : " + outID);

		// 클라이언트 종료를 위함
		String quit = "QUIT";
		try {
			DatagramPacket quitPacket = new DatagramPacket(quit.getBytes(), quit.length(), InetAddress.getByName(outIP),
					CLIENT_PORT);
			socket.send(packet); // packet 발사!
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		synchronized (sArea) {
			sArea.client.remove(outID);
		}
		/*
		 * 접속종료하는 ip와 id를 찾아서 서버에 알리고 clientIP에서 삭제한다
		 */
	}

	/* sReceive 종료 */
	public void sReceiveFinish() {
		System.out.println("##### 종료 #####");
		synchronized (sArea) {
			sArea.notify();
		}
	}

	/* Set & Get */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set & Get */
}