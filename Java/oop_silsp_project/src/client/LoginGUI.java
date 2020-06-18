package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import chatPackage.Join;
import chatPackage.UserDao;

public class LoginGUI extends JFrame implements ClientInterface{
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final double WIDTH = screenSize.getWidth();
	public static final double HEIGHT = screenSize.getHeight();
	
	private JPanel contentPane;
	private JTextField Idtf;
	private JTextField passwordtf;
	private ImageIcon im;
	private JPasswordField passwordField;
	private InetAddress inetAddress;
	public LoginGUI() {
		setTitle("Login 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Idtf = new JTextField();
		Idtf.setBounds(146, 300, 120, 25);
		contentPane.add(Idtf);
		Idtf.setColumns(10);
		
		JButton loginbtn = new JButton("");
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon = new ImageIcon("C:\\Users\\SooHwanKim"
				+ "\\Desktop\\수환\\Workspace\\oop_silsp_project\\src\\client\\login.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(90,90, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		loginbtn.setIcon(Icon);
		loginbtn.setBorderPainted(false);
		loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean loginOk;
					loginOk = UserDao.getInstance().loginCheck(tf_Id.getText(), new String(pf_Pw.getPassword()));
					if (loginOk) {
						UserDao.getInstance().loginSuccess(tf_Id.getText());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "로그인실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		loginbtn.setBounds(300, 300, 90, 90);
		contentPane.add(loginbtn);
		
		JLabel IdLabel = new JLabel("ID : ");
		IdLabel.setBounds(40, 300, 80, 25);
		contentPane.add(IdLabel);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(40, 360, 80, 25);
		contentPane.add(passwordLabel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\SooHwanKim\\\\Desktop\\\\"
				+ "수환\\\\Workspace\\\\oop_silsp_project\\\\src\\\\client\\\\scp.png"));
		lblNewLabel.setBounds(40, 10, 360, 280);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 360, 120, 25);
		contentPane.add(passwordField);
		
		JButton joinBtn = new JButton("");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join frame = new Join();
				frame.setVisible(true);
			}
		});
		joinBtn.setBounds(300, 400, 90, 20);
		joinBtn.setForeground(new Color(255, 255, 255));
		joinBtn.setBackground(new Color(255, 255, 255));
		ImageIcon originIcon2 = new ImageIcon("C:\\Users\\SooHwanKim"
				+ "\\Desktop\\수환\\Workspace\\oop_silsp_project\\src\\client\\join.png");
		Image originImg2 = originIcon2.getImage(); 
		Image changedImg2= originImg2.getScaledInstance(60,20, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		joinBtn.setIcon(Icon2);
		joinBtn.setBorderPainted(false);
		contentPane.add(joinBtn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		LoginGUI test = new LoginGUI();
	}
}
