package HW2;

/**
* This <code>TrainManager</code> class has a main method that 
* runs a menu driven application which first creates an empty 
* TrainLinkedList object. The program prompts the user for a 
* command to execute an operation. Once a command has been chosen,
* the program may ask the user for additional information if necessary, 
* and performs the operation. 
* 
* @author Minqi Shi
* email: minqi.shi@stonybrook.edu
* Stony Brook ID: 111548035
**/

import java.util.*;
public class TrainManager
{
    public static void main(String[] args) 
    {
        Scanner stdin = new Scanner(System.in);
        TrainLinkedList list = new TrainLinkedList();
        String command = "";
        while ((!command.equals("Q"))&&(!command.equals("q")))
        {
            System.out.println("(F) Cursor Forward \n"
              +"(B) Cursor Backward \n" + "(I) Insert Car After Cursor \n"
              +"(R) Remove Car At Cursor \n" + "(L) Set Product Load \n"
              +"(S) Search For Product \n" + "(T) Display Train \n"
              +"(M) Display Manifest \n"+"(D) Remove Dangerous Cars \n"
              +"(Q) Quit\n");
            System.out.print("Enter a selection: ");
            command = stdin.next();
            System.out.println();
            switch(command)
            {
                //Moves the cursor forward one car (if a next car exists).
                case("F"):
                case("f"):
                    if (list.getCursor().getNext()!=null) 
                    {
                        list.cursorForward();
                        System.out.println("Cursor moved forward.");
                    }
                    else
                        System.out.println("No next car, cannot move "
                          +"cursor forward.");
                    System.out.println();
                    break;
                /**
                * Moves the cursor backward one car 
                * (if a previous car exists).
                **/
                case("B"):
                case("b"):
                    if (list.getCursor().getPrev()!=null)
                    {
                        list.cursorBackward();
                        System.out.println("Cursor moved backward.");
                    }
                    else
                        System.out.println("No previous car, cannot"
                          + " move cursor backward.");
                    System.out.println();
                    break;
                /** 
                * Inserts a new empty car after the cursor. 
                * If the cursor is null (i.e. the train is empty), the car 
                * is set as the head of the train. After insertion, the 
                * cursor is set to the newly inserted car.
                **/
                case("I"):
                case("i"):
                    try
                    {
                        System.out.print("Enter car length in meters: ");
                        double length = stdin.nextDouble();
                        if(length<0)
                            throw new IllegalArgumentException();
                        System.out.print("Enter car weight in tons: ");
                        double weight = stdin.nextDouble();
                        TrainCar car = new TrainCar(length,weight);
                        list.insertAfterCursor(car);
                        System.out.println("New train car "+ length 
                          +" meters "+ weight +" tons inserted into train.");
                        System.out.println();
                    }
                    catch(IllegalArgumentException | InputMismatchException iae)
                    {
                        System.out.println();
                        System.out.println("Invalid input!");
                        System.out.println();
                        stdin.nextLine();
                    }
                    break;
                /**
                * Removes the car at current position of the cursor. 
                * After deletion, the cursor is set to the next car in the
                * list if one exists, otherwise the previous car. If there
                * is no previous car, the list is empty and the cursor
                * is set to null.
                **/
                case("R"):
                case("r"):
                    TrainCar removed = list.removeCursor();
                    System.out.println("Car successully unlinked. The "
                      +"following load has been removed from the train:");
                    System.out.println();
                    System.out.println("Name      Weight (t)     "
                      +"Value ($)   Dangerous");
                    System.out.println("==========================="
                      +"=====================");
                    System.out.printf("%-10s%-15.1f%-12.2f", 
                      removed.getLoad().getName(),
                      removed.getLoad().getWeight(), 
                      removed.getLoad().getValue());
                    if (removed.getLoad().getIsDangerous())
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                    System.out.println();
                    break;
                //Sets the product load at the current position in the list.
                case("L"):
                case("l"):
                    try
                    {
                        if(list.size()<=0)
                            throw new IllegalArgumentException();
                        stdin.nextLine();
                        System.out.print("Enter produce name: ");
                        String name = stdin.nextLine();
                        list.getCursorData().getLoad().setName(name);
                        System.out.print("Enter product weight in tons: ");
                        double weight = stdin.nextDouble();
                        list.getCursorData().getLoad().setWeight(weight);
                        list.setTotalWeight(list.getTotalWeight()+ weight);
                        System.out.print("Enter prduct value in dollars: ");
                        double value = stdin.nextDouble();
                        list.getCursorData().getLoad().setValue(value);
                        list.setTotalValue(list.getTotalValue()+value);
                        System.out.print("Enter is product dangerous? "
                          +"(y/n): ");
                        stdin.nextLine();
                        String isDangerous = stdin.nextLine();
                        switch (isDangerous) {
                            case "y":
                                list.getCursor().getCar().getLoad()
                                  .setIsDangerous(true);
                                list.setTotalDangerous(list.getTotalDangerous()
                                  + 1);
                                break;
                            case "n":
                                list.getCursor().getCar().getLoad()
                                  .setIsDangerous(false);
                                break;
                            default:
                                throw new IllegalArgumentException();
                            }
                        System.out.println(weight+" tons of "+ name 
                          +" added to the current car."); 
                        System.out.println();
                    }
                    catch(IllegalArgumentException | InputMismatchException iae)
                    {
                        System.out.println();
                        System.out.println("Invalid input!");
                        System.out.println();
                        stdin.nextLine();
                    }
                    break;
                /**
                * Searches the train for all the loads with the indicated
                * name and prints out the total weight and value, and 
                * whether the load is dangerous or not. If the product 
                * could not be found, indicate to the user that the train
                * does not contain the indicated product.
                **/
                case("S"):
                case("s"):
                    stdin.nextLine();
                    System.out.print("Enter product name: ");
                    list.findProduct(stdin.nextLine());
                    break;
                // Prints the String value of the train to the console.
                case("T"):
                case("t"):
                    System.out.println(list);
                    System.out.println();
                    break;
                //Prints the train manifest - the loads carried by each car.
                case("M"):
                case("m"):
                    list.printManifest();
                    System.out.println();
                    break;
                // Removes all the dangerous cars from the train.
                case("D"):
                case("d"):
                    list.removeDangerousCars();
                    System.out.println("Dangerous cars successfully "
                    	+ "removed from the train.");
                    System.out.println();
                    break;
                default:
                    if ((!command.equals("Q"))&&(!command.equals("q")))
                    {
                        System.out.println("Invalid command!");
                        System.out.println();
                    }
                    break;
            }
        }        
        stdin.close();
        System.out.println("Program terminating successfully...");    
    }
}