package com.emerap.app.AppHelper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TEST_INT = "int_value";
    private static final String TEST_STRING = "string_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        MyAppSettings appSettings = new MyAppSettings(context);

        // INT
        appSettings.setInt(TEST_INT, 1);
        int intValue = appSettings.getInt(TEST_INT, 10);
        // STRING
        appSettings.setString(TEST_STRING, "hello world!");
        String stringValue = appSettings.getString(TEST_STRING, "default");
    }
}
