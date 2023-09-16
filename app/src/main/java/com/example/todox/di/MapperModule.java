package com.example.todox.di;

import com.example.todox.data.mapper.AuthTokenMapperImpl;
import com.example.todox.domain.mapper.AuthTokenMapperI;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class MapperModule {



    @Binds
    public abstract AuthTokenMapperI provideAuthTokenMapper(AuthTokenMapperImpl authTokenMapperImpl);



}
