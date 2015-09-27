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

    private String[] titles =  getResources().getStringArray(R.array.day1_titles);
    private String[] time = getResources().getStringArray(R.array.day1_time);
    private String[] desc = getResources().getStringArray(R.array.day1_desc);

    /**
     * An array of sample (dummy) items.
     */
    public static List<EventItem> ITEMS = new ArrayList<EventItem>();

    {
         for (int i=0 ; i< titles.length && i<desc.length && i<time.length; i++ ) {
             addItem(new EventItem(titles[i], R.drawable.ic_card1, desc[i], time[i]));
         }
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
    }
}
