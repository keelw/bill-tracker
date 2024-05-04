import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the entry point to the program. The main class will
 * be the driver.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BillManager manager = new BillManager(); // Create a new BillManager object
        Scanner myScanner = new Scanner(System.in); // Create a new Scanner object
        boolean isRunning = true; // Declare and initialize the isRunning variable

        // Allows the user to quit the program by changing isRunning to false.
        while (isRunning == true) {
            // Prompt the user for an action
            System.out.println(
                    "What would you like to do?\n\t1. Load Bills\n\t2. Display Bills\n\t3. Add Bill\n\t4. Edit a Bill\n\t5. Delete Bill\n\t6. Quit");
            // Gather data from user
            String userChoice = myScanner.nextLine();

            // Check if they entered a correct value
            if (!userChoice.isEmpty()) {
                // Use a switch statement to determine the outcome of the user choice
                switch (Integer.valueOf(userChoice)) {
                    case 1: // Load the file

                        manager.loadFromFile("bills.dat");
                        break;
                    case 2: // List the objects in the file
                        ArrayList<Bill> bills = manager.getBills();

                        // Loop through objects in the file and display them to the user
                        for (Bill bill : bills) {
                            System.out.println("Bill Name: " + bill.getName());
                            System.out.println("Amount: " + bill.getAmount());
                            System.out.println("Due Date: " + bill.getDueDate());
                            System.out.println(); // Add a newline for readabi
                        }
                        break;
                    case 3: // Add a bill to the file
                        manager.addBill(myScanner);

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        myScanner.nextLine();
                        break;
                    case 4: // Edit a bill
                        System.out.print("Enter the index of the bill you want to edit: ");
                        int index = myScanner.nextInt();
                        myScanner.nextLine();

                        manager.editBill(index, myScanner);

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        myScanner.nextLine();
                        break;
                    case 5: // Delete a bill
                        System.out.print("Enter the index of the bill you want to delete: ");
                        int deleteIndex = myScanner.nextInt();
                        myScanner.nextLine(); // Consume newline character

                        // Delete the bill
                        manager.deleteBill(deleteIndex - 1);

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        break;
                    case 6: // Quit the program
                        System.out.println("Happy bill paying! Goodbye.");
                        isRunning = false;
                        break;
                    default:
                        break;
                }
            } else {
                // Display an error to the user if necessary
                System.out.println("Invalid input. Please enter a valid choice.");
                myScanner.nextLine();
            }
        }
        myScanner.close(); // Close the scanner object
    }
}