package com.zap.Kalanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zap.Kalanjali.EventMasterFlow.EventContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeeshan on 9/20/2015.
 */
public class SecondHome extends Fragment {

    List<EventContent.EventItem> dataCurrent = getData();

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.card_list, container, false);
        populateList();
        registerClick();
        return myView;
    }

    public void populateList() {

        ArrayAdapter<EventContent.EventItem> adapter = new MyAdapter();
        ListView listView = (ListView) myView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private void registerClick() {
        ListView list = (ListView) myView.findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", position+3);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        list.clearFocus();
        list.setFocusable(false);
    }

    public List<EventContent.EventItem> getData() {
        List<EventContent.EventItem> data = new ArrayList<>();
        for (int i=3; i<6 ; i++) {
            EventContent.EventItem current = new EventContent.EventItem();
            current = EventContent.ITEMS.get(i);

            data.add(current);
        }
        return data;
    }

    private class MyAdapter extends ArrayAdapter<EventContent.EventItem> {

        public MyAdapter() {
            super(getActivity(), R.layout.card_list_item, dataCurrent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null)
                itemView = getActivity().getLayoutInflater().inflate(R.layout.card_list_item, parent, false);

            EventContent.EventItem currentCard = dataCurrent.get(position);

            TextView titleView = (TextView) myView.findViewById(R.id.card_list_label);
            titleView.setText("Music Events");
            titleView.clearFocus();
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
