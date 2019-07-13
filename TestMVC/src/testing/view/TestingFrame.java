package testing.view;

import javax.swing.JFrame;
import testing.controller.TestingController;

public class TestingFrame extends JFrame {
	
	private TestingPanel basePanel;
	
	public TestingFrame(TestingController baseController)
	{
		basePanel = new TestingPanel(baseController);
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(700, 700);
		this.setVisible(true);
	}

}
