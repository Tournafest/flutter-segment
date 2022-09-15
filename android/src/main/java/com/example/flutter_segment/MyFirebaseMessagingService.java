package com.example.flutter_segment;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.webengage.sdk.android.WebEngage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        WebEngage.get().setRegistrationID(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Not needed already handling in MessagingReceiver
    }
}