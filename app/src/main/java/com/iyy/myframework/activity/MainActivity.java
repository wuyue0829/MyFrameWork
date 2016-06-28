package com.iyy.myframework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.iyy.myframework.R;
import com.iyy.myframework.view.ToastMaker;

import org.xutils.view.annotation.ViewInject;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final int SHOW_END = 10000;
    private static final int SHOW_NOT_END = 20000;
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

        //设置在3秒钟之后开始跳转
        new Handler(new Handler.Callback() {
            //处理收到的消息处理
            @Override
            public boolean handleMessage(Message msg) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(), GuideActivity.class));
                finish();
                return false;
            }
        }).sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    public void setWindowsIsShow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
