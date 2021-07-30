package com.example.mystudygogo.broadcastStudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author hello word
 * @desc 广播接收器
 * @date 2021/7/30
 */
public class MyReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "成功接收广播", Toast.LENGTH_SHORT).show();
    }
}
