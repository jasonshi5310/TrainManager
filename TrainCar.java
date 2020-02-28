package HW2;

/**
* The <code>TrainCar</code> class contains information for the 
* a train car, including a length in meters (double), a weight 
* in tons (double), and a load reference (ProductLoad).
* 
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class TrainCar
{
	private double carLength; // The length of the TrainCar.
	private double carWeight; // The weight of the TrainCar.
	private ProductLoad load; // The product load of the TrainCar.
    
    /**
	* Returns a instance of <code>TrainCar</code>.
	*
	* @param carLength
	*    The length of the TrainCar.
	* 
	* @param carWeight
	*    The weight of the TrainCar.
	*
	* <dt>Precondition
	*    <dd>The length and the weight of the <code>TrainCar</code> 
	*        should be nonnegative.
	*
	* @exception IllegalArgumentException
    *    The weight and the value should be nonnegative.
    **/
    public TrainCar(double carLength, double carWeight)
      throws IllegalArgumentException
    {
    	if (carLength<0 | carWeight<0) {
    		throw new IllegalArgumentException();
    	}
    	this.carLength = carLength;
    	this.carWeight = carWeight;
        this.load = new ProductLoad();
    }

    /**
	* Returns a instance of <code>TrainCar</code>.
	*
	* @param carLength
	*    The length of the TrainCar.
	* 
	* @param carWeight
	*    The weight of the TrainCar.
	*
	* @param load
	*    The product load of the TrainCar.
	*
	* <dt>Precondition
	*    <dd>The length and the weight of the <code>TrainCar</code> 
	*        should be nonnegative.
    **/
    public TrainCar(double carLength, double carWeight, ProductLoad load)
      throws IllegalArgumentException
    {
    	if (carWeight<0 | carLength<0) {
    		throw new IllegalArgumentException();
    	}
    	this.carLength = carLength;
    	this.carWeight = carWeight;
    	this.load = load;
    }

    /**
    * Returns the current length of the TrainCar.
    * 
    * @return 
    *    Returns the length of the TrainCar.
    **/
    public double getCarLength()
    {
    	return carLength;
    }

    /**
    * Returns the current weight of the TrainCar.
    * 
    * @return 
    *    Returns the weight of the TrainCar.
    **/
    public double getCarWeight()
    {
    	return carWeight;
    }

    /**
    * Returns the current product load of the TrainCar.
    * 
    * @return 
    *    Returns the product load of the TrainCar.
    **/
    public ProductLoad getLoad()
    {
    	return load;
    }

    /**
    * Sets a new product load for the TrainCar
    *
    * @param newLoad
    *    The new product load for the TrainCar.
    **/
    public void setLoad(ProductLoad newLoad)
    {
        this.load = newLoad;
    }

    /**
    * Determine if the TrainCar is loaded or not.
    *
    * @return 
    *    True if the car if is loaded; otherwise, false.
    **/
    public boolean isEmpty()
    {
    	return(load == null);
    }
}