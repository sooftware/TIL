package java_finalExam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("c:\\CookAndroid\\test4.txt");
			FileInputStream fis = new FileInputStream("c:\\CookAndroid\\test4.txt");
			byte[] b = {1,2,3,4,5};
			
			for(int i=0;i<5;i++){
				try {
					fos.write(b[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int c;
			try {
				while((c=fis.read()) != -1){
					System.out.println((byte)c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
