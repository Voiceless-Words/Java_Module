package com.Swingy.View.GameOver;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameOverTextArea extends JPanel{
	/**serial version
	 * to mute warning
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea _textArea;
	
	public GameOverTextArea()
	{
		_textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		add(new JScrollPane(_textArea), BorderLayout.CENTER);
		_textArea.setEditable(false);
	}
	
	public void appendText(String text)
	{
		_textArea.append(text);
		_textArea.append("\n");
	}

}
