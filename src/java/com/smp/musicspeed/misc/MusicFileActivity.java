/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  androidx.appcompat.app.e
 *  java.lang.Class
 *  java.lang.String
 */
package com.smp.musicspeed.misc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.e;
import com.smp.musicspeed.MainActivity;

public class MusicFileActivity
extends e {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = this.getIntent();
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext()).edit();
        editor.putBoolean("com.smp.PREF_FROM_OTHER_APP", true);
        editor.apply();
        intent.setClass((Context)this, MainActivity.class);
        this.startActivity(intent);
        this.finish();
    }
}

