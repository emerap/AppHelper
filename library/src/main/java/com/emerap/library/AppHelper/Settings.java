package com.emerap.library.AppHelper;

/**
 * Created by karbunkul on 30.12.2016.
 */

interface SettingsSetup {
    // Setup storage provider
    int getStorageProvider(int storageProvider);
    // Setup storage mode
    int getStorageMode(int storageMode);
}

public abstract class Settings implements SettingsSetup {

    final public static int STORAGE_PROVIDER_SHARED_PREFERENCES = 0;
    final public static int STORAGE_PROVIDER_DATABASE = 1;

    final public static int STORAGE_MODE_SINGLE = 0;
    final public static int STORAGE_MODE_MULTYPLY = 1;

    private String mPrefix;

    public Settings() {
    }

    public Settings(String prefix) {
        this.mPrefix = prefix;
    }

    // Getters & setters

    public String getPrefix() {
        return mPrefix;
    }

    public void setPrefix(String prefix) {
        this.mPrefix = prefix;
    }
}
