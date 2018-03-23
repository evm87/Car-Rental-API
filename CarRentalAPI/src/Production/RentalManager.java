package Production;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Top-level class used to manage rentals of cars.
 * @author Evan Meyermann
 *
 */
public final class RentalManager 
{
	/**
	 * Create a singleton of RentalManager
	 */
	public static final RentalManager INSTANCE = new RentalManager();
	
	private RentalManager()
	{
	}
	
	public static final RentalManager getInstance()
	{
		return INSTANCE;
	}
	
	/**
	 * Map of rented cars
	 */
	private static final Map<Person, CarInterface> rentalMap = new HashMap<Person, CarInterface>();
	
	/**
	 * Maps of all available cars
	 */
	private static List<CarInterface> smallCars = new ArrayList<CarInterface>();
	private static List<CarInterface> largeCars = new ArrayList<CarInterface>();
	
	/**
	 * Automatically creates a map of 30 cars, 20 small + 10 large. 
	 * @throws Exception 
	 */
	public final void generateCars() throws Exception
	{
		for (int i = 0; i < 20; i++)
		{
			AbstractCar tinyCar = createACar("Small", RegNumber.getInstance());
			
			smallCars.add(tinyCar);
		}
	
		for (int i = 0; i < 10; i++)
		{
			AbstractCar bigCar = createACar("Large", RegNumber.getInstance());
			
			largeCars.add(bigCar);
		}
		
	}
	
	/**
	 * @param Creates an instance of either small or large cars depending on type input, "Small" or "Large", to determine what type of car needs to be added.
	 * @throw NullPointerException, IllegalArgumentException
	 */
	public static final AbstractCar createACar(String type, RegNumber regNumber) throws NullPointerException, IllegalArgumentException
	{
		if (type.equals("Small"))
		{
			return SmallCar.getInstance(regNumber);
		}
		if (type.equals("Large"))
		{
			return LargeCar.getInstance(regNumber);
		}
		if (type.equals(null))
		{
			throw new NullPointerException("Must enter a type of car");
		}
		else
		{
			throw new IllegalArgumentException("Must type in a valid type of car(Small or Large)");
		}
	}
	
	/**
	 * @param Creates a new DrivingLicense object instance by using Person, Date for year it was issued, and boolean to represent whether the license is full or not. (true == full)
	 * @return DrivingLicense
	 */
	public final DrivingLicense getALicense(Person person, Date yearOfIssue, boolean isFull)
	{
		DrivingLicense license = new DrivingLicense(person, yearOfIssue, isFull);
		
		return license;
	}
	
	/**
	 * @param Takes type of car as String input (Small or Large) to determine what type of car to count.
	 * @return Returns number of available cars to rent.
	 * @throws NullPointerException, IllegalArgumentException
	 */
	public final int availableCars(String typeOfCar) throws NullPointerException, IllegalArgumentException
	{
		int counter = 0;
		if (typeOfCar == null)
		{
			throw new NullPointerException("Must provide a valid car type (Small or Large)");
		}
		
		if (typeOfCar != ("Small") && typeOfCar != ("Large"))
		{
			throw new IllegalArgumentException("Must enter a valid car type(Small or Large");
		}
		
		if(typeOfCar == "Small")
		{
			for(CarInterface car : smallCars)
			{
				if(car.getFuelInTank() == 49 && car.getIsRented() == false)
				{
					counter++;
				}
			}
		}
		
		if(typeOfCar == "Large")
		{
			for (CarInterface car : largeCars)
			{
				if (car.getFuelInTank() == 60 && car.getIsRented() == false)
				{
					counter++;
				}
			
			}
			
		}

		return new Integer(counter);
	}
	
