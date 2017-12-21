/**************************************************************************************
 * ------------------------------------------------------------------------------------
 * File name: Project4.java
 * Project name: CSCI 1250 Project 4
 * ------------------------------------------------------------------------------------
 * Author Name: Dakota Cowell
 * Author E-mail: cowelld@goldmail.etsu.edu
 * Course-Section: CSCI-1250-201
 * Creation Date: 11/2/2015
 * Date of Last Modification: 11/3/2015
 * -----------------------------------------------------------------------------
 */
 import java.util.Scanner; //to allow input from the keyboard
 import java.text.DecimalFormat;//to allow decimal formatting
 /*******************************************************************************
  * Class Name: Project4 <br>
  * Class Purpose: Project 4  <br>
  *
  * <hr>
  * Date created: 11/2/2015 <br>
  * Date last modified: 11/3/2015
  * @author Dakota Cowell
  */
 public class Project4
{
  /*****************************************************************************
 * Method Name: main <br>
 * Method Purpose:
 * You are to write a driver program that will interact with the CustomerOrder
 * class to process a customer’s order.  Your program is to interact with the
 * user by getting all customer input related to the order.  It should then use
 * the CustomerOrder class to store the information and get information back
 * related to the order for display to the user.  Ultimately, you will be asking
 * for the order information and displaying their order results to the screen in
 *  the form of a bill statement as shown in the screen shot below.  While your
 * output does not need to look exactly like what is shown, it should have the
 * same information and should be displayed in a neat, readable format with all
 * currency formatted to 2 decimal places.
 * <br>
 *
 * <hr>
 * Date created: 11/2/2015 <br>
 * Date last modified: 11/3/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 * Once you have all of the required order information, you should store that
 * information in an object of the CustomerOrder class using the appropriate
 * methods.  At that point, you can begin to process the order and display the
 * final bill to the user.  You may not do any calculations in your driver
 * program.  All of the functionality is provided in the CustomerOrder class.
 * You are to call the appropriate methods to get the information that you need
 * in order to display the bill to the customer. Once the program has displayed
 * the bill to the customer, it should ask the user if they would like to place
 * another order.  If they answer yes, your program should repeat from the
 * beginning.  This should continue until the user indicates that they have no
 * more orders to place.

 *
 * <hr>
 * @param String[] args - Command Line Arguments
 */
  public static void main(String[] args)
  {
    //***************************VARIABLE DECLARATIONS*************************
    //-------------------------------input by user-----------------------------
    char repeat = ' ';//to ask if user if they would like to repeat the program

    //*************************INPUT - PROCESSING - OUTPUT*********************
    //create new Scanner
    Scanner kb = new Scanner(System.in);

    //create currency decimal format
    DecimalFormat currency = new DecimalFormat("$ #, ##0.00");

    //create object of CustomerOrder class
    CustomerOrder google = new CustomerOrder();

    //start do while loop
    do{

    //clear the screen
    clearScreen();

    //Prompt for customer's name
    System.out.print("Please enter your last name. (If your name is less than 4 "
                 + "characters, \nplease enter X's after your name until it is"
                 + " 4 characters.)  ");
      //Set customer's name
      google.setCustomerName(kb.nextLine());

    //clear the screen
    clearScreen();

    //Prompt for customer's phone number
    System.out.print("Please enter your phone number in the format ###-####.  ");
      //Set customer's phone number
      google.setPhoneNum(kb.nextLine());

    //clear the screen
    clearScreen();

    //Prompt for number of gadgets the customer would like to buy
    System.out.print("Please enter the number of gadgets you would like to "
              +  "purchase.  ");
              //Set number of gadgets that the customer chose
              google.setNumGadgets(kb.nextInt());

    //clear the screen
    clearScreen();

    //Prompt for number of widgets the customer would like to buy

    System.out.print("Please enter the number of widgets you would like to "
              +  "purchase.  ");
              //Set number of widgets that the customer chose
              google.setNumWidgets(kb.nextInt());

    //clear the screen
    clearScreen();

    //Prompt customer for which discount they would like
    System.out.println("************************ Discount Menu *******************");
    System.out.println("0. No Discount");
    System.out.println("1. Loyalty discount");
    System.out.println("2. Employee discount ");
    System.out.print("Which discount would you like?(Enter 0,1, or 2) ");
      //Set customer's discount selection
      google.setDiscountCode(kb.nextInt());

    //flush input buffer
    kb.nextLine();

    //clear the screen
    clearScreen();

    //Prompt for customer's tax choice
    System.out.print("Is this order taxable? (Enter N for non-taxable orders"
                  +" and T for taxable orders)");
    //Set customer's tax choice
    google.setTaxCode(kb.nextLine().charAt(0));

    //clear the screen
    clearScreen();

    //Prompt customer for shipping choice
    System.out.print("What type of shipping would you like? (Enter O for overnight"
              +  " shipping, P for \npriority shipping, or S for "
              +  "standard shipping)");
    //Set customer's shipping choice
    google.setShippingCode(kb.nextLine().charAt(0));

    //Clear the screen
    clearScreen();

    //Display bill
    System.out.println("********************* Order Details *****************"
                     + "***********");
    System.out.println("   Customer Number: " + google.getCustomerNumber());
    System.out.println("   Customer Name  : " + google.getCustomerName());
    System.out.println("   Phone Number   : " + google.getPhoneNum());
    System.out.println("----------------------------------------------------"
                     + "------------");
    System.out.println("         # Gadgets: " + google.getNumGadgets());
    System.out.println("         # Widgets: " + google.getNumWidgets() + "\n");
    System.out.println("         Discount : " + currency.format(google.calcDiscount())
                    + "(" + google.translateDiscountCode() + ")");
    System.out.println("         Tax      : " + currency.format(google.calcTax())
                    + "(" + google.translateTaxCode() + ")");
    System.out.println("         Shipping : " + currency.format(google.calcShipping())
                    + "("+ google.translateShippingCode() + ")");
    System.out.println("         Total Due: " + currency.format(google.calcTotalDue()));
    System.out.println("****************************************************"
                    +  "************");
    System.out.print("Would you like to place another order?(Y or N) ");
        repeat = kb.nextLine().charAt(0);
    }while(repeat == 'Y' || repeat == 'y');
  }//end main


  /*****************************************************************************
 * Method Name: clearScreen <br>
 * Method Purpose: Method to clear the screen
 *
 * <br>
 *
 * <hr>
 * Date created: 11/3/2015 <br>
 * Date last modified: 11/3/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 */
  public static void clearScreen()
  {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }
}//end Project2
