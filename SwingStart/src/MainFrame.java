import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame()
	{
		super("Hello World");
		
		setLayout(new BorderLayout());//setting the Layout
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		toolbar.setStringListener(new StringListener() {

			public void textEmitted(String text) {
				textPanel.appendText(text);				
			}			
		});
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e)
			{
				String name = e.getName();
				String occupation = e.getOccupation();
				
				if (!name.isEmpty() && !occupation.isEmpty())
				{
					textPanel.appendText(name + ": " + occupation + "\n");
				}
			}
		});
		
		add(formPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		
		setSize(600, 500);//sets window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// terminates the program on exit
		setVisible(true);//show the window
	}
}
