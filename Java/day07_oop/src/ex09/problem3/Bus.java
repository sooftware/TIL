package ex09.problem3;
import java.util.*;

public class Bus implements Tran {
	double distance=0;
	double last_speed,first_speed;
	final double limit=100;
	int t = 0;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void move() {
		System.out.print("처음 속도를 눌러주세요 >.< (m/s) : ");
		first_speed=sc.nextDouble();
		
		last_speed=first_speed;
		
		while(last_speed<limit){
			last_speed += accelerater;
			t++;
		}
		distance = ((first_speed+limit)/2) * t;
		stop();
	}

	@Override
	public void stop() {
		System.out.println("버스가 멈췄습니다 >.<");
		System.out.printf("이동한 거리는 %.2fm입니다",distance);
	}

}
