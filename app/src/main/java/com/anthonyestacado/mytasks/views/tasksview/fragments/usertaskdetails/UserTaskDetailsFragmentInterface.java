package com.anthonyestacado.mytasks.views.tasksview.fragments.usertaskdetails;

/**
 * Created by Anthony Kontsevoy on 03.04.2018.
 */
public interface UserTaskDetailsFragmentInterface {
    void displayUserTaskDetails(String title, String description, String dueDate, int hasNotification, String repeatMode);
    void changeUserTaskStatus(boolean status);
    void deleteUserTask(int userTaskID);
    void editUserTask(int userTaskID);
}
