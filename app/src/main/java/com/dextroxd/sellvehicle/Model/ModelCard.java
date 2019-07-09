package com.dextroxd.sellvehicle.Model;

import android.nfc.Tag;
import android.util.Log;

import static com.facebook.AccessTokenManager.TAG;

public class ModelCard {
    // String imageUrl;
    String Cost;
    // String title;
    // boolean like;
    String Bedroom;
    String Furnishing;

  public ModelCard(String cost,String bedroom,String furnishing) {
      // this.imageUrl = imageUrl;
      Cost = cost;
      // this.title = title;
      // this.like = like;
      Bedroom = bedroom;
      Furnishing = furnishing;
  }
    //}

    //  public String getImageUrl() {
    //    return imageUrl;
    // }


    public String getCost() {
        return Cost;

    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getBedroom() {
        return Bedroom;
    }

    public void setBedroom(String bedroom) {
        Bedroom = bedroom;
    }

    public String getFurnishing() {
        return Furnishing;
    }

    public void setFurnishing(String furnishing) {
        Furnishing = furnishing;
    }
}
