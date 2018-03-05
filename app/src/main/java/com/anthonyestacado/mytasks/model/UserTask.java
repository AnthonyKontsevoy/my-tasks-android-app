package com.anthonyestacado.mytasks.model;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public class UserTask {

    public int taskID;
    public int assignedUserID;
    public String title;
    public String description;
    public boolean status;
    public String dueDate;
    public boolean hasNotificationAlert;
    public int repeatMode;

    public int editTask (int ID, int userID, String title, String description, boolean status, String dueDate, boolean hasNotificationAlert, int repeatMode) {
        this.taskID = ID;
        this.assignedUserID = userID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.hasNotificationAlert = hasNotificationAlert;
        this.repeatMode = repeatMode;

        return 0;
    }

    public int changeTaskStatus (boolean status) {
        this.status = status;

        return 0;
    }
}
