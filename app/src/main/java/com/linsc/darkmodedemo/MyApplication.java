package com.linsc.darkmodedemo;

import android.app.Application;
import android.content.Context;

/**
 * Create by linsc on 2020/5/24
 */
public class MyApplication extends Application {
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ModeManager.getInstance.init();
    }

    public static Context getContext() {
        return context;
    }
}
