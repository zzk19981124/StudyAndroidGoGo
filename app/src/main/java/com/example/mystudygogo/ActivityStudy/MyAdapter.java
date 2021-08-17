package com.example.mystudygogo.ActivityStudy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mystudygogo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/8/17
 */
public class MyAdapter extends BaseAdapter {

    private List<Bean> b = new ArrayList<>();
    private Context mContext;

    public MyAdapter(List<Bean> b, Context context) {
        this.b = b;
        mContext = context;
    }

    @Override
    public int getCount() {
        return b.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView==null){
            convertView  = LayoutInflater.from(mContext)
                    .inflate(R.layout.list_item,parent,false);
            viewHolder.textView  =convertView.findViewById(R.id.tv_show);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(b.get(position).getName());

        Log.d("MyAdapter", "getView: ");

        return convertView;
    }
    private final class ViewHolder{
        TextView textView;
    }
}
