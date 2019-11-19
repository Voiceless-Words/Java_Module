package com.Swingy.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.Swingy.Controller.Heros.HeroDetails;
import com.Swingy.View.HeroInformation;
import com.Swingy.View.LetlakalaLaGoRaloka.GamePlayButtons;
import com.Swingy.View.LetlakalaLaGoRaloka.LetlakalaLaGoRaloka;
import com.Swingy.View.LetlakalaLaGoRaloka.StatsDisplay;

public class PapadiEGolo implements ActionListener {
	
	private GamePlayButtons _gamePlayButtons;
	private HeroInformation _heroInformation;
	private HeroDetails _detailsOfHero;
	private HashMap<String,Integer> _enemies;
	private List<Map<String, Integer>> _enemyArray;
	private int	_mapSize;
	private int _xCoordinate;
	private int _yCoordinate;
	private int _enemyHere;

	public PapadiEGolo(HeroDetails newHero) 
	{
		this._enemyHere = 0;
		this._detailsOfHero = newHero;
		this._gamePlayButtons = new GamePlayButtons();
		this._gamePlayButtons.get_fightButton().setEnabled(false);
		this._gamePlayButtons.get_runButton().setEnabled(false);
		this.DisplayStats();
		this.CreateMap(this._detailsOfHero.get_HeroLevel());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		JButton clicked;
		
		clicked = (JButton)e.getSource();
		_heroInformation = LetlakalaLaGoRaloka.getLetlakala().getHeroInfo();
	
		if(_gamePlayButtons.get_upImg().getToolTipText() == clicked.getToolTipText())
		{
			_heroInformation.displayInformation("Moving up");
			this.ChangeLocationOfHero("up");
		}else if (_gamePlayButtons.get_downImg().getToolTipText() == clicked.getToolTipText())
		{
			_heroInformation.displayInformation("Moving down");
			this.ChangeLocationOfHero("down");
			_gamePlayButtons.get_runButton().setEnabled(false);
		}else if (_gamePlayButtons.get_leftImg().getToolTipText() == clicked.getToolTipText())
		{
			_heroInformation.displayInformation("Moving left");
			this.ChangeLocationOfHero("left");
		}else if (_gamePlayButtons.get_rightImg().getToolTipText() == clicked.getToolTipText())
		{
			_heroInformation.displayInformation("Moving right");
			this.ChangeLocationOfHero("right");
		}else if (_gamePlayButtons.get_runButton().getToolTipText() == clicked.getToolTipText())
		{
			if (this._enemyHere == 0)
			{
				_heroInformation.displayInformation("What are you running away from??");
			} else {
				_heroInformation.displayInformation("Runaway? Can you make it?");
				this.RunAway();
				this._enemyHere = 0;
			}
		}else if (_gamePlayButtons.get_fightButton().getToolTipText() == clicked.getToolTipText())
		{
			if (this._enemyHere == 0)
			{
				_heroInformation.displayInformation("You are wasting power.");
			} else {
				_heroInformation.displayInformation("It's about to go down");
				this.FightEnemy();
				this._enemyHere = 0;
			}
		}else
		{
			System.out.println("Nothing happening yet");
		}
		
	}
	
	private void DisplayStats() 
	{
		StatsDisplay.get_statsField().setText("Name: "+_detailsOfHero.get_HeroName()+" Type: " +_detailsOfHero.get_HeroClass()+
				" Lv: "+_detailsOfHero.get_HeroLevel()+" Atck: "+_detailsOfHero.get_HeroAttack()+" Exp: "+_detailsOfHero.get_HeroExp()+
				" Dfns: "+_detailsOfHero.get_HeroDefense()+" HP: "+_detailsOfHero.get_HeroHP());
		
	}

	private void CreateMap(int level) 
	{
		
		this._mapSize = (level- 1)*5 + 10 - (level%2);
		this._xCoordinate = this._mapSize/2;
		this._yCoordinate = this._mapSize/2;
		this.CreateEnemies();
	}
	
	private void CreateEnemies() 
	{
		Random randomCoordinate = new Random();
		int j = randomCoordinate.nextInt(3);
		this._enemyArray = new ArrayList<Map<String, Integer>>(this._detailsOfHero.get_HeroLevel() + 1);
		for(int i = 0; i < this._detailsOfHero.get_HeroLevel() + 1; i++)
		{
			this._enemies = new HashMap<>(this._detailsOfHero.get_HeroLevel() + 1);
			this._enemies.put("Enemy" + Integer.toString(i + 1), i + 1);
			this._enemies.put("Enemy" + Integer.toString(i + 1) + "HP", 60);
			this._enemies.put("Enemy" + Integer.toString(i + 1) + "Defense", 25);
			this._enemies.put("Enemy" + Integer.toString(i + 1) + "Weapon", j);
			this._enemies.put("Enemy" + Integer.toString(i + 1)+"xCoordinate", randomCoordinate.nextInt(this._mapSize));
			this._enemies.put("Enemy" + Integer.toString(i + 1)+"yCoordinate", randomCoordinate.nextInt(this._mapSize));
			this._enemyArray.add(this._enemies);
		}
	}


