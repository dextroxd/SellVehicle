package com.dextroxd.sellvehicle.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.dextroxd.sellvehicle.Model.ModelCard;
import com.dextroxd.sellvehicle.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private ArrayList<ModelCard>modelCards;
    private Context context;
    private  int layout;


    public GridAdapter(Context context, int layout, ArrayList<ModelCard> modelCards) {
        this.context = context;
        this.layout = layout;
        this.modelCards = modelCards;
    }
    private class ViewHolder{

        TextView cost,bedroom,furnishing;
    }



    @Override
    public int getCount() {
        return modelCards.size();
    }

    @Override
    public Object getItem(int position) {
        return modelCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View GridItemView = convertView;
        ViewHolder holder = new ViewHolder();


        if (GridItemView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            GridItemView = inflater.inflate(layout, null);
            holder.cost = (TextView) GridItemView.findViewById(R.id.cost_sell);
            holder.bedroom = (TextView) GridItemView.findViewById(R.id.heading_sell);
            holder.furnishing = (TextView) GridItemView.findViewById(R.id.description_sell);
            GridItemView.setTag(holder);

        }
        else{
            holder = (ViewHolder) GridItemView.getTag();
        }



         ModelCard modelCard = modelCards.get(position);
       // ImageView imageView = GridItemView.findViewById(R.id.imageView);
        //Un comment the below line to load image from url;
//        Picasso.get().load(servicesModel.getImageUrl()).into(imageView);
        holder.cost.setText("₹ "+modelCard.getCost());
        holder.bedroom.setText("bedroom "+modelCard.getBedroom());
        holder.furnishing.setText("furnishing "+modelCard.getFurnishing());

        // Use code below for click event happen on click of card element.
//        GridItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        return GridItemView;

    }
}