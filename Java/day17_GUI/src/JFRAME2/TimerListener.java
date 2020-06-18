package JFRAME2;

import java.util.Date;

import Alarm.Music;

public class TimerListener {
	public void dosomething(){
		Date d = new Date();

		while(true){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(d.getHours()==11 && d.getMinutes() == 30){
					System.out.println("시간되쪙!!!!!!");
					
					
					Music introMusic = new Music("WayBackHome.mp3", true); // 노래재생
					introMusic.start();
			}
		}
	}
}

/*
템플릿메소드패턴은 메소드 수행중에 특정 동작에 대해 추상메소드 호출로 비워놓고
해당 작업을 자식클래스의 오버라이드된 동작으로 채워지도록 하는 것
-> 키리스너 생각!!
*/