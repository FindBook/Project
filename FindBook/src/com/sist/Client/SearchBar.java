package com.sist.Client;

import javax.swing.*;
import java.awt.*; // Image

public class SearchBar extends JPanel {
	JButton logo, mp, ch, search;
	JTextField tf;
	JLabel lb;

	public SearchBar() {

		logo = new JButton(new ImageIcon("c:\\data\\logo.png")); // �ΰ�
		tf = new JTextField();// �˻�â
		search = new JButton(new ImageIcon("c:\\data\\search.png")); // �˻� ��ư
		lb = new JLabel(""); // ����� �̸�
		lb.setForeground(Color.white);
		lb.setFont(new Font("����", Font.BOLD, 25));
		mp = new JButton("�α׾ƿ�");// �α׾ƿ� ��ư
		ch = new JButton("ä���ϱ�");// ä���ϱ� ��ư

		// ��ġ
		setLayout(null); // ���� ��ġ
		setBackground(new Color(26, 64, 121));
		logo.setBounds(10, 5, 250, 50);
		tf.setBounds(270, 10, 800, 40);
		search.setBounds(1050, 10, 100, 40);
		lb.setBounds(1250, 10, 200, 40);
		mp.setBounds(1430, 10, 200, 40);
		ch.setBounds(1650, 10, 200, 40);

		logo.setContentAreaFilled(false);// ���뿵�� ä���� �ʱ�� ��
		logo.setFocusPainted(false);// ����(focus)�Ǿ��� �� �׵θ� �Ȼ����

		search.setContentAreaFilled(false);
		search.setFocusPainted(false);

		// ��Ʈ����
		// mp.setFont(new Font("�����ٸ����",Font.BOLD,12));
		// ch.setFont(new Font("�����ٸ����",Font.BOLD,12));

		add(logo);
		add(tf);
		add(search);
		add(lb);
		// add(mp);
		add(ch);
	}
}
