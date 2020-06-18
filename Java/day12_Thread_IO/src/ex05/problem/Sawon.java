package ex05.problem;
import java.util.*;
import java.io.*;

public class Sawon {
	Scanner sc = new Scanner(System.in);
	
	public void file() throws FileNotFoundException{
		OutputStream os = new FileOutputStream("C:/Users/Soohwan/Desktop/수환/Workspace/day12_Thread,IO/Sawon.txt");
		String str =new String();
		String space = "  ";
		try{
			while(true){
				System.out.println("끝내시려면 언제든지 exit을 눌러주세요 (대소문자 상관x)");
				
				System.out.print("이름 : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());
				
				System.out.print("직급 : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());
				
				System.out.print("부서 : ");
				str=sc.next();
				if(str.equalsIgnoreCase("EXIT")){
					break;
				}
				os.write(str.getBytes());
				os.write(space.getBytes());

			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
