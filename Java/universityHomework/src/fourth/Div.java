package fourth;

public class Div extends Calc{
	/* 나누기 연산 */
	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		/* 0으로는 나눌 수 없으므로 예외처리를 위함 */
		if (!(b == 0)) {
			return (a / b);
		}else{
			/* 0으로 나눌때는 -1 반환 */
			return -1;
		}
	}
}
