package com.zap.Kalanjali.EventMasterFlow;

/**
 * Created by Zeeshan on 9/27/2015.
 */
public class EventItem {
    public int title;
    public int icon;
    public int event_desc;
    public int time;
    public int eventLocationId;

    public EventItem (){}

    public EventItem(int title, int icon, int event_desc, int time, int eventLocationId) {
        this.title = title;
        this.icon =icon;
        this.event_desc = event_desc;
        this.time = time;
        this.eventLocationId = eventLocationId;
    }
}