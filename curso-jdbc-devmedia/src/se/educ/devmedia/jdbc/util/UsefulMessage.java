package se.educ.devmedia.jdbc.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class UsefulMessage {
	
	// Component: is the place where message will be shown, like "ClassName.this"
	public static void addMsg(Component component, String msg){
		JOptionPane.showMessageDialog(component, msg);
	}

}
