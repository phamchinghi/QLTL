package com.example.qltl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

//Disable vuot 2 cai tabitem

public class customViewPager extends ViewPager {

    private boolean enable;

    public customViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.enable = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enable) {
            return super.onTouchEvent(ev);
        }
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(this.enable){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
    //ham khong cho viet
    public void setPagingEnable(Boolean enable){
        this.enable = enable;
    }
}
