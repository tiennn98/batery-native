package com.battery;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BateryModule extends ReactContextBaseJavaModule {
    BateryModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "BatteryModule";
    }

    @ReactMethod
    public void getDeviceBatteryLevel(Promise promise) {
        try {
            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = getReactApplicationContext().registerReceiver(null, ifilter);
            int level = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) : -1;
            int scale = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1) : -1;
            float batteryPct = level / (float) scale;
            // Success, resolve the promise with the battery percentage
            promise.resolve(batteryPct);
        } catch (Exception e) {
            // If there are any exceptions, reject the promise
            promise.reject("Error", "Cannot access battery level", e);
        }
    }
}