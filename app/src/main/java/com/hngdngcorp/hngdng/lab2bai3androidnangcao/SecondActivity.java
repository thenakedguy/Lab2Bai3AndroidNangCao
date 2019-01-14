package com.hngdngcorp.hngdng.lab2bai3androidnangcao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mTvOutput;
    public static final String ACTION_TEST = "abc";
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTvOutput = (TextView) findViewById(R.id.tvOutput);

        //Khai báo broadcastRêciver
        broadcastReceiver= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String s = intent.getStringExtra("output");
                if(s != null) mTvOutput.setText(s);
            }
        } ;
    }
}
