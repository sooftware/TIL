package ex01_problem1;

public class Tv {
	String color;
	int channel;
	boolean sound;
	
	public Tv(){
		color="BLACK";
		channel=7;
		sound=true;q
	}
	
	public Tv(String color,int channel,boolean sound){
		this.color=color;
		this.channel=channel;
		this.sound=sound;
	}
	
	/* SET GET */
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getChannel() {
		return channel;
	}
	public int setChannel(int channel) {
		return this.channel = channel;
	}
	public boolean isSound() {
		return sound;
	}
	public void setSound(boolean sound) {
		this.sound = sound;
	}
	
	/* SET GET */
}
