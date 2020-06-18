package java_finalExam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FileWriter writer = null;
		int c;
		try {
			writer = new FileWriter("c:\\CookAndroid\\test4.txt");
			
				String line = sc.next();
			
			
				writer.write(line,0,line.length());
				writer.write("\r\n",0,2);
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}
