package project1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Set3UI extends SuperUI {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Set3UI() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton singlebtn = new JButton("½Ì±Û");
		singlebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oneOrder += ((AbstractButton) e.getSource()).getText();
				order.add(oneOrder);
				dorder.add(oneOrder);
				list.setListData(dorder);
			}
		});
		singlebtn.setBackground(new Color(255, 255, 224));
		singlebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 20));
		contentPane.add(singlebtn);
		
		JButton couplebtn = new JButton("Ä¿ÇÃ");
		couplebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oneOrder += ((AbstractButton) e.getSource()).getText();
				order.add(oneOrder);
				dorder.add(oneOrder);
				list.setListData(dorder);
			}
		});
		couplebtn.setBackground(new Color(255, 255, 240));
		couplebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 20));
		contentPane.add(couplebtn);
		
		JButton danbtn = new JButton("´ÜÇ°");
		danbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oneOrder += ((AbstractButton) e.getSource()).getText();
				order.add(oneOrder);
				dorder.add(oneOrder);
				list.setListData(dorder);
			}
		});
		danbtn.setBackground(new Color(255, 255, 255));
		danbtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 20));
		contentPane.add(danbtn);
	}
}
