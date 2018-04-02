package com.anthonyestacado.mytasks.views.tasksview.fragments.taskslist;

import android.content.Context;

import com.anthonyestacado.mytasks.model.Model;
import com.anthonyestacado.mytasks.model.ModelInterface;
import com.anthonyestacado.mytasks.common.TaskStatuses;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 30.03.2018.
 */
public class TasksListFragmentPresenter implements TasksListFragmentPresenterInterface{

    private TasksListFragmentInterface fragment;
    private ModelInterface modelInstance;
    private Context context;

    public TasksListFragmentPresenter (TasksListFragmentInterface fragment, Context context) {
        this.fragment = fragment;
        modelInstance = Model.getModelInstance();
        this.context = context;
    }

    @Override
    public int editUserTask(int userTaskID) {
        return 0;
    }

    @Override
    public int deleteUserTask(int userTaskID) {
        return 0;
    }

    @Override
    public List<UserTask> getUserTasksList(TaskStatuses selectionMode) {
        return modelInstance.getTasks(selectionMode);
    }

    @Override
    public int changeUserTaskStatus(int userTaskID) {
        return 0;
    }
}
