package event04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import event03.MyFrame2;


public class MyFrame extends JFrame{
	private JButton button1;
	private JPanel panel;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	String a;
	int b;
	int c;
	String c1;
	public MyFrame() {
		this.setTitle("원을 달러로 바꿔줄꼐!!!");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();

		textField1 = new JTextField(10);
		textField3 = new JTextField(40);
		button1 = new JButton("눌러");

		button1.addActionListener(new MyListener());
		textField1.addKeyListener(new MyListener());
		textField3.addActionListener(new MyListener());

		this.panel.add(textField1);
		this.panel.add(button1);
		this.panel.add(textField3);
		this.add(panel);

		this.setVisible(true);

	}

	class MyListener implements KeyListener, ActionListener {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button1) {
				a = textField1.getText();
				b=Integer.parseInt(a)/1300;
				int rest = Integer.parseInt(a)%1300;
				String rest_Text=""+rest;
				String b_Text=""+b;
				textField3.setText(a+"원은 "+b_Text+"달러 입니다. 그리고 "+rest_Text+"원이 남습니당!!");
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
