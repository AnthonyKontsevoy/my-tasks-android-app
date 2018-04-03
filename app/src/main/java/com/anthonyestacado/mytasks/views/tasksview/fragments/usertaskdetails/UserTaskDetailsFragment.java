package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskdetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.views.tasksview.activity.TasksActivity;
import com.anthonyestacado.mytasks.views.tasksview.activity.TasksActivityInterface;



public class UserTaskDetailsFragment extends Fragment implements UserTaskDetailsFragmentInterface{

    private TasksActivityInterface activity;
    private UserTaskDetailsFragmentPresenterInterface presenter;

    //ID of the displayed task
    private int userTaskID;

    private TextView detailsTextView, dueDateTextView, repeatModeTextView, hasNotificationTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_task_details, container, false);

        activity = (TasksActivityInterface) getActivity();
        presenter = new UserTaskDetailsFragmentPresenter(getActivity(), this);

        activity.setToolbarTitle("Task title");

        activity.setFabAddEnabled(false);
        activity.setFabSaveEnabled(false);
        activity.setFabEditEnabled(true);

        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);

        detailsTextView = (TextView) view.findViewById(R.id.taskDetailsTextView);
        dueDateTextView = (TextView) view.findViewById(R.id.taskDueDateTextView);
        repeatModeTextView = (TextView) view.findViewById(R.id.taskRepeadtModeTextView);
        hasNotificationTextView = (TextView) view.findViewById(R.id.taskNotificationTextView);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            userTaskID = getArguments().getInt("id");
        }
        presenter.displayUserTaskDetails(userTaskID);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(false);
        activity.setFabAddEnabled(true);

        activity.setAppBarOpened(false);

        activity.setBackButtonOnToolbarEnabled(false);
        activity.setDrawerEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();

        activity.setToolbarTitle("Task title");

        activity.setFabEditEnabled(true);
        activity.setFabSaveEnabled(false);
        activity.setFabAddEnabled(false);

        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);
    }

    @Override
    public void displayUserTaskDetails(String title, String description, String dueDate, int hasNotification, String repeatMode) {

        //I hope it will work otherwise I would have to use some twisted magic
        getActivity().setTitle(title);

        detailsTextView.setText(description);
        dueDateTextView.setText(dueDate);

        String repeat = getString(R.string.text_repeat) + repeatMode;
        repeatModeTextView.setText(repeat);

        if (hasNotification == 0) {
            hasNotificationTextView.setText(R.string.text_has_reminder);
        } else {
            hasNotificationTextView.setText(R.string.text_no_reminder);
        }
    }

    @Override
    public void changeUserTaskStatus(boolean status) {

    }

    @Override
    public void deleteUserTask(int userTaskID) {

    }

    @Override
    public void editUserTask(int userTaskID) {

    }
}
