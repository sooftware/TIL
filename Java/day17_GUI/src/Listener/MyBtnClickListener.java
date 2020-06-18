package Listener;

import java.awt.event.ActionListener;

import Alarm.Music;

import java.awt.event.ActionEvent;

public class MyBtnClickListener implements ActionListener,SooHwanListener {


	@Override
	public void sysout() {
		// TODO Auto-generated method stub
		System.out.println("sysout 정의");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("누름");
	}
}