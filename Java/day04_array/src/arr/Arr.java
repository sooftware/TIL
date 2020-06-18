package arr;

public class Arr {
	public static void main(String[] args) {
		char[] ch;
		ch=new char[4];	// 방법 1
		
		char[] ch2=new char[4]; // 방법2
		
		ch[0]='J';
		ch[1]='A';
		ch[2]='V';
		ch[3]='A';
		
		// 배열의 길이   " 배열이름.length "
		System.out.println("배열의 길이 : " + ch.length);
		
		// 배열의 내용 출력
		
		for(int i=0;i<4;i++){
			System.out.print(ch[i]+" ");
		}
	}
}
