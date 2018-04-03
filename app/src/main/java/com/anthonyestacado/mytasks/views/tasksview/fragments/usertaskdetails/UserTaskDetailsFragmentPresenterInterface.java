package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskdetails;

import com.anthonyestacado.mytasks.model.UserTask;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public interface UserTaskDetailsFragmentPresenterInterface {
    void displayUserTaskDetails(int userTaskID);
    void changeUserTaskStatus(boolean status);
    void deleteUserTask(int userTaskID);
    void editUserTask(int userTaskID);
}
