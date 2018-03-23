package Production;
import java.security.InvalidParameterException;

/**
 * Superclass for SmallCar and LargeCar
 * @author Evan Meyermann
 *
 */
public abstract class AbstractCar implements CarInterface 
{
	private boolean isRented = false;
	private RegNumber regNumber;
	private int fuelTankSize;
	private int fuelInTank;
	
	public final boolean tankIsFull()
	{
		if (fuelTankSize == fuelInTank)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @param Adds fuel if the tank is not full. Throws exception if the gas attempted to add would overfill the tank. 
	 * 
	 * @return Returns amount of fuel used and prints notification to indicate how much
	 * was added.
	 * 
	 */
	public final int addFuel(int fuel) throws InvalidParameterException
	{
		if (fuel < (fuelTankSize - fuelInTank))
		{
			fuelInTank += fuel;
		}
		else
		{
			throw new InvalidParameterException("Too much gas attempted to add. Add less!");
		}
		
		System.out.println("Total fuel added: " + fuel);
		return fuel;
	}
	
	public final RegNumber setRegNumber(RegNumber regNumber)
	{
		return this.regNumber = regNumber;
	}
	
	public final int setTankSize(int size)
	{
		return fuelTankSize = size;
	}
	
	public final int setFuelInTank(int amount)
	{
		return fuelInTank = amount;
	}
	
	public final void setIsRentedFalse()
	{
		this.isRented = false;
	}
	
	public final void setIsRentedTrue()
	{
		this.isRented = true;
	}
	
	public final void changeTankAmount(int amount)
	{
		this.fuelInTank = getFuelInTank() - amount;
	}
	
	public int drive(int distanceInKi) throws IllegalArgumentException
	{	
		if (isRented == false)
		{
			throw new IllegalArgumentException("This car is not rented");
		}
		return 0;
	}
	
	public final boolean getIsRented()
	{
		return isRented;
	}
	
	public final int getTankSize()
	{
		return fuelTankSize;
	}
	
	public final int getFuelInTank()
	{
		return fuelInTank;
	}
	
	public final RegNumber getRegNumber()
	{
		return regNumber;
	}
	
	public String toString()
	{
		return ("Car Information: Rented? " + isRented +
				"\nRegistration Number: " + regNumber +
				"\nFuel Tank Size: " + fuelTankSize +
				"\nCurrent Fuel In Tank: " + fuelInTank);
	}

}

