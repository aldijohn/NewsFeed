package com.example.oljas.newsfeed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by oljas on 29.05.2016.
 */
public class NewsDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="news.db";
    public static final String COLUMN_ID="_id";
    public static final String TABLE_NEWS="news";
    public static final String COLUMN_TITLE="title";
    public static final String COLUMN_TEXT="text";
    public static final String COLUMN_DATE="date";
    public static final String COLUMN_CATEGORY="category";
    public static final String COLUMN_SOURCEURL="sourceurl";

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+TABLE_NEWS+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_TITLE+" TEXT, "+COLUMN_TEXT+" TEXT, "+COLUMN_CATEGORY+" TEXT, "+
                COLUMN_DATE+" TEXT, "+COLUMN_SOURCEURL+" TEXT "+");";

db.execSQL(query);
 }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NEWS);
        onCreate(db);
    }

    public void addNews(News news)
    {
        ContentValues values=new ContentValues();
          values.put(COLUMN_TITLE,news.getTitle());
          values.put(COLUMN_TEXT,news.getText());
          values.put(COLUMN_CATEGORY,news.getCategory());
          values.put(COLUMN_DATE,news.getDate());
          values.put(COLUMN_SOURCEURL,news.getSourceurl());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NEWS,null,values);
        db.close();
    }

    public void deleteNews(String title)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NEWS+" WHERE "+COLUMN_TITLE+"=\""+title+"\";" );

    }
public String[] titlearray(String category)
{
    SQLiteDatabase db=getWritableDatabase();
    String query="SELECT * FROM "+TABLE_NEWS+" WHERE "+COLUMN_CATEGORY+"=\""+category+"\";";
    ArrayList<String> newsarray=new ArrayList<String>();
    Cursor c = db.rawQuery(query, null);
    c.moveToFirst();
    while (!c.isAfterLast()) {
        if (c.getString(c.getColumnIndex("title")) != null) {
            newsarray.add(c.getString(c.getColumnIndex("title")));

        }
        c.moveToNext();
    }
    db.close();
    String[] bar=newsarray.toArray(new String[newsarray.size()]);

    return bar;

}
    public String[] textsarray(String category)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NEWS+" WHERE "+COLUMN_CATEGORY+"=\""+category+"\";";
        ArrayList<String> newsarray=new ArrayList<String>();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("text")) != null) {
                newsarray.add(c.getString(c.getColumnIndex("text")));

            }
            c.moveToNext();
        }
        db.close();
        String[] bar=newsarray.toArray(new String[newsarray.size()]);

        return bar;

    }

    public String[] datearray(String category)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NEWS+" WHERE "+COLUMN_CATEGORY+"=\""+category+"\";";
        ArrayList<String> newsarray=new ArrayList<String>();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("date")) != null) {
                newsarray.add(c.getString(c.getColumnIndex("date")));

            }
            c.moveToNext();
        }
        db.close();
        String[] bar=newsarray.toArray(new String[newsarray.size()]);

        return bar;

    }

    public String[] sourceurlsarray(String category)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NEWS+" WHERE "+COLUMN_CATEGORY+"=\""+category+"\";";
        ArrayList<String> newsarray=new ArrayList<String>();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("sourceurl")) != null) {
                newsarray.add(c.getString(c.getColumnIndex("sourceurl")));

            }
            c.moveToNext();
        }
        db.close();
        String[] bar=newsarray.toArray(new String[newsarray.size()]);

        return bar;

    }
    public NewsDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
}
