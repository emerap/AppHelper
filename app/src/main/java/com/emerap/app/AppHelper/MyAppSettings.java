package com.emerap.app.AppHelper;

import com.emerap.library.AppHelper.Settings;

/**
 * Test settings helper.
 * Created by karbunkul on 30.12.2016.
 */

public class MyAppSettings extends Settings {

    @Override
    public int getStorageProvider(int provider) {
        return STORAGE_PROVIDER_SHARED_PREFERENCES;
    }

    @Override
    public int getStorageMode(int storageMode) {
        return STORAGE_MODE_SINGLE;
    }
}
