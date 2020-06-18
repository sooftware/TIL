package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Set4UI extends SuperUI {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Set4UI() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton set41 = new JButton("기본");
		set41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				order.add("양념감자(소)");
				dorder.add("양념감자(소)");
				list.setListData(dorder);
			}
		});
		set41.setBackground(new Color(255, 240, 245));
		set41.setFont(new Font("나눔바른펜", Font.BOLD, 25));
		contentPane.add(set41);
		
		JButton set42 = new JButton("감자 사이즈 업");
		set42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				order.add("양념감자(중)");
				dorder.add("양념감자(중)(변경)");
				list.setListData(dorder);
			}
		});
		set42.setBackground(new Color(255, 245, 238));
		set42.setFont(new Font("나눔바른펜", Font.BOLD, 25));
		contentPane.add(set42);
		
		JButton set43 = new JButton("치즈감자");
		set43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText() + "(변경)");
				list.setListData(dorder);
			}
		});
		set43.setBackground(new Color(255, 248, 220));
		set43.setFont(new Font("나눔바른펜", Font.BOLD, 25));
		contentPane.add(set43);
		
		JButton set44 = new JButton("어니언치즈감자");
		set44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText() + "(변경)");
				list.setListData(dorder);
			}
		});
		set44.setBackground(new Color(255, 250, 205));
		set44.setFont(new Font("나눔바른펜", Font.BOLD, 25));
		contentPane.add(set44);
	}

}
