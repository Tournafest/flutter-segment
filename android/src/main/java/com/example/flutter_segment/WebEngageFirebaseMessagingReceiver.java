package com.example.flutter_segment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.webengage.sdk.android.WebEngage;

import java.util.HashMap;
import java.util.Map;

public class WebEngageFirebaseMessagingReceiver extends BroadcastReceiver {
    private static final String TAG = "Tournafest-WebEngage";
    static HashMap<String, RemoteMessage> notifications = new HashMap<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Webengage broadcast received for message");

        if (intent.getExtras() == null) {
            Log.d(
                    TAG,
                    "broadcast received but intent contained no extras to process RemoteMessage. Operation cancelled.");
            return;
        }

        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        Map<String, String> data = remoteMessage.getData();
        if(data != null) {
            if(data.containsKey("source") && "webengage".equals(data.get("source"))) {
                WebEngage.get().receive(data);
            }
        }
    }
}