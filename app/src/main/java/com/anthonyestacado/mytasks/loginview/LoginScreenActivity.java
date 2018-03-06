package com.anthonyestacado.mytasks.loginview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anthonyestacado.mytasks.R;

public class LoginScreenActivity extends AppCompatActivity implements ILoginScreen {

    ILoginScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginScreenPresenter(this);
    }

    @Override
    public void getUserCredentials() {

    }

    @Override
    public void showLoginError(String errorMessage) {

    }
}
