package com.zap.Kalanjali;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

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

    ImageView fb;
    ImageView browser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.contactus_fragment, container, false);

        // get the listview
        expListView = (ExpandableListView) myView.findViewById(R.id.contact_us_list);
        expListView.clearFocus();
        expListView.setFocusable(false);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        fb = (ImageView) myView.findViewById(R.id.img_fb);
        browser = (ImageView) myView.findViewById(R.id.img_browser);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/Kalanjali2015";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://sirmvitkalanjali.in/index.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.expandGroup(0);
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i=0; i<listAdapter.getGroupCount();i++){
                    if(i!= groupPosition)
                        expListView.collapseGroup(i);
                }
            }
        });
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
        coords.add("Rakesh Nayaka                 7406441190");
        coords.add("Surabhi Suresh                 9886943629");

        List<String> cocoords = new ArrayList<String>();
        cocoords.add("Vyshnavi Acharya              9902085109");
        cocoords.add("Subbramanya Adiga             9535483934");
        cocoords.add("Aditya Kashyap                9740640725");

        List<String> event = new ArrayList<String>();
        event.add("Mahima Fernandes              8722376145");
        event.add("Shwetha Bolumbu               9591346244");
        event.add("Yashas Bysani                 9439979695");

        List<String> lit = new ArrayList<String>();
        lit.add("Anand Shekar                  8884502660");
        lit.add("Jovil                         7406702079");
        lit.add("Muditha Gosh                  8792236573");

        List<String> dance = new ArrayList<String>();
        dance.add("Jofin George                  8197265160");
        dance.add("Shreya Acharya                8971269757");

        List<String> music = new ArrayList<String>();
        music.add("Swastik Nandkumar             8123214006");
        music.add("Raghuveer C                   9480635524");
        music.add("Anupama VS                    9036446095");
        music.add("Gokul                         8050510824");

        List<String> fine = new ArrayList<String>();
        fine.add("Khushbu Agarwal               8951582705");
        fine.add("Avi Shekar                    9632642969");

        List<String> photo = new ArrayList<String>();
        photo.add("Abhishek Chintamani                9595959595");

        List<String> drama = new ArrayList<String>();
        drama.add("Parikshith                    9481015014");

        List<String> tech = new ArrayList<String>();
        tech.add("Vaithee                       9060359435");
        tech.add("Harinder                      7795260469");
        tech.add("Shubam Singh                  7795196871");

        List<String> pub = new ArrayList<String>();
        pub.add("Namrath Hebbar                9844005697");
        pub.add("Pramodh M                     9742622478");
        pub.add("Joane Kripa                   9740167271");

        List<String> spons = new ArrayList<String>();
        spons.add("Kushal                        9739859668");
        spons.add("Yashas                        9739979695");
        spons.add("Roshni                        9731524574");

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
