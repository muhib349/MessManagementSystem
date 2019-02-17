package ac.uiu.messmanagementsystem.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.model.DailyExpense;

public class DailyExpAdapter extends ArrayAdapter<DailyExpense> {

    private Activity context;
    private ArrayList<DailyExpense> dailyExpenses;


    public DailyExpAdapter(ArrayList<DailyExpense> dailyExpenses, Activity con) {
        super(con, android.R.layout.simple_list_item_1,dailyExpenses);
        this.context = con;
        this.dailyExpenses = dailyExpenses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.daily_exp_list, null, true);

        TextView name = view.findViewById(R.id.tv_dailyexp_name);
        TextView item_details = view.findViewById(R.id.tv_dailyexp_item);
        TextView date = view.findViewById(R.id.tv_dailyexp_date);
        TextView balance = view.findViewById(R.id.tv_dailyexp_amount);

        name.setText(dailyExpenses.get(position).getName());
        item_details.setText(dailyExpenses.get(position).getItems());
        date.setText(dailyExpenses.get(position).getDate());
        balance.setText(dailyExpenses.get(position).getAmount().toString());
        return view;
    }
}
