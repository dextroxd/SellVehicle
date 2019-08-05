package com.dextroxd.sellvehicle.my_account;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dextroxd.sellvehicle.Activity.viewEditProfile;
import com.dextroxd.sellvehicle.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {
    TextView viewProfile;


    public MyAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_my_account, container, false);
        viewProfile=view.findViewById(R.id.id_viewProfile);
        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(view.getContext(), viewEditProfile.class);
                startActivity(in);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
