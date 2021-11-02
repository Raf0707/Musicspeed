/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.preference.ListPreference
 *  androidx.preference.Preference
 *  androidx.preference.Preference$c
 *  androidx.preference.j
 *  b.i.o.a
 *  b.i.o.e
 *  b.i.o.f
 *  com.smp.musicspeed.settings.c
 *  f.z.d.k
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.smp.musicspeed.settings;

import android.content.Context;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.j;
import b.i.o.a;
import b.i.o.e;
import com.smp.musicspeed.settings.c;
import com.smp.musicspeed.utils.t;
import f.z.d.k;

public final class f {
    private static final Preference.c a = c.a;

    public static final void a(Preference preference) {
        k.g((Object)preference, (String)"preference");
        Preference.c c2 = a;
        preference.setOnPreferenceChangeListener(c2);
        c2.a(preference, (Object)j.b((Context)preference.getContext()).getString(preference.getKey(), ""));
    }

    public static /* synthetic */ boolean b(Preference preference, Object object) {
        return f.c(preference, object);
    }

    private static final boolean c(Preference preference, Object object) {
        String string2 = object.toString();
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference)preference;
            int n2 = listPreference.i(string2);
            if (n2 >= 0) {
                preference.setSummary((CharSequence)listPreference.j()[n2].toString());
                return true;
            }
        } else {
            if (k.c((Object)preference.getKey(), (Object)"preferences_store_path") && t.E(preference.getContext())) {
                preference.setSummary((CharSequence)a.c().k(string2, b.i.o.f.a, true));
            }
            preference.setSummary((CharSequence)string2);
        }
        return true;
    }
}

