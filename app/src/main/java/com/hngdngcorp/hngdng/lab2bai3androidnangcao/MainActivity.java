package com.hngdngcorp.hngdng.lab2bai3androidnangcao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtInput;
    private Button mButton;
    private String input;
    public final String ACTION_TEST = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEdtInput = (EditText) findViewById(R.id.edtInput);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent1);
            }

            private void check() {
                input = mEdtInput.getText().toString();
                //check so luong ki tu
                if (input.length() == 9 ){
                    //Check khi nào là mem, khi nào là vip, khi nào là sai
                    if ( input.contains("MEM")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Chúc mừng bạn được giảm giá 15%");
                    }else if ( input.contains("VIP")){
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Chúc mừng bạn được giảm giá 50%");
                    }else {
                        Intent intent = new Intent(ACTION_TEST);
                        intent.putExtra("output","Bạn không được giảm giá");
                    }
                }
                // báo lỗi khi không nhập đủ 9 kí tự
                else {
                    Intent intent = new Intent(ACTION_TEST);
                    intent.putExtra("output","Dãy nhập vào không đủ 9 kí tự");
                }
            }
        });
    }
}
