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
	void test1() throws StackUnderflowException, IncorrectFormatException {
		engine.buttonPressed("5");
		engine.buttonPressed("+");
		engine.buttonPressed("5");
		engine.equals(10);
		assertEquals("10.0", engine.getDisplayString());
	}
	
	@Test 
	void test2() throws StackUnderflowException, IncorrectFormatException  {
		engine.buttonPressed("1");
		engine.buttonPressed("+");
		engine.buttonPressed("2");
		engine.buttonPressed("*");
		engine.buttonPressed("3");
		engine.equals(10);
		assertEquals("7.0", engine.getDisplayString());
	}
	
	@Test 
	void test3() throws StackUnderflowException, IncorrectFormatException  {
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
	void test4() throws StackUnderflowException, IncorrectFormatException  {
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
	void test5() throws StackUnderflowException, IncorrectFormatException  {
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
	void test6() throws StackUnderflowException, IncorrectFormatException  {
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
	void test7() throws StackUnderflowException, IncorrectFormatException  {
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
	void test8() throws StackUnderflowException, IncorrectFormatException  {
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
	void test9() throws StackUnderflowException, IncorrectFormatException  {
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
//		engine.buttonPressed("(");
//		engine.buttonPressed("1");
//		engine.buttonPressed("+");
//		engine.buttonPressed("2");
//		engine.buttonPressed(")");
//		engine.buttonPressed("*");
//		engine.buttonPressed("(");
//		engine.buttonPressed("3");
//		engine.buttonPressed("+");
//		engine.buttonPressed("4");
//		engine.buttonPressed(")");
		engine.equals(10);
		assertEquals("21.0", engine.getDisplayString());
	}
}