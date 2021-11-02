/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  androidx.preference.Preference
 *  androidx.preference.Preference$d
 *  com.smp.musicspeed.settings.e
 *  java.lang.Object
 */
package com.smp.musicspeed.settings;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import com.smp.musicspeed.settings.e;

public final class b
implements Preference.d {
    public final /* synthetic */ SharedPreferences a;
    public final /* synthetic */ e b;

    public /* synthetic */ b(SharedPreferences sharedPreferences, e e2) {
        this.a = sharedPreferences;
        this.b = e2;
    }

    public final boolean a(Preference preference) {
        return e.x((SharedPreferences)this.a, (e)this.b, (Preference)preference);
    }
}

