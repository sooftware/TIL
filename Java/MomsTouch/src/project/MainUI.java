package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainUI extends SuperUI {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final double WIDTH = screenSize.getWidth();
	public static final double HEIGHT = screenSize.getHeight();
	private JPanel contentPane;
	Vector<String> codeBuffer;
	SuperUI s;
	LinkedList component_name;
	LinkedList component_num;
	LinkedList component_min;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainUI(Vector<String> codeBuffer, LinkedList component_name, LinkedList component_num,
			LinkedList component_min) {
		this.codeBuffer = codeBuffer;
		this.component_name = component_name;
		this.component_num = component_num;
		this.component_min = component_min;
		s = new SetUI();
		order = new Vector<>();
		dorder = new Vector<>();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int) WIDTH, (int) HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList(dorder);
		list.setBounds(0, 100, (int) WIDTH, (int) (HEIGHT) - 100);

		MyActionListener ml = new MyActionListener();

		JPanel menupanel = new JPanel();
		menupanel.setForeground(Color.WHITE);
		menupanel.setBackground(Color.DARK_GRAY);
		menupanel.setBounds(0, 0, (int) WIDTH, (int) (HEIGHT / 2));
		contentPane.add(menupanel);
		menupanel.setLayout(new GridLayout(0, 10, 0, 0));

		JButton b1 = new JButton("½ÎÀÌ¹ö°Å");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b1.setBackground(new Color(255, 245, 238));
		menupanel.add(b1);

		JButton b2 = new JButton("µöÄ¡Áî¹ö°Å");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b2.setBackground(new Color(255, 245, 238));
		menupanel.add(b2);

		JButton b3 = new JButton("È­ÀÌÆ®°¥¸¯¹ö°Å");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b3.setBackground(new Color(255, 245, 238));
		menupanel.add(b3);

		JButton b4 = new JButton("ºÒ½ÎÀÌ¹ö°Å");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b4.setBackground(new Color(255, 245, 238));
		menupanel.add(b4);

		JButton b5 = new JButton("Åë»õ¿ì¹ö°Å");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b5.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b5.setBackground(new Color(255, 245, 238));
		menupanel.add(b5);

		JButton b6 = new JButton("ºÒ°í±â¹ö°Å");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b6.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b6.setBackground(new Color(255, 245, 238));
		menupanel.add(b6);

		JButton b7 = new JButton("Ä¡Áîº£ÀÌÄÁ¹ö°Å");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b7.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b7.setBackground(new Color(255, 245, 238));
		menupanel.add(b7);

		JButton b8 = new JButton("µð·°½ººÒ°í±â¹ö°Å");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b8.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b8.setBackground(new Color(255, 245, 238));
		menupanel.add(b8);

		JButton b9 = new JButton("Ä®½·ÇÃ·¯½º¹ö°Å");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetUI();
				s.setVisible(true);
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
			}
		});
		b9.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		b9.setBackground(new Color(255, 245, 238));
		menupanel.add(b9);

		JButton B1 = new JButton("Blank");
		B1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B1.setEnabled(false);
		menupanel.add(B1);

		JButton c1 = new JButton("ÈÄ¶óÀÌµåÄ¡Å²");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c1.setBackground(new Color(255, 250, 205));
		menupanel.add(c1);

		JButton c2 = new JButton("¾ç³äÄ¡Å²");
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c2.setBackground(new Color(255, 250, 205));
		menupanel.add(c2);

		JButton c3 = new JButton("ÂòÇß´ß");
		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c3.setBackground(new Color(255, 250, 205));
		menupanel.add(c3);

		JButton c4 = new JButton("Ä¡ÆÄ¿ÀÄ¡Å²");
		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c4.setBackground(new Color(255, 250, 205));
		menupanel.add(c4);

		JButton c5 = new JButton("»ÑÄ¡(¾î´Ï¾ðÄ¡Áî)");
		c5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c5.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c5.setBackground(new Color(255, 250, 205));
		menupanel.add(c5);

		JButton c6 = new JButton("»ÑÄ¡(ÇÖÄ¥¸®)");
		c6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c6.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c6.setBackground(new Color(255, 250, 205));
		menupanel.add(c6);

		JButton c7 = new JButton("»ÑÄ¡(ºÒ°¥ºñ)");
		c7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		c7.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c7.setBackground(new Color(255, 250, 205));
		menupanel.add(c7);

		JButton c8 = new JButton("¼ø»ìÄ¡Å²(8Á¶°¢)");
		c8.addActionListener(ml);
		c8.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c8.setBackground(new Color(255, 250, 205));
		menupanel.add(c8);

		JButton c9 = new JButton("¼ø»ìÄ¡Å²(16Á¶°¢)");
		c9.addActionListener(ml);
		c9.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c9.setBackground(new Color(255, 250, 205));
		menupanel.add(c9);

		JButton c12 = new JButton("ÅëÄ¡Å²");
		c12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new SetBanUI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});

		JButton c10 = new JButton("¼ø»ìÄ¡Å²(8Á¶°¢)-¾ç³ä");
		c10.addActionListener(ml);
		c10.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c10.setBackground(new Color(255, 250, 205));
		menupanel.add(c10);

		JButton c11 = new JButton("¼ø»ìÄ¡Å²(16Ä¡Å²)-¾ç³ä");
		c11.addActionListener(ml);
		c11.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c11.setBackground(new Color(255, 250, 205));
		menupanel.add(c11);
		c12.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		c12.setBackground(new Color(255, 250, 205));
		menupanel.add(c12);

		JButton s1 = new JButton("ÇÒ¶óÇÇ´¢³Ê°Ù(8Á¶°¢)");
		s1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.add(((AbstractButton) e.getSource()).getText());
				dorder.add(((AbstractButton) e.getSource()).getText());
				list.setListData(dorder);
			}
		});

		JButton B2 = new JButton("Blank");
		B2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B2.setEnabled(false);
		menupanel.add(B2);

		JButton B3 = new JButton("Blank");
		B3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B3.setEnabled(false);
		menupanel.add(B3);

		JButton B4 = new JButton("Blank");
		B4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B4.setEnabled(false);
		menupanel.add(B4);

		JButton B5 = new JButton("Blank");
		B5.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B5.setEnabled(false);
		menupanel.add(B5);

		JButton B6 = new JButton("Blank");
		B6.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B6.setEnabled(false);
		menupanel.add(B6);

		JButton B7 = new JButton("Blank");
		B7.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B7.setEnabled(false);
		menupanel.add(B7);

		JButton B8 = new JButton("Blank");
		B8.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B8.setEnabled(false);
		menupanel.add(B8);

		JButton B9 = new JButton("Blank");
		B9.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B9.setEnabled(false);
		menupanel.add(B9);
		s1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s1.setBackground(new Color(245, 222, 179));
		menupanel.add(s1);

		JButton s2 = new JButton("ÇÒ¶óÇÇ´¢³Ê°Ù(10Á¶°¢)");
		s2.addActionListener(ml);
		s2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s2.setBackground(new Color(245, 222, 179));
		menupanel.add(s2);

		JButton s3 = new JButton("ÇÒ¶óÇÇ´¢³Ê°Ù(22Á¶°¢)");
		s3.addActionListener(ml);
		s3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s3.setBackground(new Color(245, 222, 179));
		menupanel.add(s3);

		JButton s4 = new JButton("¸ÅÄÞ±è¶±¸¸");
		s4.addActionListener(ml);
		s4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s4.setBackground(new Color(245, 222, 179));
		menupanel.add(s4);

		JButton s5 = new JButton("°¥¸¯±è¶±¸¸");
		s5.addActionListener(ml);
		s5.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s5.setBackground(new Color(245, 222, 179));
		menupanel.add(s5);

		JButton s6 = new JButton("ÆËÄÜº¼");
		s6.addActionListener(ml);
		s6.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s6.setBackground(new Color(245, 222, 179));
		menupanel.add(s6);

		JButton s7 = new JButton("°í±¸¸¶Ä¡Áîº¼");
		s7.addActionListener(ml);
		s7.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s7.setBackground(new Color(245, 222, 179));
		menupanel.add(s7);

		JButton s8 = new JButton("°­Á¤");
		s8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new Set3UI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		s8.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s8.setBackground(new Color(245, 222, 179));
		menupanel.add(s8);

		JButton s9 = new JButton("Ä¡ÆÄ¿À");
		s9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new Set3UI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		s9.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s9.setBackground(new Color(245, 222, 179));
		menupanel.add(s9);

		JButton s10 = new JButton("ÂòÇß´ß");
		s10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.dispose();
				s = new Set3UI();
				s.setVisible(true);
				oneOrder = ((AbstractButton) e.getSource()).getText();
			}
		});
		s10.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s10.setBackground(new Color(245, 222, 179));
		menupanel.add(s10);

		JButton s11 = new JButton("ÅÙ´õ·ÎÀÎ(2Á¶°¢)");
		s11.addActionListener(ml);
		s11.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s11.setBackground(new Color(245, 222, 179));
		menupanel.add(s11);

		JButton s12 = new JButton("Ä¡Áî½ºÆ½(2Á¶°¢)");
		s12.addActionListener(ml);
		s12.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s12.setBackground(new Color(245, 222, 179));
		menupanel.add(s12);

		JButton s13 = new JButton("ÆËÄÜ¸¸µÎ");
		s13.addActionListener(ml);
		s13.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s13.setBackground(new Color(245, 222, 179));
		menupanel.add(s13);

		JButton s14 = new JButton("Ä¡Å²»ø·¯µå");
		s14.addActionListener(ml);
		s14.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		s14.setBackground(new Color(245, 222, 179));
		menupanel.add(s14);

		JButton se1 = new JButton("µô¸®¹ö¸®A");
		se1.addActionListener(ml);

		JButton B10 = new JButton("Blank");
		B10.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B10.setEnabled(false);
		menupanel.add(B10);

		JButton B11 = new JButton("Blank");
		B11.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B11.setEnabled(false);
		menupanel.add(B11);

		JButton B12 = new JButton("Blank");
		B12.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B12.setEnabled(false);
		menupanel.add(B12);

		JButton B13 = new JButton("Blank");
		B13.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B13.setEnabled(false);
		menupanel.add(B13);

		JButton B14 = new JButton("Blank");
		B14.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B14.setEnabled(false);
		menupanel.add(B14);

		JButton B15 = new JButton("Blank");
		B15.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		B15.setEnabled(false);
		menupanel.add(B15);
		se1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se1.setBackground(new Color(255, 204, 51));
		menupanel.add(se1);

		JButton se2 = new JButton("µô¸®¹ö¸®B");
		se2.addActionListener(ml);
		se2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se2.setBackground(new Color(255, 204, 51));
		menupanel.add(se2);

		JButton se3 = new JButton("µô¸®¹ö¸®C");
		se3.addActionListener(ml);
		se3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se3.setBackground(new Color(255, 204, 51));
		menupanel.add(se3);

		JButton se4 = new JButton("È¨ÆÑA");
		se4.addActionListener(ml);
		se4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se4.setBackground(new Color(255, 204, 51));
		menupanel.add(se4);

		JButton se5 = new JButton("È¨ÆÑB");
		se5.addActionListener(ml);
		se5.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se5.setBackground(new Color(255, 204, 51));
		menupanel.add(se5);

		JButton se6 = new JButton("½Ç¼ÓÆÑ");
		se6.addActionListener(ml);
		se6.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		se6.setBackground(new Color(255, 204, 51));
		menupanel.add(se6);

		JButton p1 = new JButton("¾ç³ä°¨ÀÚ(¼Ò)");
		p1.addActionListener(ml);
		p1.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		p1.setBackground(new Color(244, 164, 96));
		menupanel.add(p1);

		JButton p2 = new JButton("¾ç³ä°¨ÀÚ(Áß)");
		p2.addActionListener(ml);
		p2.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		p2.setBackground(new Color(244, 164, 96));
		menupanel.add(p2);

		JButton p3 = new JButton("Ä¡Áî°¨ÀÚ");
		p3.addActionListener(ml);
		p3.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		p3.setBackground(new Color(244, 164, 96));
		menupanel.add(p3);

		JButton p4 = new JButton("¾î´Ï¾ðÄ¡Áî°¨ÀÚ");
		p4.addActionListener(ml);
		p4.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		p4.setBackground(new Color(244, 164, 96));
		menupanel.add(p4);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, (int) (HEIGHT / 2), (int) WIDTH, (int) (HEIGHT / 2));
		contentPane.add(panel);

		JButton allcanclebtn = new JButton("\uC804\uCCB4 \uCDE8\uC18C");
		allcanclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.removeAllElements();
				dorder.removeAllElements();
				list.setListData(dorder);
			}
		});
		allcanclebtn.setBackground(new Color(255, 0, 0));
		allcanclebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 20));
		allcanclebtn.setBounds(250, 40, 100, 25);
		allcanclebtn.setBorderPainted(false);
		panel.add(allcanclebtn);

		JButton canclebtn = new JButton("\uAC1C\uBCC4 \uCDE8\uC18C");
		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				order.remove(i);
				dorder.remove(i);
				list.setListData(dorder);
			}
		});
		canclebtn.setBackground(Color.WHITE);
		canclebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 20));
		canclebtn.setBounds(120, 40, 100, 25);
		panel.add(canclebtn);

		JButton transbtn = new JButton("\uC804\uC1A1!!!!");
		transbtn.addActionListener(new ActionListener() {
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			public void actionPerformed(ActionEvent e) {
				About_SQL sql = new About_SQL();				
				sql.connect_SQL();
				JOptionPane.showMessageDialog(null, "Àü¼Û¿Ï·á");
				MainUI.this.codeBuffer = order;
				String rocket = "";
				Vector<Integer> codeReceive = new Vector<Integer>();
				
				sql.searchCode(MainUI.this.codeBuffer, codeReceive);
				
				for (int i = 0; i < codeReceive.size(); i++) {	//  receiveAmount.size()´Â °á°úÀûÀ¸·Î ÁÖ¹®ÀÇ °³¼öÀÌ¹Ç·Î ÁÖ¹®ÀÇ °³¼ö¸¸Å­ ¹Ýº¹ÇÑ´Ù´Â ÀÇ¹Ì
						sql.bring_SQL(codeReceive.get(i), component_name, component_num, component_min);
				}
				sql.nameOverlap(component_name, component_num, component_min);
				
				for (int i = 0; i < component_name.size(); i++) {
					rocket+=component_name.get(i) + " : " + component_num.get(i) + "°³ " + component_min.get(i) + "ºÐ\n";
				}
				/* »èÁ¦ */
				order.removeAllElements();
				dorder.removeAllElements();
				list.setListData(dorder);
				for(int i=0;i<order.size();i++){
					order.remove(i);
				}
				MainUI.this.codeBuffer.removeAllElements();
				codeReceive.removeAllElements();
				component_name.clear();
				component_num.clear();
				component_min.clear();
				/* »èÁ¦ */
				
				System.out.println(rocket);
				//UDPsender uSen = new UDPsender(rocket);
			}
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
			/* ·Î±×ÀÎ ÈÄ ¸ÞÀÎÈ­¸é */
		});
		transbtn.setBackground(Color.WHITE);
		transbtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 20));
		transbtn.setBounds((int) (WIDTH) - 200, 40, 100, 25);
		panel.add(transbtn);

		panel.add(list);

		JLabel label = new JLabel("\uC8FC\uBB38\uCC3D");
		label.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 20));
		label.setBounds(20, 40, 60, 25);
		panel.add(label);
	}

	class MyActionListener implements ActionListener {

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			order.add(((AbstractButton) e.getSource()).getText());
			dorder.add(((AbstractButton) e.getSource()).getText());
			list.setListData(dorder);
		}

	}
}