package com.dextroxd.sellvehicle.exploreFragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dextroxd.sellvehicle.activities.filterActivity;
import com.dextroxd.sellvehicle.exploreFragment.adapter_explore.GridAdapter;
import com.dextroxd.sellvehicle.exploreFragment.model_explore.ModelCard;
import com.dextroxd.sellvehicle.R;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment implements Animation.AnimationListener {
    private final String LINK_URL = "http://www.litstays.com/wp-json/wp/v2/properties";
    int p = 1;
    int to_be_returned = 200;
    private RecyclerView recyclerView;
    private ImageButton filter_button;
    String cost, bedroom, furnishing;
    private GridAdapter gridAdapter;
    private SkeletonScreen skeletonScreen;
    private ArrayList<ModelCard> modelCards;
    private int visibleThreshold = 6;
    private int currentPage = 1,visibleItemCount,totalItemCount,firstVisibleItem;
    private int previousTotal = 0;
    private boolean loading = true;
    Animation animFadein;


    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         final  View view = inflater.inflate(R.layout.fragment_explore, container, false);
        animFadein = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.fade_in);
        modelCards = new ArrayList<ModelCard>();
        recyclerView = view.findViewById(R.id.id_recycler_explore);
        view.startAnimation(animFadein);
        gridAdapter = new GridAdapter(view.getContext(),modelCards);
        filter_button=(ImageButton)view.findViewById(R.id.filter_button);
        filter_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), filterActivity.class));
            }
        });

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(gridAdapter);
        skeletonScreen = Skeleton.bind(recyclerView).adapter(gridAdapter).shimmer(true).count(10).load(R.layout.skeleton_view).show();
        getJson(LINK_URL,view.getContext());
        gridAdapter.notifyDataSetChanged();

       recyclerView.addOnScrollListener(new OnScrollListener() {
           @Override
           public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
               super.onScrollStateChanged(recyclerView, newState);
           }

           @Override
           public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
               super.onScrolled(recyclerView, dx, dy);
               if (loading) {
                   if (dy > 0) //check for scroll down
                   {
                       visibleItemCount = linearLayoutManager.getChildCount();
                       totalItemCount = linearLayoutManager.getItemCount();
                       firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

                           if (firstVisibleItem + visibleItemCount == totalItemCount) {
                               loading=false;
                               p++;
                               if (getJson(LINK_URL + "?page=" + p, view.getContext()) == 400) {
                                   return;
//               super.onScrolled(recyclerView, dx, dy);
                               }
                           }
                       }

                   }
               }



       });
        return view;
    }

    public int getJson(String link_url, final Context context) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, link_url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                skeletonScreen.hide();
                for (int i = 0; i < response.length(); i++) {
                    JSONObject obj1 = response.optJSONObject(i);
                    JSONObject property = obj1.optJSONObject("property_meta");
                    JSONArray price_array = property.optJSONArray("REAL_HOMES_property_price");
                    String price = price_array.optString(0);
//                    JSONArray bedroom_array = property.optJSONArray("REAL_HOMES_property_bedrooms");
//                    String bedroom = bedroom_array.optString(0);
//                    if(bedroom.equals("null")){
//                        bedroom="0";
//                    }
//                    Log.e("bedroom",bedroom);
                    JSONArray size_array = property.optJSONArray("REAL_HOMES_property_size");
                    String size = size_array.optString(0);
                    JSONArray thumbnail_array=property.optJSONArray("_thumbnail_id");
                    String thumbnail_id=thumbnail_array.optString(0);
                    ModelCard m1 = new ModelCard("₹ "+price, "7", size,thumbnail_id);
                    modelCards.add(m1);


                }

                gridAdapter.notifyDataSetChanged();
//                gridAdapter.notify();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.toString());

            }
        })
        {
            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                int mStatusCode = response.statusCode;
                to_be_returned = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        requestQueue.add(jsonArrayRequest);

        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                100000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        return to_be_returned;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
//    public String getThumbnail(String id,Context context){
//        RequestQueue requestQueue=Volley.newRequestQueue(context);
//        String LINK_MEDIA="http://www.litstays.com/wp-json/wp/v2/media"+"/"+id;
//
//        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, LINK_MEDIA, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                JSONObject request=response.optJSONObject("media_details");
//                JSONObject request_size=request.optJSONObject("sizes");
//                JSONObject thumbnail=request_size.optJSONObject("thumbnail");
//                 url_image=thumbnail.optString("source_url");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Error", error.toString());
//
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//
//        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
//                5000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        return url_image;
//
//    }

}










