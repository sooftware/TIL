package ex04.FILE;
import java.io.*;
import java.util.*;

public class FileInputEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try{
		//	OutputStream os = new FileOutputStream("mome.txt");	상대경로
			// OutputStream os = new FileOutputStream("C:\\Users\\Soohwan\\Desktop\\수환\\Workspace\\day12_Thread,IO\\mome.txt");
			OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/수환/Workspace/day12_Thread,IO/mome.txt");
			
			while(true){
				System.out.print("문자열 입력 요망 : ");
				String str = sc.nextLine() + "\r\n";
				
				if(str.equalsIgnoreCase("EXIT\r\n")){
					break;
				}
				
				os.write(str.getBytes());	// 예외발생, 읽어들인 문자 str의 길이 (getBytes()만큼 써주세요)
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
