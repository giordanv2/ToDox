package com.example.todox.domain.repository;

import com.example.todox.domain.entity.AuthToken;

import java.util.concurrent.CompletableFuture;

public interface LoginRepository {

    CompletableFuture<AuthToken> loginUser(String email, String password);

}
