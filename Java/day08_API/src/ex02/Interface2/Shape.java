package ex02.Interface2;

public abstract class Shape {
	double result = 0;
	public abstract double calc();
	public abstract void draw();
	
	public void show(){
		System.out.println("Super class Shape");
	}
	
	/* SET GET */
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	/* SET GET */
}
