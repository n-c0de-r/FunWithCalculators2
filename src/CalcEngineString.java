/*
 * @author n-c0de-r, jonasblome, and joeysmeets
 * @version 12.06.21
 */

public class CalcEngineString {
	private String displayString = "";
	private Postfix postfix;
	
	public CalcEngineString() {
		postfix = new Postfix();
	}
	
	 /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayString()
    {
        return displayString; 
    }
	
	/**
     * Calculate the dec / hex output
     * @param number The number pressed on the calculator.
     */
	public void buttonPressed(String number) {
        displayString = displayString + number; 
    }
	 
	public void equals(int mode) throws StackUnderflowException, IncorrectFormatException {
    	if (displayString != null) {
    		String pfx = postfix.infixToPostfix(displayString);
    		if (mode == 10) {
    			displayString = ""+postfix.evaluate(pfx);
    		} else {
    			//Cast Doubles to integer, as hex cant calculate doubles anyways!
    			displayString = ""+ Integer.toHexString((int) (postfix.evaluate(pfx)));
    		}
    	}
    }
	
	/**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     */
    public void clear()
    {
        displayString = "";
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Better Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "D.J. Barnes & M. Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 2";
    }
}
