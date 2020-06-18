package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetBanUI extends SuperUI {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SetBanUI() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton banhtn = new JButton("¹Ý¸¶¸®");
		banhtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oneOrder += "-"+((AbstractButton) e.getSource()).getText();
				order.add(oneOrder);
				dorder.add(oneOrder);
				list.setListData(dorder);
			}
		});
		banhtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 25));
		banhtn.setBackground(new Color(255, 248, 220));
		contentPane.add(banhtn);
		
		JButton hanbtn = new JButton("ÇÑ¸¶¸®");
		hanbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oneOrder += "-"+((AbstractButton) e.getSource()).getText();
				order.add(oneOrder);
				dorder.add(oneOrder);
				list.setListData(dorder);
			}
		});
		hanbtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 25));
		hanbtn.setBackground(new Color(255, 240, 245));
		contentPane.add(hanbtn);
	}

}
