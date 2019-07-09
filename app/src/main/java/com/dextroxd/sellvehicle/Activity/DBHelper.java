package com.dextroxd.sellvehicle.Activity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dextroxd.sellvehicle.Model.ModelCard;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_1="status.db";
    public static final String TABLE_1="status_table";
    public static final String col1="cost";
    public static final String col3="bedrooms";
    public static final String col0="id";
    public static final String col5="furnishing";

    public DBHelper(Context context){
        super(context,DATABASE_1,null,3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_1 + "("
                +col0+ " INTEGER PRIMARY KEY AUTOINCREMENT," + col1 + " TEXT,"
                + col3 + " VARCHAR,"  + col5+ " TEXT"+")";
        db.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        onCreate(db);

    }
    public  int adddata(String bedroom,String furnishing,String cost){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
       contentValues.put(col1,cost);
        contentValues.put(col3,bedroom);
        contentValues.put(col5,furnishing);

        long result=db.insert(TABLE_1,null,contentValues);
        ModelCard modelCard=new ModelCard(cost,bedroom,furnishing);
        modelCard.setCost(cost);
        modelCard.setBedroom(bedroom);
        modelCard.setFurnishing(furnishing);
        if(result==-1)
            return 0;
        else
            return 1;
    }
    public Cursor getListContents(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM status_table WHERE emailId = '"+email+"'", null);
        return data;
    }
    public Cursor getListContents1(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+TABLE_1, null);
        return data;
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

}
