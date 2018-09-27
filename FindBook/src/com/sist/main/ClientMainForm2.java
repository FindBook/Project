package com.sist.main;

import java.awt.*;
import javax.swing.*;

import com.sist.dao.BookData;

import java.awt.event.*;

public class ClientMainForm2 extends JPanel implements ActionListener {
	// CardLayout card=new CardLayout();
	MenuForm mf = new MenuForm();
	ControlPanel cp = new ControlPanel();
	int curpage = 1;
	int totalpage = 0;
	String data = "ÀüÃ¼";

	public ClientMainForm2() {
		setLayout(null);
		setBackground(new Color(253, 234, 219));
		mf.setBounds(20, 10, 1865, 30);
		mf.setVisible(true);
		mf.setOpaque(false);

		cp.setBounds(100, 50, 1865, 900);
		cp.setOpaque(false);
		cp.setVisible(true);

		add(mf);
		add(cp);

		// setSize(1000,800);
		setVisible(true);
		/*
		 * mf.b1.addActionListener(this); mf.b2.addActionListener(this);
		 * mf.b3.addActionListener(this);
		 */
		for (int i = 0; i < 11; i++) {
			mf.menu[i].addActionListener(this);
		}

		cp.b1.addActionListener(this);
		cp.b2.addActionListener(this);

		cp.pageLa.setText(curpage + " page / " + BookData.totalpage + " pages");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new ClientMainForm2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// totalpage=cp.list.size()/10;
		/*
		 * if(e.getSource()==mf.b1) { curpage=1;
		 * 
		 * data=mf.b1.getText(); cp.movieList(data,curpage);
		 * cp.pageLa.setText(curpage+" page / "+MovieData.totalpage+" pages"); } else
		 * if(e.getSource()==mf.b2) { data=mf.b2.getText(); cp.movieList(data,curpage);
		 * cp.pageLa.setText(curpage+" page / "+MovieData.totalpage+" pages"); } else
		 * if(e.getSource()==mf.b3) { curpage=1; data=mf.b3.getText();
		 * cp.movieList(data,curpage);
		 * cp.pageLa.setText(curpage+" page / "+MovieData.totalpage+" pages"); }
		 */
		for (int i = 0; i < 11; i++) {
			if (e.getSource() == mf.menu[i]) {
				curpage = 1;

				data = mf.menu[i].getText();
				cp.movieList(data, curpage);
				cp.pageLa.setText(curpage + " page / " + BookData.totalpage + " pages");
			}

		}
		if (e.getSource() == cp.b1) {
			System.out.println("111");
			if (curpage > 1) {
				curpage--;
				cp.movieList(data, curpage);
				cp.pageLa.setText(curpage + " page / " + BookData.totalpage + " pages");
			}
		} else if (e.getSource() == cp.b2) {
			// System.out.println("222");
			// System.out.println("curpage:"+curpage+",totalpage:"+cp.totalpage);
			if (curpage < BookData.totalpage) {
				// System.out.println("curpage:"+curpage+",totalpage:"+cp.totalpage);
				curpage++;
				cp.movieList(data, curpage);
				cp.pageLa.setText(curpage + " page / " + BookData.totalpage + " pages");
			}
		}

	}

}
