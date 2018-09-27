package com.sist.Client;

import java.util.*;


import javax.swing.*;

import com.sist.main.ClientMainForm2;

import java.awt.*;

public class ControllPanel extends JPanel {
	public CardLayout card = new CardLayout();
	BookForm[] bf = new BookForm[10];
	BookMain bm = new BookMain(bf);
	ChatMain cm = new ChatMain();
	public DetailMain dm = new DetailMain();
	ClientMainForm2 cm2 = new ClientMainForm2();
	FindBookForm fbf = new FindBookForm();

	public ControllPanel() {
		setLayout(card);
		setBackground(new Color(253, 234, 219));
		bm.setOpaque(false);
		cm.setOpaque(false);
		dm.setOpaque(false);
		cm2.setOpaque(false);

		add("CLIENT", cm2);
		add("BOOKMAIN", bm);
		add("CHATMAIN", cm);
		add("DETAILMAIN", dm);
		add("FINDBOOK", fbf);

	}

	public BookMain[] getBookList() {
		BookMain[] b = new BookMain[10];
		return b;
	}
}
