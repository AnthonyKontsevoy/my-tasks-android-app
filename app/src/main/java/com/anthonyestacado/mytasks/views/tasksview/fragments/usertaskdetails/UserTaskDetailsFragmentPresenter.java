package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskdetails;

import android.content.Context;

import com.anthonyestacado.mytasks.model.Model;
import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.model.UserTask;

/**
 * Created by Anthony Kontsevoy on 03.04.2018.
 */
public class UserTaskDetailsFragmentPresenter implements UserTaskDetailsFragmentPresenterInterface {

    private ModelInterface modelInstance;
    private UserTaskDetailsFragmentInterface fragment;
    private Context context;

    public UserTaskDetailsFragmentPresenter(Context context, UserTaskDetailsFragmentInterface fragment) {
        this.context = context;
        this.fragment = fragment;
        modelInstance = Model.getModelInstance();
    }


    @Override
    public void displayUserTaskDetails(int userTaskID) {
        UserTask userTask = modelInstance.getUserTaskByID(userTaskID);
        fragment.displayUserTaskDetails(userTask.getTitle(), userTask.getDescription(), userTask.getDueDate(), userTask.getHasNotificationAlert(), userTask.getRepeatMode());
    }

    @Override
    public void changeUserTaskStatus(boolean status) {

    }

    @Override
    public void deleteUserTask(int userTaskID) {

    }

    @Override
    public void editUserTask(int userTaskID) {

    }
}
