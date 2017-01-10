package com.emerap.app.AppHelper;

import android.content.Context;

import com.emerap.library.AppHelper.settings.Settings;
import com.example.SettingsItem;

/**
 * Test settings helper.
 * Created by karbunkul on 30.12.2016.
 */

public class MyAppSettings extends Settings {

    @SettingsItem(name = "123554")
    String mString = "qwerty";

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