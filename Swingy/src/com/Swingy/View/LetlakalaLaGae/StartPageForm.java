package com.Swingy.View.LetlakalaLaGae;
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

public class StartPageForm extends JPanel {
	
	/**serial version
	 * to mute a warning
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton _hero1Img;
	private JButton _hero2Img;
	private JButton _hero3Img;
	private BufferedImage _heroPicture;
	
	public StartPageForm() {
		
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		
		try {
			
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\hero1.jpg"));
			_hero1Img = new JButton(new ImageIcon(_heroPicture));
			_hero1Img.setToolTipText("hero1");
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\hero2.jpg"));
			_hero2Img = new JButton(new ImageIcon(_heroPicture));
			_hero2Img.setToolTipText("hero2");
			_heroPicture = ImageIO.read(new File("C:\\Users\\Voiceless Words\\eclipse-workspace\\Swingy\\src\\com\\Swingy\\View\\hero3.jpg"));
			_hero3Img = new JButton(new ImageIcon(_heroPicture));
			_hero3Img.setToolTipText("hero3");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Border innerBorder = BorderFactory.createTitledBorder("Select Hero");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gridCons = new GridBagConstraints();
		
		//first row
		gridCons.gridx = 0;
		gridCons.weightx = 1;
		gridCons.weighty = 0.1;
		gridCons.gridy = 0;
		gridCons.fill = GridBagConstraints.NONE;
		
		gridCons.anchor = GridBagConstraints.LINE_END;
		gridCons.insets = new Insets(0,0,0,5);
		add(_hero1Img, gridCons);
		
		gridCons.gridx = 1;
		gridCons.gridy = 0;
		
		gridCons.anchor = GridBagConstraints.LINE_START;
		gridCons.insets = new Insets(0,0,0,0);
		add(_hero2Img, gridCons);
		
		//second row
		gridCons.gridy = 1;
		gridCons.gridx = 0;
		gridCons.weightx = 1;
		gridCons.weighty = 0.2;
		
		gridCons.insets = gridCons.insets = new Insets(0,0,0,5);
		gridCons.anchor = GridBagConstraints.LINE_END;
		add(_hero3Img, gridCons);

	}

	public JButton getHero1Img() {
		return _hero1Img;
	}

	public JButton getHero2Img() {
		return _hero2Img;
	}

	public JButton getHero3Img() {
		return _hero3Img;
	}

	public void setHero1Img(JButton hero1Img) {
		this._hero1Img = hero1Img;
	}

	public void setHero2Img(JButton hero2Img) {
		this._hero2Img = hero2Img;
	}

	public void setHero3Img(JButton hero3Img) {
		this._hero3Img = hero3Img;
	}

}
