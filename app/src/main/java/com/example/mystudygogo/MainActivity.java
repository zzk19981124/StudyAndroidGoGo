package com.example.mystudygogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mystudygogo.serviceStudy.PlayMusicActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ak_
 * 2021.7.29 可优化：使用List<Class> 可以把AllActivity.class这个文件去掉
 */
public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Class> mData = null;
    private MyAdapter mMyAdapter = null;
    private Context mContext;
    private Intent it = null;
    private List<Class> activities = null;
    //private List<Class<PlayMusicActivity>> activitiesList = new ArrayList<Class<PlayMusicActivity>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        initView();//初始化控件
        bindItemListener();//绑定listView的长按监听事件
    }

    private void initView() {
        //添加所有需要跳转的活动，这样写，很不方便，需要后续优化
        activities = new ArrayList<>();
        activities.add(PlayMusicActivity.class);

        mListView = findViewById(R.id.listView_main);
        //mData = new LinkedList<AllActivity>();
        //设置listView的对应标题
        //mData.add(new AllActivity("service的基本使用——音乐后台播放"));
        mMyAdapter = new MyAdapter(mData,mContext);
        mListView.setAdapter(mMyAdapter);
    }

    /**
     * 绑定listView的长按监听事件
     */
    private void bindItemListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()){
                    case R.id.listView_main:
                        toActivity(position);//跳转activity
                        break;
                    default:
                        break;
                }
            }

            private void toActivity(int position) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            it = new Intent();
                            //跳转到点击的item对应的活动
                            it.setClass(mContext,activities.get(position));
                            startActivity(it);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}