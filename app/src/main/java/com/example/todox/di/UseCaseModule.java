package com.example.todox.di;

import com.example.todox.domain.repository.LoginRepository;
import com.example.todox.domain.usecases.LoginUserUseCaseImpl;
import com.example.todox.presentation.usecases.LoginUserUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {
    @Provides
    @Singleton
    public LoginUserUseCase provideLoginUserUseCase(LoginUserUseCaseImpl loginUserUseCaseImpl) {
        return loginUserUseCaseImpl;
    }
}
