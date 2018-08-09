package vendorwar;

/**
 * @author Vizirov, Gabriel
 * @date last modified July 19, 2018
 */

public class Match {

		private Fighter fighter1 = new Fighter();
		private Fighter fighter2 = new Fighter();
		private int roundNum;
		private int fighterTurn;
		private int matchWinner;	//1 is fighter1 and 2 is fighter2
		private int fighter1Health;
		private int fighter2Health;
		
		public Match() {		//default values
			this.fighter1 = null;
			this.fighter2 = null;
			this.roundNum = 1;
			this.fighterTurn = 1;
			this.matchWinner = 0;
			this.fighter1Health = 0;
			this.fighter2Health = 0;
		}
		
		public Match(Fighter fighter1, Fighter fighter2) {		//default values
			this.fighter1 = fighter1;
			this.fighter2 = fighter2;
			this.roundNum = 1;
			this.fighterTurn = 1;
			this.matchWinner = 0;
			this.fighter1Health = fighter1.getHealth();
			this.fighter2Health = fighter2.getHealth();
		}
		
		public void showFighters() {
			System.out.print(this.fighter1);
			System.out.println();
			System.out.println(this.fighter2);
		}
		
		public int chooseFirstAttacker() {	//with initiative system
			int initiative1 = this.fighter1.getInititative();
			int initiative2 = this.fighter2.getInititative();
			
			int min = 0;
			int max = 100;
			
			int fighter1Rand = 0;
			int fighter2Rand = 0;
			
			//keep selecting random numbers till 1 fighter has a larger number than the other
			//prevents having ties
			while (fighter1Rand == fighter2Rand) {
				
				//add the intiative to the random number given to get a higher probability
				fighter1Rand = (int)(Math.random() * ((max - min) + 1 ));
				System.out.println("\t" + this.fighter1.getVendor() + ": " + fighter1Rand + ", with initiative: " + (fighter1Rand + initiative1));
				fighter1Rand += initiative1;
				
				//make sure that 100 is the maximum limit of getting a random number even with the initiative
				/*
				if(fighter1Rand > 100)
				{
					fighter1Rand = 100;
				}
				*/
				
				fighter2Rand = (int)(Math.random() * ((max - min) + 1 ));
				System.out.println("\t" + this.fighter2.getVendor() + ": " + fighter2Rand + ", with initiative: " + (fighter2Rand + initiative2));
				fighter2Rand += initiative2;
				
				//make sure that 100 is the maximum limit of getting a random number even with the initiative
				/*
				if(fighter2Rand > 100)
				
				{
					fighter2Rand = 100;
				}
				*/
			}
			
			
			if (fighter1Rand > fighter2Rand) {
				System.out.println("\t" + this.fighter1.getVendor() 
					+ " is randomly selected to go first (" + fighter1Rand + " > " + fighter2Rand +")");
				return 1;
			}
			else {
				System.out.println("\t" + this.fighter2.getVendor() 
				+ " is randomly selected to go first (" + fighter2Rand + " > " + fighter1Rand +")");
				return 2;
			}
		}
		
