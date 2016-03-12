package com.randomizer.event;

import javax.swing.JCheckBox;

public class ActionPerformed {

	public ActionPerformed() {
		
	}
 	
	public void processCheckBox(JCheckBox j) {
		if (j.isSelected()) {
			System.out.println("J was sleected");
		}
	}
}
