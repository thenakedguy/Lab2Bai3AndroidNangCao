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

public class SecondActivity extends AppCompatActivity {
    private TextView mTvOutput;
    public static final String ACTION_TEST = "abc";
    private EditText mEdtInput;
    private Button mButton;
    private String input;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mEdtInput = (EditText) findViewById(R.id.edtInput);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }

            private void check() {
                input = mEdtInput.getText().toString();
                //check so luong ki tu
                if (input.length() == 9 ){
                    //Check khi nào là mem, khi nào là vip, khi nào là sai
                    if ( input.contains("MEM")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Chúc mừng bạn được giảm giá 15%");
                        sendBroadcast(intent);
                    }else if ( input.contains("VIP")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Chúc mừng bạn được giảm giá 50%");
                        sendBroadcast(intent);
                    }else {
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Bạn không được giảm giá");
                        sendBroadcast(intent);
                    }
                }
                // báo lỗi khi không nhập đủ 9 kí tự
                else {
                    Intent intent = new Intent(ACTION_TEST);
                    intent.putExtra("output","Dãy nhập vào không đủ 9 kí tự");
                    sendBroadcast(intent);
                }
            }
        });
    }
}
