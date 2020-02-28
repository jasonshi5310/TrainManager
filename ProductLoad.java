package HW2;

/**
* The <code>ProductLoad</code> class contains information for the 
* product loaded, containing the product name (String), its weight 
* in tons (double), its value in dollars (double), and whether the 
* product is dangerous or not (boolean) in a <code>TrainCar</code>.
* 
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class ProductLoad
{
    private String name; // The name of the product.
    private double weight; // The weight of the product in tons.
    private double value; // The value of the product in dollars.
    private boolean isDangerous; // Whether the product is dangerous or not.

    /**
    * Returns an instance of <code>ProductLoad</code>. 
    **/
    public ProductLoad()
    {
        this.name = "Empty";
    }

    /**
    * Returns an instance of <code>Product</code>. 
    *
    * @param name
    *    The name of the product.
    * 
    * @param weight 
    *    The weight of the product in tons.
    * 
    * @param value
    *    The value of the product in dollars.
    * 
    * @param isDangerous
    * 	 Whether the product is dangerous or not. 
    *
    * <dt>Precondition:
    *    <dd><code>weight</code> and <code>value</code> must be
    *    greater than or equal to 0.
    *
    * @exception IllegalArgumentException
    *    The weight and the value should be nonnegative.
    **/
    public ProductLoad(String name, double weight, double value, 
      boolean isDangerous) throws IllegalArgumentException
    {
    	if (weight<0|value<0) {
    		throw new IllegalArgumentException();
    	}
    	this.name = name;
    	this.weight = weight;
    	this.value = value;
    	this.isDangerous = isDangerous;
    }
    
    /**
    * Returns the current name of the product.
    *
    * @return 
    *    Returns the name of the product.
    **/
    public String getName()
    {
        return name;
    }
    
    /**
    * Returns the current weight of the product.
    *
    * @return 
    *    Returns the weight of the product.
    **/
    public double getWeight()
    {
        return weight;
    }

    /**
    * Returns the current value of the product.
    *
    * @return
    *    Returns the value of the product.
    **/
    public double getValue()
    {
    	return value;
    }

    /**
    * Returns whether the product is dangerous or not.
    *
    * @return
    *    Returns a boolean value if the product is dangerous or not.
    **/
    public boolean getIsDangerous()
    {
    	return isDangerous;
    }

    /**
    * Set a new name for the product.
    *
    * @param newName
    *    the new name for the product.
    **/
    public void setName(String newName)
    {
    	this.name = newName;
    }

    /**
    * Set a new weight for the product.
    *
    * @param newWeight
    *    the new weight for the product.
    *
    * @exception IllegalArgumentException
    *    The weight and the value should be nonnegetive.
    **/
    public void setWeight(double newWeight) throws IllegalArgumentException
    {
    	if (newWeight<0) {
    		throw new IllegalArgumentException();
    	}
    	this.weight = newWeight;
    }

    /**
    * Set a new value for the product.
    *
    * @param newValue
    *    the new value for the product.
    *
    * @exception IllegalArgumentException
    *    The weight and the value should be nonnegetive.
    **/
    public void setValue(double newValue) throws IllegalArgumentException
    {
    	if (newValue<0) {
    		throw new IllegalArgumentException();
    	}
    	this.value = newValue;
    }

    /**
    * Change whether the product is dangerous or not
    *
    * @param newIsDangerous
    *    the new isDangerous for the product
    **/
    public void setIsDangerous(boolean newIsDangerous)
    {
    	this.isDangerous = newIsDangerous;
    }
}