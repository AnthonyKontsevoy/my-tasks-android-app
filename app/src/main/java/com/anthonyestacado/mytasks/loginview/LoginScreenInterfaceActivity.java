package com.anthonyestacado.mytasks.loginview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivity;

public class LoginScreenInterfaceActivity extends AppCompatActivity implements LoginScreenInterface, View.OnClickListener {

    LoginScreenPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Attach a presenter to the view
        presenter = new LoginScreenPresenter(this);

        //Set onClickListener for the button
        Button signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);


    }

    @Override
    public void getUserCredentials() {

    }

    @Override
    public void showLoginError(String errorMessage) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signInButton: {

                //TODO: use an authentication procedure to determine if it is allowed to start main activity
                //For the sake of initial UI testing we will redirect user to the main activity without any authentication
                Intent startMainActivityIntent = new Intent(this, TasksActivity.class);
                startActivity(startMainActivityIntent);

                finish();
                break;
            }
            default: {
                break;
            }
        }
    }
}
