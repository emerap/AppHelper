package com.emerap.library.AppHelper.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.emerap.library.AppHelper.AppHelperException;

/**
 * Created by karbunkul on 31.12.16.
 */

class StorageProviderSharedPreferences extends StorageProvider {

    private SharedPreferences mPrefs;

    public StorageProviderSharedPreferences(Context context) {
        super(context);
        setContext(context);
        SharedPreferences prefs;
        if (getContext() != null) {
            prefs = getContext().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
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

    @Override
    public void onChangePrefix(String prefix) {
        setPrefix(prefix);
    }
}
