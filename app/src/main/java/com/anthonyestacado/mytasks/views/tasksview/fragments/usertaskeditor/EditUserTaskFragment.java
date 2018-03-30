package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskeditor;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.anthonyestacado.mytasks.R;
import com.anthonyestacado.mytasks.views.tasksview.activity.TasksActivityInterface;

import java.text.DateFormat;
import java.util.Calendar;


public class EditUserTaskFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    private TasksActivityInterface activity;
    private TextView dateTimePickerTextView;

    private int dayTmp, monthTmp, yearTmp, hourTmp, minuteTmp;
    private int day, month, year, hour, minute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit_user_task, container, false);

        activity = (TasksActivityInterface) getActivity();
        activity.setToolbarTitle("New task");

        activity.setFabAddEnabled(false);
        activity.setFabEditEnabled(false);
        activity.setFabSaveEnabled(true);

        activity.setAppBarOpened(true);

        activity.setDrawerEnabled(false);
        activity.setBackButtonOnToolbarEnabled(true);

        Spinner spinner = (Spinner) view.findViewById(R.id.repeatModeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.repeat_mode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        dateTimePickerTextView = (TextView) view.findViewById(R.id.taskDueDateEditText);
        dateTimePickerTextView.setOnClickListener(this);

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

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), this, hourTmp, minuteTmp, true);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hour = i;
        minute = i1;
    }
}
