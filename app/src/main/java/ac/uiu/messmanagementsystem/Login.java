package ac.uiu.messmanagementsystem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import ac.uiu.messmanagementsystem.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.btnLogin.setOnClickListener(this);
        binding.tvCreateAccount.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
     if(v.getId() == R.id.btnLogin){


         startActivity(new Intent(getApplicationContext(),Dashboard.class));
     }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.tvCreateAccount){
            startActivity(new Intent(getApplicationContext(),Registration.class));
        }
        return false;
    }

}
