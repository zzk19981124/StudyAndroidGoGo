package com.example.mystudygogo.contentProviderStudy;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author hello word
 * @desc uri ——通用资源标识符
 * @date 2021/7/30
 */
public class MyUser {
    public static final String AUTHORITY  = "com.ak.MyContentProvider";
    public static final class User implements BaseColumns{
        //定义Uri
        public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY);
        //定义数据表列
        public static final String USER_NAME = "USER_NAME";
    }
}
