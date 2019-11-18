package com.Swingy.View.LetlakalaLaGae;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameSelectButtons extends JPanel{
	
	/**serial version ID 
	 * to mute the warning
	 */
	private static final long serialVersionUID = 1L;
	
	private static JButton _continueButton;
	private static JButton _newButton;
	private JLabel _nameLabel;
	private static JTextField _nameField = new JTextField(20);
	
	public GameSelectButtons()
	{
		setBorder(BorderFactory.createEtchedBorder());
		
		this._nameLabel = new JLabel("Enter Hero Name");
		_continueButton = new JButton("Continue");
		_continueButton.setToolTipText("Continue");
		_newButton = new JButton("New Game");
		_newButton.setToolTipText("New Game");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(_continueButton);
		this.add(_newButton);
		this.add(_nameLabel);
		this.add(_nameField);
		
	}

	public static JButton getContinueButton() {
		return _continueButton;
	}

	public void setContinueButton(JButton continueButton) {
		_continueButton = continueButton;
	}

	public static JButton getNewButton() {
		return _newButton;
	}

	public void setNewButton(JButton newButton) {
		_newButton = newButton;
	}

	public static JTextField getNameField() {
		return _nameField;
	}

	public void setNameField(JTextField nameField) {
		_nameField = nameField;
	}
	
}
