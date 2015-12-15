package com.example.paulconroy.viewpagerinput;

import android.app.Activity;
import android.os.Bundle;

import android.support.v4.view.ViewPager;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.wearable.view.DismissOverlayView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import Adapter.FragmentAdapter;


public class MainActivity extends Activity {

    private ViewPager mViewPager;
    private DismissOverlayView mDismissOverlayView;
    private GestureDetector mGestureDetector;
    private FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pager);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        adapter = new FragmentAdapter(
                getFragmentManager());
        adapter.addFragment(new AcceptFragment());
        adapter.addFragment(new ContentFragment());
        adapter.addFragment(new DeclineFragment());

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                commitFunction(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(1);

        mGestureDetector = new GestureDetector(this, new LongPressListener());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event)
                || super.dispatchTouchEvent(event);
    }

    private class LongPressListener extends
            GestureDetector.SimpleOnGestureListener {
        @Override
        public void onLongPress(MotionEvent event) {
            mDismissOverlayView.show();

        }

    }

    public void commitFunction(int position){
        if(position == 0){
            Toast.makeText(this,"Accept Function",Toast.LENGTH_LONG).show();
            mViewPager.setCurrentItem(1);
        } else if(position == 2){
            Toast.makeText(this,"Decline Function",Toast.LENGTH_LONG).show();
            mViewPager.setCurrentItem(1);
        }
    }
}
