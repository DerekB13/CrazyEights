package crazyeights.mainapp;
import crazyeights.gui.MenuScene;
import crazyeights.gui.RulesScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Demo extends Application{
	public static Stage STAGE;
	public static MenuScene MENU;
	public static RulesScene RULES;
	
	private String menuStyle = getClass().getResource("Menu.css").toExternalForm();
	
	@Override
	public void start(Stage primaryStage){
		STAGE = primaryStage;
		
		MENU = new MenuScene();
		MENU.getStylesheets().addAll(menuStyle);
		
//		game = new GameScene();
		
		RULES = new RulesScene();
		RULES.getStylesheets().addAll(menuStyle);
		
//		quit = new QuitScene();
		
		STAGE.setScene(MENU);
		STAGE.setTitle("Rock, Paper, Scissors Simulator 2017");
		STAGE.setResizable(false);
		STAGE.show();
	}
	
	public static void menuButtonPress(ActionEvent event){
/*		if(event.getSource() == btnNewGame){
			stage.setScene(game);
		}
*/		if(event.getSource() == RulesScene.BTN_BACK){
			STAGE.setScene(MENU);
		}
		if(event.getSource() == MenuScene.BTN_RULES){
			STAGE.setScene(RULES);
		}
/*		if(event.getSource() == btnQuit){
			stage.setScene(quit);
		}*/
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		crazyEights game = new crazyEights();
		
		Application.launch(args);
		
		System.out.println(game.getDeck().getUsed());
		System.out.println(game.getDeck().getOrigincards());
		game.getDeck().putFirstCard();
		System.out.println(game.getDeck().getTopUsed());
		game.play();
		System.out.println(game.getDeck().getOrigincards());
		
	}
}