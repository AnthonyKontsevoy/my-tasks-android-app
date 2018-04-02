package com.anthonyestacado.mytasks.views.tasksview.fragments.taskslist;

import com.anthonyestacado.mytasks.common.TaskStatuses;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 30.03.2018.
 */
public interface TasksListFragmentPresenterInterface {
    int editUserTask(int userTaskID);
    int deleteUserTask(int userTaskID);
    List<UserTask> getUserTasksList(TaskStatuses selectionMode);
    int changeUserTaskStatus(int userTaskID);
}
