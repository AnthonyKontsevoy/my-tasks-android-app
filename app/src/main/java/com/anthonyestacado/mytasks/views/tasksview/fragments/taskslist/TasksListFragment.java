package com.anthonyestacado.mytasks.views.tasksview.fragments.taskslist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.common.TaskStatuses;
import com.anthonyestacado.mytasks.model.UserTask;
import com.anthonyestacado.mytasks.views.tasksview.activity.TasksActivityInterface;

import java.util.List;

import static com.anthonyestacado.mytasks.model.SQLiteDBHelper.context;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class TasksListFragment extends Fragment
                               implements TasksListFragmentInterface{

    private TasksActivityInterface userTasksActivity;

    private TasksListFragmentPresenterInterface presenter;

    private List<UserTask> userTasksList;

    private String userTasksSelectionCriteria;

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);

        userTasksActivity = (TasksActivityInterface) getActivity();

        presenter = new TasksListFragmentPresenter(this, getActivity());

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            userTasksSelectionCriteria = getArguments().getString("criteria");
        }

        //TODO: load information about tasks into the list
        if (userTasksSelectionCriteria != null) {
            switch (userTasksSelectionCriteria) {
                case "All tasks": {
                    //userTasksList = MyUtils.getListOfAllUserTasks();
                    userTasksList = presenter.getUserTasksList(TaskStatuses.ALL);
                    break;
                }
                case "In progress": {
                    //userTasksList = MyUtils.getListOfUserTasksInProgress();
                    userTasksList = presenter.getUserTasksList(TaskStatuses.IN_PROGRESS);
                    break;
                }
                case "Done tasks":{
                    //userTasksList = MyUtils.getListOfDoneUserTasks();
                    userTasksList = presenter.getUserTasksList(TaskStatuses.DONE);
                    break;
                }
                default: {
                    //userTasksList = MyUtils.getListOfAllUserTasks();
                    userTasksList = presenter.getUserTasksList(TaskStatuses.ALL);
                    break;
                }
            }
        }

        if (userTasksList.size() == 0) {
            Toast toast = Toast.makeText(context, "No tasks found in the database", Toast.LENGTH_SHORT);
            toast.show();
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.userTasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Set adapter with proper onClickListener
        adapter = new MyRecyclerViewAdapter(getActivity(), userTasksList, new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override public void onItemClick(UserTask userTask) {
                        Toast.makeText(getActivity().getApplicationContext(), "Clicked the card with id: " + userTask.getTaskID(), Toast.LENGTH_SHORT).show();

                        //TODO: uncomment this line to launch a task details fragment that is associated with this card
                        //userTasksActivity.loadUserTaskDetailsFragment(userTask.getTaskID());
                    }
                });
        recyclerView.setAdapter(adapter);

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

        getActivity().setTitle(userTasksSelectionCriteria);
        userTasksActivity.setToolbarTitle(userTasksSelectionCriteria);

        userTasksActivity.setFabEditEnabled(false);
        userTasksActivity.setFabAddEnabled(true);
        userTasksActivity.setAppBarOpened(false);

        //Lock the collapsing toolbar in the parent activity
        recyclerView.setNestedScrollingEnabled(false);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public int editUserTask(int userTaskID) {
        return 0;
    }

    @Override
    public int deleteUserTask(int userTaskID) {
        return 0;
    }

    @Override
    public List<UserTask> getUserTasksList(TaskStatuses selectionMode) {
        return  presenter.getUserTasksList(selectionMode);
    }

    @Override
    public int changeUserTaskStatus(int userTaskID) {
        return 0;
    }
}
