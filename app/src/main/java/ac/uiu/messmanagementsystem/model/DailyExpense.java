package ac.uiu.messmanagementsystem.model;

import java.io.Serializable;

public class DailyExpense implements Serializable {
    private String name;
    private String items;
    private String date;
    private Double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DailyExpense(String name, String items, String date, Double amount) {

        this.name = name;
        this.items = items;
        this.date = date;
        this.amount = amount;
    }
}
