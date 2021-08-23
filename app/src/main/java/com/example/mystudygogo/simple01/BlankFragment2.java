package com.example.mystudygogo.simple01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mystudygogo.R;


public class BlankFragment2 extends Fragment {

    private View root;
    private TextView textview;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root==null){
            root = inflater.inflate(R.layout.fragment_blank1,container,false);
        }
        textview = root.findViewById(R.id.textview);
        button  = root.findViewById(R.id.btn);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               textview.setText("yes, i'm fine. And you ? ");
           }
       });

        return root;
    }
    
}