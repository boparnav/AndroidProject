package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper
{
    private static final String dbname="list";
    private static final String Table_name="users";

    private static final String COL0="id";
    private static final String COL1="name";
    private static final String COL2="description";


    public DBhelper(Context context){

        super(context, Table_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table " + Table_name + " (id integer primary key autoincrement , " + COL1 + " TEXT , " + COL2 + " TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(String name , String description){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //ContentValues cv1 = new ContentValues();

        cv.put(COL1,name);
        cv.put(COL2,description);

        long result = db.insert(Table_name,null,cv);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select *from " + Table_name;
        Cursor data = db.rawQuery(sql,null);
        return data;
    }

    public void deleteData(int id){
        SQLiteDatabase db=this.getWritableDatabase();

        String sql1="select * from users;";
        Cursor result=db.rawQuery(sql1,null);
        String sql="DELETE FROM users WHERE id="+id;



       // Log.i("Delete query is ", sql);
        db.execSQL(sql);
    }

}
