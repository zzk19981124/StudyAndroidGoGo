package com.example.mystudygogo.ActivityStudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.mystudygogo.R;

public class TestActivity extends AppCompatActivity {
    private NotificationManager manager;
    private Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
         manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
             NotificationChannel channel = new NotificationChannel("leo", "测试通知",
                     NotificationManager.IMPORTANCE_HIGH);
             manager.createNotificationChannel(channel);
         }

        notification = new NotificationCompat.Builder(this, "leo")
                .setContentTitle("官方通知")
                .setContentText("世界那么大，想去走走吗")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.q1))
                .build();

    }

    public void CancelNotification(View view) {
        manager.cancel(1);
    }

    public void sendNotification(View view) {
        manager.notify(1,notification);

    }
}