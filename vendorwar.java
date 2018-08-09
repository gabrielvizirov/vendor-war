/**
 *
 */
package vendorwar;

/**
 * @author Vizirov, Gabriel
 * @date last modified July 19, 2018
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendorwar {
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		/////////////////////////////////////////////////////////
		//read the csv file and store to a list of fighters
		/////////////////////////////////////////////////////////
		
		//create a list to store vendors
		List<Fighter> vendorList = new ArrayList<Fighter>();
		List<Integer> vendorWins = new ArrayList<Integer>();
		
		String csvFile = "vendor_fighters.csv";
		Scanner scanner = null;
		try {
			
			scanner = new Scanner(new File(csvFile));
			scanner.useDelimiter(",|\\n");	//separate csv by comma or endline
			
			//store the csv data into the list of fighter type objects
			//skip the first line since they are the headers for the table
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				
				String vendor = scanner.next();
				//System.out.println(vendor);
				int health = Integer.parseInt(scanner.next());
				//System.out.println(health);
				int damage = Integer.parseInt(scanner.next());
				//System.out.println(damage);
				int attacks = Integer.parseInt(scanner.next());
				//System.out.println(attacks);
				int dodge = Integer.parseInt(scanner.next());
				//System.out.println(dodge);
				int critical = Integer.parseInt(scanner.next());
				//System.out.println(critical);
				int initiative = Integer.parseInt(scanner.next());
				//System.out.println(initiative);
				
				Fighter fighter = new Fighter(vendor, health, damage, attacks, dodge, critical, initiative);
				
				
				//add the fighter to the vendorList
				vendorList.add(fighter);
				//each item for vendorList corresponds to vendorWins so vendorList[0] is connected to vendorWins[0], vendorList[1] is connected to vendorWins[1], etc
				vendorWins.add(0);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		//close input reading
		scanner.close();
		
		System.out.println("List of vendors:");
		System.out.println(vendorList);
		//System.out.println(vendorWins);
		
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("-------------------------------------------------------");
		
		
		////////////////////////////////////////////////////////////
		//	Play all the matches
		/////////////////////////////////////////////////////////
		
		//counter to tell what match number it is
		int matchNumberCount = 1;
		for (int i=0; i<=vendorList.size(); i++) {
			
			for (int j=(vendorList.size()-1); j>i;j--) {
				
				//print the match number
				System.out.println("Match " + matchNumberCount + ":\n");
				
				//play the match
				Match match = new Match(vendorList.get(i), vendorList.get(j));
				match.playMatch();
				
				//printing a line in between matches
				System.out.println("-------------------------------------------------------");
				int winnerOfMatch = match.getMatchWinner();
				int winsValue;
				if(winnerOfMatch == 1) {
					winsValue = vendorWins.get(i);
					vendorWins.set(i, (winsValue+1));
				}
				else
				{
					winsValue = vendorWins.get(j);
					vendorWins.set(j, (winsValue+1));
				}
				
				matchNumberCount++;
				
			}
			
		}
		
		////////////////////////////////////////////////////////////
		//	Print out the Winner
		/////////////////////////////////////////////////////////
		//System.out.println("List of vendors:");
		//System.out.println(vendorList);
		//System.out.println(vendorWins);
	
		//get the largest value in the vendorWins List which is the winner of the war
		int winner = 0;
		for (int i=1; i< vendorWins.size(); i++) {
			if (vendorWins.get(i) > vendorWins.get(winner) ) {
				winner = i;
			}
			/////////////////////////////////////////////////////////////////////////
			//	if there is a tie breaker have the players play 1 more match for win
			/////////////////////////////////////////////////////////////////////////
			else if (vendorWins.get(i) == vendorWins.get(winner) ) {
				//System.out.println("-------------------------------------------------------");
				//System.out.println("-------------------------------------------------------");
				//System.out.println("-------------------------------------------------------");
				//System.out.println("Tiebreaker between " + vendorList.get(i).getVendor() + " and " + vendorList.get(winner).getVendor());
				//System.out.println("Doing rematch game");
				Match tieMatch = new Match(vendorList.get(i), vendorList.get(winner));
				tieMatch.playMatch();
				System.out.println("-------------------------------------------------------");
				int tieWinner = tieMatch.getMatchWinner();
				if (tieWinner == 1) {
					winner = i;
				}
			}
		}
		
		
		System.out.println("Winner of the Vendor War: " + vendorList.get(winner).getVendor() + " with " + vendorWins.get(winner) + " wins!!!!" );
		
	}

}
