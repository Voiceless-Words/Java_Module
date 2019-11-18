package com.Swingy.View.LetlakalaLaGoRaloka;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatsDisplay extends JPanel{
	
	/**serial version ID 
	 * to mute the warning
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel _statsLabel;
	private static JTextField _statsField;
	
	public StatsDisplay()
	{
		setBorder(BorderFactory.createEtchedBorder());
		
		_statsLabel = new JLabel("Statistics");
		_statsField = new JTextField("", 50);
		_statsField.setEditable(false);
		_statsField.setBorder(null);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(_statsLabel);
		add(_statsField);
		
	}

	public static JTextField get_statsField() {
		return _statsField;
	}

	public void set_statsField(JTextField statsField) {
		_statsField = statsField;
	}
	
}
