package com.example.todox.data.remote.api;

import com.example.todox.data.remote.dto.LoginRequest;
import com.example.todox.data.remote.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
