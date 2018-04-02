package com.anthonyestacado.mytasks.model;

import com.anthonyestacado.mytasks.common.RepeatMode;
import com.anthonyestacado.mytasks.common.TaskStatuses;

import java.util.List;

/**
 * Created by anthonykontsevoy on 05.03.2018.
 */

public interface ModelInterface {

    int createTask(String title, String description, String dueDate, int hasNotification, RepeatMode repeatMode);
    int editTask(int userTaskID, String title, String description, String dueDate, TaskStatuses status, int hasNotification, RepeatMode repeatMode);
    int deleteTask(int userTaskID);
    UserTask getUserTaskByID(int userTaskID);
    List<UserTask> getTasks(TaskStatuses selectionMode);
    int authenticateUser(String username, String password);
    int changeUserTaskStatus(int UserTaskID, int status);
    int setNotificationForTask(int userTaskID);
}
