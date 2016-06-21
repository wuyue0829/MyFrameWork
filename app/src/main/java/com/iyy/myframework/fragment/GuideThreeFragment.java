package com.iyy.myframework.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.iyy.myframework.R;
import com.iyy.myframework.view.McVideoView;

/**
 * Created by wuyue on 2016/6/21.
 */
public class GuideThreeFragment extends BaseFragment {

    public McVideoView mcVideoView;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_guidethree;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mcVideoView != null){
            mcVideoView.playVideo(getActivity(), Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+ R.raw.guide_3));
        }
    }

    @Override
    protected void initParms(View view) {
        mcVideoView = (McVideoView) view.findViewById(R.id.videoView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mcVideoView != null){
            mcVideoView.stopPlayback();
        }
    }
}
