package ac.uiu.messmanagementsystem.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.interfaces.AddDailyExpListener;
import ac.uiu.messmanagementsystem.model.DailyExpense;

public class UpdateDailyExpDialog extends DialogFragment {

    private AddDailyExpListener listener;
    private int index =0;

    private Button btn_datepicker;
    private Spinner spinner_person;
    private EditText et_exp_name;
    private EditText et_exp_amount;
    private ArrayList<String> persons=new ArrayList<String>(
            Arrays.asList("Muhib","Sujon","Mainul","Liu")
            );


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        ViewGroup root;
        final View view = inflater.inflate(R.layout.daily_exp_dialog, null);


        btn_datepicker = view.findViewById(R.id.btn_exp_date);
        spinner_person = view.findViewById(R.id.spinner_person);
        et_exp_name = view.findViewById(R.id.et_exp_name);
        et_exp_amount = view.findViewById(R.id.et_exp_amount);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, persons);

        spinner_person.setAdapter(adapter);


        final Bundle bundle = getArguments();
        DailyExpense dailyExpense = (DailyExpense) bundle.getSerializable("dailyExp");

        et_exp_name.setText(dailyExpense.getItems());
        et_exp_amount.setText(dailyExpense.getAmount().toString());
        btn_datepicker.setText(dailyExpense.getDate());
        spinner_person.setSelection(persons.indexOf(dailyExpense.getName()));


        builder.setView(view)
                .setTitle("Edit Expense")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                })
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.updateExpList(bundle.getInt("id"),
                                et_exp_name.getText().toString(),
                                et_exp_amount.getText().toString(),
                                btn_datepicker.getText().toString(),
                                persons.get(index));
                    }
                });

        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        listener = (AddDailyExpListener) getTargetFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        spinner_person.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
