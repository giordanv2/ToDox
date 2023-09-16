package com.example.todox.data.repository;

import com.example.todox.data.mapper.AuthTokenMapperImpl;
import com.example.todox.data.remote.api.ApiInterface;
import com.example.todox.data.remote.dto.LoginRequest;
import com.example.todox.data.remote.dto.LoginResponse;
import com.example.todox.domain.entity.AuthToken;
import com.example.todox.domain.mapper.AuthTokenMapperI;
import com.example.todox.domain.repository.LoginRepository;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import retrofit2.Response;

public class LoginRepositoryImpl implements LoginRepository {
    private final ApiInterface apiInterface;
    private final AuthTokenMapperI authTokenMapperI;
    private final ExecutorService executorService;

    @Inject
    public LoginRepositoryImpl(ApiInterface apiInterface, AuthTokenMapperI authTokenMapperI, ExecutorService executorService) {
        this.apiInterface = apiInterface;
        this.authTokenMapperI = authTokenMapperI;
        this.executorService = executorService;
    }

    @Override
    public CompletableFuture<AuthToken> loginUser(String email, String password) {
        if (!email.equals("eve.holt@reqres.in") || !password.equals("cityslicka")) {
            CompletableFuture<AuthToken> future = new CompletableFuture<>();
            future.completeExceptionally(new IllegalStateException("Invalid email or password"));
            return future;
        }
        LoginRequest request = new LoginRequest(email, password);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Response<LoginResponse> response = apiInterface.loginUser(request).execute();
                if (response.isSuccessful()) {
                    return authTokenMapperI.mapToDomain(response.body());
                } else {
                    // Handle error and throw an exception
                    throw new IllegalStateException("Login failed: " + response.errorBody());
                }
            } catch (IOException e) {
                throw new RuntimeException("Network error", e);
            }
        }, executorService);
    }

}
