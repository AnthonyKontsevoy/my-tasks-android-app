package com.anthonyestacado.mytasks.model;

import java.util.List;

/**
 * Created by anthonykontsevoy on 05.03.2018.
 */

public interface IModel {

    int createTask(String title, String description, boolean status, String dueDate, int repeatMode);
    int editTask(int userTaskID);
    int deleteTask(int userTaskID);
    UserTask getUserTaskByID(int ID);
    List<UserTask> getTasks(int selectionModeID);
    int authenticateUser(String username, String password);
    int changeUserTaskStatus(boolean status);
    int setNotificationForTask(int userTaskID);
}
