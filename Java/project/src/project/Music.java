package project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/* 노래를 재생하는 class */
public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../audios/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime(){
		if(player == null){
			return 0;
		}
		return player.getPosition();
	}
	
	public void close(){
		isLoop = false;
		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try{
			do{
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
/* 노래를 재생하는 class */
