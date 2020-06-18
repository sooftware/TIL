package event03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {
	private JButton button1;
	private JPanel panel;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	String a=null, b=null;
	int c;
	String c1;
	public MyFrame2() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();

		textField1 = new JTextField(10);
		textField2 = new JTextField(10);
		textField3 = new JTextField(20);
		button1 = new JButton("´­·¯");

		button1.addActionListener(new MyListener());
		textField1.addKeyListener(new MyListener());
		textField2.addKeyListener(new MyListener());
		textField3.addActionListener(new MyListener());

		this.panel.add(textField1);
		this.panel.add(textField2);
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
/*			if (e.getSource() == textField1) {
				a = textField1.getText();
			} else if (e.getSource() == textField2) {
				b = textField1.getText();
			} */
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button1) {
				a = textField1.getText();
				Integer.parseInt(a);
				b = textField2.getText();
				Integer.parseInt(b);
				c= Integer.parseInt(a) + Integer.parseInt(b);
				c1 = ""+c;
				textField3.setText(c1);
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
		MyFrame2 mf = new MyFrame2();
	}
}
