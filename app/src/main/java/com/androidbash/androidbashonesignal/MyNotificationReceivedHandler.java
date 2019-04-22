package com.androidbash.androidbashonesignal;

import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONObject;

//La class est applé quand l'application reçoit une notification pendant le service

public class MyNotificationReceivedHandler  implements OneSignal.NotificationReceivedHandler {
    @Override
    public void notificationReceived(OSNotification notification) {
        JSONObject data = notification.payload.additionalData;
        String customKey;

        if (data != null) {
            //While sending a Push notification from OneSignal dashboard
            // you can send an addtional data named "customkey" and retrieve the value of it and do necessary operation
            customKey = data.optString("customkey", null);
            if (customKey != null)
                Log.i("OneSignal", "customkey valeur: " + customKey);
        }
    }
}