package com.sist.main;

import java.awt.*;
import javax.swing.*;

public class MenuForm extends JPanel {
	JButton[] menu = new JButton[11];

	public MenuForm() {

		menu[0] = new JButton("소설");
		menu[1] = new JButton("한국소설");
		menu[2] = new JButton("영미소설");
		menu[3] = new JButton("일본 소설");
		menu[4] = new JButton("중국 소설");

		menu[5] = new JButton("여행");
		menu[6] = new JButton("국내여행");
		menu[7] = new JButton("해외여행");

		menu[8] = new JButton("다이어트/운동/스포츠");
		menu[9] = new JButton("스타일/뷰티");
		menu[10] = new JButton("건강");

		for (int i = 0; i < 11; i++) {

			add(menu[i]);
		}

	}

}
