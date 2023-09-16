package com.example.todox.domain.mapper;

import com.example.todox.data.remote.dto.LoginResponse;
import com.example.todox.domain.entity.AuthToken;

public class AuthTokenMapper {

    public AuthToken mapToDomain(LoginResponse loginResponse) {
        return new AuthToken(loginResponse.getToken());
    }

    public LoginResponse mapToData(AuthToken authToken) {
        return new LoginResponse(authToken.getToken());
    }
}
