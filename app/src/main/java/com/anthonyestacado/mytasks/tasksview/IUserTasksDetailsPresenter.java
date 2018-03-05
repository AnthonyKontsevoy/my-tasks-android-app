package com.anthonyestacado.mytasks.tasksview;

/**
 * Created by User on 05.03.2018.
 */

public interface IUserTasksDetailsPresenter {

    int changeUserTaskStatus(int userTaskID);
    int deleteUserTask(int userTaskID);
    int displayUserTaskDetails(int userTaskID);
}
