package ex08.problem;

public class MainEntry {
	public static void main(String[] args) {
		String str = "abcDEFGHeijwEIMPYmnqi";
		char[] str2=new char[str.length()];
		System.out.println("before : " + str);
		
		for(int i=0;i<str.length();i++){
			if((int)str.charAt(i)>=65 && (int)str.charAt(i)<=90){	// 대문자
				str2[i]= str.charAt(i);
				str2[i]+=32;
			}
			
			else if((int)str.charAt(i)>=97 && (int)str.charAt(i)<=122){	// 소문자
				str2[i]=str.charAt(i);
				str2[i] -= 32;
			}
		}
		
		System.out.print("after : " );
		for(int i=0;i<str2.length;i++){
			System.out.print(str2[i] );
		}
		
	}
}
