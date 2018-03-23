package JUnitTesting;

import static org.junit.Assert.*;
import Production.*;
import org.junit.Test;

public class SmallCarTest {

	RegNumber number = RegNumber.getInstance();
	SmallCar car = SmallCar.getInstance(number);
	
	@Test
	public void testDrive()
	{
		car.setIsRentedTrue();
		car.drive(1);
		
		assertTrue(car.getFuelInTank() < car.getTankSize());
		assertTrue(car.getFuelInTank() > 47);
		assertTrue(car.getFuelInTank() == 48);
		
		car.drive(40);
		
		assertTrue(car.getFuelInTank() < 47);
		assertTrue(car.getFuelInTank() == 46);
		assertTrue(car.getFuelInTank() > 45);
		
		car.drive(100000000);
		
		assertTrue(car.getFuelInTank() <= 0);
	}

}
