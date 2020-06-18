package event02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	JTextField t1 = new JTextField(40);
	public MyFrame() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		t1.addActionListener(new MyListener());
		JButton mybtn = new JButton("´­·¯");
		JPanel mypnl = new JPanel();
		mypnl.add(t1);
		mypnl.add(mybtn);
		this.add(mypnl);

		this.setVisible(true);
	}
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(t1.getText());
		}
	}
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}