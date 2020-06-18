package third;

import java.util.Scanner;

public class Div {
	int a, b;

	/* 입력받은 a,b를 해당 객체 a,b에 넣어준다. */
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/* 나누기 연산 */
	public int calculate(int a, int b) {
		/* 0으로 나눌 시 예외처리를 위함 */
		if (!(b == 0)) {
			return (a/b);
		} else {
			return -1;
		}
	}
}
