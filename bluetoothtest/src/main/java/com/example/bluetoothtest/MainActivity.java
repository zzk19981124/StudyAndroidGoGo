package com.example.bluetoothtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.text.Edits;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.getSimpleName();
    private static final int REQUEST_ENABLE_BT = 0;
    private BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //发现设备
            if (BluetoothDevice.ACTION_FOUND.equals(action)){
                //获得bluetoothDevice
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceStr = "name:"+device.getName()+"  address:"+device.getAddress();
                Log.d(TAG, "onReceive: "+deviceStr);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        requestPermission();
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        //filter.can
    }

    /*检查判断蓝牙开启相关*/
    private void checkPermission() {
        //判断是否支持蓝牙

        if (bAdapter == null) {
            Toast.makeText(this, "该设备不支持蓝牙", Toast.LENGTH_SHORT).show();
        }
        //如果设备支持蓝牙就打开蓝牙
        if (!bAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } else {
            Toast.makeText(this, "蓝牙已开启", Toast.LENGTH_SHORT).show();
        }
        checkAlreadyConnect();

    }
    /*检查有没有已经配对的设备*/
    private void checkAlreadyConnect() {
        Log.d(TAG, "checkAlreadyConnect: begin");
        //获取已经配对的集合
        Set<BluetoothDevice> pairedDevices = bAdapter.getBondedDevices();
        if (pairedDevices.size()>0){
            for (BluetoothDevice  device: pairedDevices){
                //测试，已配对过的设备先打印出来
                //System.out.println(device.getName()+"\n"+device.getAddress());
                Log.d(TAG, "checkAlreadyConnect: "+device.getName()+"\n"+device.getAddress());

            }
        }
    }

    /*动态权限获取*/
    private void requestPermission() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode != RESULT_OK) {
                    Toast.makeText(this, "蓝牙开启失败", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "蓝牙已开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭广播
        unregisterReceiver(mReceiver);
    }
}