package com.anthonyestacado.mytasks.model;

import com.anthonyestacado.mytasks.common.TaskStatuses;

import java.util.List;

/**
 * Created by User on 05.03.2018.
 */

public interface RepositoryInterface {

    int saveUserTask(UserTask userTask);
    int updateUserTask(UserTask userTask);
    int deleteUserTask(int userTaskID);
    UserTask getUserTaskByID(int userTaskID);
    List<UserTask> getUserTasks(TaskStatuses selectionMode);
    List<String> validateUserCredentials(String username, String password);
}
