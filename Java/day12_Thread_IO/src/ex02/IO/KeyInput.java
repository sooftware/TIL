package ex02.IO;
import java.io.*;

public class KeyInput {
	public static void main(String[] args) {
		InputStream is = System.in;	//	표준입력
		int num;
		
		try{
			System.out.print("단일 문자 입력 : ");
			num=is.read();
			System.out.println(num);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
