package com.anthonyestacado.mytasks.tasksview.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;

import com.anthonyestacado.mytasks.R;

/**
 * Created by Anthony Kontsevoy on 19.03.2018.
 */

public interface TasksActivityInterface {

    void setToolbarTitle(String toolbarTitle);
    void expandToolbar();
    void lockToolbar();
    void setHomeAsUpEnabled(boolean flag);
    void setFabAddEnabled(boolean flag);
    void setFabEditEnabled(boolean flag);
    void setFabSaveEnabled(boolean flag);
    void loadUserTasksListFragmentByCriteria(String criteria);
    void loadUserTaskDetailsFragment(int userTaskID);
    void loadEditUserTaskFragment(int userTaskID);
    void setAppBarOpened(boolean flag);
    void setDrawerEnabled(boolean flag);
    void setBackButtonOnToolbarEnabled(boolean flag);
}
