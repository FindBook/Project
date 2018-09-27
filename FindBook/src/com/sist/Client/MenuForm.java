package com.sist.Client;

import javax.swing.*;

import java.awt.*; // Image

public class MenuForm extends JPanel {
	JPanel menu_panel;
	JButton[] menu = new JButton[12];

	ImageIcon[] btnimg = new ImageIcon[12];
	ImageIcon[] btnCimg = new ImageIcon[12];

	// String[] mainMenu={"나라 전체","한국","영미","일본","기타","여행 전체","국내","해외","라이프스타일
	// 전체","운동","뷰티","건강"};
	public MenuForm() {
		menu_panel = new JPanel();
		// setLayout(new GridLayout(1,12));
		for (int i = 0; i < 12; i++) {
			btnimg[i] = new ImageIcon("src//img//cate" + (i + 1) + ".png");
			btnCimg[i] = new ImageIcon("src//img//cate" + (i + 1) + "_1.png");

			menu[i] = new JButton(btnimg[i]);
			menu[i].setRolloverIcon(btnCimg[i]);
			menu[i].setBorderPainted(false);
			menu[i].setPreferredSize(new Dimension(155, 60));
			menu[i].setBorderPainted(false);
			menu[i].setFocusPainted(false);
			menu[i].setContentAreaFilled(false);
			menu[i].setOpaque(false);
			// add(menu[i]);
			menu_panel.add(menu[i]);
		}
		add(menu_panel);
		menu_panel.setVisible(true);
		menu_panel.setOpaque(false);
	}

}
