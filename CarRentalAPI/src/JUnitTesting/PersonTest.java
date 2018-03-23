package JUnitTesting;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Production.Person;

public class PersonTest {
	
	Date dob = new Date(1);

	@Test
	public void testGetAge() 
	{
		Person p = new Person("John", "Smith", dob);
		
		assertTrue(p.getAge() == 47);
		assertTrue(p.getAge() > 46);
		assertTrue(p.getAge() < 48);
	}

}
