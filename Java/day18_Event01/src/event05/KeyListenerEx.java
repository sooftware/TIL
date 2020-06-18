package event05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyListenerEx extends JFrame{
	private JPanel panel;
	private JTextField textField1;
	private JTextField textField2;

	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	
	public KeyListenerEx(){
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MoveMove");
		
		panel = new JPanel();
		textField1 = new JTextField(10);
		textField2 = new JTextField(10);
		
		textField1.addKeyListener(new MyKeyListener());
		
		panel.add(textField1);
		panel.add(textField2);
		add(panel);
		
		this.setVisible(true);
	}	
	
	public static void main(String[] args) {
		KeyListenerEx kle = new KeyListenerEx();
	}

	class MyKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			String text1 = textField1.getText();
			textField2.setText(text1.toUpperCase());
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
