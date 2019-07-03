package com.dextroxd.sellvehicle.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dextroxd.sellvehicle.Fragments.MyAdsFragment;
import com.dextroxd.sellvehicle.R;
import com.dextroxd.sellvehicle.Fragments.ChatsFragment;
import com.dextroxd.sellvehicle.Fragments.ExploreFragment;
import com.dextroxd.sellvehicle.Fragments.MyAccountFragment;
import com.dextroxd.sellvehicle.Fragments.SellFragment;

public class MainActivity extends AppCompatActivity {
    //Bottom Navigation Bar and its navigator
    //Just to select the various fragments associated with the navigation bar ©Dextroxd(DIVYANSHU)


    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            android.support.v4.app.Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.explore:
                    selectedFragment = new ExploreFragment();
                    break;
                case R.id.chats:
                    selectedFragment = new ChatsFragment();
                    break;
                case R.id.sell:
                    selectedFragment = new SellFragment();
                    break;
                case R.id.myads:
                    selectedFragment = new MyAdsFragment();
                    break;
                case R.id.myaccount:
                    selectedFragment = new MyAccountFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment).commit();
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ExploreFragment()).commit();
    }


}
