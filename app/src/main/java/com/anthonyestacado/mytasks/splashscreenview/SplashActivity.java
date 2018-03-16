package com.anthonyestacado.mytasks.splashscreenview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.loginview.LoginScreenActivity;
import com.anthonyestacado.mytasks.tasksview.activity.ActivityTasks;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //TODO: Here you must check if user must proceed to the login activity or he can be sent directly to the main activity if authentication tokens are still valid
        //For now we will start login activity without any background checks
        Intent startLoginScreenActivityIntent = new Intent(this, LoginScreenActivity.class);
        startActivity(startLoginScreenActivityIntent);

        finish();
    }
}
