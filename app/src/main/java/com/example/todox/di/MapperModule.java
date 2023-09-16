package com.example.todox.di;

import com.example.todox.domain.mapper.AuthTokenMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class MapperModule {

    @Provides
    @Singleton
    public AuthTokenMapper provideAuthTokenMapper() {
        return new AuthTokenMapper();
    }

}
