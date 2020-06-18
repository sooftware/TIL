package ex02.Util;
import java.util.*;

public class StringTokenizerEX02 {
	public static void main(String[] args) {
/*		StringTokenizer token = new StringTokenizer("김수환 킹수환 갓수환 수환무 수환킴 솬킴 SHW@N");
		
		while(token.hasMoreTokens()){	// 다음 요소가 있다면???
			System.out.println(token.nextToken());
		}*/
		
		StringTokenizer token = new StringTokenizer("사과=5 | 초코렛=3 | 샴페인=1","=",true);
		while(token.hasMoreTokens()){	// 다음 token이 있다면
			String str = token.nextToken();
			
			if(str.equals("=")){	System.out.print("\t");}
			else if(str.equals("|")){	System.out.print("\n");}
			else{	System.out.println(str);}
		}
	}
}

// 따로 구분자를 안 넣었지만, default값이 ' ' 이기 떄문에 알아서 구분이 됨