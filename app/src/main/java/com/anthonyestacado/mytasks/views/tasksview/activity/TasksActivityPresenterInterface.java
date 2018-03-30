package com.anthonyestacado.mytasks.views.tasksview.activity;

import com.anthonyestacado.mytasks.common.Tasks;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public interface TasksActivityPresenterInterface {

    //TODO: make methods that will handle toolbar and sidemenu events
    void loadUserTasksListFragment(Tasks criteria);
    void createNewTask();

}
