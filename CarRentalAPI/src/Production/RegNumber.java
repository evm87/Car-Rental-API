package Production;
import java.util.HashMap;
import java.util.Map;

/**
 * Used in Car classes to enforce uniqueness.
 * @author Evan Meyermann
 *
 */
public final class RegNumber
{
	private static String part1 = "AA";
	private static String part2 = "AAA";
	private static int theNumbers = 9;
	private String realPart1;
	private String realPart2;
	private int numbers;
	
	/**
	 * Map containing all registration numbers to ensure no duplicates.
	 */
	private static Map<String, RegNumber> regNumbers = new HashMap<String, RegNumber>();
	
	private RegNumber() 
	{
		realPart1 = part1;
		realPart2 = part2;
		numbers = theNumbers;
	}
	
	/**
	 * @param Creates a new registration number by incrementing static values by one, if the maximum amount of numbers is reached,
	 * an exception is thrown to indicate such. If the character is set to increment past Z, reset number value to 10 to start over
	 * with new character.
	 * @return RegNumber
	 */
	
	public final static RegNumber getInstance() throws IndexOutOfBoundsException
	{
		theNumbers++;
		
		char[] charArray1 = part1.toCharArray();
		char[] charArray2 = part2.toCharArray();

		if (theNumbers == 100)
			{
				theNumbers = 10;
				
				char letter5 = charArray2[2];
				letter5 = (char) (letter5 + 1);
				charArray2[2] = letter5;
				
				if(charArray2[2] > 'Z')
				{
					char letter4 = charArray2[1];
					letter4 = (char) (letter4 + 1);
					charArray2[2] = 'A';
					charArray2[1] = letter4;
					
					if(charArray2[1] > 'Z')
					{
						char letter3 = charArray2[0];
						letter3  = (char) (letter3 + 1);
						charArray2[1] = 'A';
						charArray2[0] = letter3;
						
						if(charArray2[0] > 'Z')
						{
							char letter2 = charArray1[1];
							letter2 = (char) (letter2 + 1);
							charArray2[0] = 'A';
							charArray1[1] = letter2;
							
							if(charArray1[1] > 'Z')
							{
								char letter1 = charArray1[0];
								letter1 = (char) (letter1 + 1);
								charArray1[1] = 'A';
								charArray1[0] = letter1;
								
								if(charArray1[0] > 'Z')
								{
									throw new IndexOutOfBoundsException("Registration Number Limit Reached");
								}
							}
						}
					}
				}
				
			}
		
		part1 = new String(charArray1);
		part2 = new String(charArray2);
		
		RegNumber regNumber = new RegNumber();
		
		if(regNumbers.containsKey(regNumber.toString()))
		{
			throw new IllegalArgumentException("Duplicate Registration Number!");
		}
		else
		{
			regNumbers.put(regNumber.toString(), regNumber);
		}
		
		return regNumber;
	}
	
	public final String getPart1()
	{
		return new String(realPart1 + this.convertNumToInt());
	}
	
	public final String getPart2()
	{
		return new String(realPart2);
	}
	
	public final int getNumbers()
	{
		return new Integer(numbers);
	}
	
	/**
	 * Returns the string value of the numbers in the total CarRegNumber object.
	 */
	public final String convertNumToInt()
	{
		return Integer.toString(getNumbers());
	}
	
	public final String toString()
	{
		return getPart1() + " " + getPart2();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numbers;
		result = prime * result + ((realPart1 == null) ? 0 : realPart1.hashCode());
		result = prime * result + ((realPart2 == null) ? 0 : realPart2.hashCode());
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
		RegNumber other = (RegNumber) obj;
		if (numbers != other.numbers)
			return false;
		if (realPart1 == null) {
			if (other.realPart1 != null)
				return false;
		} else if (!realPart1.equals(other.realPart1))
			return false;
		if (realPart2 == null) {
			if (other.realPart2 != null)
				return false;
		} else if (!realPart2.equals(other.realPart2))
			return false;
		return true;
	}

}