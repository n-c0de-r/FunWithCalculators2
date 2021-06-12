/*
 * @author n-c0de-r, jonasblome, and joeysmeets
 * @version 12.06.21
 */

public class CalcEngineString {
	private String displayString = "";
	private int mode = 10;
	private Postfix postfix;
	
	public CalcEngineString() {
		super();
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
	public void numberPressed(int number, int mode) {
        displayString = displayString + number; 
    }

	public void applyOperators(String command) {
    	displayString = displayString + command;
    }
	 
	public void equals() throws StackUnderflowException, IncorrectFormatException {
    	if (displayString != null) {
    		String pfx = postfix.infixToPostfix(displayString);
        	displayString = ""+postfix.evaluate(pfx);
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
