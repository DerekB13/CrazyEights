package crazyeights.gui;

import crazyeights.mainapp.Demo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RulesScene extends Scene {
	public Scene rules;
	public static BorderPane BORDER_RULES = new BorderPane();
	public VBox rulesLeft, rulesRight, rulesBottom, rulesCenter;
	public HBox rulesTop;
	public static BackButton BTN_BACK;
	
	public RulesScene(){
		super(BORDER_RULES, 550, 400);
		
		rulesCenter = new VBox();
		rulesCenter.setPadding(new Insets(10, 20, 10, 20));
		rulesCenter.setAlignment(Pos.TOP_CENTER);
		rulesCenter.setStyle("-fx-background-color: forestgreen;");
		
		Text title = new Text("Rules");
		title.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 36));
		title.setStyle("-fx-text-alignment: center; -fx-fill: white;");
		
		Text rules = new Text("\nYou have five cards in your hand to begin, and the goal is to \n"
							+ "get rid of all of them. Each turn, you must play a card onto \n"
							+ "the discard pile. This card must match either the number or the \n"
							+ "suit of the face up card. If you don't have any cards that you \n"
							+ "can play, you must draw cards from the deck until you pick up \n"
							+ "a card that can be played. If the deck runs out, the discard \n"
							+ "pile will be shuffled and you may continue drawing cards. All \n"
							+ "of the eights are wild. This means that you can play an eight \n"
							+ "on top of any card and when you do, you must declare which \n"
							+ "suit you would to change it to. If an eight is face up, you \n"
							+ "must either play a card of the declared suit or play another 8.");
		rules.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		rules.setStyle("-fx-text-alignment: justify; -fx-fill: white;");


		rulesCenter.getChildren().addAll(title, rules);
		
		
		rulesTop = new HBox();
		rulesTop.setPadding(new Insets(5));
		rulesTop.setStyle("-fx-background-color: forestgreen;");
		
		
		rulesLeft = new VBox();
		rulesLeft.setPadding(new Insets(0));
		rulesLeft.setAlignment(Pos.TOP_LEFT);
		rulesLeft.setStyle("-fx-background-color: forestgreen;");
		
		BTN_BACK = new BackButton();
		BTN_BACK.setOnAction(Demo::menuButtonPress);
		rulesLeft.getChildren().add(BTN_BACK);
		
		
		rulesRight = new VBox();
		rulesRight.setPadding(new Insets(35));
		rulesRight.setStyle("-fx-background-color: forestgreen;");
		
		
		rulesBottom = new VBox();
		rulesBottom.setPadding(new Insets(35));
		rulesBottom.setAlignment(Pos.CENTER);
		rulesBottom.setStyle("-fx-background-color: forestgreen;");
		
	
		
		BORDER_RULES.setCenter(rulesCenter);
		BORDER_RULES.setTop(rulesTop);
		BORDER_RULES.setLeft(rulesLeft);
		BORDER_RULES.setRight(rulesRight);
		BORDER_RULES.setBottom(rulesBottom);
	}
}
