package com.example.myapplication_scroll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MusicListDBManager {
    static final String DB_Music = "Music.db";
    static final String TABLE_Music = "Playlist";
    static final int DB_VERSION = 1;

    Context myContext = null;

    private static MusicListDBManager myDBManager = null;
    private SQLiteDatabase myDB = null;

    private MusicListDBManager(Context context) {
        myContext = context;
        myDB = context.openOrCreateDatabase(DB_Music, Context.MODE_PRIVATE,null);

        myDB.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_Music + "(_idPlayList INTEGER PRIMARY KEY, singer VARCHAR(45), album VARCHAR(100), title VARCHAR(45))");
    }

    public static MusicListDBManager getInstance(Context context){
        if(myDBManager == null){
            myDBManager = new MusicListDBManager(context);
        }

        return myDBManager;
    }

    public long insert(ContentValues addRowValue){
        return myDB.insert(TABLE_Music, null , addRowValue);
    }

    public void deleteAll() {
        myDB.delete(TABLE_Music, null, null);
    }

    public boolean delete(long id){
        return myDB.delete(TABLE_Music, "_idPlayList ="+id, null) > 0;
    }

    public Cursor query(String [] column,
                        String selection,
                        String[] sectionArgs,
                        String groupBy,
                        String having,
                        String orderby) {
        return myDB.query(TABLE_Music,
                column,
                selection,
                sectionArgs,
                groupBy,
                having,
                orderby);
    }
}
