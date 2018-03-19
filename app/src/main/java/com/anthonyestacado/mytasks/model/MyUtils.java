package com.anthonyestacado.mytasks.model;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Kontsevoy on 12.03.2018.
 */

public class MyUtils {

    public static String selectOnlyDateFromString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        String month = stringBuilder.substring(5, 7);
        switch (month) {
            case "01": {
                month = "Jan";
                break;
            }
            case "02": {
                month = "Feb";
                break;
            }
            case "03": {
                month = "Mar";
                break;
            }
            case "04": {
                month = "Apr";
                break;
            }
            case "05": {
                month = "May";
                break;
            }
            case "06": {
                month = "Jun";
                break;
            }
            case "07": {
                month = "Jul";
                break;
            }
            case "08": {
                month = "Aug";
                break;
            }
            case "09": {
                month = "Sep";
                break;
            }
            case "10": {
                month = "Oct";
                break;
            }
            case "11": {
                month = "Nov";
                break;
            }
            case "12": {
                month = "Dec";
                break;
            }
        }
        String convertedDate = month + " " + stringBuilder.substring(8, 10);
        return convertedDate;
    }

    public static String selectOnlyTimeFromString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.substring(11,16);
    }

    public static List<UserTask> getListOfUserTasksForDebug() {

        List<UserTask> userTasksForDebug = new ArrayList<UserTask>();

        for (int i = 0; i < 5; i++) {

            UserTask userTask = new UserTask();

            userTask.setTaskID(1);
            userTask.setAssignedUserID(1);
            userTask.setTitle("Test title" + String.valueOf(i));
            userTask.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
            userTask.setStatus(0);
            userTask.setDueDate("2018-03-30 23:59:06");
            userTask.setHasNotificationAlert(0);
            userTask.setRepeatMode("never");
            userTask.setAttachedUser(null);

            userTasksForDebug.add(userTask);

            UserTask userTask1 = new UserTask();

            userTask1.setTaskID(1);
            userTask1.setAssignedUserID(1);
            userTask1.setTitle("Test title" + String.valueOf(i + 1));
            userTask1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
            userTask1.setStatus(1);
            userTask1.setDueDate("2018-03-30 23:59:06");
            userTask1.setHasNotificationAlert(0);
            userTask1.setRepeatMode("never");
            userTask1.setAttachedUser(null);

            userTasksForDebug.add(userTask1);
        }

        return userTasksForDebug;
    }
}
