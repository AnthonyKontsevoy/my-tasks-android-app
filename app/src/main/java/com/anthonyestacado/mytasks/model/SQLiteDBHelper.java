package com.anthonyestacado.mytasks.model;
import android.content.ContentValues;
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
    public static final String KEY_ENTRY_ID = "entry_id";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_LOGIN = "login";
    public static final String KEY_USER_PASSWORD = "password";

    public static Context context;

    public static void setContext(Context receivedContext) {
        context = receivedContext;
    }

    public SQLiteDBHelper() {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Method to create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //define and run the SQL script to initialize TABLE_TASKS
        String CREATE_TABLE_TASKS =
                "CREATE TABLE " + TABLE_TASKS + " " +
                        "("
                            + KEY_TASK_ID + " INTEGER PRIMARY KEY, "
                            + KEY_ASSIGNED_USER_ID + " INTEGER, "
                            + KEY_TASK_TITLE + " TEXT, "
                            + KEY_TASK_DESCRIPTION + " TEXT, "
                            + KEY_TASK_STATUS + " INTEGER, "
                            + KEY_TASK_DUE_DATE + " TEXT, "
                            + KEY_TASK_HAS_NOTIFICATION + " INTEGER, "
                            + KEY_TASK_REPEAT_MODE + " TEXT" +
                        ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_TASKS);

        //define and run the SQL script to initialize TABLE_USERS
        String CREATE_TABLE_USERS =
                "CREATE TABLE " + TABLE_USERS + " " +
                        "("
                            + KEY_ENTRY_ID + " INTEGER PRIMARY KEY, "
                            + KEY_USER_ID + " INTEGER, "
                            + KEY_USER_LOGIN + " TEXT, "
                            + KEY_USER_PASSWORD + " TEXT" +
                        ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);

//        //Inserting tasks with status "In progress"
        for (int i = 0; i < 4; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_ASSIGNED_USER_ID, String.valueOf(1));
            contentValues.put(KEY_TASK_TITLE, "Test title " + String.valueOf(i));
            contentValues.put(KEY_TASK_DESCRIPTION, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
            contentValues.put(KEY_TASK_STATUS, String.valueOf(0));
            contentValues.put(KEY_TASK_DUE_DATE, "2018-03-30 23:59:06");
            contentValues.put(KEY_TASK_HAS_NOTIFICATION, String.valueOf(0));
            contentValues.put(KEY_TASK_REPEAT_MODE, "Never");
            sqLiteDatabase.insert(SQLiteDBHelper.TABLE_TASKS, null, contentValues);
        }

        //Inserting tasks with status "Done"
        for (int i = 4; i < 6; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_ASSIGNED_USER_ID, String.valueOf(1));
            contentValues.put(KEY_TASK_TITLE, "Test title " + String.valueOf(i));
            contentValues.put(KEY_TASK_DESCRIPTION, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
            contentValues.put(KEY_TASK_STATUS, String.valueOf(1));
            contentValues.put(KEY_TASK_DUE_DATE, "2018-03-30 23:59:06");
            contentValues.put(KEY_TASK_HAS_NOTIFICATION, String.valueOf(0));
            contentValues.put(KEY_TASK_REPEAT_MODE, "Never");
            sqLiteDatabase.insert(SQLiteDBHelper.TABLE_TASKS, null, contentValues);
        }
    }

    //This method is called every time when you want to make changes to the database schema
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int currentVersion, int newVersion) {
        //Not needed at the moment.
    }
}
