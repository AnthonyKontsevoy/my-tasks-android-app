package com.anthonyestacado.mytasks.model;

import java.util.List;

/**
 * Created by User on 05.03.2018.
 */

public interface IRepository {

    int saveUserTask(UserTask userTask);
    int deleteUserTask(UserTask userTask);
    int getUserTasks(int selection_mode);
    List<String> validateUserCredentials(String username, String password);
}
