package project;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UserTest extends Thread {
	KeyEvent ke;
	char keyCode;

	public static final int MOVE = 10;
	int user_X_Coord;
	int user_Y_Coord;

	public UserTest() {
		user_X_Coord = (int) (Main.SCREEN_WIDTH / 2);
		user_Y_Coord = (int) (Main.SCREEN_WIDTH / 2);
	}

	public void drawmap(Graphics g) {
		// int keyCode = e.getKeyCode();

		for (int j = 100; j < 201; j += 50) {
			for (int i = 40; i < Main.SCREEN_WIDTH - 100; i += 70) {
				g.drawRect(i, j, 10, 10);
			}
		}

		
	}

}
