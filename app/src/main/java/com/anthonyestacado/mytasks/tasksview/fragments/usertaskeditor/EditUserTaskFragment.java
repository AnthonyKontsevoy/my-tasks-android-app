package com.anthonyestacado.mytasks.tasksview.fragments.usertaskeditor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivityInterface;


public class EditUserTaskFragment extends Fragment {

    private TasksActivityInterface activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit_user_task, container, false);

        activity = (TasksActivityInterface) getActivity();

        activity.expandToolbar();
        activity.setAppBarOpened(true);

        activity.setFabAddEnabled(false);
        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);

        Spinner spinner = (Spinner) view.findViewById(R.id.repeatModeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.repeat_mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        activity.lockToolbar();
        activity.setAppBarOpened(false);

        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(false);
        activity.setFabAddEnabled(true);

        activity.setBackButtonOnToolbarEnabled(false);
        activity.setDrawerEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();

        activity.expandToolbar();
        activity.setAppBarOpened(true);

        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(true);
        activity.setFabAddEnabled(false);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);


    }
}
