package com.anthonyestacado.mytasks.tasksview.fragments.taskslist;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.model.MyUtils;
import com.anthonyestacado.mytasks.model.UserTask;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivity;
import com.anthonyestacado.mytasks.tasksview.activity.TasksActivityInterface;
import com.anthonyestacado.mytasks.tasksview.fragments.usertaskdetails.UserTaskDetailsFragment;

import java.util.List;

import static com.anthonyestacado.mytasks.model.SQLiteDBHelper.context;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class TasksListFragment extends Fragment  {

    private List<UserTask> userTasksList;

    private String userTasksSelectionCriteria;

    private RecyclerView recyclerView;

    private TasksActivityInterface userTasksActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);

        userTasksActivity = (TasksActivityInterface) getActivity();

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

        recyclerView = (RecyclerView) view.findViewById(R.id.userTasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Set adapter with proper onClickListener
        recyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), userTasksList, new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override public void onItemClick(UserTask userTask) {
                Toast.makeText(getActivity().getApplicationContext(), "Clicked the card with id: " + userTask.getTaskID(), Toast.LENGTH_SHORT).show();

                //TODO: uncomment this line to launch a task details fragment that is associated with this card
                //userTasksActivity.loadUserTaskDetailsFragment(userTask.getTaskID());
            }
        }));

        //Lock the collapsing toolbar in the parent activity
        recyclerView.setNestedScrollingEnabled(false);


        userTasksActivity.setFabEditEnabled(false);
        userTasksActivity.setFabAddEnabled(true);
        getActivity().setTitle(userTasksSelectionCriteria);

        userTasksActivity.setAppBarOpened(false);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        userTasksActivity.setFabEditEnabled(false);
        userTasksActivity.setFabAddEnabled(true);
        userTasksActivity.setAppBarOpened(false);

        //Lock the collapsing toolbar in the parent activity
        recyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    public void onPause() {
        super.onPause();

    }
}
