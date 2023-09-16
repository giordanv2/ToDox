package com.example.todox.di;

import com.example.todox.data.remote.api.ApiInterface;
import com.example.todox.data.repository.LoginRepositoryImpl;
import com.example.todox.domain.mapper.AuthTokenMapper;
import com.example.todox.domain.repository.LoginRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public ExecutorService provideExecutorService() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    public LoginRepository provideLoginRepository(ApiInterface apiInterface, AuthTokenMapper authTokenMapper, ExecutorService executorService) {
        return new LoginRepositoryImpl(apiInterface, authTokenMapper, executorService);
    }
}
