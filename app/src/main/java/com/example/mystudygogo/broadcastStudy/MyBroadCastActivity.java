package com.example.mystudygogo.broadcastStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mystudygogo.R;

public class MyBroadCastActivity extends AppCompatActivity {
    private Button btnSendBc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broad_cast);
        btnSendBc = findViewById(R.id.button1);
        final Intent it = new Intent("com.ak.receiver.myreciver");
        btnSendBc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                sendBroadcast(it);
            }
        });
    }
}