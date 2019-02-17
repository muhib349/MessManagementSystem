package ac.uiu.messmanagementsystem.fragments.dailyexpenses;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.adapters.DailyExpAdapter;
import ac.uiu.messmanagementsystem.dialog.AddDailyExpDialog;
import ac.uiu.messmanagementsystem.dialog.UpdateDailyExpDialog;
import ac.uiu.messmanagementsystem.interfaces.AddDailyExpListener;
import ac.uiu.messmanagementsystem.model.DailyExpense;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyExpFragment extends Fragment implements AddDailyExpListener {

    private ListView lv_dailyexp_list;
    private DailyExpAdapter customAdapter;
    private FloatingActionButton fab_add_dailyexp;

    private ArrayList<DailyExpense> dailyExpenses = new ArrayList<DailyExpense>();


    public DailyExpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_exp, container, false);

        getActivity().setTitle("Daily Expenses");

        lv_dailyexp_list = view.findViewById(R.id.lv_dailyexp_list);
        fab_add_dailyexp = view.findViewById(R.id.fab_add_dailyexp);

        customAdapter = new DailyExpAdapter(dailyExpenses, getActivity());
        lv_dailyexp_list.setAdapter(customAdapter);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        fab_add_dailyexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        lv_dailyexp_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                DailyExpense de = (DailyExpense)parent.getItemAtPosition(position);

                Bundle args = new Bundle();
                args.putInt("id",position);
                args.putSerializable("dailyExp",de);
                openUpdateDialog(args);

                return false;
            }
        });
    }

    private void openUpdateDialog(Bundle args) {

        UpdateDailyExpDialog upExp = new UpdateDailyExpDialog();
        upExp.setTargetFragment(this,1);
        upExp.setArguments(args);
        upExp.show(getFragmentManager(),"Update Expense");
        upExp.setCancelable(false);
    }

    private void openDialog() {
        AddDailyExpDialog addDailyExpDialog = new AddDailyExpDialog();
        addDailyExpDialog.setTargetFragment(this,0);
        addDailyExpDialog.show(getFragmentManager(),"Add Expense");
        addDailyExpDialog.setCancelable(false);
    }

    @Override
    public void applyText(String exp_name, String amount,String date,String person) {
        dailyExpenses.add(new DailyExpense(person,exp_name,date,Double.parseDouble(amount)));
        customAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(),"Expense Added Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateExpList(int position, String ex_name, String amount, String date, String person) {
        dailyExpenses.remove(position);
        dailyExpenses.add(position,new DailyExpense(person,ex_name,date,Double.valueOf(amount)));
        customAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(),"Expense Updated Successfully",Toast.LENGTH_SHORT).show();
    }
}
