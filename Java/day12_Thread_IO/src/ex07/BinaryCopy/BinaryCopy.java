package ex07.BinaryCopy;
import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File("C:/Windows/explorer.exe");  //절대경로 - 복사원본
		File dist = new File("C:/Users/Soohwan/Desktop/수환/explorer.bin"); //절대경로 - 복제될 위치
		int count;
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream  bis = null;
		BufferedOutputStream  bos = null;
		System.out.println("== 김수환 ==");
		try {
			fis = new FileInputStream(src);  //파일 입력 바이트 스트림 연결
			fos = new FileOutputStream(dist); //파일 출력 바이트스트림 연결
			bis = new BufferedInputStream(fis);  //버퍼 입력스트림 연결
			bos = new BufferedOutputStream(fos); //버퍼 출력스트리 연결
			
			while( (count = bis.read())  != -1 ) {
				bos.write((char)count);
			} // end while
			
			System.out.println("파일 복사 성공");
			bis.close();			bos.close();			fis.close();			fos.close();
		} catch (Exception e) {
			System.out.println("파일 복사 오류 발생~~~~");
		}
			
	}
}
