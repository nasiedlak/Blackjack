import java.util.*;
public class Deck 
{
	private static String[][]deck;
	int removeRow;
	int removeColumn;
	private ArrayList<Integer>row;
	private ArrayList<Integer>column;
	
	public Deck()
	{
		deck = new String[4][13];
		row = new ArrayList();
		column = new ArrayList();
		row.add(100);
		column.add(100);
	}
	
	public void generateDeck() 
	{
		for(int i = 0; i < 4;i++) 
		{
			for(int j = 0;j < 13;j++) 
			{
				Card x = new Card(i,j);
				deck[i][j] = x.draw();
			}
		}
	}
	
	public void removeCard() 
	{
		boolean iterate = false;
		
		while(!iterate) 
		{
			removeRow = (int)(Math.random() * 4);
			removeColumn = (int)(Math.random() * 13);
			if(deck[removeRow][removeColumn] ==  null) 
			{
				continue;
			}
			else 
			{
				iterate = true;
			}	
		}
		deck[removeRow][removeColumn] = null;
	}
	
	public int getRow() 
	{
		return removeRow;
	}
	
	public int getColumn() 
	{
		return removeColumn;
	}
	
	public static void getDeck() 
	{
		for(int i = 0; i < 4;i++) 
		{
			for(int j = 0;j < 13;j++) 
			{
				System.out.print(deck[i][j] + " ");
			}
			System.out.println();
		}
	}
}
