package JUnitTesting;

import static org.junit.Assert.*;
import Production.*;
import org.junit.Test;

public class RegNumberTest {

	@Test
	public void testGetInstance() 
	{
		RegNumber number = RegNumber.getInstance();
		assertEquals(number.toString(), "AA10 AAA");
		
		RegNumber number2 = RegNumber.getInstance();
		assertEquals(number2.toString(), "AA11 AAA");
	}

}
