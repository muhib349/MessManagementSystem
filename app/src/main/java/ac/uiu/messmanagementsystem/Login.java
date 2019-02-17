package ac.uiu.messmanagementsystem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONStringer;

import java.net.Authenticator;
import java.util.HashMap;
import java.util.Map;

import ac.uiu.messmanagementsystem.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ActivityLoginBinding binding;
    String url =GlobalData.domainName+"login.php";
    private GlobalData gd = GlobalData.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.btnLogin.setOnClickListener(this);
        binding.tvCreateAccount.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            String username = binding.etUsername.getText().toString();
            String password = binding.etPassword.getText().toString();

            startActivity(new Intent(getApplicationContext(),Dashboard.class));
            /*if (!username.isEmpty() && !password.isEmpty()) {
                parseRequest(username, password);
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }*/
        }
    }


    private void parseRequest(final String username, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("success")){
                            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                            intent.putExtra("username",username);
                            intent.putExtra("password",password);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        };

        gd.addToRequestQueue(request);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.tvCreateAccount) {
            startActivity(new Intent(getApplicationContext(), Registration.class));
        }
        return false;
    }

}
