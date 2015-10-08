package com.zap.Kalanjali;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zeeshan on 9/15/2015.
 */
public class ContactDetails extends Fragment {

    View myView;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.contactus_fragment, container, false);

        // get the listview
        expListView = (ExpandableListView) myView.findViewById(R.id.contact_us_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return myView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("CO-ORDINATORS");
        listDataHeader.add("CO-COORDINATORS");
        listDataHeader.add("EVENT MANAGEMENT");
        listDataHeader.add("LITERARY");
        listDataHeader.add("DANCE");
        listDataHeader.add("MUSIC");
        listDataHeader.add("FINE ARTS");
        listDataHeader.add("PHOTOGRAPHY");
        listDataHeader.add("DRAMATICS");
        listDataHeader.add("TECHNICAL");
        listDataHeader.add("PUBLICITY");
        listDataHeader.add("SPONSORSHIPS & STALLS");

        // Adding child data
        List<String> coords = new ArrayList<String>();
        coords.add("Rakesh Nayaka");
        coords.add("Surabhi Suresh");

        List<String> cocoords = new ArrayList<String>();
        cocoords.add("Vyshnavi Acharya");
        cocoords.add("Subbramanya Adiga");
        cocoords.add("Aditya Kashyap");

        List<String> event = new ArrayList<String>();
        event.add("Mahima Fernandes");
        event.add("Shwetha Bolumbu");
        event.add("Yashas Bysani");

        List<String> lit = new ArrayList<String>();
        lit.add("Anand Shekar");
        lit.add("Jovil");
        lit.add("Muditha Gosh");

        List<String> dance = new ArrayList<String>();
        dance.add("Jofin George");
        dance.add("Shreya Acharya");

        List<String> music = new ArrayList<String>();
        music.add("Swastik Nandkumar");
        music.add("Raghuveer C");
        music.add("Anupama VS");
        music.add("Gokul");

        List<String> fine = new ArrayList<String>();
        fine.add("Khushbu Agarwal");
        fine.add("Avi Shekar");

        List<String> photo = new ArrayList<String>();
        photo.add("Abhishek Chintamani");

        List<String> drama = new ArrayList<String>();
        drama.add("Parikshith");

        List<String> tech = new ArrayList<String>();
        tech.add("Vaithee");
        tech.add("Harinder");
        tech.add("Shubam Singh");

        List<String> pub = new ArrayList<String>();
        pub.add("Namrath Hebbar");
        pub.add("Pramodh M");
        pub.add("Joane Kripa");

        List<String> spons = new ArrayList<String>();
        spons.add("Kushal");
        spons.add("Yashas");
        spons.add("Roshni");

        listDataChild.put(listDataHeader.get(0), coords); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cocoords);
        listDataChild.put(listDataHeader.get(2), event);
        listDataChild.put(listDataHeader.get(3), lit);
        listDataChild.put(listDataHeader.get(4), dance);
        listDataChild.put(listDataHeader.get(5), music);
        listDataChild.put(listDataHeader.get(6), fine);
        listDataChild.put(listDataHeader.get(7), photo);
        listDataChild.put(listDataHeader.get(8), drama);
        listDataChild.put(listDataHeader.get(9), tech);
        listDataChild.put(listDataHeader.get(10), pub);
        listDataChild.put(listDataHeader.get(11), spons);
    }
}
