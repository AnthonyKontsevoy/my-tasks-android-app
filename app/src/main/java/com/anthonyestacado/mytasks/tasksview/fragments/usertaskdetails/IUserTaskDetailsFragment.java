package com.anthonyestacado.mytasks.tasksview.fragments.usertaskdetails;

import com.anthonyestacado.mytasks.model.UserTask;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public interface IUserTaskDetailsFragment {
    void displayUserTaskDetails(int userTaskID);
    void changeUserTaskStatus();
    void deleteUserTask();
}
