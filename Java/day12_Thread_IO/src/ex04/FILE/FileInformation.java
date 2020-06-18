package ex04.FILE;
import java.io.*;
import java.util.*;

public class FileInformation {
	public static void main(String[] args) throws IOException {
		File fp = null;
		byte[] fileName = new byte[100];
		String strName;
		
		System.out.print("file name = ");
		System.in.read(fileName); 	// 예외발생w
		strName = new String(fileName).trim(); // 위에서 읽어낸 파일 이름 받아옴 ( 공백제거 )
		
		fp = new File(strName);
		
		System.out.println("절대경로 : " + fp.getAbsolutePath());
		System.out.println("표준경로 : " + fp.getCanonicalPath());
		System.out.println("최종수정일 : " + new Date(fp.lastModified()));
		System.out.println("파일크기 : " + fp.length());
		System.out.println("읽기속성 : " + fp.canRead());
		System.out.println("쓰기속성 : " + fp.canWrite());
		System.out.println("파일경로 : " + fp.getPath());
		System.out.println("숨김속성 : " + fp.isHidden());
		
		// 상대경로 memo.txt
		// 절대경로 D:\java..
		
	}
}
