package ac.uiu.messmanagementsystem.model;

public class MemberModel {
    private String name;
    private Integer img;
    private String email;
    private String phone;
    private Double balance;

    public MemberModel(String name, Integer img, String email, String phone, Double balance) {
        this.name = name;
        this.img = img;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
