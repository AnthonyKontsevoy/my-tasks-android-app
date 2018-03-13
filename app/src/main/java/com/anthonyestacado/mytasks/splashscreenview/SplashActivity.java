package com.anthonyestacado.mytasks.splashscreenview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.anthonyestacado.mytasks.tasksview.activity.ActivityTasks;

/**
 * Created by Anthony Kontsevoy on 09.03.2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ActivityTasks.class);
        startActivity(intent);
        finish();
    }
}
