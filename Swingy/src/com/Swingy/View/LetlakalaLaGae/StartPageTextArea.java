package com.Swingy.View.LetlakalaLaGae;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StartPageTextArea extends JPanel {
	
	/**serial version
	 * to mute warning
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea _textArea;
	
	public StartPageTextArea()
	{
		_textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		add(new JScrollPane(_textArea), BorderLayout.CENTER);
		_textArea.setEditable(false);
	}
	
	public void appendText(String text)
	{
		_textArea.setText(null);
		_textArea.append(text);
	}

}
