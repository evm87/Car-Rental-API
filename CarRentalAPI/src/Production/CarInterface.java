package Production;
import java.security.InvalidParameterException;

/**
 * Interface for AbstractCar
 * @author Evan Meyermann
 *
 */
public interface CarInterface
{
	RegNumber getRegNumber();
	
	
	int getTankSize();

	
	int getFuelInTank();

	
	boolean getIsRented();

	
	boolean tankIsFull();

	
	int addFuel(int fuel) throws InvalidParameterException;
	
	
	RegNumber setRegNumber(RegNumber regNumber);
	
	
	void setIsRentedTrue();
	
	
	void setIsRentedFalse();
	
	
	int setFuelInTank(int amount);
}