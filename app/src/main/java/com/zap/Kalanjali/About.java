package com.zap.Kalanjali;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class About extends Fragment {

    private View myView;
    private ImageView icon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_about, container, false);

        icon = (ImageView) myView.findViewById(R.id.kalanjali_icon);
        icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_aka));

        return myView;
    }

}
