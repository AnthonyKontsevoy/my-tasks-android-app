package com.anthonyestacado.mytasks.tasksview.activity;

/**
 * Created by Anthony Kontsevoy on 19.03.2018.
 */

public interface TasksActivityInterface {

    void setToolbarTitle(String toolbarTitle);
    void expandToolbar();
    void lockToolbar();
    void loadUserTasksListFragmentByCriteria(String criteria);
    void loadUserTaskDetailsFragment(int userTaskID);
}
