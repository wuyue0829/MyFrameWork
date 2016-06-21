package com.iyy.myframework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wuyue on 2016/6/21.
 */
public abstract class SimpleBaseAdapter<T> extends BaseAdapter{

    protected Context c;
    protected LayoutInflater layoutInflater = null;
    protected List<T> datas = null;

    public SimpleBaseAdapter(Context context,List<T> datas){
        this.c = context;
        this.datas =datas;
        layoutInflater = LayoutInflater.from(c);
    }

    /**
     * 刷新适配器
     * @param datas
     */
    public void refreshDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // 将getview设置成抽象方法
    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
