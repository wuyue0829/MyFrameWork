package com.iyy.myframework.application;

import android.app.Application;
import android.content.Context;

import com.iyy.myframework.exception.BaseExceptionHandler;
import com.iyy.myframework.exception.LocalFileHandler;

/**
 * Created by wuyue on 2016/6/20.
 */
public abstract class BaseApplication extends Application{

    public static final String TAG = "Application";
    public static Context application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = getApplicationContext();

        if(getDefaultUncaughtExceptionHandler() == null){
            Thread.setDefaultUncaughtExceptionHandler(new LocalFileHandler(application));
        }else{
            Thread.setDefaultUncaughtExceptionHandler(getDefaultUncaughtExceptionHandler());
        }
    }

    public abstract BaseExceptionHandler getDefaultUncaughtExceptionHandler();
}
