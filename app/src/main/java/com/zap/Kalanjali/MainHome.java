package com.zap.Kalanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class MainHome extends Fragment {

    private int MAIN_ARG = 1111;

    View myView;
    TextView mtextview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_main_event, container, false);
        myView.isClickable();
        myView.setOnClickListener(mClickListner);
        myView.setFocusable(true);
        mtextview = (TextView) myView.findViewById(R.id.main_event_text);
        mtextview.setText(getString(R.string.title_main_event));
        return myView;
    }

    private View.OnClickListener mClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), EventActivity.class);
            Bundle b = new Bundle();
            b.putInt("title", R.string.title_main_event);
            b.putInt("desc", R.string.main_event_desc);
            b.putInt("arg", MAIN_ARG);
            intent.putExtras(b);
            startActivity(intent);
        }
    };
}
