package ac.uiu.messmanagementsystem.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.model.FixedExpense;

public class FixedExpenseAdapter extends ArrayAdapter<FixedExpense> {
    Activity mContext;
    private ArrayList<FixedExpense> fixedExpenses;

    public FixedExpenseAdapter(ArrayList<FixedExpense> fe ,Activity con){
        super(con, android.R.layout.simple_list_item_1,fe);
        this.fixedExpenses = fe;
        this.mContext = con;
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View view = inflater.inflate(R.layout.fixed_exp_list, null, true);

        TextView tv_exp = view.findViewById(R.id.tv_list_exp);
        TextView tv_amount = view.findViewById(R.id.tv_list_amount);

        tv_exp.setText(fixedExpenses.get(position).getExpName());
        tv_amount.setText(fixedExpenses.get(position).getAmout().toString());

        return view;
    }
}
