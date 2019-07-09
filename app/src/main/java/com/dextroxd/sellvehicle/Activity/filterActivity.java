package com.dextroxd.sellvehicle.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dextroxd.sellvehicle.Fragments.ExploreFragment;
import com.dextroxd.sellvehicle.Fragments.ExploreFragment_filter;
import com.dextroxd.sellvehicle.R;

public class filterActivity extends AppCompatActivity {
SeekBar seekBar;
SeekBar seekBar2;
SeekBar seekBar3;
TextView textView;
TextView textView12;
TextView textView14;
int max=50000;int min=1000;int current=10000;
int min2=2,max2=1000,current2=500;
int furnishing_type;//0 for furnished,1 for semi,2 for unfurnished
int for_gender;//0 for boys,1 for girls,2 for family,3 for other
    int bedroom_no;
    int max1=100,min1=0,current1=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        textView=(TextView)findViewById(R.id.textView);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);
        Button button6=(Button)findViewById(R.id.button6);
        Button button7=(Button)findViewById(R.id.button7);
        Button button12=(Button)findViewById(R.id.button12);
        Button button8=(Button)findViewById(R.id.button8);
        Button button9=(Button)findViewById(R.id.button9);
        Button button10=(Button)findViewById(R.id.button10);
        Button button11=(Button)findViewById(R.id.apply_filter_button);
        SeekBar seekBar2=(SeekBar)findViewById(R.id.seekBar2);
        SeekBar seekBar3=(SeekBar)findViewById(R.id.seekBar3);
        textView12=(TextView)findViewById(R.id.textView12);
        textView14=(TextView)findViewById(R.id.textView14);
        seekBar.setMax(max);
        seekBar.setProgress(current);
        textView.setText(""+current);
        seekBar2.setMax(max1);
        seekBar2.setProgress(current1);
        textView12.setText(current1+"km");
        seekBar3.setMax(max2);
        seekBar3.setProgress(current2);
        textView14.setText(""+current2+"months");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current=progress;
                textView.setText(""+"₹"+current);

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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for_gender=0;
                Toast toast=Toast.makeText(filterActivity.this,"Room for Boys",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for_gender=1;
                Toast toast=Toast.makeText(filterActivity.this,"Room for Girls",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for_gender=2;
                Toast toast=Toast.makeText(filterActivity.this,"Room for Family ",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bedroom_no=1;
                Toast toast=Toast.makeText(filterActivity.this,"1 Bedroom",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bedroom_no=2;
                Toast toast=Toast.makeText(filterActivity.this,"2 Bedroom",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bedroom_no=3;
                Toast toast=Toast.makeText(filterActivity.this,"3 Bedroom",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bedroom_no=4;
                Toast toast=Toast.makeText(filterActivity.this,"4+ Bedroom",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for_gender=3;
                Toast toast=Toast.makeText(filterActivity.this,"Other",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current1=progress;
                textView12.setText(""+current1+"km");
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
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current2=progress;
                textView14.setText(""+current2+"months");
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
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                furnishing_type=0;
                Toast toast=Toast.makeText(filterActivity.this,"Furnished Selected",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                furnishing_type=1;
                Toast toast=Toast.makeText(filterActivity.this,"Semi Selected",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                furnishing_type=2;
                Toast toast=Toast.makeText(filterActivity.this,"Unfurnished Selected",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(filterActivity.this,"Filters Applied!",Toast.LENGTH_SHORT);
                toast.show();
                Intent in=new Intent(filterActivity.this, ExploreFragment.class);
                startActivity(in);
            }
        });


    }
}
