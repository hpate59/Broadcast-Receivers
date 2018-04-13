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

public class Restaurants extends AppCompatActivity {

    //create a list of items
    String[] restaurants = { "Baccis Pizzeria", "Lou Malantis", "Velvet Taco",
            "DePasada", "Chilango", "Eleven City Diner"};

    String[] cities = { "Chicago","Chicago","Chicago","Chicago","Chicago","Chicago"};

    String[] url = { "http://www.baccipizza.com/","https://www.loumalnatis.com/",
            "https://velvettaco.com/","http://www.depasadarestaurant.com/",
            "http://chilangorestaurant.com/","https://www.opentable.com/r/eleven-city-diner-chicago-2"};

    private SimpleAdapter adapter;
    WebView webview;

    private ArrayList<String> restaurant_list = new ArrayList<>();
    private ArrayList<String> city_list = new ArrayList<>();
    private ArrayList<String> web_list = new ArrayList<>();


    private Map<String, String> resAndCity;
    private List<Map<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ListView finalList = findViewById(R.id.finalList);

        restaurant_list.addAll(Arrays.asList(restaurants));
        city_list.addAll(Arrays.asList(cities));
        web_list.addAll(Arrays.asList(url));


        list = new ArrayList<>();
        for (int i=0; i<restaurants.length; i++) {

            //create a HashMap to add song and the artist name
            resAndCity = new HashMap<>(2);

            //put the artist name and the song name in the
            resAndCity.put("restaurants", restaurants[i]);
            resAndCity.put("city", cities[i]);

            //add the song and the artist to the list
            list.add(resAndCity);
        }

        adapter = new SimpleAdapter(this, list, R.layout.restaurants,
                new String[] {"restaurants", "city"},
                new int[] {R.id.restaurant_name,
                        R.id.city});

        //set the adapter
        finalList.setAdapter(adapter);

        finalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url = web_list.get(position);

                webview = new WebView(Restaurants.this);
                setContentView(webview);
                webview.loadUrl(url);

            }
        }); //end of on click listner
    }

    //Create a options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    //set click listner for the menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //if the intent to see the restaurants
        if(id == R.id.id_restaurants){

            //make and intent to start the specific activity activity
            Intent open_restaurants = new Intent(Restaurants.this, Restaurants.class);

            //start the activity
            startActivity(open_restaurants);
            return true;

        }//end of add song


        //if the intent is to see the attractions
        if(id == R.id.id_attractions){

            //make and intent to start the specific activity activity
            Intent open_attractions = new Intent(Restaurants.this, Attractions.class);

            //start the activity
            startActivity(open_attractions);
            return true;

        }
        return true;
    }
}
