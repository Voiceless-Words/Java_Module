package com.Swingy.Controller;

import javax.swing.SwingUtilities;

public class SwingyMain {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {	 			
				new MainController(args);				
			}
			
		});

	}

}
