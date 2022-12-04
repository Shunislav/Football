package com.example.football;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBClass extends SQLiteOpenHelper {

    private final Context context;
    private static final String DataBase_Name = "AC.db";
    private static final int DataBase_Version = 1;

    private static final String Table_Name = "Footbal";
    private static String Column_Guest = "guest";
    private static final String Column_Home = "home";
    private static final String Column_GoalGuest = "GoalG";
    private static final String Column_GoalHome = "GoalH";
    private static final String ID = "id";




    public DBClass(@Nullable Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "Create Table " + Table_Name +
                        " (" + ID + " Integer PRIMARY KEY AUTOINCREMENT, " +
                        Column_Home + " Text, " +
                        Column_Guest + " Text, " +
                        Column_GoalHome + " Text, " +
                        Column_GoalGuest + " Text);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists " + Table_Name);
        onCreate(db);

    }

    void add_users(String home, String guest, String goalh,String goalg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Column_Home, home);
        cv.put(Column_Guest, guest);
        cv.put(Column_GoalHome, goalh);
        cv.put(Column_GoalGuest, goalg);

        long result = db.insert(Table_Name,null, cv);
        if(result == -1)
        {
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Added Successfully", Toast.LENGTH_SHORT).show();
        }

    }

}
