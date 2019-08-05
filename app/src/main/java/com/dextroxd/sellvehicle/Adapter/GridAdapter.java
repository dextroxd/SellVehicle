package com.dextroxd.sellvehicle.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.dextroxd.sellvehicle.Image_fetching.ImageFetching;
import com.dextroxd.sellvehicle.Model.ModelCard;
import com.dextroxd.sellvehicle.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<ModelCard> {
    private ArrayList<ModelCard>a1=new ArrayList<>();
    private TextView cost,bedroom,furnishing;
    private ImageView image_house;
    private Context context;

    public GridAdapter(@NonNull Context context, @NonNull ArrayList<ModelCard> objects) {
        super(context,0, objects);
        this.context = context;

    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View GridItemView = convertView;

        if (GridItemView == null) {
            GridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cardsofsale, parent, false);
        }

        final ModelCard modelCard = getItem(position);
        cost=GridItemView.findViewById(R.id.cost_sell);
        bedroom=GridItemView.findViewById(R.id.bedroom_sell);
        furnishing=GridItemView.findViewById(R.id.size_sell);
        image_house=GridItemView.findViewById(R.id.imageView_house);
        ImageFetching imageFetching = new ImageFetching();
        String url  = imageFetching.fetchImage(context,modelCard.getImageUrl());
        if(url!="null")
        Picasso.get().load(url).fit().centerCrop().into(image_house);
        cost.setText("₹ "+modelCard.getCost());
        bedroom.setText("bedroom "+modelCard.getBedroom());
        furnishing.setText("furnishing "+modelCard.getFurnishing());


        return GridItemView;

    }
}