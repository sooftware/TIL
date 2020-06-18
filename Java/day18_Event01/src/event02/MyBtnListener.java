package event02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyBtnListener implements ActionListener{
	JTextField textField;
	public MyBtnListener(JTextField textField){
		this.textField=textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
