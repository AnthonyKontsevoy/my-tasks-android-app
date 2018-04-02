package com.anthonyestacado.mytasks.model;

import com.anthonyestacado.mytasks.common.RepeatMode;
import com.anthonyestacado.mytasks.common.TaskStatuses;

import java.util.List;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class Model implements ModelInterface {

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
    public int createTask(String title, String description, String dueDate, int hasNotification, RepeatMode repeatMode) {

        UserTask userTask = new UserTask();
        userTask.setAssignedUserID(currentUser.getUserID());
        userTask.setTitle(title);
        userTask.setDescription(description);
        userTask.setStatus(0);
        userTask.setDueDate(dueDate);
        userTask.setHasNotificationAlert(hasNotification);
        userTask.setRepeatMode(repeatMode.getRepeatMode());

        sqliteRepo.saveUserTask(userTask);

        return 0;
    }

    @Override
    public int editTask(int userTaskID, String title, String description, String dueDate, TaskStatuses status, int hasNotification, RepeatMode repeatMode) {

        UserTask userTask = new UserTask();
        userTask.setAssignedUserID(currentUser.getUserID());
        userTask.setTitle(title);
        userTask.setDescription(description);
        userTask.setStatus(status.getStatus());
        userTask.setDueDate(dueDate);
        userTask.setRepeatMode(repeatMode.getRepeatMode());

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
    public List<UserTask> getTasks(TaskStatuses selectionMode) {

        return sqliteRepo.getUserTasks(selectionMode);
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
