package fourth;

public abstract class Calc {	
	int a,b;	// 공통으로 쓸 필드
	
	/* 4개의 클래스 모두 같은 내용이므로 공통으로 정의해준다 */
	public  void setValue(int a,int b){
		this.a=a;
		this.b=b;
	}
	
	/* 각기 다른 정의를 가질 것이므로 추상메서드로 남겨둔다 */
	public abstract  int calculate(int a,int b);
}
