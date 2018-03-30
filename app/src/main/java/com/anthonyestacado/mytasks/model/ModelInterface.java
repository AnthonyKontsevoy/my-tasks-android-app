package com.anthonyestacado.mytasks.model;

import com.anthonyestacado.mytasks.common.Tasks;

import java.util.List;

/**
 * Created by anthonykontsevoy on 05.03.2018.
 */

public interface ModelInterface {

    int createTask(String title, String description, int status, String dueDate, String repeatMode);
    int editTask(int userTaskID, String title, String description, int status, String dueDate, String repeatMode);
    int deleteTask(int userTaskID);
    UserTask getUserTaskByID(int userTaskID);
    List<UserTask> getTasks(Tasks selectionMode);
    int authenticateUser(String username, String password);
    int changeUserTaskStatus(int UserTaskID, int status);
    int setNotificationForTask(int userTaskID);
}
