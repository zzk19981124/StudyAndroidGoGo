package com.example.mystudygogo.contentProviderStudy;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/30
 */
public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase sqlDB;
    private DatabaseHelper dbHelper;
    //数据库名
    private static final String DATABASE_NAME = "Users.db";
    //数据库版本
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "User";

    public static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        //第一次创建数据库时，调用该方法
        @Override
        public void onCreate(SQLiteDatabase db) {
            //在数据库里生成一张表
            db.execSQL("Create table "
                    + TABLE_NAME
                    + "(_id INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ",USER_NAME TEXT);");
        }

        //当更新数据库版本额时候，调用该方法，可以删除、修改表的信息
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DatabaseHelper(getContext());
        //返回创建对象是否成功
        return (dbHelper == null) ? false : true;
    }

    //查询
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //新建数据库查询类
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        qb.setTables(TABLE_NAME);
        //取得查询结果的游标
        Cursor c = qb.query(db, projection, selection, null, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    //取得类型
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    //插入数据
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        sqlDB = dbHelper.getWritableDatabase();
        long rowId = sqlDB.insert(TABLE_NAME, "", values);
        if (rowId > 0) {
            Uri rowUri = ContentUris.appendId(
                    MyUser.User.CONTENT_URI.buildUpon(), rowId).build();
            //通知更改
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        }
        throw new SQLException("Failed to insert row into" + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
