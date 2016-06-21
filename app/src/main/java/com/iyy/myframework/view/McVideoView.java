package com.iyy.myframework.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

/**
 * Created by wuyue on 2016/6/21.
 */
public class McVideoView extends VideoView {

    public McVideoView(Context context) {
        super(context, null);
    }

    public McVideoView(Context context, AttributeSet attr){
        super(context,attr,0);
    }

    public McVideoView(Context context, AttributeSet attr, int defStyle){
        super(context,attr,defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec),View.MeasureSpec.getSize(heightMeasureSpec));
    }

    /**
     * 开始播放
     * @param context
     * @param uri
     */
    public void playVideo(Context context, Uri uri){
        if(uri == null){
            throw new IllegalArgumentException("Uri can not be null");
        }

        setVideoURI(uri);
        start();
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                return true;
            }
        });
    }
}
