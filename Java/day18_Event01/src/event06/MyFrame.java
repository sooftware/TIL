package event06;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	protected JTextField textField1;
	protected JTextField textField2;
	protected JTextField textField3;
	protected JTextArea textArea;
	protected JButton mybtn;
	private JPanel jp = new JPanel();
	
	public MyFrame() {
		setTitle("Text Area Test");
		setSize(1200,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mybtn = new JButton("Ãß°¡");
		textField1 = new JTextField(10);
		textField2 = new JTextField(10);
		textField3 = new JTextField(10);
		mybtn.addActionListener(new MyListener());
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		jp.add(textField1);
		jp.add(textField2);
		jp.add(textField3);
		add(jp,BorderLayout.NORTH);
		add(mybtn,BorderLayout.AFTER_LAST_LINE);

		add(scrollPane, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	class MyListener  implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = textField1.getText()+"\t"+textField2.getText()+"\t"+textField3.getText();
			textArea.append(text + "\n");
			textField1.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}