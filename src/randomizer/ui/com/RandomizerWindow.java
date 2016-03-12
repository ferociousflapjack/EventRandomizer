package randomizer.ui.com;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomizerWindow extends JPanel {
	
	public RandomizerWindow() {
		setBackground(Color.BLACK);
		JButton b1 = new JButton("test");
		JButton b2 = new JButton("test2");
		JCheckBox testBox = new JCheckBox("testerino");
		testBox.setSelected(true);
		JTextField textField = new JTextField(20);
		add(testBox);
		add(textField);
		add(b1);
		add(b2);
	}
	

}
