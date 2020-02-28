package HW2;

/**
* The <code>TrainLinked</code> class implements a Double-Linked List ADT.
*
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/
public class TrainLinkedList
{
    private TrainCarNode head; // The head of the list.
    private TrainCarNode tail; // The tail of the list.
    private TrainCarNode cursor; // The cursor of the list.
    private int manyItems; // The number of TrainCar object in the chain.
    private double totalLength; // The total length of the chain.
    private double totalValue; // The total value of the chain.
    private double totalWeight; // The total weight of the chain.
    // The number of dangerous cars in the chain.
    private int totalDangerous; 
    
    /**
    * Returns an instance of <code>TrainLinkedList</code>;
    * constructs an instance of the TrainLinkedList 
    * with no TrainCar objects in it.
    *
    * <dt>Preconditions:
    *    <dd>This TrainLinkedList has been initialized to 
    *    an empty linked list. head, tail, and cursor are 
    *    all set to null.
    **/
    public TrainLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.cursor = null;
        this.manyItems = 0;
        this.totalDangerous = 0;
        this.totalWeight = 0;
        this.totalLength = 0;
        this.totalValue = 0;
    }

    /**
    * Returns a reference to the TrainCar at the node currently 
    * referenced by the cursor.
    *
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null).
    * 
    * @return
    *    The reference to the TrainCar at the node currently 
    *    referenced by the cursor.
    **/
    public TrainCar getCursorData()
    {
        return cursor.getCar();
    }
    
    /**
    * Returns a reference to the TrainCarNode currently 
    * referenced to the cursor.
    *
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null).
    * 
    * @return
    *    The reference to the TrainCarNode currently 
    *    referenced to the cursor.
    **/
    public TrainCarNode getCursor()
    {
        return cursor;
    }

    /**
    * Places car in the node currently referenced by the cursor.
    *
    * @param car
    *    The new car for the node.
    * 
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null).
    * 
    * <dt>Postconditions:
    *   <dd>The cursor node now contains a reference to car as its data. 
    **/
    public void setCursorData(TrainCar car)
    {
        cursor.setCar(car);
    }

    /**
    * Moves the cursor to point at the next TrainCarNode.
    *
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null) and cursor 
    *   does not currently reference the tail of the list.
    *
    * <dt>Postconditions:
    *    <dd>The cursor has been advanced to the next TrainCarNode, 
    *    or has remained at the tail of the list.
    **/
    public void cursorForward()
    {
        if (cursor.getNext() != null) 
        {
            cursor = cursor.getNext();
        }  
    }

    /**
    * Moves the cursor to point at the previous TrainCarNode.
    *
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null) and cursor 
    *   does not currently reference the head of the list.
    *
    * <dt>Postconditions:
    *    <dd>The cursor has been back to the previous TrainCarNode, 
    *    or has remained at the head of the list.
    **/
    public void cursorBackward()
    {
        if (cursor.getPrev() != null)
        {
            cursor = cursor.getPrev();
        }
    }

    /**
    * Inserts a car into the train after the cursor position.
    *
    * @param newCar
    *    the new TrainCar to be inserted into the train.
    *
    * <dt>Preconditions:
    *    <dd>This TrainCar object has been instantiated.
    *
    * <dt>Postconditions:
    *    <dd>The new TrainCar has been inserted into the train after
    *    the position of the cursor. All TrainCar objects previously 
    *    on the train are still on the train, and thier order has been
    *    preserved. The cursor now points to the inserted car.
    *
    * @exception IllegalArgumentException
    *    Indicates that newCar is null.
    **/
    public void insertAfterCursor(TrainCar newCar) 
      throws IllegalArgumentException
    {
        if (newCar == null)
        {
            throw new IllegalArgumentException();
        }
        TrainCarNode newNode = new TrainCarNode(newCar);
        manyItems++;
        totalLength += newCar.getCarLength();
        totalWeight += newCar.getCarWeight();
        if (cursor == null)
        {
            cursor = newNode;
            head = newNode;
            tail = newNode;
        }
        else if(cursor.getNext() != null)
        {
            newNode.setNext(cursor.getNext());
            newNode.getNext().setPrev(newNode);
            cursor.setNext(newNode);
            newNode.setPrev(cursor);
            cursor = newNode;
        }
        else
        {
            newNode.setPrev(cursor);
            cursor.setNext(newNode);
            tail = newNode;
            cursor = newNode;
        }
    }

    /**
    * Removes the TrainCarNode referenced by the cursor and returns the 
    * TrainCar contained within the node.
    *
    * @return 
    *    Returns the train car removed from the list.
    * 
    * <dt>Preconditions:
    *   <dd>The list is not empty (cursor is not null).
    *
    * <dt>Postconditions:
    *    <dd>The TrainCarNode referenced by the cursor has been removed 
    *    from the train. The cursor now references the next node, or the 
    *    previous node if no next node exists.
    **/
    public TrainCar removeCursor()
    {
        if(head != null)
        {
            TrainCar removed = cursor.getCar();
            manyItems--;
            totalLength -= removed.getCarLength();
            totalWeight -= removed.getCarWeight()
              - removed.getLoad().getWeight();
            totalValue -= removed.getLoad().getValue();
            if (removed.getLoad().getIsDangerous())
                totalDangerous--;
            if(cursor != head)
            {
                cursor.getPrev().setNext(cursor.getNext());
                if(cursor.getNext()!=null)
                {
                    cursor.getNext().setPrev(cursor.getPrev());
                    cursor = cursor.getNext();
                }
                else
                {
                    cursor = cursor.getPrev();
                    tail = cursor;
                }
            }
            else if (head.getPrev()!=null)
            {
                head = cursor.getNext();
                head.setPrev(null);
            }
            if (manyItems==1)
                head = tail;
            else if (manyItems == 0)
                head = tail = cursor = null;
            return removed;
        }
        return null;
    }

    /**
    * Determines the number of TrainCar objects currently on the train.
    *
    * @return
    *    The number of TrainCar objects on this train.
    *
    * Notes: This function should complete in O(1) time.
    **/
    public int size()
    {
        return manyItems;
    }

    /**
    * Returns the total length of the train in meters.
    *
    * @return
    *    The sum of the lengths of each TrainCar in the train.
    * 
    * Notes:
    *    This function should complete in O(1) time.
    **/
    public double getLength()
    {
        return totalLength;
    }

    /**
    * Returns the total value of product carried by the train.
    *
    * @return
    *    The sum of the values of each TrainCar in the train.
    *
    * Notes:
    *    This function should complete in O(1) time.
    **/
    public double getValue()
    {
        return totalValue;
    }

    /**
    * Returns the total weight in tons of the train. Note that the 
    * weight of the train is the sum of the weights of each empty TrainCar, 
    * plus the weight of the ProductLoad carried by that car.
    *
    * @return
    *     The sum of the weight of each TrainCar plus the sum of 
    *     the ProductLoad carried by that car.
    *
    * Notes:
    *    This function should complete in O(1) time.
    **/
    public double getWeight()
    {
        return totalWeight;
    }

    /**
    * Whether or not there is a dangerous product on one of the 
    * TrainCar objects on the train.
    *
    * @return
    *    Returns true if the train contains at least one TrainCar 
    *    carrying a dangerous ProductLoad, false otherwise.
    *
    * Notes:
    *    This function should complete in O(1) time.
    **/
    public boolean isDangerous()
    {
        return (totalDangerous > 0);
    }

    /**
    * Set the number of dangerous train cars.
    *
    * @param dangerousCar
    *    the number of dangerous train cars.
    **/
    public void SetTotalDangerous(int dangerousCar)
    {
        this.totalDangerous = dangerousCar;
    }

    /**
    * Searches the list for all ProductLoad objects with the indicated
    * name and sums together their weight and value (Also keeps track of 
    * whether the product is dangerous or not), then prints a single 
    * ProductLoad record to the console.
    *
    * @param name
    *    The name of the ProductLoad to find on the train.
    *
    * Notes:
    *    This method should search the entire train for the indicated 
    *    ProductLoad, and should not stop after the first match. For example,
    *    if there are three different TrainCar objects each carrying a 
    *    ProductLoad with the name "corn", then this method should print a 
    *    single record with the sum of the weight and value for the corn on 
    *    each car. If nothing was found, indicate that there are no 
    *    ProductLoad objects of the indicated name on board the train. 
    *    For the purposes of this assignment, you may assume that the 
    *    dangerousness of loads with equal names are equal. Simply use the 
    *    boolean value of isDangerous for the first match found.
    **/
    public void findProduct(String name)
    {
        System.out.println();
        int count = 0;
        TrainCarNode nodePtr = head;
        double weight = 0;
        double value = 0;
        String dangerousness = "NO";
        while (nodePtr != null)
        {
            if(nodePtr.getCar().getLoad().getName().equals(name))
            {
                weight += nodePtr.getCar().getLoad().getWeight();
                value += nodePtr.getCar().getLoad().getValue();
                if(nodePtr.getCar().getLoad().getIsDangerous())
                    dangerousness = "Yes";
                count++;
            }
            nodePtr = nodePtr.getNext();
        }
        if (count == 0) 
            System.out.println("No record of "+ name +" on board train.");
        else
        {
            System.out.println("The following products were found "
              +"on "+ count+" cars:");
            System.out.println();
            System.out.println("Name      Weight (t)     "
              +"Value ($)   Dangerous");
            System.out.println("==========================="
              +"=====================");
            System.out.printf("%-10s%-15.1f%-12.2f%s\n", name, weight, value, 
              dangerousness);
            
        }
        System.out.println();
    }

    /**
    * Prints a neatly formatted table of the car number, car length, 
    * car weight, load name, load weight, load value, and load dangerousness
    * for all of the car on the train.
    *
    * Notes:
    *    There should be a record for each TrainCar printed to the console, 
    *    numbered from 1 to n. For each car, print the data of the car, 
    *    followed by the ProductLoad data if the car is not empty. If the car
    *    is empty, print "Empty" for name, 0 for weight and value, and "NO" 
    *    for dangerousness (see sample I/O for example).
    **/
    public void printManifest()
    {
        System.out.println("CAR:                               LOAD:");
        System.out.print("  Num   Length (m)    Weight (t)  |    ");
        System.out.println("Name      Weight (t)     Value ($)   Dangerous");
        System.out.println("=================================="
          +"+===================================================");
        TrainCarNode nodePtr = head;
        int count = 1;
        while(nodePtr!=null)
        {
            if(nodePtr != cursor)
                System.out.printf("%5d",count);
            else
                System.out.printf("->%3d",count);
            System.out.println(nodePtr);
            nodePtr = nodePtr.getNext();
            count++;
        }
    }

    /**
    * Removes all dangerous cars from the train, maintaining the order
    * of the cars in the train.
    *
    * <dt>Postconditions:
    *    <dd>All dangerous cars have been removed from this train.
    *    The order of all non-dangerous cars must be maintained upon 
    *    the completion of this method.
    *
    * Notes:
    *    All the dangerous cars may be discarded after calling this method.
    **/
    public void removeDangerousCars()
    {
        cursor = head;
        while(cursor!= null)
        {
            if (cursor.getCar().getLoad().getIsDangerous())
            {
                this.removeCursor();
                continue;
            }
            cursor = cursor.getNext();
        }
        cursor = tail;
    }
        
    /**
     * Sets totalDangerous for the list.
     * 
     * @param dangerCar
     *    The new number of dangerous car in the list.
    **/
    public void setTotalDangerous(int dangerCar)
    {
        this.totalDangerous = dangerCar;
    }
          
    /**
     * Sets total weight for the train.
     * 
     * @param newWeight
     *    The new weight for the train.
    **/
    public void setTotalWeight(double newWeight)
    {
        this.totalWeight = newWeight;
    }  
               
    /**
     * Sets total length for the list.
     * 
     * @param newLength
     *    The new length for the train.
    **/
    public void setTotalLength(double newLength)
    {
        this.totalLength = newLength;
    }
    
            
    /**
     * Sets total value for the list.
     * 
     * @param newValue
     *    The new total value in the list.
    **/
    public void setTotalValue(double newValue)
    {
        this.totalValue = newValue;
    }
    
    /**
     * Returns total value for the list.
     * 
     * @return
     *    The total value in the list.
    **/
    public double getTotalValue()
    {
        return totalValue;
    }
    
    /**
     * Returns total weight for the list.
     * 
     * @return
     *    The total weight in the list.
    **/
    public double getTotalWeight()
    {
        return totalWeight;
    }
    
    /**
     * Returns total dangerous cars for the list.
     * 
     * @return
     *    The total dangerous cars in the list.
    **/
    public int getTotalDangerous()
    {
        return totalDangerous;
    }
    
    /**
    * Returns a neatly formatted String representation of the train.
    *
    * @return
    *    A neatly formatted string containing information about the train,
    *    including it's size (number of cars), length in meters, weight 
    *    in tons, value in dollars, and whether it is dangerous or not.
    **/
    @Override
    public String toString()
    { 
        String danger;
        if(this.isDangerous())
            danger = "DANGEROUS";
        else
            danger = "not dangerous";
        return String.format("Train: %d cars, %.1f meters, %.1f tons, "
                + "$%.2f value, %s.", manyItems, totalLength, totalWeight, 
                totalValue, danger);
    }
}