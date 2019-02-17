package ac.uiu.messmanagementsystem.fragments.members;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.databinding.ActivityAddMemberBinding;
import ac.uiu.messmanagementsystem.serializable.Member;

public class AddMemberActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActivityAddMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_member);

        toolbar = findViewById(R.id.addmember_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Member");

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.etAddMemberName.getText().toString();
                String email = binding.etAddMemberEmail.getText().toString();
                String phone = binding.etAddMemberPhone.getText().toString();
                Double balance;
                Integer img;
                if (binding.etAddMemberBalance.getText().toString().isEmpty()) {
                    balance = 0.0;
                } else {
                    balance = Double.parseDouble(binding.etAddMemberBalance.getText().toString());
                }

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
                    Intent resultIntent = new Intent();
                    Member member = new Member(name, email, phone, balance);
                    resultIntent.putExtra("dataObject", member);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
