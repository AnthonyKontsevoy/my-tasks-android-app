package com.anthonyestacado.mytasks.loginview;

import com.anthonyestacado.mytasks.model.Modelnterface;
import com.anthonyestacado.mytasks.model.Model;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class LoginScreenPresenter implements LoginScreenPresenterInterface {

    private LoginScreenInterface loginView;
    private Modelnterface modelInstance;

    public LoginScreenPresenter(LoginScreenInterface loginView) {
        this.loginView = loginView;
        modelInstance = Model.getModelInstance();
    }
    @Override
    public int runAuthenticationProcedure(String username, String password) {
        return 0;
    }
}
