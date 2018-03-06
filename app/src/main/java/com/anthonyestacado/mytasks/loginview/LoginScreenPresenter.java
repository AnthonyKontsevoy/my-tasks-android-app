package com.anthonyestacado.mytasks.loginview;

import com.anthonyestacado.mytasks.model.IModel;
import com.anthonyestacado.mytasks.model.Model;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class LoginScreenPresenter implements ILoginScreenPresenter {

    private ILoginScreen loginView;
    private IModel modelInstance;

    public LoginScreenPresenter(ILoginScreen loginView) {
        this.loginView = loginView;
        modelInstance = Model.getModelInstance();
    }
    @Override
    public int runAuthenticationProcedure(String username, String password) {
        return 0;
    }
}
