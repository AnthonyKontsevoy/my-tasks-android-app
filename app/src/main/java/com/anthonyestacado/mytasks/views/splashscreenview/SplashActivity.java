package com.anthonyestacado.mytasks.views.splashscreenview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.views.loginview.LoginScreenActivity;
import com.anthonyestacado.mytasks.model.Model;
import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.model.SQLiteDBHelper;

public class SplashActivity extends AppCompatActivity {

    private SplashActivityPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashActivityPresenter(this);
        presenter.initializeModel(this);

        //TODO: Here you must check if user must proceed to the login activity or he can be sent directly to the main activity if authentication tokens are still valid
        //For now we will start login activity without any background checks
        Intent startLoginScreenActivityIntent = new Intent(this, LoginScreenActivity.class);
        startActivity(startLoginScreenActivityIntent);

        finish();
    }
}
