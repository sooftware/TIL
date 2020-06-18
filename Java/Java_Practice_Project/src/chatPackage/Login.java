package chatPackage;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Class : 로그인 클래스 및 main 메서드
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField idTf;
	private JPasswordField  passwordtf;
	private ImageIcon im;
	private UserDao dao;

	public static void main(String[] args) {
		new Login(new UserDao());
	}
	
	/* Login 생성자 */
	Login(UserDao dao) {
		this.dao=dao;
		setTitle("Login 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idTf = new JTextField();
		idTf.setBounds(146, 300, 120, 25);
		contentPane.add(idTf);
		idTf.setColumns(10);
		
		JButton loginbtn = new JButton("");
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop\\"
				+ "수환\\Workspace\\Java_Practice_Project\\src\\chatPackage\\login.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(80,80, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		loginbtn.setIcon(Icon);
		loginbtn.setBorderPainted(false);
		
		/* 로그인 버튼 Action!!! */
		/* 로그인 버튼 Action!!! */
		/* 로그인 버튼 Action!!! */
		loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean loginOk;
					loginOk = dao.loginCheck(idTf.getText(), new String(passwordtf.getPassword()));
					if (loginOk) {
						dao.loginSuccess(idTf.getText());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "로그인실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/* 로그인 버튼 Action!!! */
		/* 로그인 버튼 Action!!! */
		/* 로그인 버튼 Action!!! */
		
		loginbtn.setBounds(300, 300, 90, 90);
		contentPane.add(loginbtn);
		
		JLabel IdLabel = new JLabel("ID : ");
		IdLabel.setBounds(40, 300, 80, 25);
		contentPane.add(IdLabel);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(40, 360, 80, 25);
		contentPane.add(passwordLabel);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon titleIcon = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop\\"
				+ "수환\\Workspace\\Java_Practice_Project\\src\\chatPackage\\title.png");
		Image titleImage=titleIcon.getImage();
		titleImage = titleImage.getScaledInstance(360,280,Image.SCALE_SMOOTH);
		titleIcon=new ImageIcon(titleImage);
		lblNewLabel.setIcon(titleIcon);
		lblNewLabel.setBounds(40, 10, 360, 280);
		contentPane.add(lblNewLabel);
		
		passwordtf = new JPasswordField();
		passwordtf.setBounds(146, 360, 120, 25);
		contentPane.add(passwordtf);
		
		
		/* 회원가입 Action!!! */
		/* 회원가입 Action!!! */
		/* 회원가입 Action!!! */
		JButton joinBtn = new JButton("");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join frame = new Join(dao);
				frame.setVisible(true);
			}
		});
		/* 회원가입 Action!!! */
		/* 회원가입 Action!!! */
		/* 회원가입 Action!!! */
		
		
		joinBtn.setBounds(300, 400, 90, 20);
		joinBtn.setForeground(new Color(255, 255, 255));
		joinBtn.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon2 = new ImageIcon("C:\\Users\\SooHwanKim\\Desktop\\"
				+ "수환\\Workspace\\Java_Practice_Project\\src\\chatPackage\\join.png");
		Image originImg2 = originIcon2.getImage(); 
		Image changedImg2= originImg2.getScaledInstance(60,20, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		joinBtn.setIcon(Icon2);
		joinBtn.setBorderPainted(false);
		contentPane.add(joinBtn);
		
		setVisible(true);
	}
}



