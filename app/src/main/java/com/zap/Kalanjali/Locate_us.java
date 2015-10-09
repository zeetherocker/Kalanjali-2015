package com.zap.Kalanjali;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;
import com.zap.Kalanjali.Maps.MapsContent;
import com.zap.Kalanjali.Maps.MapsItem;

import java.util.ArrayList;
import java.util.List;

public class Locate_us extends ActionBarActivity {

    private static final LatLng LOCATION_MVIT = new LatLng(13.151030, 77.610929);
    private static final LatLng LOCATION_SCIENCE = new LatLng(13.150812, 77.609026);
    private static final LatLng LOCATION_NB = new LatLng(13.150893, 77.610195);
    private static final LatLng LOCATION_NA = new LatLng(13.151428, 77.607093);
    private static final LatLng LOCATION_OA = new LatLng(13.1513653, 77.6072150);
    private static final LatLng LOCATION_LIB = new LatLng(13.151283, 77.608933);
    private static final LatLng LOCATION_PL = new LatLng(13.150273, 77.609734);
    private static final LatLng LOCATION_CS = new LatLng(13.151042, 77.608881);
    private static final LatLng LOCATION_CA = new LatLng(13.149867, 77.610226);
    private static final LatLng LOCATION_ME = new LatLng(13.150604, 77.608400);
    private static final LatLng LOCATION_CB = new LatLng(13.150856, 77.608690);
    private static final LatLng LOCATION_MBA = new LatLng(13.151316, 77.609377);
    private static final LatLng LOCATION_DEN = new LatLng(13.149771, 77.608481);
    private static final LatLng LOCATION_WORK = new LatLng(13.151112, 77.607833);
    private static final LatLng LOCATION_GROUND = new LatLng(13.149730, 77.605473);

    private LatLng curLatlng;

    private final float LOCATION_ANGLE = 270;
    private final float LOCATION_ZOOM = 18.19f;
    private final float LOCATION_ZOOM_EVENT = 20f;
    private final float LOCATION_TILT = 60;
    private static int layout_type = 1;
    private int cameraPos;


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate_us);
        setUpMapIfNeeded();


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locate_us.this.onBackPressed();
            }
        });
        toolbar.setBackgroundColor(getResources().getColor(R.color.brown));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public static void getLayout(CheckBox cb) {
        if (cb.isChecked())
            layout_type = 1;
        else if (!cb.isChecked())
            layout_type = 0;
    }

    private void setUpMap() {

        getMarkers();
        CameraPosition pos = getCameraPos();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);
        mMap.animateCamera(update);
        if (layout_type == 1)
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        else if (layout_type == 0)
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);

    }

    public void getMarkers() {

        List<MapsItem> list = new ArrayList<MapsItem>();
        list = MapsContent.ITEMS;

        IconGenerator iconfactory = new IconGenerator(this);
        iconfactory.setTextAppearance(R.style.MapLabel);
        iconfactory.setBackground(null);

        for (int i=0; i<list.size(); i++ ){

            MapsItem current = list.get(i);

            final BitmapDescriptor icon =
                    BitmapDescriptorFactory.fromBitmap(iconfactory.makeIcon(getString(current.title)));
            final BitmapDescriptor icon1 =
                    BitmapDescriptorFactory.fromResource(R.drawable.marker);
            mMap.addMarker(new MarkerOptions().position(current.titlePosition).title(getString(current.title)).icon(icon)
                    .anchor(iconfactory.getAnchorU(), iconfactory.getAnchorV()));
            mMap.addMarker(new MarkerOptions().position(current.position).title(getString(current.title)).icon(icon1));

        }

    }

    public CameraPosition getCameraPos(){

        Bundle b = getIntent().getExtras();
        if(b!=null) {
            cameraPos = b.getInt("cameraPos");
            switch (cameraPos) {
                case 1:
                    curLatlng = LOCATION_NB;
                    break;
                case 2:
                    curLatlng = LOCATION_NA;
                    break;
                case 3:
                    curLatlng = LOCATION_OA;
                    break;
                case 4:
                    curLatlng = LOCATION_CB;
                    break;
                case 5:
                    curLatlng = LOCATION_PL;
                    break;
                case 6:
                    curLatlng = LOCATION_SCIENCE;
                    break;
                case 7:
                    curLatlng = LOCATION_MBA;
                    break;
                case 8:
                    curLatlng = LOCATION_DEN;
                    break;
                case 9:
                    curLatlng = LOCATION_WORK;
                    break;
                case 10:
                    curLatlng = LOCATION_GROUND;
                    break;
            }
            return new CameraPosition.Builder().bearing(LOCATION_ANGLE).target(curLatlng).zoom(LOCATION_ZOOM_EVENT).tilt(LOCATION_TILT).build();
        }
        return new CameraPosition.Builder().bearing(LOCATION_ANGLE).target(LOCATION_MVIT).zoom(LOCATION_ZOOM).tilt(LOCATION_TILT).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if(id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
