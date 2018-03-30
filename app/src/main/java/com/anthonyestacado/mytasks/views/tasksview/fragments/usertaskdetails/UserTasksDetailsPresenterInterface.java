package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskdetails;

import com.anthonyestacado.mytasks.model.UserTask;

/**
 * Created by User on 05.03.2018.
 */

public interface UserTasksDetailsPresenterInterface {

    int changeUserTaskStatus(int userTaskID);
    int deleteUserTask(int userTaskID);
    UserTask requestUserTaskDetails(int userTaskID);
}
