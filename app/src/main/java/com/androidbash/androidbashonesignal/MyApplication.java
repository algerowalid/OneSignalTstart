package com.androidbash.androidbashonesignal;

        import android.app.Application;
        import android.content.Context;
        import android.util.Log;

        import com.onesignal.OneSignal;

public class MyApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    //Called when the application is starting, before any other application objects have been created.
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //MyNotificationOpenedHandler : This will be called when a notification is tapped on.
        //MyNotificationReceivedHandler : This will be called when a notification is received while your app is running.
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new MyNotificationOpenedHandler())
                .setNotificationReceivedHandler( new MyNotificationReceivedHandler() )
                .init();




        // Récupére le ID  affecter par OneSignal a l'application user
/*
        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            @Override
            public void idsAvailable(String userId, String registrationId) {
                Log.i("debugOneSignalId", "User:" + userId);
                tx.setText(" " +userId +"\n "+registrationId );
                if (registrationId != null)
                    Log.i("debugOneSignalId", "registrationId:" + registrationId);
            }
        });
  */
    }


}
