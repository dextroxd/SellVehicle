package com.dextroxd.sellvehicle.login_and_signup.network;

import com.dextroxd.sellvehicle.login_and_signup.network.model.LoginPost;
import com.dextroxd.sellvehicle.login_and_signup.network.model.LoginResponse;
import com.dextroxd.sellvehicle.login_and_signup.network.model.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface
{
    @POST("register")
    Call<Response> saveUser(
           @Body Response response
    );

    @POST("login")
    Call<LoginResponse> loginUser(
            @Body LoginPost loginPost
            );



}
