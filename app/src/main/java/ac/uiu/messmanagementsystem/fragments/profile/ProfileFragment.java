package ac.uiu.messmanagementsystem.fragments.profile;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.adapters.FixedExpenseAdapter;
import ac.uiu.messmanagementsystem.model.FixedExpense;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private ArrayList<FixedExpense> fixedExpenses;
    private Button btn_add,btn_save;
    private EditText et_expName,et_title,et_email,et_username,et_members,et_rooms;
    private EditText et_amount;
    private FixedExpenseAdapter adapter;
    private FloatingActionButton fab_edit;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        getActivity().setTitle("Mess Information");
        ListView lv = view.findViewById(R.id.lv_exp);
        btn_add = view.findViewById(R.id.btn_pro_add);
        et_expName = view.findViewById(R.id.et_pro_expName);
        et_amount = view.findViewById(R.id.et_pro_amount);
        fab_edit =view.findViewById(R.id.fab_profile);

        et_title = view.findViewById(R.id.et_pro_title);
        et_email = view.findViewById(R.id.et_pro_email);
        et_username = view.findViewById(R.id.et_pro_username);
        et_members = view.findViewById(R.id.et_pro_member);
        et_rooms = view.findViewById(R.id.et_pro_rooms);
        btn_save = view.findViewById(R.id.btn_pro_save);


        fixedExpenses = new ArrayList<FixedExpense>();
        fixedExpenses.add(new FixedExpense("Rent",20000));
        adapter = new FixedExpenseAdapter(fixedExpenses,getActivity());
        lv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_pro_add && !et_expName.getText().toString().isEmpty() && !et_amount.getText().toString().isEmpty()){
                    adapter.add(new FixedExpense(et_expName.getText().toString(),Integer.parseInt(et_amount.getText().toString())));
                    adapter.notifyDataSetChanged();
                    et_amount.setText("");
                    et_expName.setText("");
                }
            }
        });


        fab_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_title.setEnabled(true);
                et_email.setEnabled(true);
                et_members.setEnabled(true);
                et_rooms.setEnabled(true);
                btn_save.setEnabled(true);
            }
        });
    }
}
