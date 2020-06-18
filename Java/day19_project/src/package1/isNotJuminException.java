package package1;

public class isNotJuminException extends RuntimeException{
	public isNotJuminException(){
		super("주민번호 자릿수가 틀립니다 (13자리로 입력해주세요)");
	}
	
	public void ment(){
		System.out.println("\n\n주민번호 자릿수가 틀려용");
		System.out.println("다시 입력하세용 O   ㅅa O \n\n");
	}
}
