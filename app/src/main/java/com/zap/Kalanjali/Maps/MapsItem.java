package com.zap.Kalanjali.Maps;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Zeeshan on 9/28/2015.
 */
public class MapsItem {
    public int title;
    public LatLng position;
    public LatLng titlePosition;

    public MapsItem (){}

    public MapsItem(LatLng position, int title, LatLng titlePosition) {
        this.title = title;
        this.position = position;
        this.titlePosition = titlePosition;
    }
}