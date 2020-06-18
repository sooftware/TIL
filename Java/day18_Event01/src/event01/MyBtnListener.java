package event01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnListener implements ActionListener{
	int count;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("바로 어제 3년 약정한 핸드뽄!");
	}
}



