package com.anthonyestacado.mytasks.tasksview.fragments.usertaskdetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivity;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivityInterface;



public class UserTaskDetailsFragment extends Fragment {

    private TasksActivityInterface activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_task_details, container, false);

        activity = (TasksActivityInterface) getActivity();

        activity.setFabAddEnabled(false);
        activity.setFabSaveEnabled(false);
        activity.setFabEditEnabled(true);

        activity.expandToolbar();
        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(false);
        activity.setFabAddEnabled(true);

        activity.lockToolbar();
        activity.setAppBarOpened(false);

        activity.setBackButtonOnToolbarEnabled(false);
        activity.setDrawerEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();

        activity.setFabEditEnabled(true);
        activity.setFabSaveEnabled(false);
        activity.setFabAddEnabled(false);

        activity.expandToolbar();
        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);
    }
}
