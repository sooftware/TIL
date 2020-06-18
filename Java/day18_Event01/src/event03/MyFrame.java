package event03;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;

	public MyFrame() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();
		button1 = new JButton("ÇÎÅ©ÇÎÅ©ÇØ");
		button2 = new JButton("³ë¶û³ë¶ûÇØ");
		button1.addActionListener(new MyListener());
		button2.addActionListener(new MyListener());
		this.panel.add(button1);
		this.panel.add(button2);
		this.add(panel);
		
		this.setVisible(true);
		
	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button1) {
				panel.setBackground(Color.PINK);
			}
			else if(e.getSource() == button2){
				panel.setBackground(Color.YELLOW);
			}
		}
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
