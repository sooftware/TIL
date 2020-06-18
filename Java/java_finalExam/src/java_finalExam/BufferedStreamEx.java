package java_finalExam;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedStreamEx {
	public static void main(String[] args) {
		BufferedOutputStream bos = new BufferedOutputStream(System.out,5);
		try {
			FileReader fin = new FileReader("c:\\CookAndroid\\test4.txt");
			int c;
			
			try {
				while((c=fin.read())  != -1){
					bos.write((char)c);
				}
				new Scanner(System.in).nextLine();
				bos.flush();
				fin.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