	/**
	 * Checks the hashmap keys for every car that has its rented status as true, and places each in an ArrayList.
	 * 
	 * @return Returns immutable list of cars that have been rented.
	 */
	public final List<CarInterface> getRentedCars()
	{
		List<CarInterface> rentedCars = new ArrayList<CarInterface>();
		
		for (CarInterface car : rentalMap.values())
		{
			rentedCars.add(car);
		}
		
		List<CarInterface> unmodifiableRentedCars = Collections.unmodifiableList(rentedCars);
		
		return unmodifiableRentedCars;
	}

	/**
	 * @param Checks the hashmap of rentals for any person that matches the input.
	 * @return Returns null if no car was found with that license, or returns the car if one was found attached to the given person.
	 */
	public final CarInterface getCar(Person person)
	{
		if (rentalMap.containsKey(person))
		{
		for (Map.Entry<Person, CarInterface> entry : rentalMap.entrySet())
			{
				if (person.equals(entry.getValue()))
				{
					return entry.getValue();
				}
			}
		}
		return null;
	}
	
	/**
	 * @param Checks for validity of license to rent a car. Then checks for a valid car to rent by fuel and if it is attached to a value in the 
	 * hashmap. The hashmap contains a list of cars as keys and licenses as values. If a car key is associated to a null value, it is 
	 * unrented.
	 */
	
	public final void issueCar(Person person, DrivingLicense drivingLicense, String typeOfCar) throws IllegalArgumentException
	{
		Date date = new Date();
		Calendar today = Calendar.getInstance();
		today.setTime(date);
		
		int yearsDriving = today.get(Calendar.YEAR) - drivingLicense.getYearOfIssue();
		
		// Checks to see if license is full, if the license is currently attached to a car in the rentalMap, if the driver is at least 20, and if renting a large car, if the driver is at least 25
		if (drivingLicense.getIsFull() == false || rentalMap.containsKey(person) || person.getAge() < 20 || yearsDriving < 1 ||(typeOfCar.equals("Large") && person.getAge() < 25 || yearsDriving < 5))
		{
			throw new IllegalArgumentException("Cannot rent");
		}
		else
		if(typeOfCar == "Small")
		{
			for(CarInterface car : smallCars)
			{
				if(car.getFuelInTank() == 49 && car.getIsRented() == false && yearsDriving >= 1)
				{
					car.setIsRentedTrue();
					rentalMap.put(person, car);
					break;
				}
			}
		}
		else
		if (typeOfCar == "Large")
		{
			for(CarInterface car : largeCars)
			{
				if(car.getFuelInTank() == 60 && car.getIsRented() == false && yearsDriving >= 5)
				{
					car.setIsRentedTrue();
					rentalMap.put(person, car);
					break;
				}
			}
		}	
	}
	
	/**
	 * @param Terminates a rental by checking if the given license value is in the hashmap. 
	 * @return Returns the associated car key's gas tank amount, and refills the gas tank.
	 */
	public final int terminateRental(Person person)
	{
		int refuelAmount = 0;
		for (Map.Entry<Person, CarInterface> entry : rentalMap.entrySet())
		{
			Person renter = entry.getKey();
			CarInterface car = entry.getValue();
			if (renter.equals(person))
			{
				car.setIsRentedFalse();
				refuelAmount = car.getTankSize() - car.getFuelInTank();
				rentalMap.remove(renter);
				break;
			}
		}
		return refuelAmount;
	}
	
	public final static Map<Person, CarInterface> getRentalMap() 
	{
		Map<Person, CarInterface> unmodifiableRentalMap = Collections.unmodifiableMap(rentalMap);
		return unmodifiableRentalMap;
	}

	public final static List<CarInterface> getSmallCars() 
	{
		List<CarInterface> unmodifiableSmallCars = Collections.unmodifiableList(smallCars);
		return unmodifiableSmallCars;
	}

	public final static List<CarInterface> getLargeCars() 
	{
		List<CarInterface> unmodifiableLargeCars = Collections.unmodifiableList(largeCars);
		return unmodifiableLargeCars;
	}
	
}