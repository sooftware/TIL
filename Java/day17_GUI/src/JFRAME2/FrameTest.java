package JFRAME2;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameTest extends JFrame{
	public static final int FRAME_WIDTH=1280;
	public static final int FRAME_HEIGHT=720;
	
	public FrameTest(){
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("진국 마시쪙!!!!!");
		
		
		JPanel panel = new JPanel();
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		t2.setEditable(false);
		panel.add(t1);
		panel.add(t2);
		
		JButton button1 = new JButton("왼쪽 꾸욱");
		JButton button2 = new JButton("중앙 꾸욱");
		JButton button3 = new JButton("오른쪽 꾸욱");

		
		Font font = new Font("궁서",Font.BOLD,30);
		button1.setFont(font);
		button2.setFont(font);
		button3.setFont(font);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		add(panel);
		setVisible(true);
	}
}