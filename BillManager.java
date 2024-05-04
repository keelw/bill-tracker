import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BillManager {
    private ArrayList<Bill> bills = new ArrayList<>();

    public void addBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bill name: ");
        String name = scanner.nextLine();

        System.out.print("Enter bill amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.next();

        // Create a new bill object
        Bill newBill = new Bill(name, amount, dueDate);

        // Add the new bill to the list
        bills.add(newBill);

        System.out.println("New bill added successfully.");
        scanner.close();
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void editBill(int index) {
        if (index >= 0 && index < bills.size()) {
            Scanner scanner = new Scanner(System.in);
            Bill bill = bills.get(index);

            System.out.println("Editing bill: " + bill.getName());
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new amount: ");
            double newAmount = scanner.nextDouble();
            System.out.print("Enter new due date: ");
            String newDueDate = scanner.next();

            // Update bill details
            bill.setName(newName);
            bill.setAmount(newAmount);
            bill.setDueDate(newDueDate);

            scanner.close();

            System.out.println("Bill updated successfully.");
        } else {
            System.out.println("Invalid bill index.");
        }
    }

    public void deleteBill(int index) {
        if (index >= 0 && index < bills.size()) {
            Bill deletedBill = bills.remove(index);
            System.out.println("Deleted bill: " + deletedBill.getName());
        } else {
            System.out.println("Invalid bill index.");
        }
    }

    public void saveToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bills);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
