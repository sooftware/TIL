package ex02.Util;
import java.util.*;

public class StringTokenizerEX01 {
	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("김수환/수환킴/수환무/킹수환/갓수환","/");
		
		while(token.hasMoreTokens()){	// 다음 token이 있다면  즉 위에서는 / 이 있다면
			System.out.println(token.nextToken());
		}
	}
}
