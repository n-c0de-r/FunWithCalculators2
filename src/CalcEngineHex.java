/**
 * The main part of the calculator doing the calculations.
 * 
 * @author AlexJger and n-c0de-r
 * @version 27.05.2021
 */
public class CalcEngineHex extends CalcEngine { 
		
	@Override
    public void numberPressed(int number, int mode)
    {
        if(buildingDisplayValue) {
            // Incorporate this digit.
            displayValue = displayValue*mode + number;
        }
        else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
    }
	
}