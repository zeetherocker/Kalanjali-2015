package com.zap.Kalanjali;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zap.Kalanjali.Tabs.Day1EventList;
import com.zap.Kalanjali.Tabs.Day2EventList;
import com.zap.Kalanjali.Tabs.SlidingTabLayout;

/**
 * Created by Zeeshan on 9/15/2015.
 */
public class EventTabsList extends ActionBarActivity {

    private View myView;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.event_tabs_list, container, false);

        mPager = (ViewPager) myView.findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) myView.findViewById(R.id.tabs_view);
        mTabs.setViewPager(mPager);
        mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.white));

        return myView;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs_title);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = Day1EventList.newInstance();
                    break;
                case 1:
                    fragment = Day2EventList.newInstance();
                    break;
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
