package com.example.mystudygogo.ActivityStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mystudygogo.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Bean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView listView = findViewById(R.id.listview_main);
        for (int i =0;i<100;i++){
            Bean b = new Bean();
            b.setName("雨伞"+i);
            list.add(b);
        }

        listView.setAdapter(new MyAdapter(list,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,
                        "you click "+ position + " position", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private final class ViewHolder{

    }
}