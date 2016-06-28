package com.iyy.myframework.activity.login;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iyy.myframework.R;
import com.iyy.myframework.activity.BaseActivity;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by wuyue on 2016/6/28.
 */
public class LoginActivity extends BaseActivity{

    @ViewInject(R.id.im_login_top)
    private ImageView im_login_top;

    @Override
    public void setWindowsIsShow() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.zh_login;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initParams() {
        //设置顶图自适应
        LinearLayout.LayoutParams l_menulp = (LinearLayout.LayoutParams) im_login_top.getLayoutParams();
        l_menulp.height = (int) ((sysConfig.getScreenWidth()/640f) * 200f);
        im_login_top.setLayoutParams(l_menulp);
    }


}
