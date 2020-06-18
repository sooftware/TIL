package dbEx;

public class GnoAlreadyExistException extends RuntimeException{
	public GnoAlreadyExistException(){
		super("이미 존재하는 고객번호 입니다.");
	}

	public void ment(){
		System.out.println("\n\n이미 존재하는 고객번호에용");
		System.out.println("다시 입력하세용 O   ㅅa O \n\n");
	}
}