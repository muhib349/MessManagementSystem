package ac.uiu.messmanagementsystem;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ac.uiu.messmanagementsystem.databinding.ActivityDashboardBinding;
import ac.uiu.messmanagementsystem.fragments.HomeFragment;
import ac.uiu.messmanagementsystem.fragments.members.MemberHome;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityDashboardBinding binding;
    private Toolbar toolbar;

    private DrawerLayout dl;
    private NavigationView nv;

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

        if (menuItem.getItemId() == R.id.nv_item_dailyEx) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new HomeFragment()).commit();
            binding.dl.closeDrawers();

        } else if (menuItem.getItemId() == R.id.nv_item_members) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frDashboard, new MemberHome()).commit();
            binding.dl.closeDrawers();
        }

        return false;
    }
}
