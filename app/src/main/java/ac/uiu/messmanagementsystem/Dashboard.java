package ac.uiu.messmanagementsystem;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import ac.uiu.messmanagementsystem.databinding.ActivityDashboardBinding;
import ac.uiu.messmanagementsystem.fragments.HomeFragment;
import ac.uiu.messmanagementsystem.fragments.dailyexpenses.DailyExpFragment;
import ac.uiu.messmanagementsystem.fragments.members.MemberHome;
import ac.uiu.messmanagementsystem.fragments.profile.ProfileFragment;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityDashboardBinding binding;
    private Toolbar toolbar;
    private DrawerLayout dl;
    private NavigationView nv;
    String url = "https://10.10.255.5/mess/mess_info.php";

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");
        parseMessInfo(username,password);
    }

    private void parseMessInfo(final String username, final String password) {


        JSONObject params = new JSONObject();
        try {
            params.put("username",username);
            params.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.POST, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.toString());
                    }
                }
        );
        GlobalData.getInstance().addToRequestQueue(request2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        toolbar = findViewById(R.id.dashboardToolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);

        binding.navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            binding.dl.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.nv_item_meal) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new HomeFragment()).commit();
            binding.dl.closeDrawers();

        } else if (menuItem.getItemId() == R.id.nv_item_members) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new MemberHome()).commit();
            binding.dl.closeDrawers();
        } else if (menuItem.getItemId() == R.id.nv_item_profile) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new ProfileFragment()).commit();
            binding.dl.closeDrawers();
        } else if (menuItem.getItemId() == R.id.nv_item_dailyEx) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new DailyExpFragment()).commit();
            binding.dl.closeDrawers();
        }

        return false;
    }
}
