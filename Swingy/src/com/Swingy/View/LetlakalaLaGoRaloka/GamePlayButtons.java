package com.Swingy.View.LetlakalaLaGoRaloka;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.Swingy.View.HeroInformation;

public class GamePlayButtons extends JPanel {
	
	/**serial version
	 * to mute a warning
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton _leftImg;
	private JButton _rightImg;
	private JButton _upImg;
	private JButton _downImg;
	private JButton _runButton;
	private JButton _fightButton;
	private BufferedImage _heroPicture;
	public GamePlayButtons() {
		
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		
		try {
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\up.jpg"));
			_upImg = new JButton(new ImageIcon(_heroPicture));
			_upImg.setToolTipText("up");
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\down.jpg"));
			_downImg = new JButton(new ImageIcon(_heroPicture));
			_downImg.setToolTipText("down");
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\left.jpg"));
			_leftImg = new JButton(new ImageIcon(_heroPicture));
			_leftImg.setToolTipText("left");
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\right.jpg"));
			_rightImg = new JButton(new ImageIcon(_heroPicture));
			_rightImg.setToolTipText("right");
			
			_runButton = new JButton("Run!");
			_runButton.setToolTipText("run");
			_fightButton = new JButton("Fight!");
			_fightButton.setToolTipText("fight");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Border innerBorder = BorderFactory.createTitledBorder("Game Controls");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gridCons = new GridBagConstraints();
		
		//first row
		gridCons.gridx = 1;
		gridCons.weightx = 1;
		gridCons.weighty = 0.1;
		gridCons.gridy = 0;
		gridCons.fill = GridBagConstraints.NONE;
		
		gridCons.anchor = GridBagConstraints.LINE_END;
		gridCons.insets = new Insets(0,0,0,5);
		add(_upImg, gridCons);
		
		gridCons.gridx = 0;
		gridCons.gridy = 1;
		
		gridCons.anchor = GridBagConstraints.LINE_START;
		gridCons.insets = new Insets(0,0,0,0);
		add(_leftImg, gridCons);
		
		//second row
		gridCons.gridy = 1;
		gridCons.gridx = 2;
		gridCons.weightx = 1;
		gridCons.weighty = 0.2;
		
		gridCons.insets = gridCons.insets = new Insets(0,0,0,5);
		gridCons.anchor = GridBagConstraints.LINE_END;
		add(_rightImg, gridCons);
		
		//third row
		gridCons.gridy = 2;
		gridCons.gridx = 1;
		gridCons.weightx = 1;
		gridCons.weighty = 0.2;
		
		gridCons.insets = gridCons.insets = new Insets(0,0,0,5);
		gridCons.anchor = GridBagConstraints.LINE_END;
		add(_downImg, gridCons);
		
		//fourth row
		gridCons.gridy = 3;
		gridCons.gridx = 0;
		
		gridCons.insets = gridCons.insets = new Insets(0,0,0,5);
		gridCons.anchor = GridBagConstraints.LINE_END;
		add(_runButton, gridCons);
		
		gridCons.gridy = 3;
		gridCons.gridx = 2;
		
		gridCons.insets = gridCons.insets = new Insets(0,0,0,5);
		gridCons.anchor = GridBagConstraints.LINE_END;
		add(_fightButton, gridCons);

	}
	
	public void setHeroInfoListener(HeroInformation listener)
	{
	}
	
	public JButton get_leftImg() {
		return _leftImg;
	}

	public void set_leftImg(JButton leftImg) {
		_leftImg = leftImg;
	}

	public JButton get_rightImg() {
		return _rightImg;
	}

	public void set_rightImg(JButton rightImg) {
		_rightImg = rightImg;
	}

	public JButton get_upImg() {
		return _upImg;
	}

	public void set_upImg(JButton upImg) {
		_upImg = upImg;
	}

	public JButton get_downImg() {
		return _downImg;
	}

	public void set_downImg(JButton downImg) {
		_downImg = downImg;
	}

	public JButton get_runButton() {
		return _runButton;
	}

	public void set_runButton(JButton runButton) {
		_runButton = runButton;
	}

	public JButton get_fightButton() {
		return _fightButton;
	}

	public void set_fightButton(JButton fightButton) {
		_fightButton = fightButton;
	}

}
