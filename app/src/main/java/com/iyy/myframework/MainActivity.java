package com.iyy.myframework;

import android.os.Bundle;

import com.iyy.myframework.activity.BaseActivity;
import com.iyy.myframework.utils.LogUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
        RequestParams params = new RequestParams("www.baidu.com");
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                LogUtils.e("onSuccess");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtils.e("onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtils.e("onCancelled");
            }

            @Override
            public void onFinished() {
                LogUtils.e("onFinished");
            }
        });
    }
}
