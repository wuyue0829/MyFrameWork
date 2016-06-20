package com.iyy.myframework;

import android.os.Bundle;

import com.iyy.myframework.activity.BaseActivity;

public class MainActivity extends BaseActivity {


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

    }
}
