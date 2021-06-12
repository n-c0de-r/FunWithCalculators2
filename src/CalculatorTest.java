import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private CalcEngine engine;
    private UserInterface gui;
	
    private CalcEngineHex engineHex;
    private UserInterfaceHex guiHex;
    
    private CalcEngineString engineString;
    private UserInterfaceString guiString;
    	
	@BeforeEach
	void setUp() throws Exception {
        
		engine = new CalcEngineHex();
		gui = new UserInterfaceHex(engine);
		
    	engineHex = new CalcEngineHex();
    	guiHex = new UserInterfaceHex(engineHex);
    	
//    	engineString = new CalcEngineString();
//    	guiString = new UserInterfaceString(engineString);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void addition() {
		engine.numberPressed(1);
		engine.plus();
		engine.numberPressed(4);
		engine.equals();
	  assertEquals(5, engine.displayValue);
	        
		engineHex.numberPressed(10, 16);
		engineHex.plus();
		engineHex.numberPressed(3, 16);
		engineHex.equals();
	  assertNotEquals(5, engineHex.displayValue);
	}

	@Test
	void subtraction() {
		engine.numberPressed(9);
		engine.minus();
		engine.numberPressed(3);
		engine.equals();
		assertNotEquals(12, engine.displayValue);
		
		engineHex.numberPressed(7, 16);
		engineHex.minus();
		engineHex.numberPressed(3, 16);
		engineHex.equals();
	  assertEquals(4, engineHex.displayValue);
	}

	@Test
	void multiplication() {
		engine.numberPressed(2);
		engine.multiply();
		engine.numberPressed(6);
		engine.equals();
	  assertEquals(12, engine.displayValue);
	    
		engineHex.numberPressed(6, 16);
		engineHex.multiply();
		engineHex.numberPressed(5, 16);
		engineHex.equals();
	  assertEquals(30, engineHex.displayValue);
	}

	@Test
	void division() {
		engine.numberPressed(9);
		engine.divide();
		engine.numberPressed(3);
		engine.equals();
		assertNotEquals(5, engine.displayValue);
			
		engineHex.numberPressed(10, 16);
		engineHex.divide();
		engineHex.numberPressed(3, 16);
		engineHex.equals();
		assertNotEquals(5, engineHex.displayValue);
	}
	
	@Test
	void modulation() {
		engine.numberPressed(4);
		engine.modulo();
		engine.numberPressed(2);
		engine.equals();
	  assertEquals(0, engine.displayValue);
	    
		engineHex.numberPressed(7, 16);
		engineHex.modulo();
		engineHex.numberPressed(6, 16);
		engineHex.equals();
	  assertEquals(1, engineHex.displayValue);
	}
}