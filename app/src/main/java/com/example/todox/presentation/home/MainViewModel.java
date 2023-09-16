package com.example.todox.presentation.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todox.domain.entity.AuthToken;
import com.example.todox.presentation.usecases.LoginUserUseCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final LoginUserUseCase loginUserUseCase;
    private final MutableLiveData<AuthToken> authToken = new MutableLiveData<>();
    private final MutableLiveData<Throwable> error = new MutableLiveData<>();

    @Inject
    public MainViewModel(LoginUserUseCase loginUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
    }

    public LiveData<AuthToken> getAuthToken() {
        return authToken;
    }

    public LiveData<Throwable> getError() {
        return error;
    }

    public void login(String email, String password) {
        Future<AuthToken> future = loginUserUseCase.execute(email, password);

        try {
            authToken.setValue(future.get());
        } catch (ExecutionException | InterruptedException e) {
            error.setValue(e);
        }
    }
}
