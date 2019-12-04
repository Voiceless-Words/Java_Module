package com.Swingy.View.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface InstructionAnnotation{
	String[] value();	
}

public class ConsoleLoop {
	private InputStreamReader _readerI;
	private BufferedReader _bReader;
	private String _selectionMade;
	private String _heroName;
	
	public ConsoleLoop()
	{
		this._readerI = new InputStreamReader(System.in);
		this._bReader = new BufferedReader(_readerI);
		try {
			System.out.println("Make Your Selection.\n1. New Game\n2. Continue Game");
			
			this._selectionMade = _bReader.readLine();
			while (this._selectionMade.equals("1") == false && this._selectionMade.equals("2") == false)
			{
				System.out.println("Make Your Selection.\n1. New Game\n2. Continue Game");
				
				this._selectionMade = _bReader.readLine();
			}
			if (this._selectionMade.equals("1"))
			{
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
