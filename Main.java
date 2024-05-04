import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BillManager manager = new BillManager();
        Scanner myScanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning == true) {
            System.out.println(
                    "What would you like to do?\n\t1. Load Bills\n\t2. Display Bills\n\t3. Add Bill\n\t4. Edit a Bill\n\t5. Delete Bill\n\t6. Quit");
            String userChoice = myScanner.nextLine();

            if (!userChoice.isEmpty()) {
                switch (Integer.valueOf(userChoice)) {
                    case 1:
                        manager.loadFromFile("bills.dat");
                        break;
                    case 2:
                        ArrayList<Bill> bills = manager.getBills();

                        for (Bill bill : bills) {
                            System.out.println("Bill Name: " + bill.getName());
                            System.out.println("Amount: " + bill.getAmount());
                            System.out.println("Due Date: " + bill.getDueDate());
                            System.out.println(); // Add a newline for readabi
                        }
                        break;
                    case 3:
                        manager.addBill();

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        break;
                    case 4:
                        System.out.print("Enter the index of the bill you want to edit: ");
                        int index = myScanner.nextInt();
                        myScanner.nextLine();

                        manager.editBill(index);

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        break;
                    case 5:
                        System.out.print("Enter the index of the bill you want to delete: ");
                        int deleteIndex = myScanner.nextInt();
                        myScanner.nextLine(); // Consume newline character

                        // Delete the bill
                        manager.deleteBill(deleteIndex - 1);

                        // Save bills to file
                        manager.saveToFile("bills.dat");
                        break;
                    case 6:
                        System.out.println("Happy bill paying! Goodbye.");
                        isRunning = false;
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
            }
        }
        myScanner.close();
    }
}