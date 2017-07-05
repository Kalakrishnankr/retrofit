package com.example.inspire.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.ResultSet;

/**
 * Created by inspire on 17/05/2017.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME ="mydb" ;
    private static final String TABLE_NAME= "employee";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_LNAME="lname";
    private static final String COLUMN_DOB="dob";
    private static final String COLUMN_DOJ="doj";
    private static final String COLUMN_DEPARTMENT="department";
    private static final String COLUMN_POSITION="position";
    private static final String COLUMN_SALARY="salary";
    private static final String COLUMN_USERNAM="username";
    private static final String COLUMN_PASSWORD="password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table employee"+"( id int primary key,name text,lname text,dob text,doj text,department text,position text,salary text,username text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    public boolean insertTable(String nm, String ln, String dateb, String datej, String sal, String spinner, String spinner1,String uname,String password) {

       try {
           SQLiteDatabase db = this.getWritableDatabase();
           ContentValues insertValues = new ContentValues();
           insertValues.put("name",nm);
           insertValues.put("lname",ln);
           insertValues.put("dob",dateb);
           insertValues.put("doj",datej);
           insertValues.put("salary",sal);
           insertValues.put("department",spinner);
           insertValues.put("position",spinner1);
           insertValues.put("username",uname);
           insertValues.put("password",password);
           long flag= db.insert("employee", null, insertValues);
           Log.e("","" + flag);
       }catch (Exception e)
       {
           e.printStackTrace();
       }

        return true;
    }

    public Object getData() {
        Cursor data= null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            data = db.rawQuery("SELECT  * FROM employee",null);
        }catch (Exception e){
            e.printStackTrace();
        }
             return data;
    }

    public Cursor login(String un, String pd) {
        Cursor data = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            data = db.rawQuery("SELECT * FROM employee where username= '" + un + "' and password = '" + pd + "'", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
