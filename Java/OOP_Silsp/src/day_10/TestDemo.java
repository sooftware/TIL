package day_10;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDemo {
	public static void main(String[] args) {
		String fileName = "C:\\Temp\\file.txt";
		try {
			byte[] buf=new byte[100];
			FileInputStream fis=new FileInputStream(fileName);
			BufferedInputStream bis=new BufferedInputStream(fis);
			
			while(true) {
				if(bis.read(buf)==-1)
					break;
				System.out.println(new String(buf));
			}
			
			fis.close();
			bis.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}