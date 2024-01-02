package com.rashid.myapps;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavView;
    HomeFragment homeFragment = HomeFragment.newInstance(null, null);
    CalculateFragment calculateFragment = CalculateFragment.newInstance(null, null);
    AccountFragment accountFragment = AccountFragment.newInstance(null, null);
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavView = findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new AlertDialog.Builder(this).setTitle("Welcome~").setMessage("Welcome to myapps. Please use the application well and apologize for some unresolved bugs.").setIcon(R.drawable.user).setNeutralButton("OK", null).create().show();


        Map<Integer, Fragment> fragments = new HashMap<>();
        fragments.put(R.id.home, homeFragment);
        fragments.put(R.id.calcule, calculateFragment);
        fragments.put(R.id.account, accountFragment);

        bottomNavView.setOnItemSelectedListener(item -> {
            Fragment fragment = fragments.get(item.getItemId());
            if(fragment == null) return false;
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        });
    }
}

