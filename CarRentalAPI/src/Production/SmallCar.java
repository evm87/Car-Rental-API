package Production;
/**
 * Subclass of AbstractCar. Difference from LargeCar is in fuelTankSize and fuel consumption rate.
 * @author Evan Meyermann
 *
 */
public class SmallCar extends AbstractCar
{
	private static int Max_Small_Cars = 20;
	private static int counter = 0;

	private SmallCar(RegNumber regNumber)
	{
		super();
		setTankSize(49);
		setFuelInTank(49);
		setRegNumber(regNumber);
	}
	
	/**
	 * @param If the fuel in tank is above 0, changes tank amount to the fuel in tank minus fuel consumed. Returns the amount of fuel consumed. If only a partial litre
	 * is used, defaults to 1 litre consumed. 
	 * @throws Throws an IllegalArgumentException if the distance is not driveable.
	 * @return Returns the total fuel consumed as int.
	 */
	public final int drive(int distanceInKi) throws IllegalArgumentException
	{
		super.drive(distanceInKi);
		int fuelConsumed = 0;
		if (getFuelInTank() > 0)
		{
			fuelConsumed = (distanceInKi/20);
			
			int partialLitre = distanceInKi % 20;
			
			if(partialLitre != 0)
			{
				fuelConsumed++;
			}
			
			changeTankAmount(fuelConsumed);
			
			return fuelConsumed;
		}
		else
		{
			throw new IllegalArgumentException("Can only drive when fuel is in the tank");
		}
	}
	
	/**
	 *@param Creates new instance of SmallCar.
	 *@return Returns a new instance of SmallCar
	 *@throws Throws an exception if too many cars are created as defined by Max_Small_Cars.
	 */
	public final static SmallCar getInstance(RegNumber regNumber) throws IndexOutOfBoundsException
	{
		if (counter < Max_Small_Cars)
		{
			counter++;
			return new SmallCar(regNumber);
		}
		else
		{
			throw new IndexOutOfBoundsException("Too many small cars created!");
		}
	}
	
}