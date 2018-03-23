package JUnitTesting;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Production.AbstractCar;
import Production.DrivingLicense;
import Production.Person;
import Production.RegNumber;
import Production.RentalManager;
import Production.SmallCar;

public class RentalManagerTest {
	
	RentalManager manager = RentalManager.getInstance();

	@Test
	public void testGenerateCars() throws Exception 
	{
		manager.generateCars();
		
		assertEquals(manager.getSmallCars().size(), 20);
		
		assertEquals(manager.getLargeCars().size(), 10);
	}
	
	@Test
	public void testAvailableCars() throws Exception
	{
		assertEquals(manager.availableCars("Small"), 20);
		assertEquals(manager.availableCars("Large"), 10);
	}
}
