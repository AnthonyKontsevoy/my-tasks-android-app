package com.anthonyestacado.mytasks.views.loginview;

import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.model.Model;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class LoginScreenPresenter implements LoginScreenPresenterInterface {

    private LoginScreenActivityInterface activity;
    private ModelInterface modelInstance;

    public LoginScreenPresenter(LoginScreenActivityInterface activity) {
        this.activity = activity;
        modelInstance = Model.getModelInstance();
    }
    @Override
    public int runAuthenticationProcedure(String username, String password) {
        return 0;
    }
}
