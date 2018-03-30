package com.anthonyestacado.mytasks.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.anthonyestacado.mytasks.common.Tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Kontsevoy on 06.03.2018.
 */

public class SQLiteRepository  implements RepositoryInterface {


    //For singleton
    private static SQLiteRepository instance;

    private static SQLiteDBHelper database;
    private ContentValues valuesForDB;

    //Singelton method for getting SQLiteRepository instance
    public static SQLiteRepository getInstance () {
        if (instance == null) {
            instance = new SQLiteRepository();
            database = new SQLiteDBHelper();
        }
        return instance;
    }

    //This method is used when you need to save a task to the database
    @Override
    public int saveUserTask(UserTask userTask) {

        getDataForInsert(userTask);

        //Insert values into the database
        database.getWritableDatabase().insert(SQLiteDBHelper.TABLE_TASKS, null, valuesForDB);
        database.close();

        return 0;
    }

    //This method is used when you need to update info about task in the database
    @Override
    public int updateUserTask(UserTask userTask) {

        getDataForInsert(userTask);

        return database.getReadableDatabase().update(SQLiteDBHelper.TABLE_TASKS, valuesForDB, SQLiteDBHelper.KEY_TASK_ID + " = ?", new String[] { String.valueOf(userTask.getTaskID()) } );
    }

    //This method is called to initialize connection to the database and to prepare data for insertion
    private void getDataForInsert(UserTask userTask){

        //Prepare values that will be inserted
        valuesForDB = new ContentValues();
        valuesForDB.put(SQLiteDBHelper.KEY_ASSIGNED_USER_ID, userTask.getAssignedUserID());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_TITLE, userTask.getTitle());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_DESCRIPTION, userTask.getDescription());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_STATUS, userTask.getStatus());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_DUE_DATE, userTask.getDueDate());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION, userTask.getHasNotificationAlert());
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_REPEAT_MODE, userTask.getRepeatMode());
    }

    //This method is called when you need to delete a specific task from the database
    @Override
    public int deleteUserTask(int userTaskID) {

        database.getWritableDatabase().delete(SQLiteDBHelper.TABLE_TASKS, SQLiteDBHelper.KEY_TASK_ID + " = ?", new String[] { String.valueOf(userTaskID) } );
        database.close();

        return 0;
    }

    //This method is called when you need to get a specific task by its ID
    @Override
    public UserTask getUserTaskByID(int userTaskID) {

        String selectQuery = "SELECT * FROM " + SQLiteDBHelper.TABLE_TASKS + " WHERE " + SQLiteDBHelper.KEY_TASK_ID + " =  ?" + String.valueOf(userTaskID);

        Cursor cursor = database.getWritableDatabase().rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        UserTask userTask = new UserTask();
        userTask.editTask(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7)
        );

        cursor.close();

        return userTask;
    }

    //This method is used to get a list of tasks based on the selection mode
    //where 0 = all tasks, 1 - in progress, 2 - done
    @Override
    public List<UserTask> getUserTasks(Tasks selectionMode) {

        List<UserTask> userTasksList = new ArrayList<UserTask>();

        //Define queries for each selection mode (all tasks, in progress or done)
        String selectQuery = "";

        Cursor cursor;

        switch(selectionMode) {
            //All tasks
            case ALL: {
//                selectQuery = "SELECT * FROM " + SQLiteDBHelper.TABLE_TASKS;
                cursor = database.getWritableDatabase().query(
                        false,
                        SQLiteDBHelper.TABLE_TASKS,
                        new String[] {
                                SQLiteDBHelper.KEY_TASK_ID,
                                SQLiteDBHelper.KEY_ASSIGNED_USER_ID,
                                SQLiteDBHelper.KEY_TASK_TITLE,
                                SQLiteDBHelper.KEY_TASK_DESCRIPTION,
                                SQLiteDBHelper.KEY_TASK_STATUS,
                                SQLiteDBHelper.KEY_TASK_DUE_DATE,
                                SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION,
                                SQLiteDBHelper.KEY_TASK_REPEAT_MODE
                        },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
                break;
            }

            //In progress
            case IN_PROGRESS:{
//                selectQuery = "SELECT * FROM " + SQLiteDBHelper.TABLE_TASKS + " WHERE " + SQLiteDBHelper.KEY_TASK_STATUS + " = FALSE";
                cursor = database.getWritableDatabase().query(
                        false,
                        SQLiteDBHelper.TABLE_TASKS,
                        new String[] {
                                SQLiteDBHelper.KEY_TASK_ID,
                                SQLiteDBHelper.KEY_ASSIGNED_USER_ID,
                                SQLiteDBHelper.KEY_TASK_TITLE,
                                SQLiteDBHelper.KEY_TASK_DESCRIPTION,
                                SQLiteDBHelper.KEY_TASK_STATUS,
                                SQLiteDBHelper.KEY_TASK_DUE_DATE,
                                SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION,
                                SQLiteDBHelper.KEY_TASK_REPEAT_MODE
                        },
                        SQLiteDBHelper.KEY_TASK_STATUS + " = 0",
                        null,
                        null,
                        null,
                        null,
                        null);
                break;
            }

            //Done tasks
            case DONE: {
//                selectQuery = "SELECT * FROM " + SQLiteDBHelper.TABLE_TASKS + " WHERE " + SQLiteDBHelper.KEY_TASK_STATUS + " = TRUE";
                cursor = database.getWritableDatabase().query(
                        false,
                        SQLiteDBHelper.TABLE_TASKS,
                        new String[] {
                                SQLiteDBHelper.KEY_TASK_ID,
                                SQLiteDBHelper.KEY_ASSIGNED_USER_ID,
                                SQLiteDBHelper.KEY_TASK_TITLE,
                                SQLiteDBHelper.KEY_TASK_DESCRIPTION,
                                SQLiteDBHelper.KEY_TASK_STATUS,
                                SQLiteDBHelper.KEY_TASK_DUE_DATE,
                                SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION,
                                SQLiteDBHelper.KEY_TASK_REPEAT_MODE
                        },
                        SQLiteDBHelper.KEY_TASK_STATUS + " = 1",
                        null,
                        null,
                        null,
                        null,
                        null);
                break;
            }
                //Default query which returns all tasks
            default: {
//                selectQuery = "SELECT * FROM " + SQLiteDBHelper.TABLE_TASKS;
                cursor = database.getWritableDatabase().query(
                        false,
                        SQLiteDBHelper.TABLE_TASKS,
                        new String[] {
                                SQLiteDBHelper.KEY_TASK_ID,
                                SQLiteDBHelper.KEY_ASSIGNED_USER_ID,
                                SQLiteDBHelper.KEY_TASK_TITLE,
                                SQLiteDBHelper.KEY_TASK_DESCRIPTION,
                                SQLiteDBHelper.KEY_TASK_STATUS,
                                SQLiteDBHelper.KEY_TASK_DUE_DATE,
                                SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION,
                                SQLiteDBHelper.KEY_TASK_REPEAT_MODE
                        },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
            }
        }

        //Looping through all rows and adding data to the list
        if (cursor.moveToFirst()) {
            do {
                UserTask userTask = new UserTask();
                userTask.editTask(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7)
                );

                // Adding tasks to the list
                userTasksList.add(userTask);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return userTasksList;
    }

    //TODO: Implement this method when you'll start working on multi-user support in this app
    @Override
    public List<String> validateUserCredentials(String username, String password) {
        return null;
    }
}
