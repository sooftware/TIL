package ex07.BinaryCopy;
import java.io.*;
import java.net.*;

public class UriCopy {
	public static void main(String[] args) 
			throws MalformedURLException, IOException{
			URL url = new URL("http://dongmoon.kw.ac.kr/wp-content/uploads/2017/05/11-1024x637.jpg");
			InputStream is = url.openStream();	//예외처리
			OutputStream os = new FileOutputStream("KwangWoon.jpg");	// 
			
			
			byte[] buffer = new byte[1024*8];
			
			
			
			while(true){
				int inputData = is.read(buffer);	// buffer 크기만큼 읽어들임
				if(inputData == -1){ 
					break;
				}
				else{
					os.write(buffer,0,inputData);	// buffer크기만큼 0부터시작 
					
				}
			}
			
			System.out.println("웹에서 파일 복사했썽!!!! 성공했썽!!!!!!!");
	}
}
