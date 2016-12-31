package com.emerap.library.AppHelper.settings;

import android.content.Context;

import static com.emerap.library.AppHelper.settings.StorageProvider.TYPE_BOOL;
import static com.emerap.library.AppHelper.settings.StorageProvider.TYPE_FLOAT;
import static com.emerap.library.AppHelper.settings.StorageProvider.TYPE_INT;
import static com.emerap.library.AppHelper.settings.StorageProvider.TYPE_STRING;

/**
 * Helper for Settings
 * Created by karbunkul on 30.12.2016.
 */

public abstract class Settings {

    private Context mContext;
    private String mPrefix;
    private StorageProvider mStorageProvider;

    public interface PrefixChangeListener {
        void onChangePrefix(String prefix);
    }

    private PrefixChangeListener listener = new PrefixChangeListener() {
        @Override
        public void onChangePrefix(String prefix) {

        }
    };

    /**
     * Constructor
     */
    public Settings(Context context) {
        setContext(context);
        setPrefix("default");
        setStorageProvider(new StorageProviderSharedPreferences(context));
    }

    /**
     * Get int from settings storage.
     *
     * @param param param name
     * @return param value
     */
    protected int getInt(String param, int defaultValue) {
        Object value = getStorageProvider().getValue(getParamName(param), defaultValue, TYPE_INT);
        return (value != null) ? (int) value : defaultValue;
    }

    /**
     * Set int to settings storage
     *
     * @param param param
     * @param value value
     */
    protected void setInt(String param, int value) {
        getStorageProvider().setValue(getParamName(param), value, TYPE_INT);
    }

    /**
     * Get string from settings storage
     *
     * @param param param
     * @param defaultValue default value
     * @return string from setiings storage
     */
    protected String getString(String param, String defaultValue) {
        Object value = getStorageProvider().getValue(getParamName(param), defaultValue, TYPE_STRING);
        return (value != null) ? (String) value : defaultValue;
    }

    /**
     * Set string to settings storage
     *
     * @param param param
     * @param value value
     */
    protected void setString(String param, String value) {
        getStorageProvider().setValue(getParamName(param), value, TYPE_STRING);
    }

    /**
     * Get boolean from settings storage
     *
     * @param param param
     * @param defaultValue default value
     * @return boolean from setiings storage
     */
    protected Boolean getBoolean(String param, Boolean defaultValue) {
        Object value = getStorageProvider().getValue(getParamName(param), defaultValue, TYPE_BOOL);
        return (value != null) ? (Boolean) value : defaultValue;
    }

    /**
     * Set boolean to settings storage
     *
     * @param param param
     * @param value value
     */
    protected void setBoolean(String param, Boolean value) {
        getStorageProvider().setValue(getParamName(param), value, TYPE_BOOL);
    }

    /**
     * Get float from settings storage
     *
     * @param param param
     * @param defaultValue default value
     * @return float from setiings storage
     */
    protected Float getFloat(String param, Float defaultValue) {
        Object value = getStorageProvider().getValue(getParamName(param), defaultValue, TYPE_FLOAT);
        return (value != null) ? (Float) value : defaultValue;
    }

    /**
     * Set float to settings storage
     *
     * @param param param
     * @param value value
     */
    protected void setFloat(String param, Float value) {
        getStorageProvider().setValue(getParamName(param), value, TYPE_FLOAT);
    }

    /**
     * Get param name with prefix
     *
     * @param param param
     * @return param with prefix
     */
    private String getParamName(String param) {
        String paramName = param + "_" + getPrefix();
        return paramName;
    }

    /**
     * Getters & setters
     */

    /**
     * Getter for context
     *
     * @return application context
     */
    protected Context getContext() {
        return mContext;
    }

    /**
     * Setter for context
     *
     * @param context application context
     */
    public void setContext(Context context) {
        this.mContext = context;
    }

    public String getPrefix() {
        return mPrefix;
    }

    /**
     * Setter for prefix
     *
     * @param prefix prefix
     */
    public void setPrefix(String prefix) {
        listener.onChangePrefix(prefix);
        this.mPrefix = prefix;


    }

    public StorageProvider getStorageProvider() {
        return mStorageProvider;
    }

    public void setStorageProvider(StorageProvider storageProvider) {
        this.mStorageProvider = storageProvider;
    }
}
