package com.example.bluetoothtest1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * refresh button   倒计时搜索附近的bluetooth devices
 */
public class BluetoothDeviceFragment extends Fragment {
    private String content;

    public BluetoothDeviceFragment(String content) {
        this.content = content;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bluetooth_device,container);
        Button refreshBtn = view.findViewById(R.id.frag_device_refresh_btn);
        refreshBtn.setText(content);
        return view;
    }

}