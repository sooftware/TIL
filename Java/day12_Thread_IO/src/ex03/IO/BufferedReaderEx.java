package ex03.IO;
import java.io.*;

public class BufferedReaderEx {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		System.out.print("character input = ");
		String str = br.readLine();
		System.out.println(str);
	}
}
