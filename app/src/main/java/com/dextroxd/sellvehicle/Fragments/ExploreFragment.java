package com.dextroxd.sellvehicle.Fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

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
    private GridAdapter gridAdapter;
    private ArrayList<ModelCard>modelCards = new ArrayList<>();
    public ExploreFragment() {
        // Required empty public constructor
    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_explore, container, false);
        ImageButton filter_button =(ImageButton)view.findViewById(R.id.filter_button);
        filter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getActivity(), filterActivity.class);
                startActivity(in);
            }
        });
        gridView = view.findViewById(R.id.grid_view);
        gridAdapter = new GridAdapter(getContext(),modelCards);
        gridView.setAdapter(gridAdapter);
        getData();
        gridAdapter.notifyDataSetChanged();
        return view;

    }

    public void getData(){
        //For fetching image through url
//        ArrayList<String> imageurl = new ArrayList<>();
        ArrayList<String> cost = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<Boolean> like  = new ArrayList<>();
        ArrayList<String> location = new ArrayList<>();
        cost.add("234575345");
        cost.add("23453456");
        cost.add("9698529");
        cost.add("74128963");
        cost.add("85296374");
        cost.add("951753868442");
        cost.add("987456321");
        cost.add("123654789");
        title.add("Porsche cayenne diesel");
        title.add("Royal Enfield Bullet");
        title.add("Flats");
        title.add("dfghjklpoiuhgf");
        title.add("efivjndfvmdfv");
        title.add("diucjnsd");
        title.add("reifoemnvfm");
        title.add("asxsaoxsom");
        description.add("2013-52000Km.");
        description.add("2018-21000Km.");
        description.add("3BHK");
        description.add("8MARLA");
        description.add("ftgyuiopoiuhgf");
        description.add("ferfeergtrg");
        description.add("efrgtrtgrtg");
        description.add("efrgetgrtg");
        like.add(false);
        like.add(false);
        like.add(false);
        like.add(false);
        like.add(false);
        like.add(false);
        like.add(false);
        like.add(false);
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        location.add("SHYAM NAGAR, JAIPUR");
        for(int i=0;i<like.size();i++){
            modelCards.add(new ModelCard("",cost.get(i),title.get(i),like.get(i),description.get(i),location.get(i)));
        }
        gridAdapter.notifyDataSetChanged();

    }


}
