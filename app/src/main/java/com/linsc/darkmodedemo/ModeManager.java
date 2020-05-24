package com.linsc.darkmodedemo;

import androidx.appcompat.app.AppCompatDelegate;

/**
 * Create by linsc on 2020/5/24
 */
class ModeManager {
    static final int MODE_LIGHT = 0;
    static final int MODE_DARK = 1;
    static final int MODE_FOLLOW = 2;
    private int mode;
    private static final String Mode = "Mode";

    private static class Builder {
        private static ModeManager instance = new ModeManager();
    }

    static ModeManager getInstance = Builder.instance;

    private ModeManager() {

    }

    void init() {
        setMode((int) SharePreferenceUtils.get(MyApplication.getContext(), Mode, MODE_LIGHT));
    }

    int getMode() {
        return mode;
    }

    void setMode(int mode) {
        switch (mode) {
            case MODE_LIGHT:
                this.mode = mode;
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case MODE_DARK:
                this.mode = mode;
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case MODE_FOLLOW:
                this.mode = mode;
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
        SharePreferenceUtils.put(MyApplication.getContext(), Mode, mode);
    }
}
