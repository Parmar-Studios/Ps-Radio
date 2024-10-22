package com.parmarstudios.radio;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.parmarstudios.radio.radiobrowser.ConnectionParams;
import com.parmarstudios.radio.radiobrowser.EndpointDiscovery;
import com.parmarstudios.radio.radiobrowser.FieldName;
import com.parmarstudios.radio.radiobrowser.ListParameter;
import com.parmarstudios.radio.radiobrowser.Paging;
import com.parmarstudios.radio.radiobrowser.RadioBrowser;
import com.parmarstudios.radio.radiobrowser.SearchMode;

import java.io.IOException;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Optional<String> endpoint = null;
                try {
                    endpoint = new EndpointDiscovery("Demo agent/1.0").discover();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

// build instance
                RadioBrowser radioBrowser = new RadioBrowser(
                        new ConnectionParams.Builder().setApiUrl(endpoint.get()).setUserAgent("Demo agent/1.0").setTimeout(5000).build());

// list stations
//                radioBrowser.listStations(ListParameter.create().order(FieldName.NAME))
//                        .limit(64)
//                        .forEach(s -> Log.d(MainActivity.class.getName(), s.getUrl()));


                radioBrowser.listStationsBy(SearchMode.BYCOUNTRYCODEEXACT, "in", ListParameter.create().order(FieldName.NAME))
                        .limit(200)
                        .forEach(s -> Log.d(MainActivity.class.getName(), s.getName()+"   "+s.getUrl()));
            }
        };

        Thread th = new Thread(run);
        th.start();

    }

    ;
}