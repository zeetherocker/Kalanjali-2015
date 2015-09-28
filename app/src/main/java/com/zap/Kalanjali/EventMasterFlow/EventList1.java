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
        addItem(new EventItem(R.string.day1_event1, R.drawable.ic_card1, R.string.day1_desc1, R.string.day1_time1));
        addItem(new EventItem(R.string.day1_event2, R.drawable.ic_card1, R.string.day1_desc2, R.string.day1_time2));
        addItem(new EventItem(R.string.day1_event3, R.drawable.ic_card1, R.string.day1_desc3, R.string.day1_time3));
        addItem(new EventItem(R.string.day1_event4, R.drawable.ic_card1, R.string.day1_desc4, R.string.day1_time4));
        addItem(new EventItem(R.string.day1_event5, R.drawable.ic_card1, R.string.day1_desc5, R.string.day1_time5));
        addItem(new EventItem(R.string.day1_event6, R.drawable.ic_card1, R.string.day1_desc6, R.string.day1_time6));
        addItem(new EventItem(R.string.day1_event7, R.drawable.ic_card1, R.string.day1_desc7, R.string.day1_time7));
        addItem(new EventItem(R.string.day1_event8, R.drawable.ic_card1, R.string.day1_desc8, R.string.day1_time8));
        addItem(new EventItem(R.string.day1_event9, R.drawable.ic_card1, R.string.day1_desc9, R.string.day1_time9));
        addItem(new EventItem(R.string.day1_event10, R.drawable.ic_card1, R.string.day1_desc10, R.string.day1_time10));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}