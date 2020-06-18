package chatPackage2;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Class : 회원가입 클래스
 */

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {
	private JPanel contentPane; 	/* 내용 */
	private JTextField tf_JoinId; 		/* 아이디 */
	private JTextField tf_JoinName; 		/* 이름 */
	private JPasswordField pf_JoinPw; 		/* 패스워드 */
	private UserDao dao;
	
	public Join(UserDao dao) {
		this.dao=dao;
		setTitle("회원가입");
		setBounds(630, 250, 300, 205); 	/* Join 창 사이즈 설정 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);



		JLabel lblID = new JLabel(" I D :");
		lblID.setBounds(39, 28, 27, 15);
		panel.add(lblID);



		tf_JoinId = new JTextField();
		tf_JoinId.setBounds(96, 25, 116, 21);
		panel.add(tf_JoinId);
		tf_JoinId.setColumns(10);



		JLabel lblNewLabel = new JLabel("PW :");
		lblNewLabel.setBounds(39, 59, 26, 15);
		panel.add(lblNewLabel);



		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setBounds(39, 90, 45, 15);
		panel.add(lblNewLabel_1);



		tf_JoinName = new JTextField();
		tf_JoinName.setBounds(96, 87, 116, 21);
		panel.add(tf_JoinName);

		tf_JoinName.setColumns(10);
		JButton btnJoinOk = new JButton("완료");

		btnJoinOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!dao.idAlreadyExist(tf_JoinId.getText())) {
						dao.insert(tf_JoinId.getText(), 
								new String(pf_JoinPw.getPassword()),tf_JoinName.getText());
						JOptionPane.showMessageDialog(null, "회원가입 성공!!");
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디 입니다!!");
						tf_JoinId.setText("");
						tf_JoinName.setText("");
						pf_JoinPw.setText("");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJoinOk.setBounds(42, 118, 97, 23);
		panel.add(btnJoinOk);
		JButton btnJoinBack = new JButton("취소");
		btnJoinBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnJoinBack.setBounds(148, 118, 97, 23);
		panel.add(btnJoinBack);

		pf_JoinPw = new JPasswordField();
		pf_JoinPw.setBounds(96, 56, 116, 21);
		panel.add(pf_JoinPw);
	}
}
