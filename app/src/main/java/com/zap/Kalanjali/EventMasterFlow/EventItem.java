package com.zap.Kalanjali.EventMasterFlow;

/**
 * Created by Zeeshan on 9/27/2015.
 */
public class EventItem {
    public String title;
    public int icon;
    public String event_desc;
    public String time;

    public EventItem (){}

    public EventItem(String title, int icon, String event_desc, String time) {
        this.title = title;
        this.icon =icon;
        this.event_desc = event_desc;
        this.time = time;
    }

    @Override
    public String toString() {
        return title;
    }
}