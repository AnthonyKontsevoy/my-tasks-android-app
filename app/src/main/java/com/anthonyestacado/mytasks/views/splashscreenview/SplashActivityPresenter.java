package com.anthonyestacado.mytasks.views.splashscreenview;

import android.content.Context;

import com.anthonyestacado.mytasks.model.Model;
import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.model.SQLiteDBHelper;

/**
 * Created by Anthony Kontsevoy on 30.03.2018.
 */
public class SplashActivityPresenter implements SplashActivityPresenterInterface{

    private SplashActivity activity;
    private ModelInterface modelInstance;

    public SplashActivityPresenter(SplashActivity activity){
        this.activity = activity;
    }

    @Override
    public void initializeModel(Context context) {
        SQLiteDBHelper.setContext(context);
        modelInstance = Model.getModelInstance();

    }
}
