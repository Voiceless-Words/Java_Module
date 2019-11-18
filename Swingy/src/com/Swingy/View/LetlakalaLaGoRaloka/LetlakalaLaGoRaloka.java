package com.Swingy.View.LetlakalaLaGoRaloka;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.Swingy.View.Display;
import com.Swingy.View.HeroInformation;

public class LetlakalaLaGoRaloka extends JPanel implements Display {
	
	/**
	 * Default serial to mute the warning
	 */
	private static final long serialVersionUID = 1L;
	
	private String _title = "LetlakalaLaGoRaloka";
	private GamePlayButtons _gameButtons;
	private StatsDisplay _statsDisplay;
	private GamePageTextArea _gamePageTextArea;
	private JButton _up;
	private JButton _down;
	private JButton _left;
	private JButton _right;
	private JButton _fight;
	private JButton _run;
	private static HeroInformation _heroInformation;
	private static LetlakalaLaGoRaloka _letlakala;
	
	public LetlakalaLaGoRaloka() {
				
	}
	
	@Override
	public JPanel getDisplay() {
		setLayout(new BorderLayout());//setting the Layout
		
		_gameButtons = new GamePlayButtons();
		_statsDisplay = new StatsDisplay();
		_gamePageTextArea = new GamePageTextArea();
		
		_up = _gameButtons.get_upImg();
		_down = _gameButtons.get_downImg();
		_left = _gameButtons.get_leftImg();
		_right = _gameButtons.get_rightImg();
		_fight = _gameButtons.get_fightButton();
		_run = _gameButtons.get_runButton();	
		
		add(_statsDisplay, BorderLayout.NORTH);
		add(_gamePageTextArea, BorderLayout.CENTER);
		add(_gameButtons, BorderLayout.WEST);
		
		this.setHeroInfoListener(_heroInformation = new HeroInformation() {
			public void displayInformation(String text) {
				_gamePageTextArea.appendText(text);				
			}
		});
		
		return this;
	}
	
	public void setHeroInfoListener(HeroInformation heroInformation) {
		LetlakalaLaGoRaloka._heroInformation = heroInformation;
	}


	public String getTitle() {
		return _title;
	}

	public static LetlakalaLaGoRaloka getLetlakala() {
		if (_letlakala == null)
			_letlakala = new LetlakalaLaGoRaloka();
		return _letlakala;
	}
	
    public HeroInformation getHeroInfo() 
    {
    	return LetlakalaLaGoRaloka._heroInformation;
    }
    
	public void homeButtonsListener(ActionListener event) {
		//homeButtons implemented in LetlakalaLaGae
	}

	@Override
	public void gameControlButtonsListener(ActionListener event) {	
		
		_up.addActionListener(event);
		_down.addActionListener(event);
		_left.addActionListener(event);
		_right.addActionListener(event);
		_fight.addActionListener(event);
		_run.addActionListener(event);
	}



}
