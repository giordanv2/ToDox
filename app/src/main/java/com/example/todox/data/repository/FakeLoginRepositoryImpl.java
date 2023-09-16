package com.example.todox.data.repository;

import com.example.todox.domain.entity.AuthToken;
import com.example.todox.domain.repository.LoginRepository;

import java.util.concurrent.CompletableFuture;

public class FakeLoginRepositoryImpl implements LoginRepository {


    @Override
    public CompletableFuture<AuthToken> loginUser(String email, String password) {
        return null;
    }
}
