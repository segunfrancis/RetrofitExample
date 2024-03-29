package com.example.computer.retrofitexample;

import com.example.computer.retrofitexample.Model.SignUpResponse;
import com.example.computer.retrofitexample.Model.UserListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded // annotation used in POST type requests
    @POST("/retrofit/register.php")
        // API's endpoints
    Call<SignUpResponse> registration(@Field("name") String name,
                                      @Field("email") String email,
                                      @Field("password") String password,
                                      @Field("logintype") String logintype);

    // In registration method @Field used to set the keys and string type is representing
    // its a string type value and callback is used to get the response from api and it will set it in our POJO class

    @GET("/retrofit/getuser.php")
        // API's endpoints
    Call<List<UserListResponse>> getUsersList();

    // UserListResponse is POJO class to get the data from API, we use List<UserListResponse>
    // in callback because the data in our API is starting from JSONArray
}
