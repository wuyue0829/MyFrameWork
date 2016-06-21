package com.iyy.myframework.application;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by wuyue on 2016/6/20.
 */
public class BaseApplication extends Application{

    public static final String TAG = "Application";

    public SharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences("yy_framwork",MODE_PRIVATE);
    }
}
