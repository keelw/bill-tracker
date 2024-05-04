import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the BillManager class which allows the user/program to:
 * - Store bill objects in an ArrayList of Bills
 * - Add bills to the list
 * - Return a list of the bills
 * - Edit existing bills that are loaded from a file
 * - Delete bills from the list loaded from a file
 * - Load bills from a file
 * - Save a list of bills to a file
 */
public class BillManager {
    private ArrayList<Bill> bills = new ArrayList<>();

    /**
     * This function gathers input from the user to add a bill
     * to the list of bills by using the add function in the
     * bills class.
     * 
     * @param scanner - the scanner object from main
     * @return - none
     */
    public void addBill(Scanner scanner) {
        System.out.print("Enter bill name: "); // Gather user input
        String name = scanner.nextLine(); // Store user input

        System.out.print("Enter bill amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.next();

        // Create a new bill object
        Bill newBill = new Bill(name, amount, dueDate);

        // Add the new bill to the list
        bills.add(newBill);

        // Output to user that it worked
        System.out.println("New bill added successfully.");
    }

    /**
     * This is a getter for the list of bills being stored locally in the
     * BillManager object
     * 
     * @return - the list of bills
     */
    public ArrayList<Bill> getBills() {
        return bills;
    }

    /**
     * This function is to edit bill information. The index of
     * the bill item is passed in by the user and then the new
     * information that the user wants to use is passed in and
     * the bill item is updated.
     * 
     * @param index   - the index of the bill item to be edited
     * @param scanner - the scanner object from main
     * @return - none
     */
    public void editBill(int index, Scanner scanner) {
        if (index >= 0 && index < bills.size()) {
            Bill bill = bills.get(index); // Get the bill object

            // Prompt and gather information from the user
            System.out.println("Editing bill: " + bill.getName());
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new amount: ");
            double newAmount = scanner.nextDouble();
            System.out.print("Enter new due date: ");
            String newDueDate = scanner.next();

            // Update bill details using getters/setters
            bill.setName(newName);
            bill.setAmount(newAmount);
            bill.setDueDate(newDueDate);

            // Advise user of success or failure
            System.out.println("Bill updated successfully.");
        } else {
            System.out.println("Invalid bill index.");
        }
    }

    /**
     * This function is to delete bill information. The index of
     * the bill item is passed in by the user and the bill item
     * is deleted.
     * 
     * @param index - the index of the bill item to be deleted
     * @return - none
     */
    public void deleteBill(int index) {
        if (index >= 0 && index < bills.size()) {
            Bill deletedBill = bills.remove(index);
            System.out.println("Deleted bill: " + deletedBill.getName());
        } else {
            System.out.println("Invalid bill index.");
        }
    }

    /**
     * This function is to save the list of bills to a file. The
     * parameter passed in to the function is the filename of the
     * file to be written to.
     * 
     * If no file exists then a new file will be written to.
     * 
     * @param filename
     * @return - none
     */
    public void saveToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename); // A new FileOutputStream object is created
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // A new ObjectOutputStream is created
            objectOut.writeObject(bills); // Writes the bills to the file
            objectOut.close(); // Close fileOut object
            fileOut.close(); // Close objectOut object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function is to load a list of bills from a file. The
     * parameter passed in to the function is the filename of the
     * file to be written to.
     * 
     * If the filename does not exist then an exception will be
     * thrown.
     * 
     * @param filename - the name of the file to be loaded into the program
     * @throws ClassNotFoundException - if the file is not found
     */
    // Supresses a warning since no objects will ever be cast to an ArrayList<Bill>
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            bills = (ArrayList<Bill>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
