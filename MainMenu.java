package crazyeights.mainapp;
import java.util.Scanner;
public class MainMenu{
	@SuppressWarnings("static-access")
	public static void main(String [] args){
		Scanner keyboard = new Scanner (System.in);
		boolean play = true;
		
		while (play){
			System.out.println("****CRAZY EIGHTS****");
			System.out.println("\nWhat would you like to do? Please enter:\nNew Game\nRules\nQuit");
			String option = keyboard.nextLine();
		
			if (option.equalsIgnoreCase("rules")){
				String rules = "You have five cards in your hand to begin, and the goal is to get rid of all of them."
						+ "\nEach turn, the you must play a card onto the discard pile. This card must match either the number or the suit of the face up card."
						+ "\nIf you don't have any cards that you can play, you must draw cards from the deck until you pick up a card that can be played."
						+ "\nIf the deck runs out, the discard pile will be shuffled and you may continue drawing cards."
						+ "\nAll of the eights are wild; You can play an eight on top of any card and when you do, you must declare"
						+ "\nwhich suit you would to change it to. If an eight is face up, you must either play a card of the declared suit or play another 8.";
				System.out.println(rules);
			}else if (option.equalsIgnoreCase("new game")){
				// ***I have still been working on this section***
				crazyEights game = new crazyEights();
				game.getDeck().putFirstCard();
				game.play();
			}else if (option.equalsIgnoreCase("quit")){
				System.out.println("Thank you for playing!");
				play = false;
				keyboard.close();
				System.exit(0);
			}else{
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
}