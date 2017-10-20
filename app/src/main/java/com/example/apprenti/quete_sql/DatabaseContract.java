package com.example.apprenti.quete_sql;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static class TweetEntry implements BaseColumns {
        public static final String TABLE_NAME = "tweet";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_USER_ID = "id_user";
    }
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ID = "id";
    }

    public static class OrganizationEntry implements BaseColumns {
        public static final String TABLE_NAME = "organization";
        public static final String COLUMN_NAME_NAME = "name_Orga";
        public static final String COLUMN_NAME_ID = "id";
    }
    public static class BelongEntry implements BaseColumns {
        public static final String TABLE_NAME = "Belong";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_USER_ID = "id_user";
        public static final String COLUMN_NAME_ORGA_ID = "id_orga";
    }

    public static final String SQL_CREATE_TWEET =
            "CREATE TABLE " + TweetEntry.TABLE_NAME + " (" +
                    TweetEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TweetEntry.COLUMN_NAME_CONTENT + " TEXT," +
                    TweetEntry.COLUMN_NAME_USER_ID + " INTEGER);";
    public static final String SQL_CREATE_USER =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    UserEntry.COLUMN_NAME_NAME + " TEXT);";
    public static final String SQL_CREATE_ORGA =
            "CREATE TABLE " + OrganizationEntry.TABLE_NAME + " (" +
                    OrganizationEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    OrganizationEntry.COLUMN_NAME_NAME + " TEXT);";
    public static final String SQL_CREATE_BELONG =
            "CREATE TABLE " + BelongEntry.TABLE_NAME + " (" +
                    BelongEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    BelongEntry.COLUMN_NAME_USER_ID + " INTEGER," +
                    BelongEntry.COLUMN_NAME_ORGA_ID + " INTEGER);";

    public static final String SQL_DELETE_TWEET =
            "DROP TABLE IF EXISTS " + TweetEntry.TABLE_NAME;
    public static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;
    public static final String SQL_DELETE_ORGA =
            "DROP TABLE IF EXISTS " + OrganizationEntry.TABLE_NAME;
    public static final String SQL_DELETE_BELONG =
            "DROP TABLE IF EXISTS " + BelongEntry.TABLE_NAME;
}
