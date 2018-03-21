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
        activity.expandToolbar();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        activity.lockToolbar();
    }
}
