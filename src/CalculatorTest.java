/*
 * @author n-c0de-r, jonasblome, and joeysmeets
 * @version 12.06.21
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    
    private CalcEngineString engine;
    private UserInterfaceString gui;
    	
	@BeforeEach
	void setUp() throws Exception {
    	
    	engine = new CalcEngineString();
    	gui = new UserInterfaceString(engine);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test 
	void test1() throws StackUnderflowException, IncorrectFormatException {
		engine.numberPressed(5, 0);
		engine.applyOperators("+");
		engine.numberPressed(5, 0);
		engine.equals();
		assertEquals("10.0", engine.getDisplayString());
	}
	
//	@Test 
//	void test2() {
//		
//	}
//	
//	@Test 
//	void test3() {
//		
//	}
//	
//	@Test 
//	void test4() {
//		
//	}
//	
//	@Test 
//	void test5() {
//		
//	}
//	
//	@Test 
//	void test6() {
//		
//	}
//	
//	@Test 
//	void test7() {
//		
//	}
//	
//	@Test 
//	void test8() {
//		
//	}
//	
//	@Test 
//	void test9() {
//		
//	}
}