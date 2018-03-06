package com.anthonyestacado.mytasks.model;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class Model implements IModel {

    private static Model modelInstance;

    private IRepository sqliteRepo;

    private Model () {
        sqliteRepo = new SQLiteRepository();
    }


    public synchronized static Model getModelInstance () {
        if (modelInstance == null) {
            modelInstance = new Model();
        }
        return modelInstance;
    }

    @Override
    public int createTask(String title, String description, boolean status, String dueDate, int repeatMode) {
        return 0;
    }

    @Override
    public int editTask(int userTaskID) {
        return 0;
    }

    @Override
    public int deleteTask(int userTaskID) {
        return 0;
    }

    @Override
    public UserTask getUserTaskByID(int ID) {
        return null;
    }

    @Override
    public List<UserTask> getTasks(int selectionModeID) {
        return null;
    }

    @Override
    public int authenticateUser(String username, String password) {
        return 0;
    }

    @Override
    public int changeUserTaskStatus(boolean status) {
        return 0;
    }

    @Override
    public int setNotificationForTask(int userTaskID) {
        return 0;
    }
}
