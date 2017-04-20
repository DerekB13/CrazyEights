package crazyeights.mainapp;
import crazyeights.gui.MenuScene;
import crazyeights.gui.RulesScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class GameGUI extends Application{
	public static Stage STAGE;
	public static MenuScene MENU;
	public static RulesScene RULES;
//	public static GameScene GAME;
	
	private String menuStyle = getClass().getResource("Menu.css").toExternalForm();
	
	@Override
	public void start(Stage primaryStage){
		STAGE = primaryStage;
		
		MENU = new MenuScene();
		MENU.getStylesheets().addAll(menuStyle);
		
//		GAME = new GameScene();
//		GAME.getStylesheets().addAll(menuStyle);
		
		RULES = new RulesScene();
		RULES.getStylesheets().addAll(menuStyle);
		
		STAGE.setScene(MENU);
		STAGE.setTitle("Rock, Paper, Scissors Simulator 2017");
		STAGE.setResizable(false);
		STAGE.show();
	}
	
	public static void menuButtonPress(ActionEvent event){
/*		if(event.getSource() == btnNewGame){
			stage.setScene(GAME);
		}
*/		if(event.getSource() == RulesScene.BTN_BACK){
			STAGE.setScene(MENU);
		}
		if(event.getSource() == MenuScene.BTN_RULES){
			STAGE.setScene(RULES);
		}
		if(event.getSource() == btnQuit){
			keyboard.close();
			play = false;
			System.exit(0);
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner (System.in);
		boolean play = true, quit = false;
		
		while (play)
		{
			
			else if (option.equalsIgnoreCase("new game"))
			{
				crazyEights game = new crazyEights();
				game.getDeck().putFirstCard();
				game.getDeck().setTopUsed(game.getDeck().getOrigincards().get(0));
				quit = false;
				
				while (!game.winner() && !quit)
				{
					// a player's turn
					try{
						if(!game.play())
							game.ai.takeTurn(); // ai's turn
					}catch(Exception e){
						quit = true;
					}
					
					if (game.playerHand.isEmpty())
					{
						System.out.println("You win!\n");
					}
					if (game.compHand.isEmpty())
					{
						System.out.println("You lose...\n");
					}
				}
			}
		}
	}
}
