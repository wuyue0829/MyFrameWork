package com.iyy.myframework.http;

import android.os.Handler;

/**
 * Created by wuyue on 2016/6/21.
 */
public class AsyncHttpGet {
    // 线程通信
    private Handler handler;

    // 访问路径
    private String url = "";

    public AsyncHttpGet(Handler handler)
    {
        this.handler = handler;
    }
}
