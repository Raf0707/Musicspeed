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
public final class PitchAndTempoSettingsFragment
extends g {
    public void _$_clearFindViewByIdCache() {
    }

    public void onCreatePreferences(Bundle bundle, String string) {
        this.addPreferencesFromResource(2132017158);
        Preference preference = this.findPreference((CharSequence)"preferences_on_track_change");
        k.e((Object)preference);
        k.f((Object)preference, "findPreference(Constants.PREFS_ON_TRACK_CHANGE)!!");
        f.a(preference);
        Preference preference2 = this.findPreference((CharSequence)"preferences_minimum_speed");
        k.e((Object)preference2);
        k.f((Object)preference2, "findPreference(Constants.PREF_MINIMUM_SPEED)!!");
        f.a(preference2);
        Preference preference3 = this.findPreference((CharSequence)"preferences_maximum_speed");
        k.e((Object)preference3);
        k.f((Object)preference3, "findPreference(Constants.PREF_MAXIMUM_SPEED)!!");
        f.a(preference3);
        Preference preference4 = this.findPreference((CharSequence)"preferences_pitch_range");
        k.e((Object)preference4);
        k.f((Object)preference4, "findPreference(Constants.PREF_PITCH_RANGE)!!");
        f.a(preference4);
    }
}

