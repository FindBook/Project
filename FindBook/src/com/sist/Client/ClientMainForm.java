package com.sist.Client;

import javax.swing.*;
import com.sist.Server.Function;
import com.sist.dao.BookData;
import com.sist.dao.BookVO;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
import java.net.*;

/*
 * ClientMAinForm->	 Login -> TotalPanel -> SerchBar,MenuBar
 * 									     -> ControlPanel     -> BookMain  -> DtailMain
 * 															 -> ChatMain
 * 													
 */

public class ClientMainForm extends JFrame implements ActionListener, Runnable {
	// ClientMainForm2 cm = new ClientMainForm2();
	Login login = new Login();
	CardLayout card = new CardLayout();
	public TotalPanel tp = new TotalPanel();

	Socket s;// ���� ����
	BufferedReader in;// �������� ������ ����� �ޱ�
	OutputStream out; // ������ ��û�� ������
	public static ClientMainForm commonMain;

	public ClientMainForm() {

		commonMain = this;
		setLayout(card);
		// add("CM",cm);
		add("LOGIN", login);
		add("TP", tp);

		setSize(1920, 1080);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		login.b1.addActionListener(this);
		tp.sb.logo.addActionListener(this);
		tp.sb.mp.addActionListener(this);
		tp.sb.ch.addActionListener(this);

		tp.cp.cm.btn1.addActionListener(this);
		tp.cp.cm.tf.addActionListener(this);
		tp.cp.cm.btn2.addActionListener(this);

		// tp.cp.bm.
		tp.sb.tf.addActionListener(this);
		tp.sb.search.addActionListener(this);

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception ex) {
		} // ����ó��
		new ClientMainForm();
	}

	// ���� (����)
	public void connection(String id) {
		try {
			s = new Socket("211.238.142.52", 5050);

			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			out.write((Function.LOGIN + "|" + id + "\n").getBytes());
			// ��Ʈ��ũ => out.write ==> �ݵ�� �������� \n
		} catch (Exception ex) {
		}
		new Thread(this).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login.b1) { // �α��� ��ư Ŭ��
			String id = Login.tf.getText();
			tp.sb.lb.setText(id);
			connection(id);
			card.show(getContentPane(), "TP");
		} else if (e.getSource() == tp.sb.logo)// ��Ż�г�.��ġ��.�ΰ� Ŭ��
		{
			tp.cp.card.show(tp.cp, "CLIENT");
		} /*
			 * else if (e.getSource() == tp.sb.mp)// ��Ż�г�.��ġ��.�α׾ƿ� Ŭ�� {
			 * tp.cp.card.show(tp.cp, "BOOKMAIN"); }
			 */ else if (e.getSource() == tp.sb.ch)// ��Ż�г�.��ġ��.ä���ϱ� Ŭ��
		{
			tp.cp.card.show(tp.cp, "CHATMAIN");
		}
		// ã�� =================================
		else if (e.getSource() == tp.sb.search || e.getSource() == tp.sb.tf) {
			String title = tp.sb.tf.getText();
			if (title.length() < 1) {
				JOptionPane.showMessageDialog(this, "�˻�� �Է��ϼ���");
				tp.sb.tf.requestFocus();
				return;
			}
			ArrayList<BookVO> list = BookData.bookFindData(title);
			for (BookVO vo : list) {
				System.out.println(vo.getTitle());
				try {
					URL url = new URL("https:" + vo.getPoster());
					Image img = getImageSizeChange(new ImageIcon(url), 30, 30);
					Object[] obj = { new ImageIcon(img), vo.getTitle(), vo.getAuth() };

					tp.cp.fbf.model.addRow(obj);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			tp.cp.card.show(tp.cp, "FINDBOOK");

		}
		// ===============================================
		if (e.getSource() == tp.cp.cm.btn1 || e.getSource() == tp.cp.cm.tf) {// ä�ø��� ��ư1 Ŭ�� or ����
			// tp.cp.cm.ta.append(tp.cp.cm.tf.getText() + "\n");

			// ä�� ��û
			try {
				// �Է°� �б�
				String msg = tp.cp.cm.tf.getText();
				if (msg.length() < 1)
					return;
				out.write((Function.WAITCHAT + "|" + msg + "\n").getBytes());
				// ó�� ==> ����
				tp.cp.cm.tf.setText("");
				tp.cp.cm.tf.requestFocus();// focus
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == tp.cp.cm.btn2)// ä�ø��� ��ư2 Ŭ��
		{
			int a = JOptionPane.showConfirmDialog(this, "���� ����ðڽ��ϱ�?");
			if (a == 0) {
				tp.cp.cm.ta.setText("");
			}
		}

	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// 100|id|name
			while (true) {
				String msg = in.readLine();
				System.out.println("Client=>��û��:" + msg);

				StringTokenizer st = new StringTokenizer(msg, "|");
				int no = Integer.parseInt(st.nextToken());
				switch (no) {
				case Function.LOGIN:// login.jsp
				{
					tp.cp.cm.ta2.append(st.nextToken() + "\n");
				}
					break;
				case Function.MYLOG: {
					card.show(getContentPane(), "WR");
				}
					break;
				case Function.WAITCHAT: {
					tp.cp.cm.bar.setValue(tp.cp.cm.bar.getMaximum());

					tp.cp.cm.ta.append(st.nextToken() + "\n");
				}
					break;
				}
			}
		} catch (Exception ex) {
		}
	}
}
