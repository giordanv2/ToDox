package com.example.todox.domain.usecases;

import com.example.todox.domain.entity.AuthToken;
import com.example.todox.domain.repository.LoginRepository;
import com.example.todox.presentation.usecases.LoginUserUseCase;

import java.util.concurrent.Future;

import javax.inject.Inject;

public class LoginUserUseCaseImpl implements LoginUserUseCase {
    private final LoginRepository loginRepository;

    @Inject
    public LoginUserUseCaseImpl(LoginRepository userRepository) {
        this.loginRepository = userRepository;
    }

    @Override
    public Future<AuthToken> execute(String email, String password) {
        return loginRepository.loginUser(email, password);
    }
}
