package com.example.mystudygogo.serviceStudy;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.example.mystudygogo.R;

public class PlayMusicService extends Service {
    //定义音乐播放器
    private MediaPlayer mMediaPlayer;

    public PlayMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        //装载音乐
        mMediaPlayer = MediaPlayer.create(this, R.raw.in_spring);
        //开始播放音乐
        mMediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
    }
}