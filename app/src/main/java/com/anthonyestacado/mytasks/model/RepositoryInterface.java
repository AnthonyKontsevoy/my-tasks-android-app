package com.anthonyestacado.mytasks.model;

import com.anthonyestacado.mytasks.common.Tasks;

import java.util.List;

/**
 * Created by User on 05.03.2018.
 */

public interface RepositoryInterface {

    int saveUserTask(UserTask userTask);
    int updateUserTask(UserTask userTask);
    int deleteUserTask(int userTaskID);
    UserTask getUserTaskByID(int userTaskID);
    List<UserTask> getUserTasks(Tasks selectionMode);
    List<String> validateUserCredentials(String username, String password);
}
