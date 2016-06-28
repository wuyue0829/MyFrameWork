package com.iyy.myframework.exception;


import java.text.DateFormat;

/**
 * Created by wuyue on 2016/6/21.
 */
public abstract class BaseExceptionHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    protected static final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // 如果正确处理了未捕获异常
        if (handleException(throwable))
        {
            try
            {
                // 如果处理了，让程序继续运行3秒再退出，保证错误日志的保存
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // 退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    public abstract boolean handleException(Throwable ex);

}
