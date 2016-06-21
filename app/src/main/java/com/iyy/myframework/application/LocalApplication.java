package com.iyy.myframework.application;

import org.xutils.x;

/**
 * 在开发应用时都会和Activity打交道，而Application使用的就相对较少 Application是用来管理应用程序的全局状态的，比如载入资源文件 在应用程序启动的时候Application会首先创建，
 * 然后才会根据情况(Intent)启动相应的Activity或者Service
 * Created by wuyue on 2016/6/21.
 */
public class LocalApplication extends BaseApplication{

    private static LocalApplication instance;

    // 当前屏幕的高宽
    public int screenW = 0;
    public int screenH = 0;

    public static LocalApplication getInstance(){
        if(null == instance){
            instance = new LocalApplication();
        }
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
