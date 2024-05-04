import java.io.*;

public class Bill implements Serializable {
    private String name;
    private double amount;
    private String dueDate;

    public Bill(String name, double amount, String dueDate) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }
}
