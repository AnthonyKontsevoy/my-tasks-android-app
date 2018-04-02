package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskeditor;

import android.content.Context;

import com.anthonyestacado.mytasks.common.RepeatMode;
import com.anthonyestacado.mytasks.model.Model;
import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.model.UserTask;

/**
 * Created by Anthony Kontsevoy on 02.04.2018.
 */
public class EditUserTaskFragmentPresenter implements EditUserTaskFragmentPresenterInterface{

    private EditUserTaskFragmentInterface fragment;
    private Context context;

    private ModelInterface modelInstance;
    private UserTask userTask;

    public EditUserTaskFragmentPresenter (Context context, EditUserTaskFragmentInterface fragment) {
        this.context = context;
        this.fragment = fragment;
        modelInstance = Model.getModelInstance();
    }

    @Override
    public int displayUserTaskDetails(int userTaskID) {
        if (userTaskID == -1) {
            fragment.makeInputFieldsEmpty();
        } else {
            //TODO: make an implementation if user decides to edit an already existing task
            //fragment.fillInputFieldsWithData();
        }
        return 0;
    }

    @Override
    public int saveUserTask(String title, String description, String dueDate, int hasNotificationAlert, int repeatMode) {

        switch (repeatMode) {
            case 0: {
                modelInstance.createTask(title, description, dueDate, hasNotificationAlert, RepeatMode.NEVER);
                break;
            }
            case 1: {
                modelInstance.createTask(title, description, dueDate, hasNotificationAlert, RepeatMode.DAILY);
                break;
            }
            case 2: {
                modelInstance.createTask(title, description, dueDate, hasNotificationAlert, RepeatMode.WEEKLY);
                break;
            }
            case 3: {
                modelInstance.createTask(title, description, dueDate, hasNotificationAlert, RepeatMode.MONTHLY);
                break;
            }
            case 4: {
                modelInstance.createTask(title, description, dueDate, hasNotificationAlert, RepeatMode.EVERY_YEAR);
                break;
            }
        }

        return 0;
    }
}
