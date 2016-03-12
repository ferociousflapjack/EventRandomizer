package randomizer.ui.com;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.EventQueue;

public class UIDriver extends JFrame {
	
	public UIDriver() {
		RandomizerWindow displayWindow = new RandomizerWindow();
		add(displayWindow);
		setSize(1000, 800);
		setResizable(true);
		
		setTitle("Event Randomizer");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				UIDriver runner = new UIDriver();
				runner.setVisible(true);

			}
		});
	}

}
