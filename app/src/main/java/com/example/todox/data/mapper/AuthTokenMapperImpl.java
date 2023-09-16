package com.example.todox.data.mapper;

import android.util.Log;

import com.example.todox.data.remote.dto.LoginResponse;
import com.example.todox.domain.entity.AuthToken;
import com.example.todox.domain.mapper.AuthTokenMapperI;

import javax.inject.Inject;

import dagger.hilt.InstallIn;

public class AuthTokenMapperImpl implements AuthTokenMapperI {

//    @Inject
//    public AuthTokenMapperImpl() {
//    }

    @Override
    public AuthToken mapToDomain(LoginResponse loginResponse) {


        return new AuthToken(loginResponse.getToken());
    }
}
