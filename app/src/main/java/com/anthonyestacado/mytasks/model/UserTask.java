package com.anthonyestacado.mytasks.model;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public class UserTask {

    private int taskID;
    private int assignedUserID;
    private String title;
    private String description;
    private int status;
    private String dueDate;
    private int hasNotificationAlert;
    private String repeatMode;

    public int getTaskID() {
        return taskID;
    }
    public void setTaskID (int taskID) {
        this.taskID = taskID;
    }

    public int getAssignedUserID() {
        return assignedUserID;
    }
    public void setAssignedUserID (int assignedUserID) {
        this.assignedUserID = assignedUserID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription (String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus (int status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate (String dueDate) {
        this.dueDate = dueDate;
    }

    public int getHasNotificationAlert() {
        return hasNotificationAlert;
    }
    public void setHasNotificationAlert (int hasNotificationAlert) {
        this.hasNotificationAlert = hasNotificationAlert;
    }

    public String getRepeatMode() {
        return repeatMode;
    }
    public void setRepeatMode (String repeatMode) {
        this.repeatMode = repeatMode;
    }

    public int editTask (int ID, int userID, String title, String description, int status, String dueDate, int hasNotificationAlert, String repeatMode) {
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

    public void changeTaskStatus (int status) {
        this.status = status;
    }
}
