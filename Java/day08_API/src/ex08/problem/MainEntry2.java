package ex08.problem;

public class MainEntry2 {
	public static void main(String[] args) {
		String str = "abcDEFGHeijwEIMPYmnqi";
		String str2 ="";
		
		System.out.println("before " + str);
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=65 && str.charAt(i)<=90){
				str2 = (char)str.charAt(i);
				str2
			}
			else if(str.charAt(i)>=97 && str.charAt(i)<=122){
				str2 +=(char)(str.charAt(i)-32);
			}
		}
		
		System.out.println("after " + str2);
	}
}