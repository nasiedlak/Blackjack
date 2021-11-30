public class Card 
{
	private String[]differentSuits = {"\u2665", "\u2666", "\u2660", "\u2663"};
	private String[]differentValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private int suit;
	private int value;

	public Card(int s, int v) 
	{
		suit = s;
		value = v;
	}

	public int getSuit() 
	{
		return suit;
	}
	
	public int getValue() 
	{
		value += 1;
		if(value >= 10)
			return 10;
		else
			return value;
	}
	
	public String draw() 
	{
		return differentSuits[suit] + differentValues[value];			
	}
}
