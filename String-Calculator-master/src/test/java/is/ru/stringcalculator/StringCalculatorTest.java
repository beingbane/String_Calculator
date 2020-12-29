package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.StringCalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void testTwoNumbers(){
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
    public void testThreeNumbers(){
    	assertEquals(6, StringCalculator.add("1,2,3"));
    }
	
	@Test
    public void testNewLine(){
    	assertEquals(6, StringCalculator.add("1\n2,3"));
    }
	
	@Test
    public void testNegativeNumber(){
    	try {
    		StringCalculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			StringCalculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
		
		try {
			StringCalculator.add("5,4,-3,-2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -3,-2");
		}
    }
	
	@Test
    public void testOverThousand(){
    	assertEquals(2, StringCalculator.add("1001,2"));
    }
}