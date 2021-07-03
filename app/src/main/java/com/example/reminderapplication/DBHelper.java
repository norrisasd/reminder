package com.example.reminderapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String ID ="ID" ;
    private static final String DATE ="DATE";
    private static final String TIME ="TIME";
    private static final String DESCRIPTION ="DESCRIPTION" ;
    private static final String REMINDER_TABLE ="REMINDER_TABLE";

    public DBHelper(@Nullable Context context) {
        super(context, "reminders.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + REMINDER_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " TEXT, " + TIME + " TEXT, " + DESCRIPTION + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //none
    }

    public boolean createReminder(Reminder r){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DATE,r.getDate());
        cv.put(TIME,r.getTime());
        cv.put(DESCRIPTION,r.getDescription());
        long insert  = db.insert(REMINDER_TABLE,null,cv);
        if(insert==-1)
            return false;
        else
            return true;
    }
    public List<Reminder> displayReminders(){
        List<Reminder> returnList =new ArrayList<>();
        String queryString = "SELECT * FROM " +REMINDER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do{
                int reminderID =cursor.getInt(0);
                String Date = cursor.getString(1);
                String Time=cursor.getString(2);
                String Description = cursor.getString(3);
                Reminder newReminder=new Reminder(reminderID,Date,Time,Description);
                returnList.add(newReminder);
            }while(cursor.moveToNext());
        }
        else {
        }
        cursor.close();
        db.close();
        return returnList;

    }
    public boolean deleteReminder(Reminder r){
        SQLiteDatabase db=this.getWritableDatabase();
        String queryString="DELETE FROM " + REMINDER_TABLE + " WHERE " + ID + " = " +r.getId();
        Cursor cursor= db.rawQuery(queryString,null);
        if(cursor.moveToFirst())
            return true;
        else
            return false;
    }

}
