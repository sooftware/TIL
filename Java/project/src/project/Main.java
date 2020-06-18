package project;

import java.awt.Graphics;

public class Main extends Thread implements Runnable{
	/* static final 識情 */
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT=720;
	/* static final 識情 */
	
	/* Main */
	public static void main (String[] args) {
		MakeFrame mk = new MakeFrame();
		Thread t1 = new Thread(mk);
		

		t1.start();
	}
	/* Main */
}
