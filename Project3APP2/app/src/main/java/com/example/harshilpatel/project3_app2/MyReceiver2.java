package com.example.harshilpatel.project3_app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //start the intent explicitly
        Intent intent1 = new Intent();
        intent1.setClassName(context.getPackageName(), Restaurants.class.getName());
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

        Toast.makeText(context, "Broadcast Received for Restaurants", Toast.LENGTH_LONG).show();

    }
}
