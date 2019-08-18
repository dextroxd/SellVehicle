package com.dextroxd.sellvehicle.cardActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dextroxd.sellvehicle.R;

import java.io.InputStream;

public class MyCustomPagerAdapter extends PagerAdapter {
    private static final String TAG = "hey";
    Context context;
    int images[];
    LayoutInflater layoutInflater;
    ImageView imageView;
    boolean zoomOut=false;

    public MyCustomPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
         return view == ((LinearLayout) o);
    }
    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item_view, container, false);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        final Uri uri = Uri.parse("android.resource://com.dextroxd.sellvehicle/drawable/ic_cave");


        container.addView(itemView);

        //listening to image click
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(v.getContext(),PhotoViewerActivity.class);
//                intent.putExtra("image", uri);
//                context.startActivity(intent);
//            }
//
//        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
