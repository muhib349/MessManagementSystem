package ac.uiu.messmanagementsystem.interfaces;

public interface AddDailyExpListener {
    void applyText(String ex_name,String amount,String date,String person);
    void updateExpList(int position,String ex_name,String amount,String date,String person);
}
