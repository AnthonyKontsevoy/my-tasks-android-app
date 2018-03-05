package com.anthonyestacado.mytasks.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public class Repository extends SQLiteOpenHelper implements IRepository {

    private SQLiteDatabase database;
    private ContentValues valuesForDB;

    public Repository(Context context) {
        super(context, SQLiteDBHelper.DATABASE_NAME, null, SQLiteDBHelper.DATABASE_VERSION);
    }

    @Override
    public int saveUserTask(UserTask userTask) {

        initDBAndGetDataForInsert(userTask);

        //Insert values into the database
        database.insert(SQLiteDBHelper.TABLE_TASKS, null, valuesForDB);
        database.close();

        return 0;
    }

    public int updateUserTask(UserTask userTask) {
        //TODO mplement this method as shown here: https://www.androidhive.info/2011/11/android-sqlite-database-tutorial/

        return 0;
    }

    private void initDBAndGetDataForInsert(UserTask userTask){

        //Prepare the database for inserting data
        database = this.getWritableDatabase();

        //Prepare values that will be inserted
        valuesForDB = new ContentValues();
        valuesForDB.put(SQLiteDBHelper.KEY_ASSIGNED_USER_ID, userTask.assignedUserID);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_TITLE, userTask.title);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_DESCRIPTION, userTask.description);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_STATUS, userTask.status);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_DUE_DATE, userTask.dueDate);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_HAS_NOTIFICATION, userTask.hasNotificationAlert);
        valuesForDB.put(SQLiteDBHelper.KEY_TASK_REPEAT_MODE, userTask.repeatMode);
    }

    @Override
    public int deleteUserTask(UserTask userTask) {
        return 0;
    }

    //This method is used to get a list of tasks based on the selection mode
    //where 0 = all tasks, 1 - in progress, 2 - done
    @Override
    public int getUserTasks(int selection_mode) {

        List<UserTask> userTasksList = new ArrayList<UserTask>();

        String selectQuery;
        switch(selection_mode) {
            case 0: selectQuery = "SELECT  * FROM " + SQLiteDBHelper.TABLE_TASKS;
            case 1: selectQuery = "SELECT  * FROM " + SQLiteDBHelper.TABLE_TASKS + " WHERE " + SQLiteDBHelper.KEY_TASK_STATUS + " = false";
            case 2: selectQuery = "SELECT  * FROM " + SQLiteDBHelper.TABLE_TASKS + " WHERE " + SQLiteDBHelper.KEY_TASK_STATUS + " = true";
            default: selectQuery = "SELECT  * FROM " + SQLiteDBHelper.TABLE_TASKS;
        }

        //TODO: implement this method so it will return a list of tasks from the database

        return 0;
    }

    @Override
    public List<String> validateUserCredentials(String username, String password) {
        return null;
    }

    //This method is called when you create the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLiteDBHelper.CREATE_TABLE_TASKS_QUERY);
        sqLiteDatabase.execSQL(SQLiteDBHelper.CREATE_TABLE_USERS_QUERY);
        sqLiteDatabase.execSQL(SQLiteDBHelper.CREATE_TABLE_REPEAT_MODES_QUERY);
    }

    //This method is called when you update your app and need to make changes to the database schema
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //No need for it at the moment
    }
}
