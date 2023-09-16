package com.example.todox.data.repository;

import com.example.todox.data.remote.api.ApiInterface;
import com.example.todox.data.remote.dto.LoginRequest;
import com.example.todox.data.remote.dto.LoginResponse;
import com.example.todox.domain.entity.AuthToken;
import com.example.todox.domain.mapper.AuthTokenMapper;
import com.example.todox.domain.repository.LoginRepository;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.inject.Inject;

import retrofit2.Response;

public class LoginRepositoryImpl implements LoginRepository {
    private final ApiInterface apiInterface;
    private final AuthTokenMapper authTokenMapper;
    private final ExecutorService executorService;

    @Inject
    public LoginRepositoryImpl(ApiInterface apiInterface, AuthTokenMapper authTokenMapper, ExecutorService executorService) {
        this.apiInterface = apiInterface;
        this.authTokenMapper = authTokenMapper;
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
                    return authTokenMapper.mapToDomain(response.body());
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
