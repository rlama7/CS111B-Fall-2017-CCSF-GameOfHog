/**
 * Die.java  ---program to roll a die with faces showing 
 * values between 1 and 6
 * @author:		Lewis/Loftus
 * @author    	Ratna Lama
 * @version   	1.0
 * @since     	10/07/2017
*/

public class Die {
    private final int MAX = 6;  // maximum face value
    private int faceValue;  	// current value showing on the die

    /**
    * Constructor sets the initial face value
    */
    public Die() {
        faceValue = 1;
    }

    /**
    * Rolls the die and returns the result
    */
    public int roll() {
        faceValue = (int)(Math.random() * MAX) + 1;
        return faceValue;
    }

    /**
    * Sets faceValue 
    */
    public void setFaceValue(int value) {
        faceValue = value;
    }

    /**
    * Gets faceValue and allows read access
    */
	public int getFaceValue() {
        return faceValue;
    }

    /**
    * Returns a string representation of this die
    */
    public String toString() {
        String result = Integer.toString(faceValue);
        return result;
    }
}
