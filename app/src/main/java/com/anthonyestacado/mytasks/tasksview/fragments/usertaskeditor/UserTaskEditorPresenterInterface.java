package com.anthonyestacado.mytasks.tasksview.fragments.usertaskeditor;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public interface UserTaskEditorPresenterInterface {

    int displayUserTaskDetails(int userTaskID);
    int editUserTask(String title, String description, boolean status, String dueDate, boolean hasNotificationAlert, int repeatMode);
}
