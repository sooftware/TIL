package client;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅프로그램 클라이언트 공유 메모리 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

public class SharedArea {
	private boolean quit=false;
	private JTextField textField;
	private JTextArea textArea;
	
	
	/* Set & Get Method */
	
	public boolean isQuit() {
		return quit;
	}
	public void setQuit(boolean quit) {
		this.quit = quit;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	/* Set & Get Method */
	
}
