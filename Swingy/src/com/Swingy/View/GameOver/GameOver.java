package com.Swingy.View.GameOver;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.Swingy.View.Display;

public class GameOver extends JPanel implements Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String _title = "Game Over!!!!";
	private GameOverTextArea _gameOverTextArea;
	private String _playerStats;
	
	public GameOver(String playerStats)
	{
		this._playerStats = playerStats;
	}
	@Override
	public JPanel getDisplay() {
		setLayout(new BorderLayout());//setting the Layout
		_gameOverTextArea = new GameOverTextArea();
		_gameOverTextArea.appendText(this._playerStats);
		add(_gameOverTextArea, BorderLayout.CENTER);

		return this;
	}

	@Override
	public String getTitle() {
		return this._title;
	}

	@Override
	public void homeButtonsListener(ActionListener event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameControlButtonsListener(ActionListener event) {
		// TODO Auto-generated method stub
		
	}

}
