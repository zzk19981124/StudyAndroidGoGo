package com.example.mystudygogo;

import android.app.Activity;
import android.os.Process;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/29
 */
public class ActivityCollector  {
    private static List<Activity> mActivities = new ArrayList<>();

    public  ActivityCollector(){
    }

    public static void addActivity(Activity activity){
        mActivities.add(activity);
    }
    public static void removeActivity(Activity activity){
        mActivities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:mActivities){
            if (!activity.isFinishing()){
                activity.finish();
                // killProcess杀掉进程
                // myPid（）用来获取进程的id
                android.os.Process.killProcess(Process.myPid());
            }
        }
    }
}
