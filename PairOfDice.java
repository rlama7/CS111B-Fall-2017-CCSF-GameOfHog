/**
 * PairOfDice.java  --program to create a class for game of Hog
 * @author    		  Ratna Lama
 * @version   		  1.0
 * @since     		  10/07/2017
*/

/**
* Instantiates die1 and die2 objects of Die Class
*/
public class PairOfDice {
	private Die die1;
	private Die die2;
	
	/**
	* Contructor intializes each objets die1 and die2 
	* of Die class to faceValue of 1
	*/
	public PairOfDice(){
		 die1 = new Die();
		 die2 = new Die();
	}	// end constructor PaifOfDice

	/**
	* @return sum of die1 and die2 after rolling them
	*/
	public int rollDice(){
		return (die1.roll() + die2.roll());
	}

	/**
	* @return the sum of die1 and die2
	*/
	public int sumDice(){
		return (die1.getFaceValue() + die2.getFaceValue());
	}

	/**
	* @return die1
	*/
	public int getDie1(){
		return die1.getFaceValue();	
	}

	/**
	* @return die2
	*/
	public int getDie2(){
		return die2.getFaceValue();
	}

	/**
	* @param die1Value the die1 to set
	*/
	public void setDie1(Die die1Value){
		die1 = die1Value;
	}

	/**
	* @param die2Value the die2 to set
	*/
	public void setDie2(Die die2Value){
		die2 = die2Value;
	}

	/**
	* @returns a one-line description of Die Class as a string
	*/
    public String toString(){
    	String sum = "Die1: "+ die1.getFaceValue() + "     " + "Die2: " + die2.getFaceValue();
      	return sum;
    }

}	// end class PairOfDice