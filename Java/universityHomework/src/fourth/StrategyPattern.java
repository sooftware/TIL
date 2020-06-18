package fourth;

public class StrategyPattern{
	Calc cal;
	/* Add,Div.. 등 원하는 연산을 수행할 때 cal에 객체를 set해주는 메서드 */
	public void setCal(Calc cal) {
		this.cal = cal;
	}	
	
	/* cal에 set을 해놓은 객체의 setValue를 찾아가서 수행할 메서드 */
	public void doSetValue(int a, int b) {
		// TODO Auto-generated method stub
		cal.setValue(a, b);
	}

	/* cal에 set을 해놓은 객체의 calculate를 찾아가서 수행할 메서드 */
	public int doCalculate(int a, int b) {
		// TODO Auto-generated method stub
		int result=0;
		
		result=cal.calculate(a, b);
		
		return result;
	}
}

/*
 StrategyPattern()의 객체를 생성하고,
 미리 만들어둔 Calc 타입의 cal 변수에 원하는 객체를 넣을 수 있는
 setCal(Calc cal) 메서드를 만들어두고, 원하는 연산에 해당하는 객체를 
 setCal(Calc cal) 메서드로 cal에 넣어준다. 
 이렇게 생성을 하면 만약 new Add() 객체가 생성이 되었다면,
 StrategyPattern()의 객체의 setValue를 실행하면
 cal.setValue(a,b) 가 실행이 될 것이고 이는 사실상
 -> Add 클래스의 setValue를 실행하는 것과 같다.
 이런 방식으로 calculate()도 실행이 된다.
 
 즉, 똑같은 클래스, 똑같은 메서드를 사용하면서, 생성하는 객체만 바꿔주면,
 원하는 다른 결과를 얻을 수 있다.
 */
