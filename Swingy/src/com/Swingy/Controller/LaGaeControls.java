package com.Swingy.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import com.Swingy.Controller.Heros.HeroStart;
import com.Swingy.View.Display;
import com.Swingy.View.HeroInformation;
import com.Swingy.View.MainFrame;
import com.Swingy.View.LetlakalaLaGae.*;
import com.Swingy.View.LetlakalaLaGoRaloka.LetlakalaLaGoRaloka;

public class LaGaeControls implements ActionListener {

	private StartPageForm _heroButtons;
	private Display _display;
	private HeroInformation _heroInformation;
	private String _chosenOne;
	private static String _heroName;
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		_heroButtons = new StartPageForm();
		JButton clicked = (JButton)event.getSource();
		_heroInformation = LetlakalaLaGae.getLetlakala().getHeroInfo();
		
		if (GameSelectButtons.getNewButton().getToolTipText() == clicked.getToolTipText())
		{
			if (GameSelectButtons.getNameField().getText().equals("") || this._chosenOne == null) 
			{
				if (this._chosenOne == null)
				{
					JOptionPane.showMessageDialog(null,"You cannot play without a hero, can you? Do the right thing.");
				} else {
					JOptionPane.showMessageDialog(null,"Let your children name themselves and claim themselves as the new day for " + 
							"today  we are determined to be the channelers of these changing frequencies\r\n" + 
							"into songs, paintings, writings, dance, drama, photography, carpentry, " + 
							"crafts, love, and love. Meaning name yourself!!!");
				}
				
			} else {
				_heroName = GameSelectButtons.getNameField().getText();
				MainFrame.getInstance().hidePanel(MainFrame.getInstance().getPanel());
				_display = new LetlakalaLaGoRaloka();
				
				MainFrame.getInstance().addPanel(_display.getDisplay());
				MainFrame.getInstance().getFrame().setTitle(_display.getTitle());
				//_display.gameControlButtonsListener((new PapadiEGolo()));
				if (this._chosenOne == "Warrior")
				{
					_display.gameControlButtonsListener(new PapadiEGolo(HeroStart.newHero(_heroName, _chosenOne, 0, 75, 450, 95, 100)));
					
				} else if (this._chosenOne == "Healer")
				{
					_display.gameControlButtonsListener(new PapadiEGolo(HeroStart.newHero(_heroName, _chosenOne, 0, 65, 450, 50, 150)));
				} else
				{
					_display.gameControlButtonsListener(new PapadiEGolo(HeroStart.newHero(_heroName, _chosenOne, 0, 90, 450, 85, 100)));
				}
			}
		}
		else if (GameSelectButtons.getContinueButton().getToolTipText() == clicked.getToolTipText())
		{
			System.out.printf("Continue Game");
		}		
		else if(_heroButtons.getHero1Img().getToolTipText() == clicked.getToolTipText()) {
			if (_heroInformation != null)
			{
				this._chosenOne = "Warrior";
				_heroInformation.displayInformation("Hero Class Type: Warrior\n"
						+ "Hero Attack: 75\nHero Defense: 95\nHero Health Points: 100\n"
						+ "Hero Experience: 85");
			}
		}
		else if (_heroButtons.getHero2Img().getToolTipText() == clicked.getToolTipText()) {
			if (_heroInformation != null)
			{
				this._chosenOne = "Healer";
				_heroInformation.displayInformation("Hero Class Type: Healer\n"
						+ "Hero Attack: 65\nHero Defense: 50\nHero Health Points: 150\n"
						+ "Hero Experience: 65");
			}
		}
		else if (_heroButtons.getHero3Img().getToolTipText() == clicked.getToolTipText()) {
			if (_heroInformation != null)
			{
				this._chosenOne = "Legend";
				_heroInformation.displayInformation("Hero Class Type: Legend\n"
						+ "Hero Attack: 90\nHero Defense: 85\nHero Health Points: 100\n"
						+ "Hero Experience: 95");
			}
		} else {
			System.out.printf("nothing yet");
		}
	}
}
