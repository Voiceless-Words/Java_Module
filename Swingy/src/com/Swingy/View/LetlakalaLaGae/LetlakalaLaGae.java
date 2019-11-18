package com.Swingy.View.LetlakalaLaGae;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.Swingy.View.Display;
import com.Swingy.View.HeroInformation;
import com.Swingy.View.LetlakalaLaGae.GameSelectButtons;

public class LetlakalaLaGae extends JPanel implements Display {
	
	/**
	 * Default serial to mute the warning
	 */
	private static final long serialVersionUID = 1L;
	
	private String _title = "LetlakalaLaGae";
	private GameSelectButtons _gameButtons;
	private StartPageForm _startPageForm;
	private StartPageTextArea _startPageTextArea;
	private JButton _newButton;
	private JButton _continueButton;
	private JButton _warriorHero;
	private JButton _healerHero;
	private JButton _legendHero;
	private static HeroInformation _heroInformation;
	private static LetlakalaLaGae _letlakala;
	
	public LetlakalaLaGae() {
				
	}
	
	@Override
	public JPanel getDisplay() {
		setLayout(new BorderLayout());//setting the Layout
		
		_gameButtons = new GameSelectButtons();
		_startPageForm = new StartPageForm();
		_startPageTextArea = new StartPageTextArea();
		_newButton = GameSelectButtons.getNewButton();
		_continueButton = GameSelectButtons.getContinueButton();
		_warriorHero = _startPageForm.getHero1Img();
		_healerHero = _startPageForm.getHero2Img();
		_legendHero = _startPageForm.getHero3Img();
		
		this.setHeroInfoListener(_heroInformation = new HeroInformation() {
			public void displayInformation(String text) {
				_startPageTextArea.appendText(text);				
			}
		});
		
		add(_startPageForm, BorderLayout.WEST);
		add(_startPageTextArea, BorderLayout.CENTER);
		add(_gameButtons, BorderLayout.NORTH);
		
		return this;
	}
	

	public String getTitle() {
		return _title;
	}

	public void setHeroInfoListener(HeroInformation heroInformation) {
		LetlakalaLaGae._heroInformation = heroInformation;
	}
	

    public HeroInformation getHeroInfo() 
    {
    	return LetlakalaLaGae._heroInformation;
    }
		
	
	public void homeButtonsListener(ActionListener event) {
		_warriorHero.addActionListener(event);
		_healerHero.addActionListener(event);
		_legendHero.addActionListener(event);
		_newButton.addActionListener(event);
		_continueButton.addActionListener(event);
		
	}
	public static LetlakalaLaGae getLetlakala() {
		if (_letlakala == null)
			_letlakala = new LetlakalaLaGae();
		return _letlakala;
	}

	@Override
	public void gameControlButtonsListener(ActionListener event) {
		// TODO Auto-generated method stub
		
	}
}