	private void LevelingUp()
	{
		this.CheckEnemyEncounter();
		double xpPoints = (this._detailsOfHero.get_HeroLevel() + 1)*1000 + Math.sqrt(((this._detailsOfHero.get_HeroLevel() + 1) - 1)*450);
		
		if (xpPoints <= this._detailsOfHero.get_HeroExp())
		{
			this.CreateMap(this._detailsOfHero.get_HeroLevel() + 1);
			this._detailsOfHero.set_HeroLevel(this._detailsOfHero.get_HeroLevel() + 1);
			this._heroInformation.displayInformation("Congratulations you just leveled up!!!");
			JOptionPane.showMessageDialog(null, "You leveling up!!! Yeepy!!!");
			this.DisplayStats();
		}
	}
	
	private void ChangeLocationOfHero(String directionOfHero)
	{
		if (directionOfHero.equals("up"))
		{
			this._yCoordinate--;
			this._detailsOfHero.set_HeroExp(this._detailsOfHero.get_HeroExp() + 10);
			this.DisplayStats();
			if (this._yCoordinate < 0)
			{
				this.LevelingUp();
				this.CreateMap(this._detailsOfHero.get_HeroLevel());
				JOptionPane.showMessageDialog(null, "reach up, checking if you can move to the next level");
			}
			this.LevelingUp();
		}else if (directionOfHero.equals("down"))
		{
			this._yCoordinate++;
			this._detailsOfHero.set_HeroExp(this._detailsOfHero.get_HeroExp() + 10);
			this.DisplayStats();
			if (this._yCoordinate >= this._mapSize)
			{
				this.LevelingUp();
				this.CreateMap(this._detailsOfHero.get_HeroLevel());
				JOptionPane.showMessageDialog(null, "reach down, checking if you can move to the next level");
			}
			this.LevelingUp();
		}else if (directionOfHero.equals("left"))
		{
			this._xCoordinate--;
			this._detailsOfHero.set_HeroExp(this._detailsOfHero.get_HeroExp() + 10);
			this.DisplayStats();			
			if (this._xCoordinate < 0)
			{
				this.LevelingUp();
				this.CreateMap(this._detailsOfHero.get_HeroLevel());
				JOptionPane.showMessageDialog(null, "reach left, checking if you can move to the next level");
			}
			this.LevelingUp();
		}else if (directionOfHero.equals("right"))
		{
			this._xCoordinate++;
			this._detailsOfHero.set_HeroExp(this._detailsOfHero.get_HeroExp() + 10);
			this.DisplayStats();
			if (this._xCoordinate >= this._mapSize)
			{
				this.LevelingUp();
				this.CreateMap(this._detailsOfHero.get_HeroLevel());
				JOptionPane.showMessageDialog(null, "reach right, checking if you can move to the next level");
			}
			this.LevelingUp();
		}
	}
	
	private void CheckEnemyEncounter()
	{
		int i = 0;
		for(Map<String, Integer> map : this._enemyArray)
		{
			if (map.get("Enemy" + Integer.toString(i + 1)+"yCoordinate") == this._yCoordinate
				&& map.get("Enemy" + Integer.toString(i + 1)+"xCoordinate") == this._xCoordinate)
			{
				this._enemyHere = i + 1;	
				JOptionPane.showMessageDialog(null, "Enemy is here!!!");
			}
			i++;
		}
	}
	
	private void FightEnemy()
	{
		Random random = new Random();
		Map<String, Integer> map = this._enemyArray.get(_enemyHere - 1);
		int enemyHP = map.get("Enemy" + Integer.toString(this._enemyHere) + "HP");
		JOptionPane.showMessageDialog(null, enemyHP);
		while(enemyHP > 0)
		{
			int randomNum = random.nextInt(5);
			
			if (randomNum%2 == 0)
			{
				_heroInformation.displayInformation("Enemy Hits first.");
			} else {
				enemyHP -= 10;
				_heroInformation.displayInformation("Hero strikes again.");
			}
		}
	}
	
	private void RunAway()
	{
		Random random = new Random();
		int randomNum = random.nextInt(5);
		
		if (randomNum%2 == 0)
		{
			_heroInformation.displayInformation("You have to fight.");
			this.FightEnemy();
		} else {
			_heroInformation.displayInformation("That was a close call.");
		}
	}
}
