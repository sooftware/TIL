package ex05.problem;

public class MainEntry {
	public static void main(String[] args) {
		final int num=4;
		Vehicle[] vc = new Vehicle[num];
		
		vc[0] = new Bus();
		vc[1] = new Subway();
		vc[2] = new Bicycle();
		vc[3] = new Plain();
		
		for(int i=0;i<vc.length;i++){
			vc[i].start();
			vc[i].process();
			vc[i].end();
			System.out.println("=====================");
		}
	}
}
