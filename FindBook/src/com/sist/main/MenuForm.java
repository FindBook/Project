package com.sist.main;

import java.awt.*;
import javax.swing.*;

public class MenuForm extends JPanel {
	JButton[] menu = new JButton[11];

	public MenuForm() {

		menu[0] = new JButton("�Ҽ�");
		menu[1] = new JButton("�ѱ��Ҽ�");
		menu[2] = new JButton("���̼Ҽ�");
		menu[3] = new JButton("�Ϻ� �Ҽ�");
		menu[4] = new JButton("�߱� �Ҽ�");

		menu[5] = new JButton("����");
		menu[6] = new JButton("��������");
		menu[7] = new JButton("�ؿܿ���");

		menu[8] = new JButton("���̾�Ʈ/�/������");
		menu[9] = new JButton("��Ÿ��/��Ƽ");
		menu[10] = new JButton("�ǰ�");

		for (int i = 0; i < 11; i++) {

			add(menu[i]);
		}

	}

}
