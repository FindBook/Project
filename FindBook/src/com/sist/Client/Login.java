package com.sist.Client;

import java.awt.*;
import javax.swing.*;

public class Login extends JPanel {
	public Image back;
	public JLabel la1, la2;
	public static JTextField tf;
	public JPasswordField pf;
	public JButton b1;

	public Login() {

		back = Toolkit.getDefaultToolkit().getImage("c:\\data\\mainpage.jpg");

		// ��ġ
		la1 = new JLabel("���̵�");
		la2 = new JLabel("��й�ȣ");

		tf = new JTextField();
		pf = new JPasswordField();

		b1 = new JButton("�α���");

		// ��ġ
		setLayout(null); // ��ġ�� ��������ʰ� ���� ��ġ
		la1.setForeground(new Color(6, 75, 136));
		// 800/2==> 400-20 ==> 380
		// 600/2 ==> 300-30 ==> 270
		la1.setFont(new Font("�����ٸ����", Font.BOLD, 12));
		la1.setBounds(1105, 500, 80, 30);
		la2.setForeground(new Color(6, 75, 136));
		la2.setFont(new Font("�����ٸ����", Font.BOLD, 12));
		la2.setBounds(1105, 540, 80, 30);

		tf.setBounds(1170, 500, 100, 30);
		tf.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		pf.setBounds(1170, 540, 100, 30);
		pf.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		JPanel p = new JPanel(); // ������Ʈ�� ��Ƽ� �Ѱ���� ��ġ���ִ°��� Panel
		p.setOpaque(false);
		p.add(b1);
		p.setBounds(1100, 580, 185, 35);

		add(la1);
		add(la2);
		add(tf);
		add(pf);
		add(p);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
}
