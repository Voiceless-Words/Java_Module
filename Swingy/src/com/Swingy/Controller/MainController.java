package com.Swingy.Controller;

import com.Swingy.View.Display;
import com.Swingy.View.MainFrame;
import com.Swingy.View.Console.ConsoleLoop;
import com.Swingy.View.LetlakalaLaGae.LetlakalaLaGae;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MainController {

	public MainController(String[] args) {
		Display display;
		
		InputStreamReader readerI = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(readerI);
		try {
			System.out.println("Please enter the Platform you want to play on Gui or Console.");
			String platformPlay = bReader.readLine();
			if(platformPlay.toLowerCase().equals("console")) {
				
				new ConsoleLoop();
			} else if (platformPlay.toLowerCase().equals("gui")) {
				display = new LetlakalaLaGae();
				MainFrame.getInstance().addPanel(display.getDisplay());
				MainFrame.getInstance().getFrame().setTitle(display.getTitle());
				display.homeButtonsListener((new LaGaeControls()));
			}
			else {
				System.out.println("Please Pass gui or console");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}