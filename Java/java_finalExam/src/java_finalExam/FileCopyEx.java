package java_finalExam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyEx {
	public static void main(String[] args) {
		File f1 = new File("c:\\CookAndroid\\test4.txt");
		File f2 = new File("c:\\CookAndroid\\test");
		
		try {

			FileOutputStream writer = new FileOutputStream(f2);
			FileInputStream reader = new FileInputStream(f1);
						
			byte[] buf = new byte[10];
			
			int n = reader.read(buf);
			writer.write(buf, 0, n);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("입출력오류");
		}
		
	}
}
