import java.util.*;
public class Dealer extends Player
{
	private int dealerTotal;
	private Deck deck;
	private int count;
	
	public void dealToPlayer(Player x) 
	{
		x.removeCard();
		count++;
		Card y = new Card(x.getRow(), x.getColumn());
		addACard(y, x);
	}
	
	public void dealToDealer(Player x) 
	{
		x.removeCard();
		count++;
		Card y = new Card(x.getRow(), x.getColumn());
		addACard(y, x);
	}
	
	public void showDeck() 
	{
		Deck.getDeck();
	}
	
	public int returnCount() 
	{
		return count;
	}
}
