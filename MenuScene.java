package crazyeights.gui;

import crazyeights.mainapp.Demo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuScene extends Scene{
	private static BorderPane BORDER_MENU = new BorderPane();
	private StackPane menuTitle = new StackPane();
	private VBox menuTop, menuLeft, menuRight, menuBottom;
	public static MenuButton BTN_NEW_GAME, BTN_RULES, BTN_QUIT;
	
	public MenuScene(){
		super(BORDER_MENU, 550, 400);
		menuTitle.setPadding(new Insets(0, 0, 75, 0));
		menuTitle.setStyle("-fx-background-color: forestgreen;");
		
		Text title = new Text("Rock, Paper, Scissors\nSimulator 2k17");
		title.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 36));
		title.setStyle("-fx-text-alignment: center; -fx-fill: white;");
		menuTitle.getChildren().add(title);
		
		
		menuTop = new VBox();
		menuTop.setPadding(new Insets(20));
		menuTop.setStyle("-fx-background-color: forestgreen;");
		
		menuLeft = new VBox();
		menuLeft.setPadding(new Insets(25));
		menuLeft.setStyle("-fx-background-color: forestgreen;");
		
		
		menuRight = new VBox();
		menuRight.setPadding(new Insets(25));
		menuRight.setStyle("-fx-background-color: forestgreen;");
		
		
		menuBottom = new VBox();
		menuBottom.setPadding(new Insets(35));
		menuBottom.setAlignment(Pos.CENTER);
		menuBottom.setStyle("-fx-background-color: forestgreen;");
		
		BTN_NEW_GAME = new MenuButton("New Game");
		BTN_NEW_GAME.setOnAction(Demo::menuButtonPress);
		
		BTN_RULES = new MenuButton("Rules");
		BTN_RULES.setOnAction(Demo::menuButtonPress);
		
		BTN_QUIT = new MenuButton("Quit");
		BTN_QUIT.setOnAction(Demo::menuButtonPress);
		
		menuBottom.getChildren().addAll(BTN_NEW_GAME, BTN_RULES, BTN_QUIT);
	
		BORDER_MENU.setCenter(menuTitle);
		BORDER_MENU.setTop(menuTop);
		BORDER_MENU.setLeft(menuLeft);
		BORDER_MENU.setRight(menuRight);
		BORDER_MENU.setBottom(menuBottom);

		System.out.println(menuTop.getStyleClass());
		System.out.println(menuLeft.getStyleClass());
		System.out.println(menuRight.getStyleClass());
		System.out.println(menuBottom.getStyleClass());
		System.out.println(menuTitle.getStyleClass());
	}
}
