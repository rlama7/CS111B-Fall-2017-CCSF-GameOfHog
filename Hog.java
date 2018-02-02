/**
 * Hog.java  ---program to play a game called Hog
 * @author    	Ratna Lama
 * @version   	1.0
 * @since     	10/07/2017
*/

import java.util.Scanner;
public class Hog{

	/**
   * Implements the PairOfDice class to create 
   * a game of Hog where the Player1 (Computer) and Player2(Human)
   * competes in rolling a dice with a goal to reach 50.
   * Computer player is the first one to roll the dice.
   * If on any turn either player rolls 1  on either die, all 
   * points accumulated for that round(turn) are forfeited 
   * and control of the dice moves to the other player.
   * Player1(Computer) relinquishes the dice after accumulating 
   * 20 or more points in any given round.
   * The Player2(Human) may voluntarily turn over the dice
   * after each roll. 
   * Finally displays who won and ouputs total score for each 
   * players and the command line arguments.
   * @param arg A string array containing 
   * the command line arguments.
   * @exception Any exception
   * @return No return value.
   */
	public static void main(String[] args) {

		/**
		* Instantiates an object dice of PairOfDice class
		* Instantiates two objects die1 and die2 of Die class
		* Declares char type and integer type variables
		*/
		char answer = 'y';
		PairOfDice dice = new PairOfDice();
		Die die1 = new Die();
		Die die2 = new Die();
		int computerTotalScore = 0;
		int humanTotalScore = 0;
		int computerRoundTotal = 0;		// Scores for computer player for a round /turn
		int humanRoundTotal = 0;		// Scores for human player for a round/turn	
		boolean bust = true;			// Checks if either player is busted
		boolean gameWon = false;	 	// Checks if either player has won the game of Hog
	
		/**
		* Plays game of hog until either computer or human
		* scores reaches 50 or greater. Whoever scores 50 first
		* wins the game of hog.
		*/
		while ((computerTotalScore < 50) && (humanTotalScore < 50) && (!gameWon)){

		/** 
		* Displays player's score status at the beginning of the game of Hog
		*/		
		System.out.println();
		System.out.println("***************************************");
		System.out.println("Current Status: ");
		System.out.println("Computer: " + computerTotalScore);
		System.out.println("You: " + humanTotalScore);					
			
			/**
			* *******************************************************************
			*				    Computer Player's turn                          *
			* *******************************************************************
			*/

			/**
			* Game of Hog starts with computer player taking turn to roll dice.
			* Computer player relinquishes turn to human player if computerRoundTotal
			* is 20 or greater in any given round OR busted if either 
			* die rolls results in 1.
			*/
			while ((computerRoundTotal < 20) && (bust)) {				
				System.out.println();
				System.out.println("Computer's Turn: ");

				/**
				* Computer player begins game by rolling the dice
				* Rolls dice and outputs faceValue of die1 and die2
				*/
				dice.rollDice();						
				System.out.println(dice.toString());

				/**
				* Outputs busted if either die = 1
				*/				
				if((dice.getDie1() == 1) || (dice.getDie2() == 1)){
					System.out.println("Busted!!!");
					bust = false;						// If busted sets bust to false
					computerRoundTotal =0;				// Forfiets the computerRoundTotal score
				} else{
				computerRoundTotal += dice.sumDice();	// Updates computerRoundTotal
				int potentialComputerScore = computerRoundTotal + computerTotalScore;
			
				/** 
				* Displays computer round status
				*/
				System.out.println("Current Round: " + computerRoundTotal);
				System.out.println("Potential total: " + potentialComputerScore);
				System.out.println();

				/**
				* Checks if computer has won
				*/				
				if (potentialComputerScore >= 50){
					bust = false;
					gameWon = true;
					}
				}

			}	// end while loop. Ends computer player's turn

			/** 
			* Updates computerTotalScore
			*/
			bust = true;
			computerTotalScore += computerRoundTotal;
			computerRoundTotal = 0;

			/**
			* *******************************************************************
			*				    Human Player's turn                             *
			* *******************************************************************
			*/

			/**
			* Displays Updated Player's Status
			*/
			System.out.println("***************************************");
			System.out.println("Current Status: ");
			System.out.println("Computer: " + computerTotalScore);
			System.out.println("You: " + humanTotalScore);
						
			/** 
			* Start while loop for Human Player
			* Human player takes turn
			* Checks if humanRoundTotal <= 50 OR bust == true OR 
			* answer to continue is yes. Human player relinqueshes
			* the turn if either answer is NO OR either dice is 1
			* in which case human player will be busted.
			*/
			while ((humanTotalScore < 50) && (bust) && (answer =='y') && (!gameWon)) {			
				System.out.println();
				System.out.println("Human Player's Turn: ");
				
				/**
				* Human player begins game by rolling the dice
				* Rolls dice and outputs faceValue of die1 and die2
				*/
				dice.rollDice();
				System.out.println(dice.toString());

				/**
				* Outputs busted if either die = 1
				*/
				if((dice.getDie1() == 1) || (dice.getDie2() == 1)){
					System.out.println("Busted!!!");
					bust = false;							// If busted sets bust to false
					humanRoundTotal =0;						// Forfiet the humanRoundTotal score
				}else {
				humanRoundTotal += dice.sumDice();			// Updates humanRoundTotal
				int potentialHumanScore = humanRoundTotal + humanTotalScore;
			
				/** 
				* Displays round status for human player
				*/
				System.out.println("Current Round: " + humanRoundTotal);
				System.out.println("Potential total: " + potentialHumanScore);

				/**
				* Checks if Human has won the game of Hog
				*/
				if (potentialHumanScore >= 50){
					gameWon = true;
				}else{
					gameWon = false;

					/** 
					* Asks human if he/she wants to continue to plays
					*/
					Scanner scan = new Scanner(System.in);
					System.out.print("Take another turn (y/n)? ");
					answer = scan.next().charAt(0);
					}	// end else
				}	// end if
			}	// end while loop. Ends human player's turn

			/** 
			* Updates humanTotalScore
			*/
			bust = true;
			humanTotalScore += humanRoundTotal;
			humanRoundTotal = 0;
			answer = 'y';
					
		}	// end while. Ends game of Hog

		/** 
		* Checks who won the game. If computerTotalScore >= 50
		* declare computer player is the winner. If humanTotalScore >= 50
		* declares human player is the winner.
		*/
		if (computerTotalScore >= 50){
			System.out.println();
			System.out.println("The Computer has won!");
			System.out.println();
		}else if (humanTotalScore >= 50){
			System.out.println();
			System.out.println("The Human has won!");
			System.out.println();
		}	//end else if

		/**
		* Displays Final Results
		*/
		System.out.println("Final Results: ");
		System.out.println("Computer: " + computerTotalScore);
		System.out.println("You: " + humanTotalScore);
		
	}	// end main method

}	// end class Hog