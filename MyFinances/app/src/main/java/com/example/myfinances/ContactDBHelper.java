package com.example.myfinances;

import android.database.sqlite.*;
import android.util.*;
import android.content.*;

public class ContactDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myfinances.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation sql statement
    private static final String CREATE_TABLE_CONTACT =
            "create table Account (actn_id integer primary key autoincrement, "
                + "AccountNumber text not null, "
                + "InitialBalance text, "
                + "CurrentBalance text not null, "
                + "InterestRate text, "
                + "PaymentAmount text);";


    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public  void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ContactDBHelper.class.getName(),
            "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS Accounts");
        onCreate(db);
    }
}
