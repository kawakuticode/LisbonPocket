package com.lisbonpocket.code.kawakuti.lisbonpocket;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Where_I_Am extends AppCompatActivity {


    private Location location;
    private GpsTracker gpsTracker;
    private double latitude;
    private double longitude;
    private ConnectionDectector connectionDectector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where__i__am);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gpsTracker = new GpsTracker(this);
        connectionDectector = new ConnectionDectector(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            LocationAddress locationAddress = new LocationAddress();

            @Override
            public void onClick(View view) {
                if (connectionDectector.isConnectingToInternet()) {
                    if (gpsTracker.canGetLocation()) {
                        latitude = gpsTracker.getLatitude();
                        longitude = gpsTracker.getLongitude();
                        location = gpsTracker.getLocation();
                        if (location != null) {
                            LocationAddress.getAddressFromLocation(latitude, longitude,
                                    getApplicationContext(), new GeocoderHandler());
                        }
                    }
                } else {
                    connectionDectector.showSettingsAlertInternet();
                }
            }
        });
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    Intent services = new Intent(getApplicationContext(), ServicesArround.class);
                    services.putExtra("Current_Address", locationAddress);
                    startActivity(services);
                    break;
                default:
                    break;
            }
        }
    }
}


