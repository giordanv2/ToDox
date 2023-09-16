package com.example.todox.domain.mapper;

import com.example.todox.data.remote.dto.LoginResponse;
import com.example.todox.domain.entity.AuthToken;

public interface AuthTokenMapperI {
    AuthToken mapToDomain(LoginResponse loginResponse);
    //LoginResponse mapToData(AuthToken authToken);
}
