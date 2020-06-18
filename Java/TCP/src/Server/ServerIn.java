package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerIn extends Thread implements ServerInterface{
	private Socket socket;
	private SharedArea sArea;

	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String msg = in.readLine();	//	메시지가 날라올때까지 여기서 대기중...
				clientBye(msg,sArea);
				synchronized (sArea) {	//	메시지가 날라오면 메세지를 보낸다
					forSendMsg(sArea, msg);	//	메시지를날리기 위한 호출
				}
				System.out.println( "클라이언트 : " + msg);	//	클라이언트의 메세지 내용 확인
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ServerIn Class 0");
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.getMessage();
			System.out.println("ServerIn Class 1");
		}
	}
	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	
	/* 클라이언트 접속 종료시 */
	private void clientBye(String msg,SharedArea sArea) {
		if (msg.equalsIgnoreCase("bye")) { // 클라이언트가 bye라고 칠 경우
			System.out.println("클라이언트에서 연결을 종료하였어영 ㅠㅠ");
			synchronized (sArea) {
				--sArea.clientNum;
			}
		}
	}

	/* msg를 날리기 위한 호출 */
	private void forSendMsg(SharedArea sArea, String msg) {
		sArea.msg = msg; // 날라온 메세지를 공유메모리에 저장
		sArea.isReady = true;
		sArea.notify(); // 저장 후 Output을 깨운다
	}

	/* Set Method */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void setSharedArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	/* Set Method */
}
