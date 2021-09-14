package com.example.bluetoothtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.inuker.bluetooth.library.BluetoothClient;

public class MainActivity extends AppCompatActivity {
    private Switch mSwitch;
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private BluetoothClient mClient = new BluetoothClient(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        bluetoothSwitchListener();

    }

    /*绑定控件*/
    private void bindView() {
        mSwitch = findViewById(R.id.main_switch_btn);
    }

    /*蓝牙开关监听回调*/
    private void bluetoothSwitchListener() {
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mBluetoothAdapter.enable();
                } else {
                    mBluetoothAdapter.disable();
                }
            }
        });
    }
}