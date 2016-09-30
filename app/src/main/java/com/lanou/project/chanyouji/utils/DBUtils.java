package com.lanou.project.chanyouji.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lanou.project.chanyouji.ToolActivity.BuyContext;

import java.util.List;

/**
 * Created by lanouhn on 16/9/27.
 */
public class DBUtils {

    BuyContext by;
    List<BuyContext> byList;

    public  static void insertData(Context context, String money, String type, String coin, String timer
     , String xiang){
        DBOpenHelper helper =new DBOpenHelper(context,DBOpenHelper.DATABASE_NAME,null,1);

        SQLiteDatabase database =helper.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("money",money);
        values.put("type",type);
        values.put("coin",coin);
        values.put("xiang",xiang);
        values.put("timer",timer);
        database.insert(DBOpenHelper.STUDENT_TABLE_NAME,null,values);
        database.close();

    }

    public static void deleteData(Context context,String id){
        DBOpenHelper helper=new DBOpenHelper(context,DBOpenHelper.DATABASE_NAME,null,1);
        SQLiteDatabase database=helper.getWritableDatabase();

        String sqlStr="delete from "+DBOpenHelper.STUDENT_TABLE_NAME+" where id =? ";
        database.execSQL(sqlStr,new String[]{id});

        database.close();
    }

    public static void updateData(Context context, float money, String type, String coin, String timer
            ,String xiang ){

        DBOpenHelper helper=new DBOpenHelper(context,DBOpenHelper.DATABASE_NAME,null,1);
        SQLiteDatabase database=helper.getWritableDatabase();

        String sqlStr="update "+DBOpenHelper.STUDENT_TABLE_NAME+" set money = ? set type = ? set coin= ? set xiang =? where id = ? ";
        database.execSQL(sqlStr);
    }


}
