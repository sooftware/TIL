package JFRAME2;

import java.util.Date;

import Alarm.Music;

public abstract class MyListener implements Listener {
	private MyListener listener;
	
	public void setListener(MyListener listener){
		this.listener = listener;
	}

	public void do_something(){
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