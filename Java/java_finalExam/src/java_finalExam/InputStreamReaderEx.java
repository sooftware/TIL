package java_finalExam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
	public static void main(String[] args) {
		try{
			FileInputStream fis = new FileInputStream("c:\\CookAndroid\\test2.txt");
			InputStreamReader reader = new InputStreamReader(fis,"MS949");
			int c;
			while((c = reader.read()) != -1){
				System.out.print((char)c);
			}
			fis.close();
			reader.close();
			
		}catch(FileNotFoundException e){
			System.out.println("파일 경로 잘못됨");
		}catch(IOException e){
			System.out.println("IOException");
		}
	}
}
