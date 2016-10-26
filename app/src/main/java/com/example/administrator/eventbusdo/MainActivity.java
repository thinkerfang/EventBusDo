package com.example.administrator.eventbusdo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eventbusdo.other.FirstEvent;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn_try;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册EventBus
        EventBus.getDefault().register(this);

        btn_try = (Button) findViewById(R.id.btn_try);
        tv = (TextView) findViewById(R.id.tv);

        //为按钮添加监听
        btn_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onEventMainThread(FirstEvent event){
        String msg="来自SecondActivity的消息："+event.getMsg();
        Log.d("harvic",msg);
        tv.setText(msg);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
