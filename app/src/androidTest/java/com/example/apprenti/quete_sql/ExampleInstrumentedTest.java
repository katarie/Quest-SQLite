package com.example.apprenti.quete_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.apprenti.quete_sql", appContext.getPackageName());
    }
    @Test
    public void testDB() throws Exception {

        Context appContext = InstrumentationRegistry.getTargetContext();

        TweetDBHelper mDbHelper = new TweetDBHelper(appContext);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();


        //User table
        ContentValues user = new ContentValues();
        user.put(DatabaseContract.UserEntry.COLUMN_NAME_NAME, "Michel");
        long newUserId = db.insert(DatabaseContract.UserEntry.TABLE_NAME, null, user);
        assertNotEquals(-1, newUserId);

        //Orga table
        ContentValues organization = new ContentValues();
        organization.put(DatabaseContract.OrganizationEntry.COLUMN_NAME_NAME, "Organization");
        long newOrganizationId = db.insert(DatabaseContract.OrganizationEntry.TABLE_NAME, null, organization);
        assertNotEquals(-1, newOrganizationId);

        //Tweet table
        for (int i = 0; i < 10; i++) {
            ContentValues tweet = new ContentValues();
            tweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT, "content " + i);
            tweet.put(DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID, newUserId);
            long newTweetId = db.insert(DatabaseContract.TweetEntry.TABLE_NAME, null, tweet);
            assertNotEquals(-1, newTweetId);

        }

        String query = "SELECT * FROM " + DatabaseContract.TweetEntry.TABLE_NAME +
                " WHERE " + DatabaseContract.TweetEntry.COLUMN_NAME_USER_ID + " = " + String.valueOf(newUserId) + ";";

        Cursor result = db.rawQuery(query, null);

        int i = 0;
        while (result.moveToNext()) {
            String content = result.getString(result.getColumnIndex(DatabaseContract.TweetEntry.COLUMN_NAME_CONTENT));
            assertEquals("content " + i, content);
            i++;

        }

        result.close();
        appContext.deleteDatabase(TweetDBHelper.DATABASE_NAME);
    }
}
