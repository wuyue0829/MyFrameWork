package com.iyy.myframework.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iyy.myframework.view.DialogMaker;

import org.xutils.x;

/**
 * Created by wuyue on 2016/6/21.
 */
public abstract class BaseFragment extends Fragment {

    private Context context;
    private Dialog dialog;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        x.view().inject(this,view);
        initParms(view);
        return view;
    }


    protected abstract int getLayoutId();

    protected abstract void initParms(View view);


    /**
     * 弹出对话框
     *
     * @author blue
     */
    public Dialog showAlertDialog(String title, String msg, String[] btns, final DialogMaker.DialogCallBack callBack, boolean isCanCancelabel, final boolean isDismissAfterClickBtn, Object tag)
    {
        if (null == dialog || !dialog.isShowing())
        {
            dialog = DialogMaker.showCommonAlertDialog(context, title, msg, btns, callBack, isCanCancelabel, isDismissAfterClickBtn, tag);
        }
        return dialog;
    }

    /**
     * 等待对话框
     *
     * @author blue
     */
    public Dialog showWaitDialog(String msg, boolean isCanCancelabel, Object tag)
    {
        if (null == dialog || !dialog.isShowing())
        {
            dialog = DialogMaker.showCommenWaitDialog(context, msg, null, isCanCancelabel, tag);
        }
        return dialog;
    }

    /**
     * 关闭对话框
     *
     * @author blue
     */
    public void dismissDialog()
    {
        if (null != dialog && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }
}
