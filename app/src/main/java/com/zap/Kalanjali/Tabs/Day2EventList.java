package com.zap.Kalanjali.Tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zap.Kalanjali.EventActivity;
import com.zap.Kalanjali.EventMasterFlow.EventItem;
import com.zap.Kalanjali.EventMasterFlow.EventList2;
import com.zap.Kalanjali.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Day1EventList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Day2EventList extends Fragment {

    private static final int SECOND_DAY_LIST = 2323;

    List<EventItem> dataCurrent = getData();
    private View myView;

    public static Day2EventList newInstance() {
        Day2EventList fragment = new Day2EventList();
        return fragment;
    }

    public Day2EventList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.event_list_fragment, container, false);

        populateList();
        registerClick();

        return myView;
    }

    public void populateList() {

        ArrayAdapter<EventItem> adapter = new MyAdapter();
        ListView listView = (ListView) myView.findViewById(R.id.event_list);
        listView.setAdapter(adapter);

    }

    private void registerClick() {
        ListView list = (ListView) myView.findViewById(R.id.event_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                Bundle b = new Bundle();
                b.putInt("pos", position);
                b.putInt("arg", SECOND_DAY_LIST);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        list.clearFocus();
        list.setFocusable(false);
    }

    public List<EventItem> getData() {
        List<EventItem> data = new ArrayList<>();
        for (int i=0; i<EventList2.ITEMS.size() ; i++) {
            EventItem current;
            current = EventList2.ITEMS.get(i);
            data.add(current);
        }
        return data;
    }

    private class MyAdapter extends ArrayAdapter<EventItem> {

        public MyAdapter() {
            super(getActivity(), R.layout.card_list_item, dataCurrent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null)
                itemView = getActivity().getLayoutInflater().inflate(R.layout.event_list_item, parent, false);

            EventItem currentCard = dataCurrent.get(position);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.card_image);
            TextView textView = (TextView) itemView.findViewById(R.id.card_item);
            TextView textView1 = (TextView) itemView.findViewById(R.id.textView);
            imageView.setImageResource(currentCard.icon);
            textView.setText(currentCard.title);
            textView1.setText(currentCard.time);

            return itemView;
        }
    }
}
