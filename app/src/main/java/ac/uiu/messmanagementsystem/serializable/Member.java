package ac.uiu.messmanagementsystem.serializable;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private String email;
    private String Phone;
    private Double Balance;

    public Member(String name, String email, String phone, Double balance) {
        this.name = name;
        this.email = email;
        Phone = phone;
        Balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }
}
