package com.calypso.library.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jian on 2016/8/25.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public final class PrefUtil {
    private PrefUtil() {
    }

    public static int getInt(Context context, final String key, int defaultValue) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(key, defaultValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt(key, value).apply();
    }

    public static long getLong(Context context, final String key, long defaultValue) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getLong(key, defaultValue);
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putLong(key, value).apply();
    }

    public static String getString(Context context, final String key, final String defaultValue) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(key, defaultValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key, final boolean defaultValue) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(key, defaultValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean(key, value).apply();
    }

    public static void remove(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove(key).apply();
    }
}