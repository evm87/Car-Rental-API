package Production;
/**
 * Subclass of AbstractCar. Difference from SmallCar is in tank size and fuel consumption rate.
 * @author Evan Meyermann
 *
 */
public class LargeCar extends AbstractCar
{
	private static int Max_Large_Cars = 10;
	private static int counter = 0;

	/**
	 * 
	 * @param Constructs a LargeCar by using a RegNumber as input.
	 */
	private LargeCar(RegNumber regNumber)
	{
		super();
		setTankSize(60);
		setFuelInTank(60);
		setRegNumber(regNumber);
	}
	
	/**
	 * @Override AbstractCar.drive()
	 * @param Reduces amount of gas in car by calculating distance driven. If the fuel in tank is above 0, changes tank amount to the fuel in tank minus fuel consumed. 
	 * @return Returns the amount of fuel consumed.
	 * @throws Throws an exception if the distance is not driveable, i.e. has no fuel or is not rented.
	 */
	public int drive(int distanceInKi) throws IllegalArgumentException
	{
		super.drive(distanceInKi);
		int fuelConsumed = 0;
		if ((getFuelInTank() > 0) && (distanceInKi <= 50))
		{
			fuelConsumed = distanceInKi/10;
			
			int partialLitre = distanceInKi % 10;
			
			if(partialLitre != 0)
			{
				fuelConsumed++;
			}
			
			changeTankAmount(fuelConsumed);
		}
		else
		if (distanceInKi > 50)
		{
			fuelConsumed = ((distanceInKi - 50)/15) + 5;
			
			int partialLitre = (distanceInKi - 50)/15 + 5 % 15;
			
			if(partialLitre != 0)
			{
				fuelConsumed++;
			}
			
			changeTankAmount(fuelConsumed);
		}
		else
		{
			throw new IllegalArgumentException("Can only drive when fuel is in the tank");
		}
		return fuelConsumed;
	}
	
	/**
	 * 
	 * @param regNumber
	 * @return LargeCar
	 * @throws Throws an IndexOutOfBoundsException if too many cars are created as defined by Max_Large_Cars.
	 */
	public static LargeCar getInstance(RegNumber regNumber) throws IndexOutOfBoundsException
	{
		if (counter < Max_Large_Cars)
		{
			counter++;
			return new LargeCar(regNumber);
		}
		else
		{
			throw new IndexOutOfBoundsException("Too many large cars created!");
		}
	}
	
	public int setFuelConsumed(int distanceInKi)
	{
		return distanceInKi/10;
	}
}
