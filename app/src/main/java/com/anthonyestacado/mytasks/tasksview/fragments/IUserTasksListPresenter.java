package com.anthonyestacado.mytasks.tasksview.fragments;

import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public interface IUserTasksListPresenter {

    int createUserTask();
    int editUserTask(int userTaskID);
    int deleteUserTask(int userTaskID);
    List<UserTask> getUserTasksList(int selection_mode);
    int changeUserTaskStatus(int userTaskID);
}
