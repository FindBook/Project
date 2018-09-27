package com.sist.main;

import javax.swing.*;

import com.sist.dao.BookData;
import com.sist.dao.BookVO;

import java.awt.*;
import java.util.*;

public class ControlPanel extends JPanel {
	ArrayList<BookVO> list = new ArrayList<BookVO>();
	MoviePanel[] mp = new MoviePanel[10];
	JButton b1 = new JButton("이전");
	JButton b2 = new JButton("다음");
	int totalpage = 0;
	JLabel pageLa = new JLabel("0 page / 0 pages");

	public ControlPanel() {
		setLayout(null);
		for (int i = 0; i < 5; i++) {
			mp[i] = new MoviePanel();
			mp[i].setBounds(310 + (i * 251), 0, 200, 380);
			add(mp[i]);
			mp[i].setOpaque(false);
		}
		for (int i = 0; i < 5; i++) {
			mp[i + 5] = new MoviePanel();
			mp[i + 5].setBounds(310 + (i * 251), 400, 200, 380);
			add(mp[i + 5]);
			mp[i + 5].setOpaque(false);
		}

		JPanel p = new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		p.setBounds(510, 780, 900, 35);
		add(p);
		p.setOpaque(false);
		movieList("전체", 1);

	}

	public void movieList(String cate, int page) {
		if (cate.equals("전체")) {
			list = BookData.movieAllData(page);
			// totalpage=list.size()/10;
		} else {
			list = BookData.movieGenreData(cate, page);
		}

		for (int i = 0; i < list.size(); i++) {
			mp[i].moviePrint(list.get(i), i);
			// totalpage=list.size()/10;
			// mp[i].validate();
		}
		if (list.size() == 10) {
			for (int i = 0; i < 10; i++) {
				mp[i].setVisible(true);
			}
		}
		if (mp.length > list.size()) {
			for (int i = mp.length - 1; i > list.size(); i--) {
				mp[i].setVisible(false);
			}
		}
	}
}
