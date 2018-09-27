package com.sist.Client;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class FindBookForm extends JPanel {
	JTable table;
	DefaultTableModel model;

	public FindBookForm() {
		String[] col = { "", "제목", "저자" };
		Object[][] row = new Object[0][3];
		setLayout(null);
		model = new DefaultTableModel(row, col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}

		};
		table = new JTable(model);
		table.setRowHeight(30);
		JScrollPane js = new JScrollPane(table);
		setBackground(new Color(253, 234, 219));

		js.setBounds(100, 30, 800, 600);
		add(js);
	}
}
