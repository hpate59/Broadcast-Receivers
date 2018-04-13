package com.example.harshilpatel.project3_app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attractions extends AppCompatActivity{

    //enter the initial songs List

    String[] attractions = { "Navy Pier", "Alder Planetarium", "Lincoln Park Zoo",
            "The TILT", "Sears Tower", "The Art Institute", "The Bean", "Millennium Park",
            "The Magnificent Mile"};

    String[] cities = { "Chicago","Chicago","Chicago","Chicago","Chicago","Chicago","Chicago",
            "Chicago","Chicago"};

    String[] url = { "https://navypier.org/", "https://www.adlerplanetarium.org/#s1LtxJyYR9PgatEf.97",
            "https://www.lpzoo.org/","http://www.360chicago.com/tilt/",
            "http://theskydeck.com/","http://www.artic.edu/",
            "https://en.wikipedia.org/wiki/Cloud_Gate",
            "https://www.cityofchicago.org/city/en/depts/dca/supp_info/millennium_park.html","https://www.themagnificentmile.com/"};


    private SimpleAdapter adapter;
    WebView webview;


    private ArrayList<String> attractions_list = new ArrayList<>();
    private ArrayList<String> city_list = new ArrayList<>();
    private ArrayList<String> web_list = new ArrayList<>();


    private Map<String, String> attAndCity;
    private List<Map<String, String>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        ListView finalList = findViewById(R.id.finalList);

        attractions_list.addAll(Arrays.asList(attractions));
        city_list.addAll(Arrays.asList(cities));
        web_list.addAll(Arrays.asList(url));


        list = new ArrayList<>();
        for (int i=0; i<attractions.length; i++) {

            attAndCity = new HashMap<>(2);

            attAndCity.put("attractions", attractions[i]);
            attAndCity.put("city", cities[i]);

            //add the song and the artist to the list
            list.add(attAndCity);
        }

        adapter = new SimpleAdapter(this, list, R.layout.attractions,
                new String[] {"attractions", "city"},
                new int[] {R.id.attraction_name,
                        R.id.city});

        //set the adapter
        finalList.setAdapter(adapter);

        finalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url = web_list.get(position);
                webview = new WebView(Attractions.this);
                setContentView(webview);
                webview.loadUrl(url);


            }
        }); //end of on click listner

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.id_restaurants){

            //make and intent to start the specific activity
            Intent open_restaurants = new Intent(Attractions.this, Restaurants.class);


            //start the activity
            startActivity(open_restaurants);
            return true;

        }//end of add song


        if(id == R.id.id_attractions){

            Intent open_attractions = new Intent(Attractions.this, Attractions.class);
            //start the activity
            startActivity(open_attractions);
            return true;

        }
        return true;
    }
}
