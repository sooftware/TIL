package event01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class kungkungtta {
	void run(ActionListener al) {
		ActionEvent e = null;
		al.actionPerformed(e);
	}
}

public class MyFrame extends JFrame {
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;

	public MyFrame() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton mybtn = new JButton("버튼입니다 >.<");
		
		if (i % 2 == 0) {
			mybtn.addActionListener(new tta());
			i++;
		} else {
			mybtn.addActionListener(new kung());
			i++;
		}
		JPanel mypnl = new JPanel();
		mypnl.add(mybtn);
		this.add(mypnl);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
