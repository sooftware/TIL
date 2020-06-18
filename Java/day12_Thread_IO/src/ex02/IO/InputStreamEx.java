package ex02.IO;

import java.io.IOException;

public class InputStreamEx {
	public static void main(String[] args) throws IOException {
		System.out.print("input = ");
		int num=System.in.read();
		
		while((num=System.in.read()) != -1){		// read는 int형으로 리턴
			if(num==10 || num==13 || num==32)	continue;
			if(num == 113 || num == 81)	break;
			
			char ch = (char)num;
		}
		
		
/*		
		try {
			while((num=System.in.read()) != -1){		// read는 int형으로 리턴	더 이상 입력받을게 없으면 -1리턴
			
			
				if(num==10 || num==13 || num==32)	continue;
				if(num == 113 || num == 81)	break;
				
				char ch = (char)num;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
