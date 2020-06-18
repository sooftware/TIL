package JFRAME;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameTest extends JFrame{
	public static final int FRAME_WIDTH=1280;
	public static final int FRAME_HEIGHT=720;
	
	public FrameTest(){
		this.setTitle("O   ¤µa O");
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel label = new JLabel("¹»ºÁ");
		JButton button = new JButton("²Ù¿í");
		panel.add(label);
		panel.add(button);
		add(panel);
		
		this.setVisible(true);
	}
}