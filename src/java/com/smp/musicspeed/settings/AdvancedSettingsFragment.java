/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.annotation.Keep
 *  androidx.preference.Preference
 *  androidx.preference.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.settings;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.preference.Preference;
import androidx.preference.g;
import com.smp.musicspeed.settings.f;
import f.z.d.k;

@Keep
public final class AdvancedSettingsFragment
extends g {
    public void _$_clearFindViewByIdCache() {
    }

    public void onCreatePreferences(Bundle bundle, String string) {
        this.addPreferencesFromResource(2132017156);
        Preference preference = this.findPreference((CharSequence)"preferences_buffer_size");
        k.e((Object)preference);
        k.f((Object)preference, "findPreference(Constants.PREF_BUFFER_SIZE)!!");
        f.a(preference);
        Preference preference2 = this.findPreference((CharSequence)"stretchQuality");
        k.e((Object)preference2);
        k.f((Object)preference2, "findPreference(Constants.PREF_STRETCH_QUALITY)!!");
        f.a(preference2);
    }
}

