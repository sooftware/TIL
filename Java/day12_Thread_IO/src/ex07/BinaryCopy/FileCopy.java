package ex07.BinaryCopy;
import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws Exception {
		// 읽기객체 - FileInputStream
		InputStream is = new FileInputStream("C:/Users/Soohwan/Desktop/수환/Java교육/apple.jpg");
		// 쓰기객체 - FileOutputStream
		OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/수환/Java교육/kiki.png");
		
		byte[] buffer = new byte[1024*8];
		
		long start = System.currentTimeMillis();
		
		while(true){
			int inputData = is.read(buffer);	// buffer 크기만큼 읽어들임
			if(inputData == -1){ 
				break;
			}
			else{
				os.write(buffer,0,inputData);	// buffer크기만큼 0부터시작 
				
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}