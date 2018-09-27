package com.sist.Client;

import javax.swing.*;
import java.awt.*; // Image

public class SearchBar extends JPanel {
	JButton logo, mp, ch, search;
	JTextField tf;
	JLabel lb;

	public SearchBar() {

		logo = new JButton(new ImageIcon("c:\\data\\logo.png")); // 로고
		tf = new JTextField();// 검색창
		search = new JButton(new ImageIcon("c:\\data\\search.png")); // 검색 버튼
		lb = new JLabel(""); // 사용자 이름
		lb.setForeground(Color.white);
		lb.setFont(new Font("돋음", Font.BOLD, 25));
		mp = new JButton("로그아웃");// 로그아웃 버튼
		ch = new JButton("채팅하기");// 채팅하기 버튼

		// 배치
		setLayout(null); // 직접 배치
		setBackground(new Color(26, 64, 121));
		logo.setBounds(10, 5, 250, 50);
		tf.setBounds(270, 10, 800, 40);
		search.setBounds(1050, 10, 100, 40);
		lb.setBounds(1250, 10, 200, 40);
		mp.setBounds(1430, 10, 200, 40);
		ch.setBounds(1650, 10, 200, 40);

		logo.setContentAreaFilled(false);// 내용영역 채우지 않기로 함
		logo.setFocusPainted(false);// 선택(focus)되었을 때 테두리 안생기게

		search.setContentAreaFilled(false);
		search.setFocusPainted(false);

		// 폰트변경
		// mp.setFont(new Font("나눔바른고딕",Font.BOLD,12));
		// ch.setFont(new Font("나눔바른고딕",Font.BOLD,12));

		add(logo);
		add(tf);
		add(search);
		add(lb);
		// add(mp);
		add(ch);
	}
}
