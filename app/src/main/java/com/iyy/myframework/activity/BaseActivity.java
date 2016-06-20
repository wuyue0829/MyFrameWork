package com.iyy.myframework.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iyy.myframework.utils.ActivityStack;
import com.iyy.myframework.view.DialogMaker;

/**
 * Created by wuyue on 2016/6/17.
 */
public abstract class BaseActivity extends AppCompatActivity implements DialogMaker.DialogCallBack{

    protected Dialog dialog;

    private boolean isCreate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.getInstance().addActivity(this);//添加当前子类到栈中
        setContentView(getLayoutId());
        isCreate = true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(isCreate){
            isCreate = false;
            initParams();
        }
    }

    /**
     * 初始化布局
     *
     * @author blue
     */
    protected abstract int getLayoutId();

    /**
     * 参数设置
     *
     * @author blue
     */
    protected abstract void initParams();


    /**
     * 关闭dialog
     */
    public void dismissDialog(){
        if(null != dialog && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    /**
     * 弹出对话框
     * @param title
     * @param msg
     * @param btns
     * @param isCancancelabel
     * @param isDismissAfterClickBtns
     * @param obj
     * @return
     */
    public Dialog showAlertDialog(String title,String msg,String[] btns,boolean isCancancelabel,final boolean isDismissAfterClickBtns,Object obj){
        if(null == dialog && !dialog.isShowing()){
            dialog = DialogMaker.showCommonAlertDialog(this,title,msg,btns,this,isCancancelabel,isDismissAfterClickBtns,obj);
        }
        return dialog;
    }

    public Dialog showWaitDialog(String msg, boolean isCancancelabel,Object o){
        if(null == dialog && !dialog.isShowing()){
            dialog = DialogMaker.
        }
    }

    @Override
    public void onButtonClick(Dialog dialog, int position, Object tag) {

    }

    @Override
    public void onCancelDialog(Dialog dialog, Object tag) {

    }


    @Override
    protected void onDestroy() {
        dismissDialog();
        ActivityStack.getInstance().removeActivity(this);
        super.onDestroy();
    }
}