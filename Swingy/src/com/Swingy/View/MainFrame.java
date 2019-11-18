package com.Swingy.View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainFrame _mainFrame = null;
	
	private JFrame _frame;
	private JPanel _panel;
	
	
	public static MainFrame getInstance() 
    { 
        if (_mainFrame == null) 
        	_mainFrame = new MainFrame(); 
  
        return _mainFrame; 
    }
	
	public JFrame getFrame() {
		if (_frame == null) {
			this._frame = new JFrame();
		}
		
		_frame.setSize(800, 500);
		_frame.setVisible(true);
		return this._frame;
	};
	
	public void setFrameTitle(String title) {
		if (this._frame != null)
			this._frame.setTitle(title);
	}
	
	public void addPanel(JPanel panel) {
		this._panel = panel;
		if (this._frame == null)
			this._frame = new JFrame();
		this._frame.add(panel);
	}
	
	public JPanel getPanel() {
		return _panel;
	}
	
	public void hidePanel(JPanel panel) {
		panel.setVisible(false);
	}
	
	
}