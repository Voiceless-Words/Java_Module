import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		//in case of multi-threading in the application
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {				
				new MainFrame();						
			}
			
		});

	}

}
