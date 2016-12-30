package com.emerap.app.AppHelper;

import android.content.Context;

import com.emerap.library.AppHelper.Settings;

/**
 * Test settings helper.
 * Created by karbunkul on 30.12.2016.
 */

public class MyAppSettings extends Settings {

    public MyAppSettings(Context context) {
        super(context);
    }

    @Override
    public int getStorageProvider() {
        return STORAGE_PROVIDER_SHARED_PREFERENCES;
    }
}