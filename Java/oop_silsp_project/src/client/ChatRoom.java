package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatRoom extends JFrame implements ActionListener, ClientInterface{
	// 연결할 포트를 설정하기 위한 변수입니다.
	private InetAddress inetAddress;
	private int port;
	private SharedArea sArea;
	private ClientReceiver receiver;
	private ClientSender sender;
	private DatagramSocket socket;
	private String clientID;
	
	String userId;
	String userName;

	private JTextField textField;
	private JTextArea textArea;

	/* ChatRoom 생성자 */
	
	public ChatRoom(String id, String name, InetAddress ip, int p) throws UnknownHostException, IOException {
		inetAddress = ip;
		port = p;
		userName = name;
		userId = id;

		receiver = new ClientReceiver();
		//sender = new ClientSender();
		sArea = new SharedArea();
		
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		/* sArea 공유 */
		
		receiver.setsArea(sArea);
		sender.setsArea(sArea);
		
		/* sArea 공유 */
		
		/* 전체적인 레이아웃 */

		setTitle("Chatting Room");
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
		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		/* 전체적인 레이아웃 */
		
		/* Banner 부분 */
		
		JButton banner = new JButton("");
		banner.setForeground(new Color(255, 255, 255));
		banner.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop"
				+ "\\수환\\Workspace\\oop_silsp_project\\src\\client\\banner.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(1000,70, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedImg);
		banner.setIcon(icon);
		banner.setBorderPainted(false);
		panel_1.add(banner);
		
		/* Banner 부분 */
		
		textField.addActionListener(this);
		panel.add(textField);
		this.setVisible(true);

		/* 공유메모리 설정 */
		
		sArea.setTextArea(textArea);
		sArea.setTextField(textField);
		
		/* 공유메모리 설정 */
		
		/* 유저가 엔터를 눌렀을 때 */
		
		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String userInput =  textField.getText() + "\n";
					textArea.append(userInput);
					textField.setText("");
					String msg = id+" : " + userInput;
					
					byte[] buf = msg.getBytes();
					
					try {
						DatagramPacket packet = new DatagramPacket(buf, buf.length, 
								InetAddress.getByName(SERVER_IP), SERVER_PORT);
						socket.send(packet);
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/* 유저가 엔터를 눌렀을 때 */
		
	}
	
	/* ChatRoom 생성자 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
