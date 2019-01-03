package ac.uiu.messmanagementsystem.model;

public class FixedExpense {
    private String expName;
    private Integer amout;


    public FixedExpense(String expName, int amout) {
        this.expName = expName;
        this.amout = amout;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
}
