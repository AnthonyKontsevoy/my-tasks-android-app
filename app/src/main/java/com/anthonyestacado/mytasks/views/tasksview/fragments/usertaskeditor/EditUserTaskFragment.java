package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskeditor;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.common.RepeatMode;
import com.anthonyestacado.mytasks.views.tasksview.activity.TasksActivityInterface;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class EditUserTaskFragment extends Fragment
                                  implements EditUserTaskFragmentInterface,
                                             View.OnClickListener,
                                             DatePickerDialog.OnDateSetListener,
                                             TimePickerDialog.OnTimeSetListener {

    private TasksActivityInterface activity;
    private EditUserTaskFragmentPresenterInterface presenter;

    private FloatingActionButton saveFab;

    private EditText taskTitleEditText;
    private EditText taskDescriptionEditText;
    private TextView dateTimePickerTextView;
    private Switch notificationSwitch;
    private Spinner repeatModeSpinner;

    private String taskTitle, taskDescription, taskDueDate;
    private int taskStatus, taskRepeatMode, hasNotification;

    private int dayTmp, monthTmp, yearTmp, hourTmp, minuteTmp;
    private int day, month, year, hour, minute;

    private String formattedDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit_user_task, container, false);

        presenter = new EditUserTaskFragmentPresenter(getActivity(), this);

        activity = (TasksActivityInterface) getActivity();
        activity.setToolbarTitle(getString(R.string.text_new_task));

        activity.setFabAddEnabled(false);
        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(true);

        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);

        saveFab = activity.getFabSave();
        saveFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: make changes in this line of method when you will be implementing notifications and repeat modes.
                getUserInput();
                presenter.saveUserTask(taskTitle, taskDescription, taskDueDate, hasNotification, taskRepeatMode);

            }
        });

        taskTitleEditText = (EditText) view.findViewById(R.id.taskTitleEditText);
        taskDescriptionEditText = (EditText) view.findViewById(R.id.taskDescriptionEditText);

        dateTimePickerTextView = (TextView) view.findViewById(R.id.taskDueDateEditText);
        dateTimePickerTextView.setOnClickListener(this);

        notificationSwitch = (Switch) view.findViewById(R.id.notificationSwitch);

        repeatModeSpinner = (Spinner) view.findViewById(R.id.repeatModeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.repeat_mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repeatModeSpinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

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

        activity.setToolbarTitle("New task");

        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(true);
        activity.setFabAddEnabled(false);

        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.taskDueDateEditText: {
                Calendar calendar = Calendar.getInstance();

                yearTmp = calendar.get(Calendar.YEAR);
                monthTmp = calendar.get(Calendar.MONTH);
                dayTmp = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, yearTmp, monthTmp, dayTmp);
                datePickerDialog.show();
                break;
            }
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year = i;
        month = i1 + 1;
        day = i2;

        Calendar cal = Calendar.getInstance();

        hourTmp = cal.get(Calendar.HOUR_OF_DAY);
        minuteTmp = cal.get(Calendar.MINUTE);

        Date chosenDate = cal.getTime();
        DateFormat dateFormatUS = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        formattedDate = dateFormatUS.format(chosenDate);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), this, hourTmp, minuteTmp, true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hour = i;
        minute = i1;

        dateTimePickerTextView.setText(formattedDate);
    }

    @Override
    public void getUserInput() {
        taskTitle = String.valueOf(taskTitleEditText.getText());
        taskDescription = String.valueOf(taskDescriptionEditText.getText());
        taskDueDate = formattedDate + " " + hour + ":" + minute;
        taskStatus = 0; //Because when it is created it is in the "in progress" state
        String.valueOf(dateTimePickerTextView.getText());
        hasNotification = 0; //we will leave it as a default value for now until we implement notifications feature
        taskRepeatMode = 0;

    }

    @Override
    public void fillInputFieldsWithData(String title, String description, String dueDate, boolean hasNotification, int repeatMode) {
        taskTitleEditText.setText(title);
        taskDescriptionEditText.setText(description);
        dateTimePickerTextView.setText(dueDate);

        notificationSwitch.setChecked(hasNotification);
        repeatModeSpinner.setSelection(repeatMode);
    }

    @Override
    public void makeInputFieldsEmpty() {
        taskTitleEditText.setText("");
        taskDescriptionEditText.setText("");
        dateTimePickerTextView.setText("");

        notificationSwitch.setChecked(false);
        repeatModeSpinner.setSelection(0);
    }
}
