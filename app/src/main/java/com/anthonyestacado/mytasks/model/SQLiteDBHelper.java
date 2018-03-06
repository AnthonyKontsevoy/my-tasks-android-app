package com.anthonyestacado.mytasks.model;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anthony Kontsevoy on 05.03.2018.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {

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

    public SQLiteDBHelper(Context context) {
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
                            + KEY_TASK_STATUS + " INTEGER"
                            + KEY_TASK_DUE_DATE + " TEXT"
                            + KEY_TASK_HAS_NOTIFICATION + "INTEGER"
                            + KEY_TASK_REPEAT_MODE + "TEXT" +
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
    }

    //This method is called every time when you want to make changes to the database schema
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int currentVersion, int newVersion) {
        //Not needed at the moment.
    }
}
