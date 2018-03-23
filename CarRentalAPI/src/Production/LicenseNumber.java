package Production;

import java.util.Map;
import java.util.HashMap;

/**
 * Used in DrivingLicense to guarantee uniqueness.
 * @author Evan Meyermann
 *
 */
public final class LicenseNumber
{
	private final int yearOfIssue;
	private final int serialNumber;
	private final Person person;
	private final String initials;
	private static int count = 0;
	
	private static Map<String, LicenseNumber> numberMap = new HashMap<String, LicenseNumber>();
	
	/**
	 * @param Creates a new license number object with string and a Date value for year.
	 */
	private LicenseNumber(Person person, int yearOfIssue)
	{
		this.person = person;
		this.yearOfIssue = yearOfIssue;
		this.serialNumber = count;
		this.initials = person.getInitials();
	}
	
	/**
	 * 
	 * @param Creates a license number with inputs and ensure there are no duplicates by checking the hashmap of numbers before adding it to the hashmap as key-value pair 
	 * with its string representation as key.
	 * @return Returns a LicenseNumber object.
	 */
	public static LicenseNumber getInstance(Person person, int yearofIssue)
	{
		count++;
		LicenseNumber licenseNumber = new LicenseNumber(person, yearofIssue);
		
		if(numberMap.containsKey(licenseNumber.toString()))
		{
			throw new IllegalArgumentException("Duplicate License Number!");
		}
		
		numberMap.put(licenseNumber.toString(), licenseNumber);
		
		return licenseNumber;
	}
	
	public int getYearOfIssue()
	{
		return new Integer(yearOfIssue);
	}
	
	public int getSerialNumber()
	{
		return new Integer(serialNumber);
	}
	
	public String getInitials()
	{
		return new String(initials);
	}
	
	public String toString()
	{
		return (getInitials() + "-" + getYearOfIssue() + "-" + getSerialNumber());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initials == null) ? 0 : initials.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + serialNumber;
		result = prime * result + yearOfIssue;
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
		LicenseNumber other = (LicenseNumber) obj;
		if (initials == null) {
			if (other.initials != null)
				return false;
		} else if (!initials.equals(other.initials))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (serialNumber != other.serialNumber)
			return false;
		if (yearOfIssue != other.yearOfIssue)
			return false;
		return true;
	}


}