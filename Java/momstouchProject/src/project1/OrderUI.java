package project1;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderUI extends JFrame {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final double WIDTH = screenSize.getWidth();
	public static final double HEIGHT = screenSize.getHeight();
	private JPanel contentPane;
	private JList list;
	private static Vector<String> order = new Vector();
	
	public void addVector(String str) {
		order.add(str);
	}
	public static Vector<String> getOrder() {
		return order;
	}
	public static void setOrder(Vector<String> order) {
		OrderUI.order = order;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public JList getList() {
		return list;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUI frame = new OrderUI();
					frame.setVisible(true);
					UDPreceiver ur = new UDPreceiver();
					ur.setOrder(frame);
					ur.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderUI() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,(int)WIDTH,(int)HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton completebtn = new JButton("¿Ï·á");
		completebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				order.remove(i);
				list.setListData(order);
			}
		});
		completebtn.setBackground(new Color(255, 235, 205));
		completebtn.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 15));
		completebtn.setBounds((int)WIDTH-300,100, 200, 50);
		completebtn.setBorderPainted(false);
		contentPane.add(completebtn);
		
		JLabel orderlabel = new JLabel("ÁÖ¹®");
		orderlabel.setIcon(new ImageIcon("logo_122x46.jpg"));
		orderlabel.setHorizontalAlignment(SwingConstants.LEFT);
		orderlabel.setBackground(new Color(147, 112, 219));
		orderlabel.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 30));
		orderlabel.setBounds(252, 10, 122, 46);
		contentPane.add(orderlabel);
		
		list = new JList(order);
		list.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.PLAIN, 20));
		list.setBackground(Color.WHITE);
		list.setBounds(30, 50, (int)(WIDTH)-60,(int)(HEIGHT)-100);
		contentPane.add(list);
	}
}
