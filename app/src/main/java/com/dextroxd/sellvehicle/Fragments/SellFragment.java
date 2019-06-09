package com.dextroxd.sellvehicle.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.dextroxd.sellvehicle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {



    public SellFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        final EditText editText_project=(EditText)view.findViewById(R.id.id_project);
        final TextView textView_count=(TextView)view.findViewById(R.id.id_count);
        final  EditText editText_ad=(EditText)view.findViewById(R.id.id_Ad);
        final TextView textView_ad=(TextView)view.findViewById(R.id.id_count_ad);

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