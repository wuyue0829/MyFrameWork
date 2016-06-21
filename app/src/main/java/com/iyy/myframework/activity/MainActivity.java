package com.iyy.myframework.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.iyy.myframework.R;
import com.iyy.myframework.view.ToastMaker;

import org.xutils.view.annotation.ViewInject;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @ViewInject(R.id.tv_test)
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
        tv_test.setOnClickListener(this);
    }

    @Override
    public void setWindowsIsShow() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_test:
                ToastMaker.showLongToast("test");
                break;
        }
    }
}
