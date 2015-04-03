package org.nsdev.testuaapp;

import android.app.Application;
import android.content.Context;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import com.urbanairship.google.PlayServicesUtils;

/**
 * Created by vitaly on 15-02-27.
 */
public class UrbanAirshipHelper {

    public UrbanAirshipHelper() {
    }

    public void setup(final Application app) {

        Context context = app.getApplicationContext();

        AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(context);

        // Calling takeOff() with a callback
        UAirship.takeOff(app, options, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship airship) {
                airship.getPushManager().setPushEnabled(true);
                airship.getPushManager().setUserNotificationsEnabled(true);
            }
        });

    }

    public void setPlayServicesErrorHandler(Context context) {
        // Handle any Google Play Services errors
        if (PlayServicesUtils.isGooglePlayStoreAvailable()) {
            PlayServicesUtils.handleAnyPlayServicesError(context);
        }
    }
}
