import java.util.*;
public class BlackjackMain 
{
	public static void main(String[]args) 
	{
		Scanner s = new Scanner (System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		System.out.println("********************Welcome to BlackJack********************\n");
		
		System.out.println("Would you like to play? y or n: ");
		String answer = s.nextLine();
		
		String random = "";
		dealer.generateDeck();
		
		while(!answer.equals("n")) 
		{
			dealer.dealToPlayer(player);
			dealer.dealToDealer(dealer);
			if(dealer.returnCount() >= 40)
				dealer.generateDeck();
			System.out.println("\nYour hand:\n" + player.showHand(player));
			System.out.println("\nDealer's hand:\n" + dealer.showHand(dealer));
			player.getPoints(player);
			dealer.getPoints(dealer);
			System.out.println("\nPress enter for next hand.");
			random = s.nextLine();
			
			System.out.println("\n************************************************************\n");
			
			dealer.dealToPlayer(player);
			dealer.dealToDealer(dealer);
			if(dealer.returnCount() >= 40)
				dealer.generateDeck();
			System.out.println("\nYour hand:\n" + player.showHand(player));
			System.out.println("\nDealer's hand:\n" + dealer.showHand(dealer));
			System.out.println("\nYour total points:\n" + player.getPoints(player));
			System.out.println("\nDealer's total points:\n" + dealer.getPoints(dealer));
			
			System.out.println("\nHit or stay? h or s: ");
			
			System.out.println("\n\n************************************************************\n");

			String choicePlayer = s.nextLine();
			
			boolean breakthis = false;
			while(!choicePlayer.equals("s")) 
			{
				dealer.dealToPlayer(player);
				if(dealer.returnCount() >= 40)
					dealer.generateDeck();
				System.out.println("\nYour hand:\n" + player.showHand(player));
				System.out.println("\nDealer's hand:\n" + dealer.showHand(dealer));
				
				System.out.println("\nYour total points:\n" + player.getPoints(player));
				System.out.println("\nDealer's total points:\n" + dealer.printPoints(dealer));
				
				if(player.printPoints(player) > 21) 
				{
					System.out.println("\nBust! Dealer Wins.");
					breakthis = true;
					break;
				}
				
				System.out.println("\nHit or stay? h or s: ");
				choicePlayer = s.nextLine();
				
				System.out.println("\n************************************************************\n");
			}
			
			if(breakthis) 
			{
				System.out.println("\n");
				dealer.showDeck();
				System.out.println("\n");
				System.out.println("\nWould you like to play again? y or n: ");
				answer = s.nextLine();
				player.resetTotal();
				dealer.resetTotal();
				player.resetHand(player);
				dealer.resetHand(dealer);
				continue;
			}
				
			boolean breakthis1 = false;
			String choiceDealer = "";
			if(dealer.printPoints(dealer) < 16)
				choiceDealer = "h";
			else
				choiceDealer = "s";
			while(!choiceDealer.equals("s")) 
			{
				dealer.dealToDealer(dealer);
				if(dealer.returnCount() >= 40)
					dealer.generateDeck();
				System.out.println("\nYour hand:\n" + player.showHand(player));
				System.out.println("\nDealer's hand:\n" + dealer.showHand(dealer));
				
				System.out.println("\nYour total points:\n" + player.printPoints(player));
				System.out.println("\nDealer's total points:\n" + dealer.getPoints(dealer));
				
				if(dealer.printPoints(dealer) > 21) 
				{
					System.out.println("\nDealer Bust! You Win.");
					breakthis1 = true;
					break;
				}
				
				if(dealer.printPoints(dealer) < 16)
					choiceDealer = "h";
				else
					choiceDealer = "s";
				
				System.out.println("\nPress enter for next hand. ");
				random = s.nextLine();
				
				System.out.println("\n************************************************************\n");
			}
			
			if(breakthis1) 
			{
				System.out.println("\n");
				dealer.showDeck();
				System.out.println("\n");
				System.out.println("\nWould you like to play again? y or n: ");
				answer = s.nextLine();
				player.resetTotal();
				dealer.resetTotal();
				player.resetHand(player);
				dealer.resetHand(dealer);
				continue;
			}
			
			if(choiceDealer.equals("s")) 
			{
				if(player.printPoints(player) > dealer.printPoints(dealer))
				{	
					System.out.println("\nYou win!");
				}
				else if(player.printPoints(player) < dealer.printPoints(dealer))
				{	
					System.out.println("\nDealer wins.");
				}
				else
				{	
					System.out.println("\nIt's a tie!");
				}
				
			}
			if(dealer.returnCount() >= 40)
				dealer.generateDeck();
			player.resetTotal();
			dealer.resetTotal();
			player.resetHand(player);
			dealer.resetHand(dealer);
			
			System.out.println("\n");
			dealer.showDeck();
			System.out.println("\n");
			System.out.println("Would you like to play again? y or n: ");
			answer = s.nextLine();	
		}		
	}
}
