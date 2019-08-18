package com.dextroxd.sellvehicle.exploreFragment.adapter_explore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.dextroxd.sellvehicle.cardActivity.cardActivity;
import com.dextroxd.sellvehicle.exploreFragment.model_explore.ModelCard;
import com.dextroxd.sellvehicle.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder>{
    private ArrayList<ModelCard>a1=new ArrayList<>();
    private TextView cost,bedroom,furnishing;
    private ImageView image_house;
    private Context context;
    private List<ModelCard> houseList;
     ImageView like_button;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cost, bedroom, size;

        public MyViewHolder(View view) {
            super(view);
            cost = (TextView) view.findViewById(R.id.cost_sell);
            bedroom = (TextView) view.findViewById(R.id.bedroom_sell);
            size = (TextView) view.findViewById(R.id.size_sell);
            like_button=(ImageView)view.findViewById(R.id.likebutton);
        }
    }
    public GridAdapter(Context context,List<ModelCard> houseList) {
        this.context=context;
        this.houseList = houseList;
    }



//    @Override
//    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View GridItemView = convertView;
//
//        if (GridItemView == null) {
//            GridItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.cardsofsale, parent, false);
//        }
//
//        final ModelCard modelCard = getItem(position);
//        cost=GridItemView.findViewById(R.id.cost_sell);
//        bedroom=GridItemView.findViewById(R.id.bedroom_sell);
//        furnishing=GridItemView.findViewById(R.id.size_sell);
//        image_house=GridItemView.findViewById(R.id.imageView_house);
//        ImageFetching imageFetching = new ImageFetching();
//        String url  = imageFetching.fetchImage(context,modelCard.getImageUrl());
//        if(url!="null")
//        Picasso.get().load(url).fit().centerCrop().into(image_house);
//        cost.setText("₹ "+modelCard.getCost());
//        bedroom.setText("bedroom "+modelCard.getBedroom());
//        furnishing.setText("furnishing "+modelCard.getFurnishing());
//        return GridItemView;
//    }

    @NonNull
    @Override
    public GridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardsofsale, viewGroup, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final ModelCard modelCard = houseList.get(i);
        myViewHolder.cost.setText(modelCard.getCost());
        myViewHolder.bedroom.setText(modelCard.getBedroom());
        myViewHolder.size.setText(modelCard.getFurnishing());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(v.getContext(),cardActivity.class);
              in.putExtra("cost",modelCard.getCost());
              in.putExtra("bedroom",modelCard.getBedroom());
              in.putExtra("size",modelCard.getFurnishing());
              context.startActivity(in);

            }
        });

    }



    @Override
    public int getItemCount() {
        return houseList.size();
    }


}