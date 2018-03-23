package Production;
import java.util.Calendar;
import java.util.Date;

/**
 * DrivingLicense consists of a license number, person, date of issue, and a boolean value.
 * @author Evan Meyermann
 *
 */
public final class DrivingLicense
{    
    private final Person person;
    private final Date dateOfIssue;
    private final boolean isFull;
	private final LicenseNumber number;
	
    /**
     * @param Create a license object with person, date of issue, and license status. Constructs license number by calling getInstance() in LicenseNumber class.
     */
    public DrivingLicense(Person person, Date dateOfIssue, boolean isFull) 
    {	
    	this.dateOfIssue = dateOfIssue;
    	this.person = person;
    	this.isFull = isFull;
    	this.number = LicenseNumber.getInstance(person, this.getYearOfIssue());
    }

	/**
     * @return Returns the year of issue by creating a calendar object using the date of issue to set the time of the calendar, then extracting the year.
     */
    public final int getYearOfIssue()
    {
    	Calendar year = Calendar.getInstance();
    	year.setTime(this.dateOfIssue);
    	
    	int yearOfIssue = year.get(Calendar.YEAR);
    	
    	return yearOfIssue;
    }
    
    public final LicenseNumber getLicenseNumber()
    {
    	return number;
    }
    
    public final boolean getIsFull()
    {
    	return isFull;
    }
    
    public String toString()
    {
    	return ("License Info: " + "\n Date Issued: " + getYearOfIssue() + 
    			"\n Full License: " + getIsFull() + "\n Number: " + getLicenseNumber());
    }
    
    public final Person getPerson() 
    {
		return person;
	}
    
}


