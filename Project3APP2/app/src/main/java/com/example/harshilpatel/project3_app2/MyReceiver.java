package com.example.harshilpatel.project3_app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        //start the intent explicitly
        Intent intent1 = new Intent();
        intent1.setClassName(context.getPackageName(), Attractions.class.getName());
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

        Toast.makeText(context, "Broadcast Received for Attractions", Toast.LENGTH_LONG).show();

    }
}
