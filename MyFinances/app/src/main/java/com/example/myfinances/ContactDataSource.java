package com.example.myfinances;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;

public class ContactDataSource {

    //declaration
    private SQLiteDatabase database;
    private ContactDBHelper dbHelper;

    public ContactDataSource(Context context) {
        dbHelper = new ContactDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}
