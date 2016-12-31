package com.emerap.app.AppHelper;

import android.content.Context;

import com.emerap.library.AppHelper.settings.Settings;

/**
 * Test settings helper.
 * Created by karbunkul on 30.12.2016.
 */

public class MyAppSettings extends Settings {

    public MyAppSettings(Context context) {
        super(context);
    }

    public static MyAppSettings newInstance(Context context) {
        return new MyAppSettings(context);
    }

    public String getGreetingMessage() {
        return getString("greeting_message", "Hello world!");
    }

    public void setGreetingMessage(String value) {
        setString("greeting_message", value);
    }
}