package com.anthonyestacado.mytasks.model;

import java.util.List;

/**
 * Created by User on 05.03.2018.
 */

public interface IRepository {

    int saveUserTask(UserTask userTask);
    int updateUserTask(UserTask userTask);
    int deleteUserTask(int userTaskID);
    UserTask getUserTaskByID(int userTaskID);
    List<UserTask> getUserTasks(int selection_mode);
    List<String> validateUserCredentials(String username, String password);
}
