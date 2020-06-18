package ex03.IO;
import java.io.*;

public class BufferedReaderEx2 {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		System.out.print("input = ");
		String str1 = br.readLine();
		System.out.print("input = ");
		String str2 = br.readLine();
		
		int num1=Integer.parseInt(str1);		// String을 int형으로
		int num2=Integer.parseInt(str2);
		
		System.out.println(num1+num2);
	}
}
