package com.zap.Kalanjali.EventMasterFlow;

import com.zap.Kalanjali.R;

import java.util.ArrayList;
import java.util.List;

public class EventList1 {

    /**
     * An array of sample (dummy) items.
     */
    public static List<EventItem> ITEMS = new ArrayList<EventItem>();

    static {
        addItem(new EventItem(R.string.day1_event1, R.drawable.ic_card1, R.string.day1_desc1, R.string.day1_time1, 1));
        addItem(new EventItem(R.string.day1_event2, R.drawable.ic_card1, R.string.day1_desc2, R.string.day1_time2, 1));
        addItem(new EventItem(R.string.day1_event3, R.drawable.ic_card1, R.string.day1_desc3, R.string.day1_time3, 2));
        addItem(new EventItem(R.string.day1_event4, R.drawable.ic_card1, R.string.day1_desc4, R.string.day1_time4, 3));
        addItem(new EventItem(R.string.day1_event5, R.drawable.ic_card1, R.string.day1_desc5, R.string.day1_time5, 4));
        addItem(new EventItem(R.string.day1_event6, R.drawable.ic_card1, R.string.day1_desc6, R.string.day1_time6, 1));
        addItem(new EventItem(R.string.day1_event7, R.drawable.ic_card1, R.string.day1_desc7, R.string.day1_time7, 2));
        addItem(new EventItem(R.string.day1_event8, R.drawable.ic_card1, R.string.day1_desc8, R.string.day1_time8, 1));
        addItem(new EventItem(R.string.day1_event9, R.drawable.ic_card1, R.string.day1_desc9, R.string.day1_time9, 3));
        addItem(new EventItem(R.string.day1_event10, R.drawable.ic_card1, R.string.day1_desc10, R.string.day1_time10, 5));
        addItem(new EventItem(R.string.day1_event11, R.drawable.ic_card1, R.string.day1_desc11, R.string.day1_time11, 5));
        addItem(new EventItem(R.string.day1_event12, R.drawable.ic_card1, R.string.day1_desc12, R.string.day1_time12, 5));
        addItem(new EventItem(R.string.day1_event13, R.drawable.ic_card1, R.string.day1_desc13, R.string.day1_time13, 1));
        addItem(new EventItem(R.string.day1_event14, R.drawable.ic_card1, R.string.day1_desc14, R.string.day1_time14, 5));
        addItem(new EventItem(R.string.day1_event15, R.drawable.ic_card1, R.string.day1_desc15, R.string.day1_time15, 5));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}