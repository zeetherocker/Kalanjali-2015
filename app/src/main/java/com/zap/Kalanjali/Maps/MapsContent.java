package com.zap.Kalanjali.Maps;

import com.google.android.gms.maps.model.LatLng;
import com.zap.Kalanjali.EventMasterFlow.EventItem;
import com.zap.Kalanjali.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeeshan on 9/28/2015.
 */
public class MapsContent {

    private static final LatLng LOCATION_MVIT = new LatLng(13.151030, 77.610929);
    private static final LatLng LOCATION_MVIT_OFF = new LatLng(13.151031, 77.610961);
    private static final LatLng LOCATION_SCIENCE = new LatLng(13.150812, 77.609026);
    private static final LatLng LOCATION_SCIENCE_OFF = new LatLng(13.150813, 77.609058);
    private static final LatLng LOCATION_NB = new LatLng(13.150893, 77.610195);
    private static final LatLng LOCATION_NB_OFF = new LatLng(13.150894, 77.610227);
    private static final LatLng LOCATION_NA = new LatLng(13.151428, 77.607093);
    private static final LatLng LOCATION_NA_OFF = new LatLng(13.151429, 77.607125);
    private static final LatLng LOCATION_OA = new LatLng(13.1513653, 77.6072150);
    private static final LatLng LOCATION_OA_OFF = new LatLng(13.1513654, 77.6072182);
    private static final LatLng LOCATION_LIB = new LatLng(13.151283, 77.608933);
    private static final LatLng LOCATION_LIB_OFF = new LatLng(13.151284, 77.608965);
    private static final LatLng LOCATION_PL = new LatLng(13.150273, 77.609734);
    private static final LatLng LOCATION_PL_OFF = new LatLng(13.150274, 77.609766);
    private static final LatLng LOCATION_CS = new LatLng(13.151042, 77.608881);
    private static final LatLng LOCATION_CS_OFF = new LatLng(13.151043, 77.608913);
    private static final LatLng LOCATION_CA = new LatLng(13.149867, 77.610226);
    private static final LatLng LOCATION_CA_OFF = new LatLng(13.149868, 77.610258);
    private static final LatLng LOCATION_ME = new LatLng(13.150604, 77.608400);
    private static final LatLng LOCATION_ME_OFF = new LatLng(13.150605, 77.608432);
    private static final LatLng LOCATION_CB = new LatLng(13.150856, 77.608690);
    private static final LatLng LOCATION_CB_OFF = new LatLng(13.150857, 77.608722);

    /**
     * An array of sample (dummy) items.
     */
    public static List<MapsItem> ITEMS = new ArrayList<MapsItem>();

    static {
        addItem(new MapsItem(LOCATION_MVIT, R.string.title_mvit, LOCATION_MVIT_OFF));
        addItem(new MapsItem(LOCATION_SCIENCE, R.string.title_science, LOCATION_SCIENCE_OFF));
        addItem(new MapsItem(LOCATION_NB, R.string.title_newblock, LOCATION_NB_OFF));
        addItem(new MapsItem(LOCATION_NA, R.string.title_audi, LOCATION_NA_OFF));
        addItem(new MapsItem(LOCATION_OA, R.string.title_oldaudi, LOCATION_OA_OFF));
        addItem(new MapsItem(LOCATION_LIB, R.string.title_library, LOCATION_LIB_OFF));
        addItem(new MapsItem(LOCATION_PL, R.string.title_parking, LOCATION_PL_OFF));
        addItem(new MapsItem(LOCATION_CS, R.string.title_coffee, LOCATION_CS_OFF));
        addItem(new MapsItem(LOCATION_CA, R.string.title_canteen, LOCATION_CA_OFF));
        addItem(new MapsItem(LOCATION_ME, R.string.title_mech, LOCATION_ME_OFF));
        addItem(new MapsItem(LOCATION_CB, R.string.title_civil, LOCATION_CB_OFF));
    }

    private static void addItem(MapsItem item) {
        ITEMS.add(item);
    }
}