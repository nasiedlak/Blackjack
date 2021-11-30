import java.util.*;
public class Player extends Deck
{
	private int totalPoints;
	private ArrayList<String>hand;
	
	public Player() 
	{
		totalPoints = 0;
		hand = new ArrayList<String>();
	}
	
	public void addACard(Card x, Player y) 
	{
		y.hand.add(x.draw());
	}

	public void resetHand(Player x) 
	{
		x.hand.clear();
	}
	public int getPoints(Player y) 
	{
		Card z = new Card(y.getRow(), y.getColumn());
		y.totalPoints += z.getValue();
		return y.totalPoints;
	}
	
	public int printPoints(Player y) 
	{
		return y.totalPoints;
	}
	
	public ArrayList<String> showHand(Player x) 
	{
		return x.hand;
	}
	
	public void resetTotal() 
	{
		totalPoints = 0;
	}	
}
