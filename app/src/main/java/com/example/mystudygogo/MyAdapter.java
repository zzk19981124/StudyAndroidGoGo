package com.example.mystudygogo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/29
 */
public class MyAdapter extends BaseAdapter {
    private List<Class> mActivityList;
    private Context mContext;

    public MyAdapter(List<Class> activityList, Context context) {
        mActivityList = activityList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mActivityList.size();
    }

    @Override
    public Object getItem(int position) {
        return mActivityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView !=null){
            itemView = LayoutInflater.from(mContext).inflate(R.layout.main_listview,parent,false);
        }
        TextView line1 = itemView.findViewById(R.id.textView_listView_getInformation);
        line1.setText(mActivityList.get(position).getName());

        return itemView;
    }
}
