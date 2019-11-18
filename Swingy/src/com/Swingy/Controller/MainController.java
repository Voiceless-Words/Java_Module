package com.Swingy.Controller;

import com.Swingy.View.Display;
import com.Swingy.View.MainFrame;
import com.Swingy.View.LetlakalaLaGae.LetlakalaLaGae;

public class MainController {

	public MainController(String[] args) {
		Display display;
		if (args.length == 1) {
			if(args[0].equals("console")) {
				
				
			} else if (args[0].equals("gui")) {
				display = new LetlakalaLaGae();
				MainFrame.getInstance().addPanel(display.getDisplay());
				MainFrame.getInstance().getFrame().setTitle(display.getTitle());
				display.homeButtonsListener((new LaGaeControls()));
			}
			else
				System.out.println("Please Pass gui or console");
		} else
			System.out.println("you need to pass in one argument");
	}
}