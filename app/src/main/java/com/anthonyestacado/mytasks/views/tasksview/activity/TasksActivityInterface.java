package com.anthonyestacado.mytasks.views.tasksview.activity;

import com.anthonyestacado.mytasks.common.Tasks;

/**
 * Created by Anthony Kontsevoy on 19.03.2018.
 */

public interface TasksActivityInterface {

    void setToolbarTitle(String toolbarTitle);
    void setHomeAsUpEnabled(boolean flag);
    void setFabAddEnabled(boolean flag);
    void setFabEditEnabled(boolean flag);
    void setFabSaveEnabled(boolean flag);
    void loadUserTasksListFragmentByCriteria(Tasks criteria);
    void loadUserTaskDetailsFragment(int userTaskID);
    void loadEditUserTaskFragment(int userTaskID);
    void setAppBarOpened(boolean flag);
    void setDrawerEnabled(boolean flag);
    void setBackButtonOnToolbarEnabled(boolean flag);
}
