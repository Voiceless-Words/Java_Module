package com.Swingy.View;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public interface Display {
	public JPanel getDisplay();
	public String getTitle();
	public void homeButtonsListener(ActionListener event);
	public void gameControlButtonsListener(ActionListener event);
}
