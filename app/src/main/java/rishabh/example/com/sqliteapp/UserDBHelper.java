package rishabh.example.com.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jindal on 6/27/2016.
 */
public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+UserContract.userinfo.TABLE_NAME+"("+UserContract.userinfo.USER_NAME+" TEXT,"+UserContract.userinfo.USER_MOB+
                    " TEXT,"+UserContract.userinfo.USER_EMAIL+" TEXT);";



    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        Log.e("DATABASE OPERATION","DATABASE OPENED/...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION","TABLE CREATED/...");

    }
    public  void addInformation(String name,String mob,String email,SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put(UserContract.userinfo.USER_NAME,name);
        cv.put(UserContract.userinfo.USER_MOB,mob);
        cv.put(UserContract.userinfo.USER_EMAIL,email);
        db.insert(UserContract.userinfo.TABLE_NAME,null,cv);
        Log.e("DATABASE OPERATION","ONE ROW INSERTED/...");



    }

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String projections[]={UserContract.userinfo.USER_NAME,UserContract.userinfo.USER_MOB,UserContract.userinfo.USER_EMAIL};
        cursor=db.query(UserContract.userinfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
