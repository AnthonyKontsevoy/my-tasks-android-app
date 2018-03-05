package com.anthonyestacado.mytasks.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public class SQLiteDBHelperOld extends SQLiteOpenHelper {

    //DB version and name declaration
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "taskManager";

    //Declaration of the table for storing information about tasks
    public static final String TABLE_TASKS = "tasks";
    public static final String KEY_TASK_ID = "task_id";
    public static final String KEY_ASSIGNED_USER_ID = "assigned_user_id";
    public static final String KEY_TASK_TITLE = "title";
    public static final String KEY_TASK_DESCRIPTION = "description";
    public static final String KEY_TASK_STATUS = "status";
    public static final String KEY_TASK_DUE_DATE = "due_date";
    public static final String KEY_TASK_HAS_NOTIFICATION = "has_notification";
    public static final String KEY_TASK_REPEAT_MODE = "repeat_mode";

    //Declaration of the table for storing information about users
    public static final String TABLE_USERS = "users";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_LOGIN = "login";
    public static final String KEY_USER_PASSWORD = "password";

    //Declaration of the table for storing information about repeat modes and their IDs
    public static final String TABLE_REPEAT_MODES = "repeat_modes";
    public static final String KEY_MODE_ID = "mode_id";
    public static final String KEY_MODE_VALUE = "value";
    public static final String KEY_MODE_DESCRIPTION = "description";

    public SQLiteDBHelperOld(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Method to create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //define and run the SQL script to initialize TABLE_TASKS
        String CREATE_TABLE_TASKS =
                "CREATE TABLE " + TABLE_TASKS +
                        "("
                            + KEY_TASK_ID + " INTEGER PRIMARY KEY,"
                            + KEY_ASSIGNED_USER_ID + " INTEGER"
                            + KEY_TASK_TITLE + " TEXT"
                            + KEY_TASK_DESCRIPTION + " TEXT"
                            + KEY_TASK_STATUS + " BOOLEAN"
                            + KEY_TASK_DUE_DATE + " TEXT"
                            + KEY_TASK_HAS_NOTIFICATION + "BOOLEAN"
                            + KEY_TASK_REPEAT_MODE + " INTEGER" +
                        ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_TASKS);

        //define and run the SQL script to initialize TABLE_USERS
        String CREATE_TABLE_USERS =
                "CREATE TABLE " + TABLE_USERS +
                        "("
                            + KEY_USER_ID + " INTEGER PRIMARY KEY,"
                            + KEY_USER_LOGIN + " TEXT"
                            + KEY_USER_PASSWORD + " TEXT" +
                        ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);

        //define and run the SQL script to initialize TABLE_REPEATE_MODES
        String CREATE_TABLE_REPEAT_MODES =
                "CREATE TABLE " + TABLE_REPEAT_MODES +
                        "("
                            + KEY_MODE_ID + " INTEGER PRIMARY KEY,"
                            + KEY_MODE_VALUE + " INTEGER"
                            + KEY_MODE_DESCRIPTION + " TEXT" +
                        ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_REPEAT_MODES);
    }

    //This method is called every time when you want to make changes to the database schema
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int currentVersion, int newVersion) {
        //Not needed at the moment.
    }

    //This method is used to add new tasks to the database
    public int addUserTask(UserTask userTask) {

        //Prepare the databse for inserting data
        SQLiteDatabase database = this.getWritableDatabase();

        //Prepare values that will be inserted
        ContentValues valuesForDB = new ContentValues();
        valuesForDB.put(KEY_ASSIGNED_USER_ID, userTask.assignedUserID);
        valuesForDB.put(KEY_TASK_TITLE, userTask.title);
        valuesForDB.put(KEY_TASK_DESCRIPTION, userTask.description);
        valuesForDB.put(KEY_TASK_STATUS, userTask.status);
        valuesForDB.put(KEY_TASK_DUE_DATE, userTask.dueDate);
        valuesForDB.put(KEY_TASK_HAS_NOTIFICATION, userTask.hasNotificationAlert);
        valuesForDB.put(KEY_TASK_REPEAT_MODE, userTask.repeatMode);

        //Insert values into the database
        database.insert(TABLE_TASKS, null, valuesForDB);
        database.close();

        return 0;
    }

    public int updateUserTask(UserTask userTask) {
        return 0;
    }
}
