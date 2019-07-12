package com.example.instagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.instagram.fragment.ComposeFragment;
import com.example.instagram.fragment.ProfileFragment;
import com.example.instagram.fragment.TimelineFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                 switch(menuItem.getItemId()){
                     case R.id.action_home:
                         fragment = new TimelineFragment();
                         Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_LONG).show();
                         break;
                     case R.id.action_compose:
                         fragment = new ComposeFragment()
                         Toast.makeText(HomeActivity.this, "Compose", Toast.LENGTH_LONG).show();
                         break;
                     case R.id.action_profile:
                         fragment = new ProfileFragment();
                         Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_LONG).show();
                         break;
                     default:
                         fragment = new TimelineFragment();
                         Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_LONG).show();
                         break;
                 }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                 return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}
