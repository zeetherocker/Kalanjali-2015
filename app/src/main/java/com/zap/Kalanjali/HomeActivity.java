package com.zap.Kalanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;
import com.zap.Kalanjali.Tabs.EventListActivity;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class HomeActivity extends Fragment implements View.OnClickListener {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_activity_main, container, false);
        ObservableScrollView v = (ObservableScrollView) myView.findViewById(R.id.scroll_view);
        v.post(new Runnable() {
            @Override
            public void run() {
                ((ScrollView) myView.findViewById(R.id.scroll_view)).fullScroll(View.FOCUS_UP);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) myView.findViewById(R.id.fab);
        fab.attachToScrollView(v);
        fab.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), EventListActivity.class));
    }
}
