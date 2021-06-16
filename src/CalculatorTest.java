/*
 * @author n-c0de-r, jonasblome, and joeysmeets
 * @version 12.06.21
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    
    private CalcEngineString engine;
    	
	@BeforeEach
	void setUp() throws Exception {
    	
    	engine = new CalcEngineString();
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test 
	void test01() throws StackUnderflowException, IncorrectFormatException {
		engine.buttonPressed("5");
		engine.buttonPressed("+");
		engine.buttonPressed("5");
		engine.equals(10);
		assertEquals("10.0", engine.getDisplayString());
	}
	
	@Test 
	void test02() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.equals(10);
		assertEquals("7.0", engine.getDisplayString());
	}
	
	@Test 
	void test03() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("3");
		engine.equals(10);
		assertEquals("5.0", engine.getDisplayString());
	}
	
	@Test 
	void test04() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("(");
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed(")");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.equals(10);
		assertEquals("9.0", engine.getDisplayString());
	}
	
	@Test 
	void test05() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("(");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.buttonPressed(")");
		engine.equals(10);
		assertEquals("15.0", engine.getDisplayString());
	}
	
	@Test 
	void test06() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("(");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.buttonPressed(")");
		engine.equals(10);
		assertEquals("9.0", engine.getDisplayString());
	}
	
	@Test 
	void test07() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("(");
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed(")");
		engine.buttonPressed("*");
		engine.buttonPressed("(");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.buttonPressed(")");
		engine.equals(10);
		assertEquals("21.0", engine.getDisplayString());
	}
	
	@Test 
	void test08() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.equals(10);
		assertEquals("11.0", engine.getDisplayString());
	}
	
	@Test 
	void test09() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("3");
		engine.buttonPressed("*");
		engine.buttonPressed("4");
		engine.equals(10);
		assertEquals("14.0", engine.getDisplayString());
	}
	
	@Test 
	void test10() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("(");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("3");
		engine.buttonPressed(")");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.equals(10);
		assertEquals("9.0", engine.getDisplayString());
	}
	
	@Test 
	void test11() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.buttonPressed("+");
		engine.buttonPressed("5");
		engine.equals(10);
		assertEquals("15.0", engine.getDisplayString());
	}
	// The following tests fail, indicating not correct calculated precedence
	// when same operators of high precedence follow each other!
	@Test 
	void test12() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("3");
		engine.buttonPressed("*");
		engine.buttonPressed("4");
		engine.buttonPressed("*");
		engine.buttonPressed("5");
		engine.equals(10); //Expected result 63, returns 75!
		assertEquals("63.0", engine.getDisplayString());
	}
	
	@Test 
	void test13() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("+");
		engine.buttonPressed("3");
		engine.buttonPressed("*");
		engine.buttonPressed("4");
		engine.buttonPressed("*");
		engine.buttonPressed("5");
		engine.buttonPressed("+");
		engine.buttonPressed("6");
		engine.buttonPressed("+");
		engine.buttonPressed("7");
		engine.equals(10); //Expected result 76, returns 88!
		assertEquals("76.0", engine.getDisplayString());
	}
	
	@Test 
	void test14() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("*");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.buttonPressed("+");
		engine.buttonPressed("4");
		engine.buttonPressed("+");
		engine.buttonPressed("5");
		engine.buttonPressed("*");
		engine.buttonPressed("6");
		engine.buttonPressed("*");
		engine.buttonPressed("7");
		engine.equals(10); //Expected result 72, returns 75!
		assertEquals("220.0", engine.getDisplayString());
	}
	
	@Test 
	void test15() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.buttonPressed("*");
		engine.buttonPressed("4");
		engine.buttonPressed("+");
		engine.buttonPressed("5");
		engine.buttonPressed("+");
		engine.buttonPressed("6");
		engine.buttonPressed("*");
		engine.buttonPressed("7");
		engine.equals(10); //Expected result 72, returns 75!
		assertEquals("72.0", engine.getDisplayString());
	}
}
