package JUnitTesting;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import Production.DrivingLicense;
import Production.Person;

public class DrivingLicenseTest {
	
	Date dob = new Date(900000000);
	Date doi = new Date(1);
	
	Person p1 = new Person("John", "Smith", dob);
	Person p2 = new Person("Johnny", "Cage", dob);

	DrivingLicense drivingLicense1 = new DrivingLicense(p1, doi, true);
	DrivingLicense drivingLicense2 = new DrivingLicense(p2, doi, false);
	
	@Test
	public void testGetYearofIssue()
	{
		assertEquals(drivingLicense1.getYearOfIssue(), drivingLicense2.getYearOfIssue());
	}

}
