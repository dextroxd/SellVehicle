package com.dextroxd.sellvehicle.login_and_signup.network;

public class ApiUtils
{
    public ApiUtils() {
    }
    public static final String BASE_URL = "http:13.235.43.83:8000/api/user/";

    public static ApiInterface getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
