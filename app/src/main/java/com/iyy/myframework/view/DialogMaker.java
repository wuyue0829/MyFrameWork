package com.iyy.myframework.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iyy.myframework.R;


/**
 * Created by wuyue on 2016/6/16.
 */
public class DialogMaker {
    public interface DialogCallBack{
        /**
         * 对话框按钮点击回调
         *
         * @param position
         *            点击Button的索引.
         * @param tag
         */
        public void onButtonClick(Dialog dialog, int position, Object tag);

        /**
         * 当对话框消失的时候回调
         *
         * @param tag
         */
        public void onCancelDialog(Dialog dialog, Object tag);
    }


    public static final String BIRTHDAY_FORMAT = "%04d-%02d-%02d";


    /**
     * 创建一个通用的alert对话框
     *
     * @param title
     *            对话框的标题。为null或""没有标题
     * @param msg
     *            对话框要显示内容
     * @param btns
     *            显示按钮的标题。为null没有按钮
     * @param callBack
     *            点击按钮的回调
     * @param isCanCancelabel
     *            是否可以点击back键消失对话框
     * @param isDismissAfterClickBtn
     *            点击任何按钮后是否消失对话框
     * @param tag
     *
     * @return 显示并返回对话框
     */
    public static Dialog showCommonAlertDialog(Context context,String title,String msg,String[] btns, final DialogCallBack callBack, boolean isCanCancelabel,final boolean isDismissAfterClickBtn, final Object tag){

        final Dialog dialog = new Dialog(context, R.style.DialogNoTitleRoundCornerStyle);
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_alert_common_layout,null);
        TextView contentTv = (TextView) contentView.findViewById(R.id.dialog_content_tv);
        TextView titleTv = (TextView) contentView.findViewById(R.id.dialog_title_tv);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != callBack){
                    callBack.onButtonClick(dialog, (Integer) view.getTag(),tag);
                }
                if(isDismissAfterClickBtn){
                    dialog.dismiss();
                }
            }
        };

        if(null != btns){
            int lens = btns.length;
            if(lens > 0){
                LinearLayout btnLayout = (LinearLayout) contentView.findViewById(R.id.btn_layout);
                Button btn;
                View lineView;

            }
        }
        return null;
    }


}