		public void playRound() {
			
			//choose the player to go first
			this.fighterTurn = chooseFirstAttacker();
			//System.out.println(this.fighterTurn);
			
			System.out.println("\t<--initiative roll");
				
			//must keep resetting number of attacks after every round
			int fighter1AttackCount = this.fighter1.getAttacks();
			int fighter2AttackCount = this.fighter2.getAttacks();
			
			//used for min and max numbers for random number generator
			int min = 0;
			int max = 100;
			
			boolean endRound = false;
			
			//ROUND LOOP
			//keep attacking in the round till all attacks have been used or a fighters health is equal to or below 0 (zero)
			while ( !endRound ) {
					
				//if there are no attacks left, end the round loop
				if ( (fighter1AttackCount + fighter2AttackCount) <= 0 ) {
					endRound = true;
				}
				
				//if fighter 1 drops health to 0 or less, end the round loop
				else if ( this.fighter1Health <= 0 ) {
					this.matchWinner = 2;
					//System.out.println(this.fighter2.getVendor() + " wins!");
					endRound = true;
				}
				
				//if fighter 2 drops health to 0 or less, end the round loop
				else if ( this.fighter2Health <= 0 ) {
					this.matchWinner = 1;
					//System.out.println(this.fighter1.getVendor() + " wins!");
					endRound = true;
				}
				
				//otherwise, continue with the program
				else {
					
					//for testing
					//System.out.println(fighter1AttackCount + fighter2AttackCount);
					//System.out.println("///// fighter1AttackCount: " + fighter1AttackCount);
					//System.out.println("///// fighter2AttackCount: " + fighter2AttackCount);
					
					
					int fighter1DamageTotal = this.fighter1.getDamage();
					int fighter2DamageTotal = this.fighter2.getDamage();
					
					
					//if it is fighter 1 turn to attack, do this:
					if((fighterTurn == 1) && (fighter1AttackCount > 0)) {
						
						System.out.print("\t" + this.fighter1.getVendor() + "'s turn:");
						System.out.println( " (" + fighter1AttackCount + " Attacks Left)" );
						//get attack damage calculated with critical hit chance for fighter 1
						////////////////////
						//roll a random number for a critical hit	
						int critical1Rand = (int)(Math.random() * ((max - min) + 1 ));
						
						//if the random number is within the critical value, there will be a critical hit
						if (critical1Rand <= this.fighter1.getCritical())
						{
							System.out.println("\t\t" + this.fighter1.getVendor() + " has a critical attack (x2).");
							//multiply total damage by 2
							fighter1DamageTotal *= 2;
						}
						
						//get defence damage calculated with dodge chance for fighter 2
						////////////////////
						//roll a random number for a dodge
						int dodge2Rand = (int)(Math.random() * ((max - min) + 1 ));
						
						//if the random number is within the dodge value, there will be a dodge
						if (dodge2Rand <= this.fighter2.getDodge())
						{
							System.out.println("\t\t" + this.fighter2.getVendor() + " has dodged the attack.");
							//sets the damage of fighter 1 to 0 since fighter 2 dodged the attack
							fighter1DamageTotal = 0;
						}
						
						System.out.println("\t\t" + this.fighter1.getVendor() + " hits " + this.fighter2.getVendor() 
							+ " for " + fighter1DamageTotal + " damage (" + this.fighter2.getHealth() + " -> "
							+ (this.fighter2Health - fighter1DamageTotal) + ")");
					
						this.fighter2Health -= fighter1DamageTotal;
	
						//switch turns if available attacks left for other fighter
						if(fighter2AttackCount > 0)
						{
							fighterTurn = 2;
						}
						
						fighter1AttackCount--;
					}
					//if it is fighter 2 turn to attack, do this:
					else if((fighterTurn == 2) && (fighter2AttackCount > 0)) {
						
						System.out.print("\t" + this.fighter2.getVendor() + "'s turn:");
						System.out.println( " (" + fighter2AttackCount + " Attacks Left)" );
						
						//get attack damage calculated with critical hit chance for fighter 1
						////////////////////
						//roll a random number for a critical hit	
						int critical2Rand = (int)(Math.random() * ((max - min) + 1 ));
						
						//if the random number is within the critical value, there will be a critical hit
						if (critical2Rand <= this.fighter2.getCritical())
						{
							System.out.println("\t\t" + this.fighter2.getVendor() + " has a critical attack (x2).");
							//multiply total damage by 2
							fighter2DamageTotal *= 2;
						}
						
						//get defence damage calculated with dodge chance for fighter 2
						////////////////////
						//roll a random number for a dodge
						int dodge1Rand = (int)(Math.random() * ((max - min) + 1 ));
						
						//if the random number is within the dodge value, there will be a dodge
						if (dodge1Rand <= this.fighter1.getDodge())
						{
							System.out.println("\t\t" + this.fighter1.getVendor() + " has dodged the attack.");
							//sets the damage of fighter 1 to 0 since fighter 2 dodged the attack
							fighter2DamageTotal = 0;
						}
						
						System.out.println("\t\t" + this.fighter2.getVendor() + " hits " + this.fighter1.getVendor() 
						+ " for " + fighter2DamageTotal + " damage (" + this.fighter1.getHealth() + " -> "
						+ (this.fighter1Health - fighter2DamageTotal) + ")");
				
						this.fighter1Health -= fighter2DamageTotal;
						
						
						//switch turns if available attacks left for other fighter
						if(fighter1AttackCount > 0)
						{
							fighterTurn = 1;
						}
								
						fighter2AttackCount--;
						
					}
					//if the fighter can not attack do nothing
					else {
						//do nothing
					}
					
				}
			}
			
		}
		
		public void playMatch() {
			showFighters();
			
			//MATCH LOOP
			//keep playing rounds till one fighter wins
			boolean endMatch = false;
			
			//loop rounds till a someone loses
			while(!endMatch) {
			
				//if fighter 1 loses all health, stop the entire match
				if(this.fighter1Health <= 0) {
					this.matchWinner = 2;
					System.out.println("\t" + this.fighter2.getVendor() + " wins!");
					endMatch = true;
				}
				//if fighter 2 loses all health, stop the entire match
				else if (this.fighter2Health <= 0) {
					this.matchWinner = 1;
					System.out.println("\t" + this.fighter1.getVendor() + " wins!");
					endMatch = true;
				}
				//otherwise continue with new rounds
				else {
					System.out.println("Round " + roundNum +":");
					playRound();
					roundNum++;
				}
			}
		}
		
		//returns the winner of the match
		//returns 1 if winner is fighter 1
		//returns 2 if winner is fighter 2
		//returns 0 if there is no winner
		public int getMatchWinner() {
			return this.matchWinner;
		}
}
