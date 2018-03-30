package com.anthonyestacado.mytasks.views.tasksview.fragments.taskslist;

import com.anthonyestacado.mytasks.common.Tasks;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 30.03.2018.
 */
public interface TasksListFragmentInterface {
    int editUserTask(int userTaskID);
    int deleteUserTask(int userTaskID);
    List<UserTask> getUserTasksList(Tasks selectionMode);
    int changeUserTaskStatus(int userTaskID);
}
