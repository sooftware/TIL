package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/* 화면 구성하는 부분 */
public class MakeFrame extends JFrame implements Runnable {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;
	Color color;
	UserTest ut = new UserTest();
	int user_X_Coord = (int) (Main.SCREEN_WIDTH / 2);
	int user_Y_Coord = (int) (Main.SCREEN_WIDTH / 2);
	public static final int MOVE = 10;
	Graphics g;
	
	public MakeFrame() {
		color = Color.yellow;
		setTitle("Gallaga");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 창 크기 조정
		setResizable(false); // 창 크기 조절 불가능
		setLocationRelativeTo(null); // 창이 정 중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기를 할 수 있게
		setVisible(true); // 눈에 보이게 하는 창

		introBackground = new ImageIcon(Main.class.getResource("../images/BACKGROUND3.jpg")).getImage(); // 이미지
																											// 받아옴

		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
			
					switch (keyCode) {
					case 37:
						user_X_Coord -= MOVE;
						g.drawString("▲", user_X_Coord, user_Y_Coord);
						break;
					case 39:
						user_X_Coord += MOVE;
						g.drawString("▲", user_X_Coord, user_Y_Coord);
						break;
					default:
						g.drawString("▲", user_X_Coord, user_Y_Coord);
				}
			}
		});
		
		
		
		Music introMusic = new Music("WayBackHome.mp3", true); // 노래재생
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.setColor(color);		
		ut.drawmap(g);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}

	public void run() { // 스레드 구현부(실행부)

		while(true){
			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
/* 화면 구성하는 부분 */