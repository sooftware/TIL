package chatPackage;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Class : 채팅방 클래스
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Messenger extends JFrame implements ActionListener {
	private InetAddress inetAddress;	/* 연결할 IP를 설정하기 위한 변수 */
	private int port;	/* 연결할 PORT를 설정하기 위한 변수 */
	private MulticastSocket Socket;		/* packet 발사를 위한 멀티캐스트 socket */
	private DatagramPacket Packet;		/* 데이터를 보내기 위한 packet */
	private DatagramSocket dataSocket;	
	
	String userId;
	String userName;
	private JTextField textField;
	private JTextArea textArea;

	public Messenger(String id, String name, InetAddress ip, int p) throws UnknownHostException, IOException {
		inetAddress = ip;
		port = p;
		userName = name;
		userId = id;
		
		/* GUI 설정 부분 START */
		/* GUI 설정 부분 START */
		/* GUI 설정 부분 START */
		
		setTitle("SooHwan Chat Room");

		setBounds(200, 100, 900, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		textField = new JTextField();
		textField.setColumns(10);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JButton banner = new JButton("");
		banner.setForeground(new Color(255, 255, 255));
		banner.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop\\"
				+ "수환\\Workspace\\Java_Practice_Project\\src\\chatPackage\\banner2.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(850,70, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedImg);
		banner.setIcon(icon);
		banner.setBorderPainted(false);
		panel_1.add(banner);
		
		
		textField.addActionListener(this); /* textField에 ActionListener 적용 */
		panel.add(textField); /* panel에 textField 추가 */
		this.setVisible(true); /* 여태 만든 GUI 모두 화면에 표시 */

		/* GUI 설정 부분 END */
		/* GUI 설정 부분 END */
		/* GUI 설정 부분 END */
		
		Runnable r = new Runnable() {
			public void run() {
				byte[] buffer = new byte[512];
				try {
					/* socket에 joinGroup을 해줘야함 */
					Socket = new MulticastSocket(port);
					Socket.joinGroup(inetAddress);
					dataSocket = new DatagramSocket();
					/* 누구누구가 접속하였습니다를 구현 */
					String connect = "[ " + userName + "님 이 접속하셨습니다. 종료는 exit ]";
					buffer = connect.getBytes();

					Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
					Socket.send(Packet);

					/* Receive 부분 */
					while (true) {
						Packet = new DatagramPacket(buffer, buffer.length);
						Socket.receive(Packet);		/* packet receive */
						String msg = new String(Packet.getData(), 0, Packet.getLength()); 	/* msg에 packet이 보낸 message 저장 */
						textArea.append(msg + "\n");	/* textArea에 msg append */
						textArea.setCaretPosition(textArea.getDocument().getLength());	/* scroll바 추가 */
					}
					/* Receive 부분 */
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				} finally {
					Socket.close();
				}
			}
		};
		new Thread(r).start();
	}

	/* Send를 수행하는 부분 */
	/* 클래스 자체가 ActionListener를 implements 했음 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String s = textField.getText();
		textField.setText(null);
		byte[] buffer = new byte[512];

		/* 입력이 따로 없을시는 그냥 종료 */
		if (s == null || s == "" || s == "\n"  || s.length() == 0) {
			return;
		} 
		/* exit 입력시 프로그램 종료 */
		else if (s.equalsIgnoreCase("exit")) { /* exit을 대,소문자 상관없이 입력 시 종료 */
			String connect = "[" + userName + "님 이 퇴장하셨습니다.]";
			buffer = connect.getBytes();
			Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
			try {
				Socket.send(Packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Socket.close();		/* 소켓 close */
			System.exit(0);	/* 프로그램 종료 */
		}
		/* EXIT 체크 */
		
		/* Message Send */
		try {
			dataSocket = new DatagramSocket();
			String msg = "[" + userName + "]  : " + s;
			buffer = msg.getBytes();
			Packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
			Socket.send(Packet);
		} catch (IOException ie) {
			System.out.println("send 오류");
		} finally {
			dataSocket.close(); // 연결을 종료합니다.
		}
		/* Message Send */
	}
}