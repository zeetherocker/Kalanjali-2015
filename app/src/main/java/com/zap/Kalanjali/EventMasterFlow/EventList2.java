package com.zap.Kalanjali.EventMasterFlow;

import android.support.v4.app.Fragment;

import com.zap.Kalanjali.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class EventList2 extends Fragment {

    /**
     * An array of sample (dummy) items.
     */
    public static List<EventItem> ITEMS = new ArrayList<EventItem>();

    static {
        addItem(new EventItem(R.string.day2_event1, R.drawable.ic_day2_event1, R.string.day2_desc1, R.string.day2_time1, 2));
        addItem(new EventItem(R.string.day2_event2, R.drawable.ic_day2_event2, R.string.day2_desc2, R.string.day2_time2, 2));
        addItem(new EventItem(R.string.day2_event3, R.drawable.ic_day2_event3, R.string.day2_desc3, R.string.day2_time3, 8));
        addItem(new EventItem(R.string.day2_event4, R.drawable.ic_day2_event4, R.string.day2_desc4, R.string.day2_time4, 8));
        addItem(new EventItem(R.string.day2_event5, R.drawable.ic_day2_event5, R.string.day2_desc5, R.string.day2_time5, 7));
        addItem(new EventItem(R.string.day2_event6, R.drawable.ic_day2_event6, R.string.day2_desc6, R.string.day2_time6 ,7));
        addItem(new EventItem(R.string.day2_event7, R.drawable.ic_day2_event7, R.string.day2_desc7, R.string.day2_time7, 1));
        addItem(new EventItem(R.string.day2_event8, R.drawable.ic_day2_event8, R.string.day2_desc8, R.string.day2_time8, 7));
        addItem(new EventItem(R.string.day2_event9, R.drawable.ic_day2_event9, R.string.day2_desc9, R.string.day2_time9, 1));
        addItem(new EventItem(R.string.day2_event10, R.drawable.ic_day2_event10, R.string.day2_desc10, R.string.day2_time10, 6));
        addItem(new EventItem(R.string.day2_event11, R.drawable.ic_day2_event11, R.string.day2_desc11, R.string.day2_time11, 4));
        addItem(new EventItem(R.string.day2_event12, R.drawable.ic_day2_event12, R.string.day2_desc12, R.string.day2_time12, 3));
        addItem(new EventItem(R.string.day2_event13, R.drawable.ic_day2_event13, R.string.day2_desc13, R.string.day2_time13, 4));
        addItem(new EventItem(R.string.day2_event14, R.drawable.ic_day2_event14, R.string.day2_desc14, R.string.day2_time14, 1));
        addItem(new EventItem(R.string.day2_event15, R.drawable.ic_day2_event15, R.string.day2_desc15, R.string.day2_time15, 1));
        addItem(new EventItem(R.string.day2_event16, R.drawable.ic_day2_event16, R.string.day2_desc16, R.string.day2_time16, 4));
        addItem(new EventItem(R.string.day2_event17, R.drawable.ic_day2_event17, R.string.day2_desc17, R.string.day2_time17, 2));
        addItem(new EventItem(R.string.day2_event18, R.drawable.ic_day2_event18, R.string.day2_desc18, R.string.day2_time18, 4));
        addItem(new EventItem(R.string.day2_event19, R.drawable.ic_day2_event19, R.string.day2_desc19, R.string.day2_time19, 1));
        addItem(new EventItem(R.string.day2_event20, R.drawable.ic_day2_event20, R.string.day2_desc20, R.string.day2_time20, 2));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}