package Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerOut extends Thread implements ServerInterface{
	private Socket socket;
	Scanner sc;
	private SharedArea sArea;

	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	public void run() {
		sc = new Scanner(System.in);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			/* while */
			while (true) {
				synchronized (sArea) {
					threadWait(sArea);	//	스레드 wait();
					if (sArea.isReady) { // 준비가 되면 실행, 아니면 다시 wait();
						sendMsgToClient(out,sArea);
						initializeSharedArea(sArea);
					}
				}
			}
			/* while */
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("ServerOut Class 1");
		}

		sc.close();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 2");
		}
	}
	/* Thread Run */
	/* Thread Run */
	/* Thread Run */
	
	/* 클라이언트에게 메세지를 뿌림 */
	private void sendMsgToClient(BufferedWriter out,SharedArea sArea) {
		String msg = sArea.msg; // 서버에서 클라이언트에 메세지 보내기
		try {
			out.write(msg + "\n");
			out.flush(); // out의 스트림 버퍼에 있는 모든 문자열 전송
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 3");
		}
	}
	
	/* 스레드 Wait상태로 변경 */
	private void threadWait(SharedArea sArea) {
		try {
			sArea.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("ServerOut Class 0");
		}
	}
	
	/* 공유메모리 초기화 */
	private void initializeSharedArea(SharedArea sArea) {
		sArea.isReady = false;
		sArea.msg=null;
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
