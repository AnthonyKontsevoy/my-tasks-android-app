package com.anthonyestacado.mytasks.model;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class Model implements Modelnterface {

    private static Model modelInstance;

    private RepositoryInterface sqliteRepo;

    private User currentUser;

    private Model () {
        sqliteRepo = SQLiteRepository.getInstance();
        currentUser = new User();
    }


    public synchronized static Model getModelInstance () {
        if (modelInstance == null) {
            modelInstance = new Model();
        }
        return modelInstance;
    }

    @Override
    public int createTask(String title, String description, int status, String dueDate, String repeatMode) {

        UserTask userTask = new UserTask();
        userTask.setAssignedUserID(currentUser.getUserID());
        userTask.setTitle(title);
        userTask.setDescription(description);
        userTask.setStatus(status);
        userTask.setDueDate(dueDate);
        userTask.setRepeatMode(repeatMode);

        sqliteRepo.saveUserTask(userTask);
        return 0;
    }

    @Override
    public int editTask(int userTaskID, String title, String description, int status, String dueDate, String repeatMode) {

        UserTask userTask = new UserTask();
        userTask.setAssignedUserID(currentUser.getUserID());
        userTask.setTitle(title);
        userTask.setDescription(description);
        userTask.setStatus(status);
        userTask.setDueDate(dueDate);
        userTask.setRepeatMode(repeatMode);

        sqliteRepo.updateUserTask(userTask);

        return 0;
    }

    @Override
    public int deleteTask(int userTaskID) {

        sqliteRepo.deleteUserTask(userTaskID);

        return 0;
    }

    @Override
    public UserTask getUserTaskByID(int userTaskID) {

        return sqliteRepo.getUserTaskByID(userTaskID);
    }

    @Override
    public List<UserTask> getTasks(int selectionModeID) {

        return sqliteRepo.getUserTasks(selectionModeID);
    }

    //TODO: this method is a part of Phase 2 of the task manager task
    @Override
    public int authenticateUser(String username, String password) {
        return 0;
    }

    @Override
    public int changeUserTaskStatus(int userTaskID, int status) {

        UserTask tmpUserTask = sqliteRepo.getUserTaskByID(userTaskID);
        tmpUserTask.setStatus(status);
        sqliteRepo.updateUserTask(tmpUserTask);

        return 0;
    }

    //TODO: this method is a part of Phase 2 of the task manager task
    @Override
    public int setNotificationForTask(int userTaskID) {
        return 0;
    }
}
