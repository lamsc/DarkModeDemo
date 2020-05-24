package com.linsc.darkmodedemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

/**
 * Create by linsc on 2020/5/24
 */
public final class ResUtils {
    private ResUtils() {
    }

    static int getColor(Activity activity, @ColorRes int colorResId) {
        return ContextCompat.getColor(activity, colorResId);
    }

    public static Drawable getDrawable(Activity activity, @DrawableRes int drawableResId) {
        return ContextCompat.getDrawable(activity, drawableResId);
    }
}
