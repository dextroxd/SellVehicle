package com.dextroxd.sellvehicle.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dextroxd.sellvehicle.R;


public class MyAdsFragment extends Fragment {


    public MyAdsFragment() {
        // Required empty public constructor
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;
            switch (menuItem.getItemId()){
                case R.id.my_Ads:
                    selectedFragment=new My_Published_ads_fragment();
                    break;
                case R.id.favorites:
                    selectedFragment=new favoritesFragment();
                    break;
            }
            getFragmentManager().beginTransaction().replace(R.id.frame_ad,selectedFragment).commit();
            return true;

        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_my_ads, container, false);
        BottomNavigationView bottomNavigationView =(BottomNavigationView)RootView.findViewById(R.id.nav_bar_1);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        

        // Inflate the layout for this fragment
        return RootView;
    }


}
