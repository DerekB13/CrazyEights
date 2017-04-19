import java.util.ArrayList;
import java.util.Scanner;
public class crazyEights extends Game{
	private Scanner kb;
	public AI ai = new AI();
	public static String eightSuit = null;
	
    public crazyEights(){
        super();
        super.deal(5);
        kb = new Scanner(System.in);
    }
    
    public static String getEightSuit(){
    	return eightSuit;
    }
    public boolean winner(){
        return (playerHand.isEmpty() || compHand.isEmpty());
    }

    public boolean validPlay(Card m){
    	if(eightSuit != null){
    		if(m.getValue().equals(super.getDeck().getTopUsed().getValue()) || m.getSuit().equals(eightSuit) || m.getValue().equals("8"))
            	return true;
            return false;
    	}else{
            if(m.getValue().equals(super.getDeck().getTopUsed().getValue()) || m.getSuit().equals(super.getDeck().getTopUsed().getSuit()) || m.getValue().equals("8"))
            	return true;
            return false;
    	}
    }

    public boolean play(){
    	boolean hasPlayed = false;
        while(!hasPlayed){
            System.out.println("Select a card to play, or type draw to draw the card.\nYour current hand contains " + super.getHand());
            if(eightSuit != null){
            	System.out.println("The top card on the discard pile is an" + super.getTop().getValue() + " but the suit has been changed to " + eightSuit);
            }else
            	System.out.println("The top card on the discard pile is " + super.getTop());
            String s=kb.next().trim();
            if(s.equalsIgnoreCase("draw"))
                super.drawToPlayer();
            else{
                if(super.getHand().contains(s) && validPlay(playerHand.get(playerHand.indexOf(s)))){
                	if(s.charAt(0) == '8'){
                		eight();
                	}else
                		eightSuit = null;
                	super.getDeck().discard(super.getHand().get(super.getHand().indexOf(s)));
                }
            }
        }
        return playerHand.isEmpty();
    }

    public void eight(){
    	System.out.print("Select a suit (clubs, spades, diamonds, hearts): ");
    	String s = kb.next();
    	while (!s.equals("Clubs") || !s.equals("Spades") || !s.equals("Hearts") || !s.equals("Hiamonds")) {
    		System.out.print("Select a suit and be case sensitive(Clubs, Spades, Diamonds, Hearts): ");
    		s = kb.next();
    	}
    	eightSuit = s;
    }
    
    public boolean hasWon(ArrayList<Card> h){
    	return h.isEmpty();
    }
}