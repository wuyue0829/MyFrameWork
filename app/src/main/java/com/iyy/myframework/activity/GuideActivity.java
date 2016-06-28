package com.iyy.myframework.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.iyy.myframework.R;
import com.iyy.myframework.fragment.GuideOneFragment;
import com.iyy.myframework.fragment.GuideThreeFragment;
import com.iyy.myframework.fragment.GuideTwoFragment;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2016/6/21.
 */
public class GuideActivity extends BaseActivity {

    @ViewInject(R.id.viewPager)
    private ViewPager viewPager;

    @ViewInject(R.id.btn_login)
    private Button btn_login;

    //欢迎界面的3个fragment
    private GuideOneFragment guideOneFragment = null;
    private GuideTwoFragment guideTwoFragment = null;
    private GuideThreeFragment guideThreeFragment = null;

    //放置fragment的list
    private List<Fragment> list = new ArrayList<Fragment>();

    private GuideFragmentPagerAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.guide;
    }

    @Override
    public void setWindowsIsShow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void initParams() {
        viewPager.setOffscreenPageLimit(3);
        if(guideOneFragment == null){
            guideOneFragment = new GuideOneFragment();
            list.add(guideOneFragment);
        }
        if(guideTwoFragment == null){
            guideTwoFragment = new GuideTwoFragment();
            list.add(guideTwoFragment);
        }
        if(guideThreeFragment == null){
            guideThreeFragment = new GuideThreeFragment();
            list.add(guideThreeFragment);
        }
        adapter = new GuideFragmentPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==2){
                    btn_login.setVisibility(View.VISIBLE);
                }
                else{
                    btn_login.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,MainActivity.class));
                finish();
            }
        });
    }


    private class GuideFragmentPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> list;
        public GuideFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
