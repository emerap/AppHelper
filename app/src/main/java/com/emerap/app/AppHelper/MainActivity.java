package com.emerap.app.AppHelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        MyAppSettings appSettings = MyAppSettings.newInstance(context);

        appSettings.setGreetingMessage("124");
        setTitle(appSettings.getGreetingMessage());
    }
}
