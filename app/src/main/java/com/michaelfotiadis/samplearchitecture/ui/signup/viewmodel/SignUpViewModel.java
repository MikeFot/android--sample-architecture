package com.michaelfotiadis.samplearchitecture.ui.signup.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {

    public enum State {
        EMAIL,
        PASSWORD,
        COMPLETE,
        FINISH
    }

    private String email;
    private String password;
    private final MutableLiveData<State> currentState = new MutableLiveData<>();
    private final MutableLiveData<Boolean> emailState = new MutableLiveData<>();
    private final MutableLiveData<Boolean> passWordState = new MutableLiveData<>();

    SignUpViewModel() {

    }

    public MutableLiveData<State> getCurrentState() {
        return currentState;
    }

    public MutableLiveData<Boolean> getEmailState() {
        return emailState;
    }

    public MutableLiveData<Boolean> getPassWordState() {
        return passWordState;
    }

    public void init() {
        currentState.postValue(State.EMAIL);
    }

    public void moveToNext() {
        if (currentState.getValue() == null) {
            return;
        }
        switch (currentState.getValue()) {
            case EMAIL:
                if (emailState.getValue() != null && emailState.getValue()) {
                    currentState.postValue(State.PASSWORD);
                }
                break;
            case PASSWORD:
                if (passWordState.getValue() != null && passWordState.getValue()) {
                    currentState.postValue(State.COMPLETE);
                }
                break;
            case COMPLETE:
                currentState.postValue(State.FINISH);
                break;
        }

    }

    public void onBackPressed() {
        if (currentState.getValue() == null) {
            return;
        }
        switch (currentState.getValue()) {
            case EMAIL:
                currentState.postValue(State.FINISH);
                break;
            case PASSWORD:
                currentState.postValue(State.EMAIL);
                break;
            case COMPLETE:
                currentState.postValue(State.PASSWORD);
                break;
            case FINISH:
                // just ignore
                break;
        }
    }

    public void setEmail(String email) {
        this.email = email;
        emailState.postValue(isValidEmailAddress(email));
    }

    public void setPassword(String password) {
        this.password = password;
        boolean isValid = password != null && password.length() > 5;
        passWordState.postValue(isValid);
    }

    // example one, just for show
    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
