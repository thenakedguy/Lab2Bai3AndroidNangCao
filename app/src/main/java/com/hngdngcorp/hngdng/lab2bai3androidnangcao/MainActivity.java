package com.hngdngcorp.hngdng.lab2bai3androidnangcao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton3;
    private TextView mTextView2;
    private BroadcastReceiver broadcastReceiver;
    public static final String ACTION_TEST = "abc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton3 = (Button) findViewById(R.id.button3);
        mTextView2 = (TextView) findViewById(R.id.textView2);

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        // Khai báo broadcast
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String text = intent.getStringExtra("output");
                if (text!= null) mTextView2.setText(text);
            }
        };
        // Đăng kí nhận intent với biến = ACTION_TEST
        IntentFilter intentFilter = new IntentFilter(ACTION_TEST);
        registerReceiver(broadcastReceiver,intentFilter);
    }

}
