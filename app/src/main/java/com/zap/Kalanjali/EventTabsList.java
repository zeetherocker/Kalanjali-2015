package com.zap.Kalanjali;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zap.Kalanjali.Tabs.SlidingTabLayout;

/**
 * Created by Zeeshan on 9/15/2015.
 */
public class EventTabsList extends Fragment {

    private View myView;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.event_tabs_list, container, false);

        mPager = (ViewPager) myView.findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        mTabs = (SlidingTabLayout) myView.findViewById(R.id.tabs_view);
        mTabs.setViewPager(mPager);

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
            MyFragment myFragment = MyFragment.getInstance(position);
            return myFragment;
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

    public static class MyFragment extends Fragment {

        private TextView mText;
        public static MyFragment getInstance(int position) {
            MyFragment myFragment =  new MyFragment();
            Bundle args =  new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.event_list_fragment, container, false);
            mText = (TextView) layout.findViewById(R.id.tabs_text);
            Bundle b = getArguments();
            if(b!= null) {
                mText.setText("The Selected tab is "+ b.getInt("position"));
            }
            return layout;
        }

    }
}
