package Production;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Evan Meyermann
 */
public class Person 
{
	private final String firstName;
	private final String lastName;
	private final Date dob;
	
	public Person(String firstName, String lastName, Date dob)
	{
		this.firstName = setFirstName(firstName);
		this.lastName = setLastName(lastName);
		this.dob = setDOB(dob);
	}
	
	/**
	 * 
	 * @return Returns new String representing firstName
	 * @throws Throws NullPointerException if a name is not entered
	 */
	private final String setFirstName(String firstName)
	{
		if (firstName.length() == 0)
		{
			throw new NullPointerException("Must have a first name");
		}
		return new String(firstName);
	}
	
	/**
	 * 
	 * @return Returns new String representing lastName
	 * @throws Throws NullPointerException if a name is not entered
	 */
	private final String setLastName(String lastName)
	{
		if (lastName.length() == 0)
		{
			throw new NullPointerException("Must have a last name");
		}
		return new String(lastName);
	}
	
	private final Date setDOB(Date dob)
	{
		if (dob == null)
		{
			throw new NullPointerException("Must have a date of birth");
		}
		return dob;
	}
	
	private final String getFirstInitial(String firstName)
	{
		final String[] firstLetter = getFirstName().split("");
		
		return new String(firstLetter[0]);
	}
	
	private final String getLastInitial(String lastName)
	{
		final String[] lastLetter = getLastName().split("");
		
		return new String(lastLetter[0]);
	}
	
	public final String getInitials()
	{
		return new String(getFirstInitial(firstName) + getLastInitial(lastName));
	}
	
    /**
     * @Return Returns an int value of the person's age by setting a time by date of birth, creating an age object using years, and if
     * today's day of year is before the day of year for year of birth, reduces the age by 1.
     */
    public final int getAge()
    {
    	Calendar birthday = Calendar.getInstance();
    	birthday.setTime(this.dob);
    	
    	Calendar today = Calendar.getInstance();
    	int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
    	
    	if (today.get(Calendar.DAY_OF_YEAR) < birthday.get(Calendar.DAY_OF_YEAR))
    	{
    		age = age-1;
    	}
    	return new Integer(age);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public final String getFirstName()
	{
		return new String(firstName);
	}
	
	public final String getLastName()
	{
		return new String(lastName);
	}
	
	public final Date getDOB()
	{
		return dob;
	}
	
	public final String toString()
	{
		return getFirstName() + " " + getLastName();
	}
}