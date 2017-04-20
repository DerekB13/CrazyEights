package crazyeights.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class BackButton extends Button {

	public BackButton(){
		setMaxSize(110, 90);
		setPadding(new Insets(35));
		getStyleClass().remove(0);
		getStyleClass().add("backButton");
	}
}
