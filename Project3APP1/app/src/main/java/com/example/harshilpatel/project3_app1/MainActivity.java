package com.example.harshilpatel.project3_app1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //define the buttons
    Button attractions;
    Button restaurants;

    //define the action keys and the permissions
    private static final String ACTION1 = "edu.uic.cs478.sp18.project3.ACTION_PROJECT3_ATTRACTIONS";
    private static final String ACTION2 = "edu.uic.cs478.sp18.project3.ACTION_PROJECT3_RESTAURANTS";
    private static final String PERMISSION = "edu.uic.cs478.sp18.project3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attractions = findViewById(R.id.button_attractions);

        //check for the click and get the permissions and then send the broadcast intent to the activity
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check for the permissions  SOURCE and CREDITS: Prof. Ugo
                if (ContextCompat.checkSelfPermission(MainActivity.this, PERMISSION)
                        == PackageManager.PERMISSION_GRANTED) {

                    //get the intent
                    Intent intent1 = new Intent(ACTION1);
                    intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    Toast.makeText(MainActivity.this, "Broadcasting for Attractions", Toast.LENGTH_LONG).show();

                    //send the broadcast intent
                    sendBroadcast(intent1);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{PERMISSION}, 0);
                }
            }
        });

        //send the
        restaurants = findViewById(R.id.button_restaurants);
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SOURCE and CREDITS: Prof. Ugo
                if (ContextCompat.checkSelfPermission(MainActivity.this, PERMISSION)
                        == PackageManager.PERMISSION_GRANTED) {

                    //send the required intent fot looking restaurants.
                    Intent intent1 = new Intent(ACTION2);
                    intent1.setAction(ACTION2);
                    intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    Toast.makeText(MainActivity.this, "Broadcasting for Restaurants", Toast.LENGTH_LONG).show();

                    //send the broadcast intent
                    sendBroadcast(intent1);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{PERMISSION}, 0);
                }
            }
        });
    }

    //SOURCE and CREDITS: Prof. Ugo
    public void onRequestPermissionsResult(int code, String[] permissions, int[] results) {
        if (results.length > 0) {
            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent1 = new Intent(ACTION1);
                intent1.setAction(ACTION1);
                intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                Toast.makeText(MainActivity.this, "Broadcasting for Attractions", Toast.LENGTH_LONG).show();

                //send the broadcast intent.
                sendBroadcast(intent1);
            } else {
                Toast.makeText(this, "Bummer: No permission", Toast.LENGTH_SHORT);
            }
        }
    }
}
