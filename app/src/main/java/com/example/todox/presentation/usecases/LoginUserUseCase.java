package com.example.todox.presentation.usecases;

import com.example.todox.domain.entity.AuthToken;

import java.util.concurrent.Future;

public interface LoginUserUseCase {
    Future<AuthToken> execute(String email, String password);
}
