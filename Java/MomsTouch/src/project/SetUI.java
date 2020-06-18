package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SetUI extends SuperUI {

	private JPanel contentPane;
	Set4UI su;
	MainUI mu;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SetUI frame = new SetUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * });
	 */

	public SetUI() {
		su = new Set4UI();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JButton singlebtn = new JButton("´ÜÇ°");
		singlebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				list.setListData(dorder);
			}
		});
		singlebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 25));
		singlebtn.setForeground(new Color(0, 0, 0));
		singlebtn.setBackground(new Color(255, 248, 220));
		contentPane.add(singlebtn);

		JButton setbtn = new JButton("¼¼Æ®");
		setbtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 25));
		setbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				su.dispose();
				su = new Set4UI();
				su.setVisible(true);
			}
		});
		setbtn.setBackground(new Color(255, 240, 245));
		contentPane.add(setbtn);
	}
	
}

/**
 * Create the frame.
 */

