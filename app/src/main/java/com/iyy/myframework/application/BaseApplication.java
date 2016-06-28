package com.iyy.myframework.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wuyue on 2016/6/20.
 */
public class BaseApplication extends Application{

    public static final String TAG = "Application";

    public SharedPreferences sharedPreferences;
    public static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        sharedPreferences = getSharedPreferences("yy_framwork",MODE_PRIVATE);
    }
}
