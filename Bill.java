import java.io.*;

/**
 * This is the Bill class which implements the serializable interface so that
 * the data can be converted to a byte string and stored in .dat which is
 * more easily readable than other files. The bill object will store 3
 * variables, name, amount, and dueDate which is everything that I wanted this
 * program to keep track of. The class also consists of several getters and
 * setters for reusability.
 */
public class Bill implements Serializable {
    private String name;
    private double amount;
    private String dueDate;

    /**
     * Constructs a new Bill object
     * 
     * Parameters:
     * 
     * @param name    - the name of the bill item
     * @param amount  - the amount of the bill item
     * @param dueDate - the due date of the bill item
     */
    public Bill(String name, double amount, String dueDate) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    /**
     * Sets the bill name
     * 
     * @param name bill name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the bill amount
     * 
     * @param amount bill amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Sets the bill dueDate
     * 
     * @param dueDate bill dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the bill name
     * 
     * @return name bill name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the bill amount
     * 
     * @return amount bill amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the bill dueDate
     * 
     * @return dueDate bill dueDate
     */
    public String getDueDate() {
        return dueDate;
    }
}
