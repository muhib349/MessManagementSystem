package ac.uiu.messmanagementsystem.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.fragments.dailyexpenses.DailyExpFragment;
import ac.uiu.messmanagementsystem.interfaces.AddDailyExpListener;

public class AddDailyExpDialog extends DialogFragment {

    private AddDailyExpListener listener;
    private EditText et_exp_name;
    private EditText et_exp_amount;
    private static Button btn_datepicker;
    private Spinner spinner_person;
    private String[] persons= {"Muhib","Sujon","Mainul","Liu"};
    private int index=0;
    private Context context;

    private static boolean isDateSelected = false;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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


        builder.setView(view)
                .setTitle("Add Expense")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(isDateSelected && !et_exp_name.getText().toString().isEmpty() && !et_exp_amount.getText().toString().isEmpty()){


                            listener.applyText(et_exp_name.getText().toString(),
                                    et_exp_amount.getText().toString(),
                                    btn_datepicker.getText().toString(),
                                    persons[index]);
                        }
                        dismiss();
                    }
                });

        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

         listener = (AddDailyExpListener) getTargetFragment();
    }



    public static class showCalender extends DialogFragment implements DatePickerDialog

            .OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int actualMonth = month + 1;
            btn_datepicker.setText(dayOfMonth + "/" + actualMonth + "/" + year);
            isDateSelected = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();


        btn_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new showCalender();
                fragment.show(getFragmentManager(), "Select Date");
            }
        });


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
