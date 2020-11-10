package com.nbpt.zyx_sb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2020/9/23.
 */

public class AccountDBHelper extends SQLiteOpenHelper {
    EditText edtName;
    private Context mContext;
    private static final String DB_NAme="user.db";
    private static final String TABLE_Name="tb_accounts";
    static final int VERSION_1=1;
    public AccountDBHelper(Context context,int version) {
        super(context, DB_NAme,null, version);
        this.mContext = context;

    }

    public String getUsername(Cursor cursor) {
        return cursor.getString(1);
    }
    public String getPassword(Cursor cursor) {
        return cursor.getString(2);
    }
    public Cursor select(String where, String orderby){
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM "+TABLE_Name);
        if (where != null){
            stringBuilder.append(" WHERE ");
            stringBuilder.append(where);
        }
        if (orderby !=null){
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(orderby);
        }
        return getWritableDatabase().rawQuery(stringBuilder.toString(),null);
    }
    public long inserUser(String username,String password,int gender,String phone){
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("gender",gender);
        values.put("phone",phone);
        long retValue = getReadableDatabase().insert(TABLE_Name,null,values);
        return retValue;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
