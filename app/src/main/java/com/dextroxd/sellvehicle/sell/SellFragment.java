package com.dextroxd.sellvehicle.sell;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dextroxd.sellvehicle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {
    EditText bedroooms,furnishing,rent;

    String final_furnishing;
    String  final_rent,final_bedroom;
    Button submit_button;


    public SellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_sell, container, false);
         final EditText editText_project=(EditText)view.findViewById(R.id.id_project);
        final TextView textView_count=(TextView)view.findViewById(R.id.id_count);
          final EditText editText_ad=(EditText)view.findViewById(R.id.id_Ad);
         final TextView textView_ad=(TextView)view.findViewById(R.id.id_count_ad);
        bedroooms=(EditText)view.findViewById(R.id.id_bedrooms);
        furnishing=(EditText)view.findViewById(R.id.id_furnishing);
        rent=(EditText)view.findViewById(R.id.id_maintenance);
        submit_button=(Button)view.findViewById(R.id.id_submit);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final_bedroom=bedroooms.getText().toString();
                final_furnishing=furnishing.getText().toString();
                final_rent=rent.getText().toString();


            }
        });

        editText_project.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text=editText_project.getText().toString();
                int symbol=text.length();
                textView_count.setText(""+symbol+"/400");


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editText_ad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text=editText_ad.getText().toString();
                int symbol=text.length();
                textView_ad.setText(""+symbol+"/400");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        // Inflate the layout for this fragment
        return view;


    }

}