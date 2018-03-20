package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.app.Application;
import android.app.Fragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.model.MyUtils;
import com.anthonyestacado.mytasks.model.UserTask;
import com.anthonyestacado.mytasks.tasksview.activity.ActivityTasks;
import com.anthonyestacado.mytasks.tasksview.activity.IActivityTasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class TasksListFragment extends Fragment {

    private List<UserTask> userTasksList;

    private String userTasksSelectionCriteria;

    private IActivityTasks userTasksActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tasks_list_fragment, container, false);

        userTasksActivity = (IActivityTasks) getActivity();

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            userTasksSelectionCriteria = getArguments().getString("criteria");
        }

        //TODO: load information about tasks into the list
        if (userTasksSelectionCriteria != null) {
            switch (userTasksSelectionCriteria) {
                case "All tasks": {
                    userTasksList = MyUtils.getListOfAllUserTasks();
                    break;
                }
                case "In progress": {
                    userTasksList = MyUtils.getListOfUserTasksInProgress();
                    break;
                }
                case "Done":{
                    userTasksList = MyUtils.getListOfDoneUserTasks();
                    break;
                }
                default: {
                    userTasksList = MyUtils.getListOfAllUserTasks();
                    break;
                }
            }
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.userTasksRecyclerView);
        RecyclerViewAdapter listAdapter = new RecyclerViewAdapter(getActivity().getApplicationContext(), userTasksList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);

        ((ActivityTasks) getActivity()).setToolbarTitle(userTasksSelectionCriteria);
        //getActivity().setTitle(userTasksSelectionCriteria);
        //userTasksActivity.setToolbarTitle(userTasksSelectionCriteria);
        return view;
    }
}
