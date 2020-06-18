package event05;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import event05.KeyListenerEx.MyKeyListener;

public class MouseListenerEx extends JFrame{
	private JPanel panel;
	private JTextField textField1;

	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	
	public MouseListenerEx(){
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mouse");
		
		panel = new JPanel();
		textField1 = new JTextField(20);
		
		textField1.addMouseListener(new MyListener());
		
		panel.add(textField1);
		add(panel);
		
		this.setVisible(true);
	}
	
	class MyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
/*			String text1 = textField1.getText();
			textField1.setText(text1.toUpperCase());*/
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String text1 = textField1.getText();
			textField1.setText(text1.toUpperCase());
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String text1 = textField1.getText();
			textField1.setText(text1.toLowerCase());
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String text1 = textField1.getText();
			textField1.setText(text1.toUpperCase());
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String text1 = textField1.getText();
			textField1.setText(text1.toLowerCase());
		}
		
	}
	
	public static void main(String[] args) {
		MouseListenerEx mle = new MouseListenerEx();
	}
}