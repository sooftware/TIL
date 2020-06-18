package day_10;

import java.io.File;
import java.nio.file.Files;
import java.util.stream.Stream;

public class TestDemo2 {
	public static void main(String[] args) {
		try {
			File f = new File("C\\Temp\\file.txt");
			Stream<String> st=Files.lines(f.toPath());
			st.forEach(s->System.out.println(s));
		}
	}
}
