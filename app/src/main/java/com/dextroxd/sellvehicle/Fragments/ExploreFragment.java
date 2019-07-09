package com.dextroxd.sellvehicle.Fragments;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

import com.dextroxd.sellvehicle.Activity.DBHelper;
import com.dextroxd.sellvehicle.Activity.filterActivity;
import com.dextroxd.sellvehicle.Adapter.GridAdapter;
import com.dextroxd.sellvehicle.Model.ModelCard;
import com.dextroxd.sellvehicle.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {

    private GridView gridView;
    private Drawable filter_button;
    String cost, bedroom, furnishing;
    DBHelper myDB;
    private GridAdapter gridAdapter;
    private ArrayList<ModelCard> modelCards=new ArrayList<>();

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_explore, container, false);
        gridView = view.findViewById(R.id.grid_view);
        gridAdapter = new GridAdapter(view.getContext(), R.layout.cardsofsale, modelCards);
        myDB=new DBHelper(view.getContext());
        gridView.setAdapter(gridAdapter);
        ImageButton filter_button =(ImageButton)view.findViewById(R.id.filter_button);
        filter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), filterActivity.class);
                startActivity(in);
            }
        });

        Cursor data = myDB.getData("SELECT * FROM status_table");
        while (data.moveToNext()) {
            cost = data.getString(1);
            bedroom = data.getString(2);
            furnishing = data.getString(3);

            modelCards.add(new ModelCard(cost, bedroom, furnishing));
        }

        gridAdapter.notifyDataSetChanged();
        return view;

    }



   /* public void getData() {
        String cost1,bedroom1,furnishing1;
        //For fetching image through url
//        ArrayList<String> imageurl = new ArrayList<>();
        ArrayList<String> cost = new ArrayList<>();
        ArrayList<String> bedroom = new ArrayList<>();
        ArrayList<String> furnishing = new ArrayList<>();
        //ArrayList<Boolean> like = new ArrayList<>();
       // ArrayList<String> location = new ArrayList<>();
        Cursor data=myDB.getListContents1();
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{

                    cost1=data.getString(1);
                    bedroom1=data.getString(2);
                    furnishing1=data.getString(3);

                    cost.add(cost1);
                    bedroom.add(bedroom1);
                    furnishing.add(furnishing1);


                }while (data.moveToNext());
            }
        }
        for (int i = 0; i < cost.size(); i++) {
            modelCards.add(new ModelCard(cost.get(i), bedroom.get(i), furnishing.get(i)));

            gridAdapter.notifyDataSetChanged();

        }


    }*/
}
