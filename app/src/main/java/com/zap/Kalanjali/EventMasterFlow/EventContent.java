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

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, EventItem> ITEM_MAP = new HashMap<String, EventItem>();

    static {
        // Add 3 sample items.
        addItem(new EventItem("1", "Music Event 1", R.drawable.ic_card1, "Event Description for Event 1\nEvent Description for Event 1\nEvent Description for Event 1\nEvent Description for Event 1\nEvent Description for Event 1", "12.00 PM"));
        addItem(new EventItem("2", "Music Event 2", R.drawable.ic_card2, "Event Description for Event 2", "01.00 PM"));
        addItem(new EventItem("3", "Music Event 3", R.drawable.ic_card3, "Event Description for Event 3", "02.00 PM"));
        addItem(new EventItem("4", "Dance Event 1", R.drawable.ic_card1, "Event Description for Event 4", "03.00 PM"));
        addItem(new EventItem("5", "Dance Event 2", R.drawable.ic_card2, "Event Description for Event 5", "04.00 PM"));
        addItem(new EventItem("6", "Dance Event 3", R.drawable.ic_card3, "Event Description for Event 6", "05.00 PM"));
        addItem(new EventItem("7", "Trending Event 3", R.drawable.ic_card1, "Event Description for Event 7", "06.00 PM"));
        addItem(new EventItem("8", "Trending Event 3", R.drawable.ic_card2, "Event Description for Event 8", "07.00 PM"));
        addItem(new EventItem("9", "Trending Event 3", R.drawable.ic_card3, "Event Description for Event 9", "08.00 PM"));
    }

    private static void addItem(EventItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class EventItem {
        public String id;
        public String title;
        public int icon;
        public String event_desc;
        public String time;

        public EventItem (){}

        public EventItem(String id, String title, int icon, String event_desc, String time) {
            this.id = id;
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
}
