package com.dextroxd.sellvehicle.cardActivity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dextroxd.sellvehicle.R;

public class cardActivity extends AppCompatActivity {
    MyCustomPagerAdapter myCustomPagerAdapter;
    ViewPager viewPager;
    TextView cost_sell,bedroom_sell,size_sell;
    String cost,bedroom,size;
    int images[]={R.drawable.black_background,R.drawable.ic_person_black_60dp,R.drawable.background_,R.drawable.ic_location_on_white_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card2);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        Intent in=getIntent();
        cost=in.getStringExtra("cost");
        bedroom=in.getStringExtra("bedroom");
        size=in.getStringExtra("size");
        Log.e("value",cost);
        cost_sell=findViewById(R.id.cost_sell);
        bedroom_sell=findViewById(R.id.bedroom_sell);
        size_sell=findViewById(R.id.size_sell);
        cost_sell.setText(cost);
        bedroom_sell.setText("Bedroom "+bedroom);
        size_sell.setText("Built Up Area "+size);
        myCustomPagerAdapter = new MyCustomPagerAdapter(cardActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

    }
}
