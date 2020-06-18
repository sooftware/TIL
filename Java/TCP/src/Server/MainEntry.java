package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainEntry implements ServerInterface{
	public static void main(String[] args) {
		/* 변수 선언 */
		ServerSocket listener=null;
		Socket socket=null;
		SharedArea obj = new SharedArea();
		boolean start = true;
		/* 변수 선언 */
		
		try {
			listener = new ServerSocket(SERVER_PORT);
			while (true) {
				System.out.println("연결을 기다리고 있습니다 .");
				socket=listener.accept();
				System.out.println("연결되었습니다. ");		++obj.clientNum;	
				System.out.println("현재 연결된 클라이언트 수는 " + obj.clientNum + "명 입니다.");
				
				/* 첫 실행시만 실행되는 부분 */
				if (start) {
					ServerIn in = new ServerIn();
					ServerOut out = new ServerOut();
					
					/* SET */
					in.setSocket(socket);
					out.setSocket(socket);
					in.setSharedArea(obj);
					out.setSharedArea(obj);
					/* SET */
					
					/* Thread Start */
					in.start();
					out.start();
					/* Thread Start */
					start=false;
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("MainEntry Class 0");
		}
		
		try {
			listener.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MainEntry Class 1");
		}
		
	}
}
