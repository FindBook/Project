package com.sist.Client;

import javax.swing.*; //J~
import javax.swing.border.Border;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.swing.*;
import com.sist.Manager.*;
import com.sist.dao.BookData;
import com.sist.dao.BookVO;

import java.net.*;//URL
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class DetailMain extends JPanel {

	JPanel p1;
	JLabel la1, la2, la3, la4, la5, la6;
	JLabel na1, na2, na3; // ¶óº§¸µ
	Image img;
	JEditorPane ta, nd, gt;
	// static int i;

	public void init(String title) {

		// int i=10;
		// public DetailMain() {

		BookData dao = new BookData();
		// ArrayList<MovieVO> s =dao.mList;
		BookVO vo = dao.movieDetail(title);

		la1 = new JLabel(vo.getTitle()); // Á¦¸ñ
		la2 = new JLabel(vo.getAuth() + " Àú"); // ÀÛ°¡
		la3 = new JLabel(vo.getPub() + " ÃâÆÇ"); // ÃâÆÇ»ç
		la4 = new JLabel(vo.getDate()); // ÃâÆÇÀÏ

		// ÆòÁ¡
		String star;
		switch (vo.getRate().charAt(0)) {
		case '5':
			star = "¡Ú¡Ú¡Ú¡Ú¡Ú";
			break;
		case '4':
			star = "¡Ú¡Ú¡Ú¡Ú¡Ù";
			break;
		case '3':
			star = "¡Ú¡Ú¡Ú¡Ù¡Ù";
			break;
		case '2':
			star = "¡Ú¡Ú¡Ù¡Ù¡Ù";
			break;
		case '1':
			star = "¡Ú¡Ù¡Ù¡Ù¡Ù";
			break;
		default:
			star = "¡Ù¡Ù¡Ù¡Ù¡Ù";
			break;
		}
		la5 = new JLabel(star + "  " + vo.getRate());

		na1 = new JLabel("Ã¥ ¼Ò°³"); // Ã¥¼Ò°³ ¶óº§
		na1.setForeground(new Color(26, 64, 121));
		na1.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		na1.setBounds(310, 410, 100, 20);
		// Ã¥¼Ò°³
		ta = new JEditorPane();
		ta.setEditable(false);
		HTMLEditorKit kit = new HTMLEditorKit();
		StyleSheet styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:¸¼Àº°íµñ; margin}");
		ta.setEditorKit(kit);
		Document doc = kit.createDefaultDocument();
		ta.setDocument(doc);
		String ss = vo.getDesc();
		ta.setText(ss);
		ta.setBackground(new Color(253, 234, 219));

		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setBorder(null);
		scrollPane.setBounds(300, 440, 1200, 250);
		add(scrollPane);

		na2 = new JLabel("¸ñÂ÷"); // ¸ñÂ÷ ¶óº§
		na2.setForeground(new Color(26, 64, 121));
		na2.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		na2.setBounds(315, 700, 100, 20);
		// ¸ñÂ÷
		nd = new JEditorPane();
		nd.setEditable(false);
		HTMLEditorKit kit2 = new HTMLEditorKit();
		StyleSheet styleSheet2 = kit2.getStyleSheet();
		styleSheet2.addRule("body {color:#000; font-family:¸¼Àº°íµñ; margin}");
		nd.setEditorKit(kit2);
		Document doc2 = kit.createDefaultDocument();
		nd.setDocument(doc2);
		String sss = vo.getIndex();
		nd.setText(sss);
		nd.setBackground(new Color(253, 234, 219));

		JScrollPane scrollPane2 = new JScrollPane(nd);
		scrollPane2.setBorder(null);
		scrollPane2.setBounds(300, 730, 600, 220);
		add(scrollPane2);

		na3 = new JLabel("¸®ºä"); // ¸®ºä ¶óº§
		na3.setForeground(new Color(188, 18, 1));
		na3.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		na3.setBounds(915, 700, 100, 20);
		// ¸®ºä
		gt = new JEditorPane();
		gt.setEditable(false);
		HTMLEditorKit kit3 = new HTMLEditorKit();
		StyleSheet styleSheet3 = kit3.getStyleSheet();
		styleSheet3.addRule("body {color:#000; font-family:¸¼Àº°íµñ; margin}");
		gt.setEditorKit(kit3);
		Document doc3 = kit.createDefaultDocument();
		gt.setDocument(doc3);
		String ssss = vo.getReview();
		gt.setText(ssss);
		gt.setBackground(new Color(253, 234, 219));

		JScrollPane scrollPane3 = new JScrollPane(gt);
		scrollPane3.setBorder(null);
		scrollPane3.setBounds(910, 730, 600, 220);
		add(scrollPane3);

		// Æ÷½ºÅÍ
		try {
			URL url = new URL("https:" + vo.getPoster());
			img = getImageSizeChange(new ImageIcon(url), 220, 320);

		} catch (Exception ex) {
		}

		la6 = new JLabel(new ImageIcon(img));

		la1.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
		la2.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		la3.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 15));
		la4.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 13));
		la5.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));

		// ¹èÄ¡
		setLayout(null);
		la1.setForeground(Color.BLACK); // Title
		la1.setBounds(600, 100, 500, 20);
		la2.setForeground(new Color(83, 86, 98)); // Auth
		la2.setBounds(603, 130, 500, 20);
		la3.setForeground(new Color(83, 86, 98)); // Pub
		la3.setBounds(603, 160, 500, 20);
		la4.setForeground(Color.BLACK); // Date
		la4.setBounds(603, 190, 500, 20);
		la5.setForeground(new Color(255, 88, 9)); // rate
		la5.setBounds(603, 220, 500, 20);
		la6.setBounds(330, 80, 220, 320); // poster

		add(la1);
		add(la2);
		add(la3);
		add(la4);
		add(la5);
		add(la6);
		add(na1);
		add(na2);
		add(na3);
	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}
}