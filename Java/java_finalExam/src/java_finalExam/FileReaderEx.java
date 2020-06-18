package java_finalExam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\CookAndroid\\test.txt");
			int c;
			char[] buf = new char[50];
			
			System.out.println("읽기 스타또!");
			while ((c = fr.read(buf)) != -1) {
				System.out.print(buf);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 없어!!");
		} catch (IOException e) {
			System.out.println("IOException!!");
		}
	}
}
