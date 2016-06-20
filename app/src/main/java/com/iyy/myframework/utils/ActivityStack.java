package com.iyy.myframework.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by wuyue on 2016/6/17.
 *
 * Activity 堆栈管理
 */
public class ActivityStack {

    private static ActivityStack activityStack;

    private Stack<Activity> mActivities;


    private ActivityStack(){
        mActivities = new Stack<Activity>();
    }

    public static ActivityStack getInstance(){
        if (null == activityStack){
            activityStack = new ActivityStack();
        }
        return activityStack;
    }

    public Stack<Activity> getStack(){
        return mActivities;
    }

    /**
     * 入栈
     * @param activity
     */
    public void addActivity(Activity activity){
        mActivities.add(activity);
    }

    /**
     * 出栈
     * @param activity
     */
    public void removeActivity(Activity activity){
        mActivities.remove(activity);
    }

    /**
     * 彻底退出
     */
    public void finishAllActivity(){
        Activity activity;
        while (!mActivities.empty()){
            activity = mActivities.pop();//栈顶对象
            if(activity != null){
                activity.finish();
            }
        }
    }

    /**
     * finish指定的activity
     *
     */
    public boolean finishActivity(Class<? extends Activity> act){
        Activity activity = findActivityByClass(act);
        if(null != activity && !activity.isFinishing()){
            activity.finish();
            return  true;
        }
        return false;
    }

    /**
     * 查询指定activity
     * @param act
     * @return
     */
    private Activity findActivityByClass(Class<? extends Activity> act) {
        Activity activity = null;
        Iterator<Activity> itr = mActivities.iterator();//创建一个迭代器
        while (itr.hasNext()){
            activity = itr.next();
            if(null != activity && activity.getClass().getName().equals(act.getClass().getName())){
                break;
            }
            activity = null;
        }
        return activity;
    }


    /**
     * 关闭指定Activity以上的Activity
     *
     */
    public boolean finishTopActivity(Class<? extends Activity> actCls, boolean isInCludeSelf){
        List<Activity> buf = new ArrayList<Activity>();
        int size = mActivities.size();
        Activity activity = null;
        for(int i = size-1;i >= 0; i++){
            activity = mActivities.get(i);
            if(activity.getClass().isAssignableFrom(actCls)){//判断是否实现共同的子类或者接口
                for(Activity a:buf){
                    a.finish();
                }
                return true;
            }else if(i == size-1 && isInCludeSelf){
                buf.add(activity);
            }else if(i == size-1){
                buf.add(activity);
            }
        }
        return false;
    }
}
