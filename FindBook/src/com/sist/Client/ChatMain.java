package com.sist.Client;

import javax.swing.*;

import com.sist.Manager.ChatManager;
import com.sist.Manager.ChatVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

public class ChatMain extends JPanel implements MouseListener {

	JPanel p1, p2, p3, p4, p5, c1;
	JTextField tf;
	JLabel title1, title2, title3, title4, copy1, copy2;
	JButton btn1, btn2;
	JTextArea ta, ta2;
	JLabel la = new JLabel(""), la2;
	Image img1, img2;
	JScrollBar bar;

	public ChatMain() {

		ChatManager Cm = new ChatManager();
		ArrayList<ChatVO> list = Cm.ChatData();// 파싱한 데이터를 가져온다.
		int com1 = (int) (Math.random() * 30); // 0.0~0.99 ==> 0.0~2.99 ==> int변환 : 0~2
		int com2 = (int) (Math.random() * 30);

		p1 = new JPanel();
		p1.setOpaque(false);
		p1.setLayout(new BorderLayout(10, 10));
		p1.setBackground(Color.GRAY);

		p2 = new JPanel(); // 채팅창 패널
		p2.setOpaque(false);

		p3 = new JPanel(); // 입력창 패널
		p3.setOpaque(false);

		p4 = new JPanel();// 왼쪽 이미지 버튼 패널
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.setOpaque(false);

		p5 = new JPanel();// 오른쪽 사용자 리스트 패널
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		p5.setOpaque(false);

		c1 = new JPanel();// 제목 패널
		c1.setOpaque(false);
		title1 = new JLabel("채 팅");
		title1.setFont(new Font("", Font.BOLD, 30));
		c1.add(title1);

		ta = new JTextArea("", 30, 60); // 채팅화면
		ta.setFont(new Font("돋음", Font.BOLD, 15));
		ta.setEditable(false);
		JScrollPane js = new JScrollPane(ta);
		bar = js.getVerticalScrollBar();
		p2.setSize(10, 10);
		p2.add(js);

		tf = new JTextField("", 20);
		btn1 = new JButton("Enter");
		btn1.setFont(new Font("돋음", Font.BOLD, 15));

		p3.add(tf);
		p3.add(btn1);

		title2 = new JLabel("       오늘의 추천 책");
		title2.setFont(new Font("돋음", Font.BOLD, 30));
		p4.add(title2);

		try {
			URL url1 = new URL(list.get(com1).getPoster());
			img1 = getImageSizeChange(new ImageIcon(url1), 300, 300);

			URL url2 = new URL(list.get(com2).getPoster());
			img2 = getImageSizeChange(new ImageIcon(url2), 300, 300);

		} catch (Exception ex) {
		}

		copy1 = new JLabel(new ImageIcon(img1));
		copy1.setOpaque(false);
		p4.add(copy1);

		title3 = new JLabel("         광                 고");
		title3.setFont(new Font("돋음", Font.BOLD, 30));
		p4.add(title3);

		copy2 = new JLabel(new ImageIcon(img2));
		copy2.setOpaque(false);
		p4.add(copy2);

		title4 = new JLabel("사용자 리스트");
		title4.setFont(new Font("돋음", Font.BOLD, 30));

		ta2 = new JTextArea("", 1, 1); // 사용자 리스트
		ta2.setFont(new Font("돋음", Font.BOLD, 30));
		ta2.setEditable(false);
		la2 = new JLabel("★☆");
		la2.setForeground(new Color(128, 128, 128));

		la2.setFont(new Font("돋음", Font.BOLD, 100));
		la2.setSize(100, 100);
		btn2 = new JButton("   채팅 지우기   ");
		btn2.setFont(new Font("돋음", Font.BOLD, 25));

		p5.add(title4);
		p5.add(ta2);
		p5.add(new JScrollPane(ta2));
		p5.add(la2);
		p5.add(btn2);

		p1.add(c1, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.CENTER);
		p1.add(p3, BorderLayout.SOUTH);
		p1.add(p4, BorderLayout.WEST);
		p1.add(p5, BorderLayout.EAST);

		add(p1);

	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == copy1) {
			ClientMainForm.commonMain.tp.cp.dm.removeAll();
			ClientMainForm.commonMain.tp.cp.card.show(ClientMainForm.commonMain.tp.cp, "DETAILMAIN");
			// ClientMainForm.commonMain.tp.cp.dm.init(1);
			ClientMainForm.commonMain.tp.cp.dm.validate();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}