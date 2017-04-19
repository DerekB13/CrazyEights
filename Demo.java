
public class Demo {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		crazyEights game = new crazyEights();
		
		game.getDeck().setTopUsed(game.getDeck().getOrigincards().get(0));
		System.out.println(game.getCompHand());
		System.out.println(game.ai.takeTurn());
		System.out.println(game.getCompHand());
		game.eight();
	}
}
