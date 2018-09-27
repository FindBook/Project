package com.sist.Client;

import javax.swing.*;

import com.sist.dao.BookData;
import com.sist.dao.BookVO;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class BookMain extends JPanel {

	Image img;

	BookVO vo = new BookVO();
	BookData dao = new BookData();
	ArrayList<BookVO> s = dao.mList;

	public BookMain(BookForm[] bl) {

		setLayout(null);
		int k = 0;
		try {
			URL url = new URL("https:" + s.get(k).getPoster());
			img = getImageSizeChange(new ImageIcon(url), 220, 320);

		} catch (Exception ex) {
		}

		for (int i = 0; i < 10; i++) {
			// for (int i = 0; i < s.size(); i++) {
			if (i == 5) {
				k = 0;
			}

			bl[i] = new BookForm(s.get(i), i);

			System.out.println("i=" + i);

			if (i >= 0 && i < 5)// i=0~i=4 0,1,2,3,4
			{
				bl[i].setBounds(310 + (k * 251), 50, 200, 380); // 10 211
				bl[i].setOpaque(false);

			} else {
				// i=5 ~ i=9 // 10 211
				bl[i].setBounds(310 + (k * 251), 455, 200, 380);
				bl[i].setOpaque(false);
			}

			add(bl[i]);
			k++;

		}
	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

}
