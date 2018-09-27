package com.sist.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import com.sist.Client.ClientMainForm;
import com.sist.dao.BookData;
import com.sist.dao.BookVO;

public class MoviePanel extends JPanel implements MouseListener {
	JLabel la = new JLabel("");
	JLabel la2 = new JLabel();
	JLabel la3 = new JLabel();
	// JTextField tf3=new JTextField();
	int i;
	BookData dao = new BookData();
	ArrayList<BookVO> s = dao.mList;

	public MoviePanel() {
		setLayout(null);
		la.setBounds(10, 15, 200, 300);
		la2.setBounds(10, 320, 200, 15);
		la3.setBounds(10, 340, 200, 15);
		// tf3.setBounds(10, 285, 180, 30);
		add(la);
		add(la2);
		add(la3);
		// add(tf3);

		la.addMouseListener(this);
		setFocusable(true);
	}

	public void moviePrint(BookVO vo, int i) {
		this.i = i;
		try {
			URL url = new URL("https:" + vo.getPoster());
			Image img = getImageSizeChange(new ImageIcon(url), 200, 300);
			la.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}

		la2.setText(vo.getTitle());
		la3.setText(vo.getAuth());
		// tf3.setText(vo.getGenre());
	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == la) {
			ClientMainForm.commonMain.tp.cp.dm.removeAll();
			ClientMainForm.commonMain.tp.cp.card.show(ClientMainForm.commonMain.tp.cp, "DETAILMAIN");
			ClientMainForm.commonMain.tp.cp.dm.init(la2.getText());
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
