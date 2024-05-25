package ru.mirea_.rybina_iboldova.jiraf_john;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InternalStorage extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "storage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USERS = "users";
    private static final String TABLE_UNIT_ANSWERS = "unit_answers";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";

    private static final String COLUMN_ANSWER_ID = "answer_id";
    private static final String COLUMN_UNIT_NUMBER = "unit_number";
    private static final String COLUMN_USER_ID_FK = "user_id_fk";
    private static final int REQUIRED_ANSWERS_COUNT = 1;
    private Context context;

    public InternalStorage(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTableQuery = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LOGIN + " TEXT," +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createUserTableQuery);

        String createUnitAnswersTableQuery = "CREATE TABLE " + TABLE_UNIT_ANSWERS + " (" +
                COLUMN_ANSWER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_UNIT_NUMBER + " INTEGER," +
                COLUMN_USER_ID_FK + " INTEGER," +
                "FOREIGN KEY(" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "))";
        db.execSQL(createUnitAnswersTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIT_ANSWERS);
        onCreate(db);
    }

    public void createUser(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN, login);
        values.put(COLUMN_PASSWORD, password);
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public boolean loginUser(String login, String password) {
        String selectQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " +
                COLUMN_LOGIN + " = '" + login + "' AND " +
                COLUMN_PASSWORD + " = '" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean result = cursor.moveToFirst();
        cursor.close();
        db.close();
        return result;
    }

    public void addAnswerToUnit(int unitNumber, int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_UNIT_NUMBER, unitNumber);
        values.put(COLUMN_USER_ID_FK, userId);
        db.insert(TABLE_UNIT_ANSWERS, null, values);
        db.close();
    }

    public boolean checkUnitCompletion(int unitNumber, int userId) {
        String selectQuery = "SELECT COUNT(*) FROM " + TABLE_UNIT_ANSWERS + " WHERE " +
                COLUMN_UNIT_NUMBER + " = " + unitNumber + " AND " +
                COLUMN_USER_ID_FK + " = " + userId;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        db.close();
        return count >= REQUIRED_ANSWERS_COUNT;
    }
}
