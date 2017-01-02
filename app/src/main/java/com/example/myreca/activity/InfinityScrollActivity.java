package com.example.myreca.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myreca.R;

import java.util.ArrayList;
import java.util.List;

public class InfinityScrollActivity extends AppCompatActivity {

    private List<String> numberList = new ArrayList<String>();
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_scroll);

        numberList.clear();
        for (int i = 0; i < 10; i++) {
            numberList.add(""+i);
        }

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mCustomPagerAdapter = new CustomPagerAdapter(InfinityScrollActivity.this);
        EndlessPagerAdapter mAdapater = new EndlessPagerAdapter(mCustomPagerAdapter);
        mViewPager.setAdapter(mAdapater);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int modulo = position%numberList.size();
//                Log.i("Current ViewPager View's Position", ""+modulo);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                handler.postDelayed(runnable, 1000);
            }
        };

        handler.post(runnable);
    }

    @Override
    protected void onDestroy() {
        if(handler!=null){
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    private class CustomPagerAdapter extends PagerAdapter {
        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return numberList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.row_item_viewpager, container, false);

            TextView textView = (TextView) itemView.findViewById(R.id.txtItem);
            textView.setText(numberList.get(position));
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    private class EndlessPagerAdapter extends PagerAdapter {
        private static final String TAG = "EndlessPagerAdapter";
        private static final boolean DEBUG = false;

        private final PagerAdapter mPagerAdapter;

        EndlessPagerAdapter(PagerAdapter pagerAdapter) {
            if (pagerAdapter == null) {
                throw new IllegalArgumentException("Did you forget initialize PagerAdapter?");
            }
            if ((pagerAdapter instanceof FragmentPagerAdapter || pagerAdapter instanceof FragmentStatePagerAdapter) && pagerAdapter.getCount() < 3) {
                throw new IllegalArgumentException("When you use FragmentPagerAdapter or FragmentStatePagerAdapter, it only supports >= 3 pages.");
            }
            mPagerAdapter = pagerAdapter;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (DEBUG) Log.d(TAG, "Destroy: " + getVirtualPosition(position));
            mPagerAdapter.destroyItem(container, getVirtualPosition(position), object);

            if (mPagerAdapter.getCount() < 4) {
                mPagerAdapter.instantiateItem(container, getVirtualPosition(position));
            }
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            mPagerAdapter.finishUpdate(container);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE; // this is the magic that we can scroll infinitely.
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerAdapter.getPageTitle(getVirtualPosition(position));
        }

        @Override
        public float getPageWidth(int position) {
            return mPagerAdapter.getPageWidth(getVirtualPosition(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return mPagerAdapter.isViewFromObject(view, o);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (DEBUG) Log.d(TAG, "Instantiate: " + getVirtualPosition(position));
            return mPagerAdapter.instantiateItem(container, getVirtualPosition(position));
        }

        @Override
        public Parcelable saveState() {
            return mPagerAdapter.saveState();
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
            mPagerAdapter.restoreState(state, loader);
        }

        @Override
        public void startUpdate(ViewGroup container) {
            mPagerAdapter.startUpdate(container);
        }

        int getVirtualPosition(int realPosition) {
            return realPosition % mPagerAdapter.getCount();
        }

        PagerAdapter getPagerAdapter() {
            return mPagerAdapter;
        }

    }
}
