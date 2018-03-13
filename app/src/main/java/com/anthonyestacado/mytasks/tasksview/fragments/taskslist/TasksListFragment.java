package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.app.Application;
import android.app.Fragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.model.MyUtils;
import com.anthonyestacado.mytasks.model.UserTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class TasksListFragment extends Fragment {
    private List<UserTask> userTasksList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tasks_list_fragment, container, false);

        //TODO: load information about tasks into the list
        //userTasksList = new ArrayList<>();

        userTasksList = MyUtils.getListOfUserTasksForDebug();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.userTasksRecyclerView);

        RecyclerViewAdapter listAdapter = new RecyclerViewAdapter(getActivity().getApplicationContext(), userTasksList);
        recyclerView.setAdapter(listAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
