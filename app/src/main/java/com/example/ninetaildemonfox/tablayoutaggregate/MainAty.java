package com.example.ninetaildemonfox.tablayoutaggregate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ninetaildemonfox.tablayoutaggregate.aty.Main2Activity;
import com.example.ninetaildemonfox.tablayoutaggregate.aty.Main3Activity;
import com.example.ninetaildemonfox.tablayoutaggregate.aty.MainActivity;

public class MainAty extends AppCompatActivity {

    private TextView button_1;
    private TextView button_2;
    private TextView button_3;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        Log.d("zdl", "==========我的日志呢==========");
        initView();
    }

    private void initView() {
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainAty.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainAty.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainAty.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
