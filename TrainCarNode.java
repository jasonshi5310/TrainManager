package HW2;

/**
* The <code>TrainCarNode</code> class acts as a node wrapper 
* around a <code>TrainCar</code> object.
* 
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

public class TrainCarNode
{
	private TrainCarNode prev; // The previous train in the chain.
	private TrainCarNode next; // The next train in the chain.
	private TrainCar car; // The TrainCar reference containing the data.

	/**
	* Returns a instance of <code>TrainCarNode</code>.
	**/
	public TrainCarNode()
	{

	}

	/**
	* Returns a instance of <code>TrainCarNode</code>.
	*
	* @param car
	*    The TrainCar reference containing the data.
	**/
	public TrainCarNode(TrainCar car)
	{
		this.car = car;
	}
    
    /**
    * Returns the previous node in the chain.
    * 
    * @return 
    *    Returns the previous node in the chain.
    **/
    public TrainCarNode getPrev()
    {
    	return prev;
    }

    /**
    * Returns the next node in the chain.
    * 
    * @return 
    *    Returns the next node in the chain.
    **/
    public TrainCarNode getNext()
    {
    	return next;
    }

    /**
    * Returns the TrainCar reference containing the data.
    * 
    * @return 
    *    Returns the TrainCar reference containing the data.
    **/
    public TrainCar getCar()
    {
    	return car;
    }

    /**
    * Sets a new previous node.
    * 
    * @param newPrev
    *    The new previous node.
    **/
    public void setPrev(TrainCarNode newPrev)
    {
    	this.prev = newPrev;
    }

    /**
    * Sets a new next node.
    * 
    * @param newNext
    *    The new next node.
    **/
    public void setNext(TrainCarNode newNext)
    {
    	this.next = newNext;
    }

    /**
    * Sets a new TrainCar reference containing data.
    *
    * @param newCar
    *    The new TrainCar reference containing data.
    **/
    public void setCar(TrainCar newCar)
    {
    	this.car = newCar;
    }

    /**
    * Returns a string containing the data in the node.
    *
    * @return 
    *    Returns a string containing the data in the node.
    **/
    @Override
    public String toString()
    {
    	String str = String.format("%13.1f%14.1f  | %7s%14.1f%13.2f",
          this.getCar().getCarLength(), 
          this.getCar().getCarWeight(), 
          this.getCar().getLoad().getName(),
          this.getCar().getLoad().getWeight(),
          this.getCar().getLoad().getValue(), this.getCar().getLoad());
        if(this.getCar().getLoad().getIsDangerous())
            str += String.format("%12s","Yes");
        else
            str += String.format("%12s","No");
        return str;
    }
}