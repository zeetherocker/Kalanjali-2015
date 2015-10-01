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
        addItem(new EventItem(R.string.day1_event1, R.drawable.ic_card1, R.string.day1_desc1, R.string.day1_time1, 2));
        addItem(new EventItem(R.string.day1_event2, R.drawable.ic_card1, R.string.day1_desc2, R.string.day1_time2, 8));
        addItem(new EventItem(R.string.day1_event3, R.drawable.ic_card1, R.string.day1_desc3, R.string.day1_time3, 4));
        addItem(new EventItem(R.string.day1_event4, R.drawable.ic_card1, R.string.day1_desc4, R.string.day1_time4, 7));
        addItem(new EventItem(R.string.day1_event5, R.drawable.ic_card1, R.string.day1_desc5, R.string.day1_time5, 1));
        addItem(new EventItem(R.string.day1_event6, R.drawable.ic_card1, R.string.day1_desc6, R.string.day1_time6, 1));
        addItem(new EventItem(R.string.day1_event7, R.drawable.ic_card1, R.string.day1_desc7, R.string.day1_time7, 1));
        addItem(new EventItem(R.string.day1_event8, R.drawable.ic_card1, R.string.day1_desc8, R.string.day1_time8, 6));
        addItem(new EventItem(R.string.day1_event9, R.drawable.ic_card1, R.string.day1_desc9, R.string.day1_time9, 9));
        addItem(new EventItem(R.string.day1_event10, R.drawable.ic_card1, R.string.day1_desc10, R.string.day1_time10, 8));
        addItem(new EventItem(R.string.day1_event11, R.drawable.ic_card1, R.string.day1_desc11, R.string.day1_time11, 3));
        addItem(new EventItem(R.string.day1_event12, R.drawable.ic_card1, R.string.day1_desc12, R.string.day1_time12, 1));
        addItem(new EventItem(R.string.day1_event13, R.drawable.ic_card1, R.string.day1_desc13, R.string.day1_time13, 1));
        addItem(new EventItem(R.string.day1_event14, R.drawable.ic_card1, R.string.day1_desc14, R.string.day1_time14, 1));
        addItem(new EventItem(R.string.day1_event15, R.drawable.ic_card1, R.string.day1_desc15, R.string.day1_time15, 9));
        addItem(new EventItem(R.string.day1_event16, R.drawable.ic_card1, R.string.day1_desc16, R.string.day1_time16, 1));
        addItem(new EventItem(R.string.day1_event17, R.drawable.ic_card1, R.string.day1_desc17, R.string.day1_time17, 1));
        addItem(new EventItem(R.string.day1_event18, R.drawable.ic_card1, R.string.day1_desc18, R.string.day1_time18, 10));
        addItem(new EventItem(R.string.day1_event19, R.drawable.ic_card1, R.string.day1_desc19, R.string.day1_time19, 5));
        addItem(new EventItem(R.string.day1_event20, R.drawable.ic_card1, R.string.day1_desc20, R.string.day1_time20, 1));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}