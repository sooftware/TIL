package project;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final double WIDTH = screenSize.getWidth();
	public static final double HEIGHT = screenSize.getHeight();
	
	private JPanel contentPane;
	private JTextField Idtf;
	private JTextField passwordtf;
	private ImageIcon im;
	MainUI t;
	private JPasswordField passwordField;


	public LoginUI(Vector<String> codeBuffer,LinkedList component_name,LinkedList component_num,LinkedList component_min) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
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
		ImageIcon originIcon = new ImageIcon("C:\\Users\\KimSooHwan\\Desktop\\수환\\Workspace\\FinalProject2\\src\\image\\banner_01_img_01_170823.png");
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(90,90, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		loginbtn.setIcon(Icon);
		loginbtn.setBorderPainted(false);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = new MainUI(codeBuffer,component_name,component_num,component_min);
				t.setVisible(true);
				dispose();
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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\KimSooHwan\\Desktop\\수환\\Workspace\\FinalProject2\\src\\image\\main_logo.jpg"));
		lblNewLabel.setBounds(40, 10, 360, 280);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 360, 120, 25);
		contentPane.add(passwordField);
		setVisible(true);
	}
}