package com.example.flutter_segment;
import android.app.Application;

import androidx.annotation.NonNull;

import com.webengage.sdk.android.WebEngage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                try {
                    String token = task.getResult();
                    WebEngage.get().setRegistrationID(token);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}