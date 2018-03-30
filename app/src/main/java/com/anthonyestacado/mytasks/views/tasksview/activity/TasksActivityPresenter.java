package com.anthonyestacado.mytasks.views.tasksview.activity;

import android.content.Context;

import com.anthonyestacado.mytasks.common.Tasks;

/**
 * Created by Anthony Kontsevoy on 30.03.2018.
 */
public class TasksActivityPresenter implements TasksActivityPresenterInterface {

    private TasksActivityInterface activity;
    private Context context;

    public TasksActivityPresenter(TasksActivityInterface activity, Context context) {
        this.activity = activity;
        this.context = context;
    }

    @Override
    public void loadUserTasksListFragment(Tasks criteria) {
        activity.loadUserTasksListFragmentByCriteria(criteria);
    }

    @Override
    public void createNewTask() {
        activity.loadEditUserTaskFragment(-1);
    }
}
