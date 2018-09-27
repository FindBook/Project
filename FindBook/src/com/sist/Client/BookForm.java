package com.sist.Client;
import javax.swing.*;
import com.sist.dao.BookData;
import com.sist.dao.BookVO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;

public class BookForm extends JPanel implements MouseListener {

	JPanel p1;
	JLabel label1, label2, label3, label4, label5, label6;

	Image img;
	int i;

	BookData dao = new BookData();
	ArrayList<BookVO> s = dao.mList;

	public BookForm(BookVO vo, int i) {
		this.i = i;
		System.out.println("BookForm:" + i);
		// DetailManager dm = new DetailManager();
		// ArrayList<DetailVO> list = dm.bookInfoData();
		// int i=0;
		// for(i=0;i<10;i++) {
		// 배치하기
		try {
			URL url = new URL("https:" + vo.getPoster());
			img = getImageSizeChange(new ImageIcon(url), 220, 320);

		} catch (Exception ex) {
		}

		label1 = new JLabel(new ImageIcon(img));
		label2 = new JLabel(vo.getTitle());
		label3 = new JLabel(vo.getAuth() + " 저");

		System.out.println("BookForm:" + i);
		// DetailManager dm = new DetailManager();
		// ArrayList<DetailVO> list = dm.bookInfoData();
		// int i=0;
		// for(i=0;i<10;i++) {
		// 배치하기
		try {
			URL url = new URL("https:" + s.get(i).getPoster());
			img = getImageSizeChange(new ImageIcon(url), 220, 320);

		} catch (Exception ex) {
		}

		label1 = new JLabel(new ImageIcon(img));
		label2 = new JLabel(s.get(i).getTitle());
		label3 = new JLabel(s.get(i).getAuth() + " 저");

		// }

		setLayout(null);

		label1.setBounds(10, 15, 200, 300);
		label2.setBounds(10, 320, 200, 15);
		label3.setBounds(10, 340, 200, 15);

		add(label1);
		add(label2);
		add(label3);
		label1.addMouseListener(this);
		setFocusable(true);

	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == label1) {
			ClientMainForm.commonMain.tp.cp.dm.removeAll();
			ClientMainForm.commonMain.tp.cp.card.show(ClientMainForm.commonMain.tp.cp, "DETAILMAIN");
			ClientMainForm.commonMain.tp.cp.dm.init(label2.getText());
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