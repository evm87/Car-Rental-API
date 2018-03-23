package JUnitTesting;

import static org.junit.Assert.*;
import Production.*;
import org.junit.Test;

public class LargeCarTest {

	RegNumber number = RegNumber.getInstance();
	LargeCar car = LargeCar.getInstance(number);
	
	@Test
	public void testDrive()
	{	
		car.setIsRentedTrue();
		car.drive(10);
		
		assertTrue(car.getFuelInTank() < car.getTankSize());
		assertTrue(car.getFuelInTank() == 59);
		assertTrue(car.getFuelInTank() > 58);
		
		car.drive(20);
		
		assertTrue(car.getFuelInTank() < 58);
		assertTrue(car.getFuelInTank() == 57);
		assertTrue(car.getFuelInTank() > 56);
		
		car.drive(65);
		
		assertTrue(car.getFuelInTank() < 51);
		assertTrue(car.getFuelInTank() == 50);
		assertTrue(car.getFuelInTank() > 49);
		
		car.drive(1000000000);
		
		assertTrue(car.getFuelInTank() <= 0);
		
	}

}
