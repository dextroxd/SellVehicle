package com.dextroxd.sellvehicle.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dextroxd.sellvehicle.R;

/*
rent_seekbar for rent, Duration_seekbar for duration of stay, distance_seekbar for distance from location


text_rent ---to give the selected rent from rent_seekbar
text_duration--- to give selected duration of stay for duration_seekbar
text_distance ---to give distance from location from distance_Seekbar

radio_housefor----radio group related to house for..
selected_housefor-----use this to get the option selected by user related to house for.
selected_housefor==1 for boys
selected_housefor==2 for girls
selected_housefor==3 for family
selected_housefor==4 for other


radio_bedroom---radio group related to bedroom..
selected_bedroom----option selected by user related to no of bedroom
selected_bedroom==1 for 1 bedroom
selected_bedroom==2 for 2 bedroom
selected_bedroom==3 for 3 bedroom
selected_bedroom==4 for 4+ bedroom


radio_furnishing----radio group related to furnishing
selected_furnishing-----option selected by user related to furnishing
selected_furnishing==1 for unfurnished
selected_furnishing==2 for semi furnished
selected_furnishing==3 for fully furnished


 */
public class filterActivity extends AppCompatActivity {
SeekBar rent_seekbar,duration_seekbar,distance_seekbar;
TextView text_rent,text_duration,text_distance;
int max=50000;int min=1000;int current=10000;// max , min,current are related to rent_seekbar
int min2=2,max2=60,current2=30;//min2,max2,current2 are related to duration_seekbar
int max1=100,min1=0,current1=50;//max1,min1,current1 are related to distance_Seekbar
int selected_housefor=0,selected_bedroom=0,selected_furnishing=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);


        text_rent=(TextView)findViewById(R.id.textView);
        rent_seekbar=(SeekBar)findViewById(R.id.seekBar);
        distance_seekbar=(SeekBar)findViewById(R.id.seekBar2);
       duration_seekbar=(SeekBar)findViewById(R.id.seekBar3);
        text_distance=(TextView)findViewById(R.id.textView12);
        text_duration=(TextView)findViewById(R.id.textView14);
        rent_seekbar.setMax(max);
        rent_seekbar.setProgress(current);
        text_rent.setText(""+current);
        distance_seekbar.setMax(max1);
        distance_seekbar.setProgress(current1);
        text_distance.setText(current1+"km");
        duration_seekbar.setMax(max2);
        duration_seekbar.setProgress(current2);
        text_duration.setText(""+current2+"months");

        rent_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current=progress;
                text_rent.setText(""+"₹"+current);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast toast=Toast.makeText(filterActivity.this,"Range selected from ₹1000 to ₹"+current,Toast.LENGTH_SHORT);
                toast.show();



            }
        });

        distance_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current1=progress;
                text_distance.setText(""+current1+"km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast toast=Toast.makeText(filterActivity.this,"Range selected from 0km to "+current1+"km",Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        duration_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current2=progress;
                text_duration.setText(""+current2+"months");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast toast=Toast.makeText(filterActivity.this,current2+"months",Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        RadioGroup radio_housefor = (RadioGroup)findViewById(R.id.radiogroup);
        radio_housefor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.boys){
                    selected_housefor=1;
                    Toast toast=Toast.makeText(filterActivity.this,"Boys selected",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(checkedId==R.id.girls){
                    selected_housefor=2;
                    Toast toast=Toast.makeText(filterActivity.this,"Girls selected",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(checkedId==R.id.family){
                    selected_housefor=3;
                    Toast toast=Toast.makeText(filterActivity.this,"Family selected",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    selected_housefor=4;
                    Toast toast=Toast.makeText(filterActivity.this,"Other",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        RadioGroup radio_bedroom = (RadioGroup)findViewById(R.id.radiogroup2);
        radio_bedroom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.one){
                    selected_bedroom=1;
                    Toast toast=Toast.makeText(filterActivity.this,"1 BHK",Toast.LENGTH_SHORT);
                    toast.show();

                }
                else if(checkedId==R.id.two){
                    selected_bedroom=2;
                    Toast toast=Toast.makeText(filterActivity.this,"2 BHK",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(checkedId==R.id.three){
                    selected_bedroom=3;
                    Toast toast=Toast.makeText(filterActivity.this,"3 BHK",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    selected_bedroom=4;
                    Toast toast=Toast.makeText(filterActivity.this,"4+ BHK",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        RadioGroup radio_furnishing = (RadioGroup)findViewById(R.id.radiogroup3);
        radio_furnishing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.unfurnished){
                    selected_furnishing=1;
                    Toast toast=Toast.makeText(filterActivity.this,"Unfurnished",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(checkedId==R.id.semifurnished){
                    selected_furnishing=2;
                    Toast toast=Toast.makeText(filterActivity.this,"Semi Furnished",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    selected_furnishing=3;
                    Toast toast=Toast.makeText(filterActivity.this,"Fully Furnished",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}
