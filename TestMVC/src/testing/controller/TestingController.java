package testing.controller;

import testing.view.TestingFrame;
import testing.model.MVCFactory;

public class TestingController 
{
	private TestingFrame appFrame;
	private MVCFactory appFactory;
	
	public MVCFactory getAppFactory()
	{
		return appFactory;
	}
	
	public TestingFrame getAppFrame()
	{
		return appFrame;	
	}
	
	public TestingController()
	{
		appFactory = new MVCFactory();
	}
	
	public void start()
	{
		appFrame = new TestingFrame(this);
	}

}
