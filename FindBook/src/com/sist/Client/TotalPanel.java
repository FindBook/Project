package com.sist.Client;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class TotalPanel extends JPanel {
	SearchBar sb = new SearchBar();
	// MenuForm menu = new MenuForm();

	public ControllPanel cp = new ControllPanel();

	public TotalPanel() {
		setLayout(null);
		setBackground(new Color(253, 234, 219));
		sb.setBounds(20, 20, 1865, 60);
		sb.setVisible(true);

		cp.setBounds(20, 85, 1865, 995);
		cp.setOpaque(false);
		cp.setVisible(true);

		/*
		 * menu.setBounds(20, 80, 1865, 60); menu.setOpaque(false);
		 * menu.setVisible(true);
		 */

		add(sb);
		// add(menu);
		add(cp);
	}
}
