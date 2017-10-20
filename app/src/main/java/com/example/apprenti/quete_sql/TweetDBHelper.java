package com.example.apprenti.quete_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.apprenti.quete_sql.DatabaseContract.SQL_CREATE_BELONG;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_CREATE_ORGA;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_CREATE_TWEET;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_CREATE_USER;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_DELETE_BELONG;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_DELETE_ORGA;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_DELETE_TWEET;
import static com.example.apprenti.quete_sql.DatabaseContract.SQL_DELETE_USER;
import static java.security.AccessController.getContext;


public class TweetDBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tweet";

    public TweetDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TWEET);
        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_ORGA);
        db.execSQL(SQL_CREATE_BELONG);
    }
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_TWEET);
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_ORGA);
        db.execSQL(SQL_DELETE_BELONG);
        onCreate(db);
    }
}
