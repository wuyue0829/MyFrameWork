package com.iyy.myframework;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.iyy.myframework.activity.BaseActivity;

public class MainActivity extends BaseActivity {


    private TextView tv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        tv_test = (TextView) findViewById(R.id.tv_test);

        tv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWaitDialog("初始化中！",true,null);
            }
        });
    }
}
