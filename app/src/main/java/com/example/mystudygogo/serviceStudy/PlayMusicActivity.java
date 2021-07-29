package com.example.mystudygogo.serviceStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mystudygogo.BaseActivity;
import com.example.mystudygogo.MainActivity;
import com.example.mystudygogo.R;

/**
 * 学习service的基本用法
 * 2021.7.29
 */
public class PlayMusicActivity extends BaseActivity implements View.OnClickListener{
    private Button btnStartMusic,btnStopMusic;
    private final Intent it = new Intent();
    private String activityName = "service的基本使用——音乐后台播放";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        //从android 5.0开始，intent必须以显式的方式调用,如果想要隐式调用，加上包名即可
        it.setPackage("com.example.mystudygogo");
        initBind();

    }

    private void initBind() {
        btnStartMusic = findViewById(R.id.buttonStartMusic);
        btnStartMusic.setOnClickListener(this);
        btnStopMusic = findViewById(R.id.buttonSopMusic);
        btnStopMusic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonStartMusic:
                //启动服务
                startService(it);
                break;
            case R.id.buttonSopMusic:
                //停止服务
                stopService(it);
                break;
            default:
                break;
        }
    }
    public String getName(){
        return activityName;
    }
}