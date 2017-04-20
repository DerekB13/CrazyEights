import java.util.ArrayList;

public class AI {
	private ArrayList<Card> hand;
	
	//constructor sets hand to point to the ArrayList<Card> in the Game class
	public AI(){
		hand = Game.getCompHand();
	}
	
	//Algorithm for the ai to take it's turn
	public boolean takeTurn(){
		String most;
		boolean canPlay = false, played = false;
		String e = "Clubs";//crazyEights.getEightSuit();
		
		while(!played){//loops until the computer plays a card.
			most = findMostValue();

			if(e != null){ //this if checks whether the last card that was played is an eight. 
				System.out.println("a");
				if(hasSuit(e) || hasEight()) //checks whether the computer has any cards that it can play.
					canPlay = true;
				
				if(canPlay){
					if(hasCard(most + " " + e)){ //checks if the computer can play its biggest set of same-valued cards. If it can, it plays them. 
						System.out.println("b");
						Game.getDeck().discard(hand.get(findCard(most + " " + e)));
						hand.remove(hand.get(findCard(most + " " + e)));
						played = true;
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(most);
						
					}else if(hasSuit(e)){ //tries to play a card with the suit that the player changed it to.
						System.out.println("c");
						Game.getDeck().discard(hand.get(findSuit(e)));
						hand.remove(hand.get(findSuit(e)));
						played = true;
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(getTopCard().getValue().toString());
						
					}else{ //plays an eight and then changes the suit to whichever suit the computer has the most of.
						System.out.println("d");
						Game.getDeck().discard(hand.get(findValue("8")));
						hand.remove(hand.get(findValue("8")));
						played = true;
						String mostSuit = findMostSuit();
						crazyEights.eightSuit = mostSuit;
						System.out.println("The Computer changes the suit to " + mostSuit + ".");
					}
				}else{ //draws a card.
					Game.drawToComputer();
					System.out.println("The Computer draws a card.");
				}
					
			}else{
				//checks whether the computer has any cards that it can play.
				if(hasSuit(getTopCard().getSuit().toString()) || hasValue(getTopCard().getValue().toString()) || hasEight())
					canPlay = true;
				
				if(canPlay){
					if(hasCard(most + " " + getTopCard().getSuit())){ //checks if the computer can play its biggest set of same-valued cards. If it can, it plays them. 
						System.out.println("e");
						Game.getDeck().discard(hand.get(findCard(most + " " + getTopCard().getSuit())));
						hand.remove(hand.get(findCard(most + " " + getTopCard().getSuit())));
						played = true;
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(most);
						
					}else if(hasValue(getTopCard().getValue().toString())){ //tries to play a card with the value of the top card.
						System.out.println("f");
						Game.getDeck().discard(hand.get(findValue(getTopCard().getValue().toString())));
						hand.remove(hand.get(findValue(getTopCard().getValue().toString())));
						played = true;
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(getTopCard().getValue().toString());
						
					}else if(hasSuit(getTopCard().getSuit().toString())){ //tries to play a card with the suit of the top card.
						System.out.println("g");
						Game.getDeck().discard(hand.get(findSuit(getTopCard().getSuit().toString())));
						hand.remove(hand.get(findSuit(getTopCard().getSuit().toString())));
						played = true;
						
						//checks whether the computer has any more same-valued cards to play.
						playMultiples(getTopCard().getValue().toString());
						
					}else{ //plays an eight and then changes the suit to whichever suit the computer has the most of.
						System.out.println("h");
						Game.getDeck().discard(hand.get(findValue("8")));
						hand.remove(hand.get(findValue("8")));
						played = true;
						String mostSuit = findMostSuit();
						crazyEights.eightSuit = mostSuit;
						System.out.println("The Computer changes the suit to " + mostSuit + ".");
					}
				}else{ //draws a card.
					Game.drawToComputer();
					System.out.println("The Computer draws a card.");
				}
			}
		}
		System.out.println("The Computer played the " + getTopCard() + ".");
		return hand.isEmpty();
	}
	
	//returns the cardValue that the Computer has the most of in String form. If there is a tie, returns the cardValue of the first occuring largest set.
	public String findMostValue(){
		int iHigh = 0;
		int iCurr = 0;
		String sHigh = null;
		String sCurr = null;
		for(Card c: hand){//loops through hand, comparing each card to the others in the hand. It counts how many of a value there are
			sCurr = "" + c.getValue();
			iCurr = 0;
			for(Card d: hand){
				if(c.getValue() == d.getValue())
					iCurr++;
			}
			if(iCurr > iHigh){ //if the current card has more occurrences than the current highest, the current card replaces the highest
				iHigh = iCurr;
				sHigh = sCurr;
			}
		}
		return sHigh;
	}
	
	//finds and then returns the name of the suit that the computer has the most of.
	public String findMostSuit(){
		int c = 0, s = 0, d = 0, h = 0, largest;
		for(Card card: hand){ //loops through hand counting how many of each suit there are.
			if(card.getSuit().equals("Clubs"))
				c++;
			else if(card.getSuit().equals("Spades"))
				s++;
			else if(card.getSuit().equals("Diamonds"))
				d++;
			else if(card.getSuit().equals("Hearts"))
				h++;
		}
		largest = Math.max(Math.max(c, s), Math.max(d, h)); //finds the suit with the most occurrences
		
		//returns the String related to the most occurring suit
		if(c == largest)
			return "Clubs";
		else if(s == largest)
			return "Spades";
		else if(d == largest)
			return "Diamonds";
		else
			return "Hearts";
	}
	
	//takes in a String and plays all of the cards of value "s"
	public void playMultiples(String s){
		while(hasValue(s)){
			Game.getDeck().discard(hand.get(findValue(s)));
			hand.remove(hand.get(findValue(s)));
		}
	}
	
	//retrieves and returns the top card of the discard pile
	public Card getTopCard(){
		return Game.getDeck().getTopUsed();
	}
	
	//returns true if the cpu's hand contains an eight
	public boolean hasEight(){
		for(Card c: hand){
			if(c.getValue().equals("8"))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card with a suit matching the inputted String
	public boolean hasSuit(String s){
		for(Card c: hand){
			if(c.getSuit().equals(s))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card with a value matching the inputted String
	public boolean hasValue(String s){
		for(Card c: hand){
			if(c.getValue().equals(s))
				return true;
		}
		return false;
	}
	
	//returns true if the cpu's hand contains a card that makes the following statement true: (c.toString().equals(s))
	public boolean hasCard(String s){
		for(Card c: hand){
			if(c.equals(s))
				return true;
		}
		return false;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose suit matches the inputted String
	public int findSuit(String s){
		for(Card c: hand){
			if(c.getSuit().equals(s))
				return hand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of a card whose value matches the inputted String
	public int findValue(String s){
		for(Card c: hand){
			if(c.getValue().equals(s))
				return hand.indexOf(c);
		}
		return -1;
	}
	
	//loops through the cpu's hand and returns the first index of the card that makes the following statement true: (c.toString().equals(s))
	public int findCard(String s){
		for(Card c: hand){
			if(c.equals(s))
				return hand.indexOf(c);
		}
		return -1;
	}
}
