package com.example.bluetoothtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.inuker.bluetooth.library.BluetoothClient;

public class MainActivity extends AppCompatActivity {
    private Switch mSwitch;
    private Context mContext;
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private FragmentManager fManager;
    private BluetoothDeviceFragment fragment;
    private static final String TAG = "MainActivity";
   // private boolean blueStateNow = false;
    //private BluetoothClient mClient = new BluetoothClient(mContext);
    private BroadcastReceiver mStateReceive = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int blueState= intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,0);
            switch (blueState){
                case BluetoothAdapter.STATE_TURNING_ON:
                    Log.d(TAG, "onReceive: "+"开启中~~~");
                    break;
                case BluetoothAdapter.STATE_ON:
                    Log.d(TAG, "onReceive: "+"开启~~~");
                  //  blueStateNow = true;
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Log.d(TAG, "onReceive: "+"关闭中~~~");
                    break;
                case BluetoothAdapter.STATE_OFF:
                    Log.d(TAG, "onReceive: "+"关闭~~~");
                   // blueStateNow=false;
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindView();
        bluetoothSwitchListener();
        IntentFilter statesFilter  = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        this.registerReceiver(mStateReceive,statesFilter);
    }

    /*绑定控件*/
    private void bindView() {
        mSwitch = findViewById(R.id.main_switch_btn);
    }

    /*蓝牙开关监听回调*/
    private void bluetoothSwitchListener() {
        mSwitch.setChecked(mBluetoothAdapter.isEnabled());//设置开关状态开始时跟随系统蓝牙的开关状态

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mBluetoothAdapter.enable();
                    Log.d(TAG, "onCheckedChanged: ");
                    controlFragment(isChecked);
                } else {
                    mBluetoothAdapter.disable();
                    controlFragment(isChecked);
                }
            }
        });
    }
    /**
     *控制fragment显示的函数
     * blueState   switch的开关状态
     * */
    private void controlFragment(boolean blueState){
        FragmentTransaction transaction = fManager.beginTransaction();

        if (blueState){//打开蓝牙状态
            fragment = new BluetoothDeviceFragment("得到了");

        }else{//关闭蓝牙状态

        }
    }
}