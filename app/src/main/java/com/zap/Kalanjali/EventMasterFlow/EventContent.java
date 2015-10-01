package com.zap.Kalanjali.EventMasterFlow;

import com.zap.Kalanjali.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class EventContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<EventItem> ITEMS = new ArrayList<EventItem>();

    static {
        // Add 3 sample items.
        addItem(new EventItem(R.string.first_home1, R.drawable.ic_card1, R.string.first_home_desc1, R.string.first_home_time1, 3));
        addItem(new EventItem(R.string.first_home2, R.drawable.ic_card2, R.string.first_home_desc2, R.string.first_home_time2, 3));
        addItem(new EventItem(R.string.first_home3, R.drawable.ic_card3, R.string.first_home_desc3, R.string.first_home_time3, 2));
        addItem(new EventItem(R.string.second_home1, R.drawable.ic_card1, R.string.second_home_desc1, R.string.second_home_time1, 2));
        addItem(new EventItem(R.string.second_home2, R.drawable.ic_card2, R.string.second_home_desc2, R.string.second_home_time2, 8));
        addItem(new EventItem(R.string.second_home3, R.drawable.ic_card3, R.string.second_home_desc3, R.string.second_home_time3, 2));
        addItem(new EventItem(R.string.third_home1, R.drawable.ic_card1, R.string.third_home_desc1, R.string.third_home_time1, 2));
        addItem(new EventItem(R.string.third_home2, R.drawable.ic_card2, R.string.third_home_desc2, R.string.third_home_time2, 1));
        addItem(new EventItem(R.string.third_home3, R.drawable.ic_card3, R.string.third_home_desc3, R.string.third_home_time3, 1));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}
