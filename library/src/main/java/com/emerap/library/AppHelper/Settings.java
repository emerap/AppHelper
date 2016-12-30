package com.emerap.library.AppHelper;

import android.content.Context;
import android.content.SharedPreferences;

import static com.emerap.library.AppHelper.Settings.StorageProvider.TYPE_INT;
import static com.emerap.library.AppHelper.Settings.StorageProvider.TYPE_STRING;

/**
 * Helper for Settings
 * Created by karbunkul on 30.12.2016.
 */

interface SettingsSetup {
    // Setup storage provider
    int getStorageProvider();
}

public abstract class Settings implements SettingsSetup {

    interface StorageProviderInterface {
        /**
         * Get value from storage provider
         *
         * @param name value name
         * @return object
         */
        Object getValue(String name, Object defaultValue, int type);

        void setValue(String param, Object object, int type);
    }

    final public static int STORAGE_PROVIDER_SHARED_PREFERENCES = 0;
    final public static int STORAGE_PROVIDER_DATABASE = 1;

    private Context mContext;
    private String mPrefix;

    /**
     * Constructor
     */
    public Settings(Context context) {
        setContext(context);
        setPrefix("default");
    }

    /**
     * Methods
     */
    /**
     * Get int from settings storage.
     *
     * @param param param name
     * @return param value
     */
    public int getInt(String param, int defaultValue) {
        Object value = getProvider().getValue(getParamName(param), defaultValue, TYPE_INT);
        return (value != null) ? (int) value : defaultValue;
    }

    /**
     * Set int to settings storage
     * @param param param
     * @param value value
     */
    public void setInt(String param, int value){
        getProvider().setValue(getParamName(param), value, TYPE_INT);
    }

    /**
     * Get string from settings storage
     * @param param param
     * @param defaultValue default value
     * @return string from setiings storage
     */
    public String getString(String param, String defaultValue){
        Object value = getProvider().getValue(getParamName(param), defaultValue, TYPE_STRING);
        return (value != null) ? (String) value : defaultValue;
    }

    /**
     * Set int to settings storage
     * @param param param
     * @param value value
     */
    public void setString(String param, String value){
        getProvider().setValue(getParamName(param), value, TYPE_STRING);
    }

    /**
     * Get storage provider object.
     *
     * @return storage provider.
     */
    private StorageProvider getProvider() {
        if (getStorageProvider() == STORAGE_PROVIDER_SHARED_PREFERENCES) {
            return new StorageProviderSharedPreferences();
        }
        return null;
    }

    private String getParamName(String param) {
        return param + "_" + getPrefix();
    }

    /**
     * Getters & setters
     */

    /**
     * Getter for context
     *
     * @return application context
     */
    private Context getContext() {
        return mContext;
    }

    /**
     * Setter for context
     *
     * @param context application context
     */
    private void setContext(Context context) {
        this.mContext = context;
    }

    private String getPrefix() {
        return mPrefix;
    }

    /**
     * Setter for prefix
     *
     * @param prefix prefix
     */
    public Settings setPrefix(String prefix) {
        this.mPrefix = prefix;
        return this;
    }

    /**
     * Base class for storage provider
     */
    public abstract class StorageProvider implements StorageProviderInterface {

        final public static int TYPE_INT = 0;
        final public static int TYPE_BOOL = 1;
        final public static int TYPE_STRING = 2;
        final public static int TYPE_FLOAT = 3;
    }

    /**
     * Storage provider for SharedPreferences storage
     */
    private class StorageProviderSharedPreferences extends StorageProvider {

        SharedPreferences mPrefs;

        StorageProviderSharedPreferences() {
            String sharedName = getParamName("app_settings");
            SharedPreferences prefs;
            if (getContext() != null) {
                prefs = getContext().getSharedPreferences(sharedName, Context.MODE_PRIVATE);
                if (prefs != null) {
                    setPrefs(prefs);
                } else {
                    try {
                        throw new AppHelperException("Editor is NULL");
                    } catch (AppHelperException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new AppHelperException("Context is NULL");
            }
        }

        @Override
        public Object getValue(String param, Object defaultValue, int type) {
            switch (type) {
                case TYPE_INT: {
                    return getPrefs().getInt(param, (int) defaultValue);
                }
                case TYPE_STRING: {
                    return getPrefs().getString(param, (String) defaultValue);
                }
                case TYPE_BOOL: {
                    return getPrefs().getBoolean(param, (Boolean) defaultValue);
                }
                case TYPE_FLOAT: {
                    return getPrefs().getFloat(param, (Float) defaultValue);
                }
            }
            return null;
        }

        @Override
        public void setValue(String param, Object object, int type) {
            switch (type) {
                case TYPE_INT: {
                    getPrefs().edit().putInt(param, (int) object).apply();
                    break;
                }
                case TYPE_STRING: {
                    getPrefs().edit().putString(param, (String) object).apply();
                    break;
                }
                case TYPE_BOOL: {
                    getPrefs().edit().putBoolean(param, (Boolean) object).apply();
                    break;
                }
                case TYPE_FLOAT: {
                    getPrefs().edit().putFloat(param, (Float) object).apply();
                    break;
                }
            }
        }

        private SharedPreferences getPrefs() {
            return mPrefs;
        }

        private void setPrefs(SharedPreferences prefs) {
            this.mPrefs = prefs;
        }
    }
}
