package crazyeights.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class MenuButton extends Button{
	
	public MenuButton(String label){
		super(label);
		setMaxSize(120, 12);
		setPadding(new Insets(5));
	}
}
