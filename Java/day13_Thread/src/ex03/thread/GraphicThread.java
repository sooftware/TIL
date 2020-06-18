package ex03.thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;

public class GraphicThread extends JFrame implements Runnable{
	// 	Frame : window
	int num,x,y;
	Color color;
	Random random;

	public GraphicThread(int num){	// 매개변수 1개 생성자 함수,	멤버변수 초기화
		this.num=num;
		color = Color.darkGray;
		random = new Random();
		setSize(500,400);	// 프레임(화면)크기 - 너비, 높이
		setVisible(true);	// 화면 보여주기
		setLocation(300,150);	// 창의 좌표 이동해주기
		setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}

	public void run(){	// 스레드 구현부(실행부)
		Rectangle rect = getBounds();
		
		for(int i=0;i<num;i++){
			x = random.nextInt(rect.width);
			y= random.nextInt(rect.height);
			
			repaint();
			
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
/*		GraphicThread gt = new GraphicThread(10);
		Thread t1 = new Thread(gt);*/
		new Thread(new GraphicThread(2000)).start();
		
		//start();
	}
}