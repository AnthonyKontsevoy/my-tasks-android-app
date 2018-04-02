package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskeditor;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public interface EditUserTaskFragmentPresenterInterface {

    int displayUserTaskDetails(int userTaskID);
    int saveUserTask(String title, String description, String dueDate, int hasNotificationAlert, int repeatMode);
}
