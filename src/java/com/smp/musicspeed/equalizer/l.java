/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.preference.PreferenceManager
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.smp.musicspeed.equalizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;
import java.util.Map;

public class l {
    public static final Map<Integer, String> a = new HashMap<Integer, String>(){
        {
            this.put((Object)0, (Object)"com.smp.equalizer.0");
            this.put((Object)1, (Object)"com.smp.equalizer.1");
            this.put((Object)2, (Object)"com.smp.equalizer.2");
            this.put((Object)3, (Object)"com.smp.equalizer.3");
            this.put((Object)4, (Object)"com.smp.equalizer.4");
            this.put((Object)5, (Object)"com.smp.equalizer.5");
            this.put((Object)6, (Object)"com.smp.equalizer.6");
            this.put((Object)7, (Object)"com.smp.equalizer.7");
        }
    };

    public static boolean a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("com.smp.balanceenabled", false);
    }

    public static float b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getFloat("com.smp.balancelevel", 0.0f);
    }

    public static boolean c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("com.smp.equalizer.enabled", false);
    }

    public static float[] d(Context context) {
        float[] arrf = new float[8];
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        arrf[0] = sharedPreferences.getFloat("com.smp.equalizer.0", 0.0f);
        arrf[1] = sharedPreferences.getFloat("com.smp.equalizer.1", 0.0f);
        arrf[2] = sharedPreferences.getFloat("com.smp.equalizer.2", 0.0f);
        arrf[3] = sharedPreferences.getFloat("com.smp.equalizer.3", 0.0f);
        arrf[4] = sharedPreferences.getFloat("com.smp.equalizer.4", 0.0f);
        arrf[5] = sharedPreferences.getFloat("com.smp.equalizer.5", 0.0f);
        arrf[6] = sharedPreferences.getFloat("com.smp.equalizer.6", 0.0f);
        arrf[7] = sharedPreferences.getFloat("com.smp.equalizer.7", 0.0f);
        return arrf;
    }

    public static boolean e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean("com.smp.preampenabled", true);
    }

    public static float f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getFloat("com.smp.preamplevel", -3.0f);
    }

    public static void g(Context context, boolean bl, float f2, boolean bl2, float[] arrf, boolean bl3, float f3) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        editor.putBoolean("com.smp.preampenabled", bl);
        editor.putFloat("com.smp.preamplevel", f2);
        editor.putBoolean("com.smp.equalizer.enabled", bl2);
        editor.putFloat("com.smp.equalizer.0", arrf[0]);
        editor.putFloat("com.smp.equalizer.1", arrf[1]);
        editor.putFloat("com.smp.equalizer.2", arrf[2]);
        editor.putFloat("com.smp.equalizer.3", arrf[3]);
        editor.putFloat("com.smp.equalizer.4", arrf[4]);
        editor.putFloat("com.smp.equalizer.5", arrf[5]);
        editor.putFloat("com.smp.equalizer.6", arrf[6]);
        editor.putFloat("com.smp.equalizer.7", arrf[7]);
        editor.putBoolean("com.smp.balanceenabled", bl3);
        editor.putFloat("com.smp.balancelevel", f3);
        editor.apply();
    }

}

