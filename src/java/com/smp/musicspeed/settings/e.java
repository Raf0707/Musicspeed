/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.d
 *  androidx.preference.ListPreference
 *  androidx.preference.Preference
 *  androidx.preference.Preference$d
 *  androidx.preference.g
 *  androidx.preference.j
 *  f.u.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 */
package com.smp.musicspeed.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.j;
import com.jaredrummler.android.colorpicker.ColorPreferenceCompat;
import com.michaelflisar.gdprdialog.c;
import com.michaelflisar.gdprdialog.d;
import com.smp.musicspeed.k0.z;
import com.smp.musicspeed.settings.a;
import com.smp.musicspeed.settings.b;
import com.smp.musicspeed.settings.f;
import com.smp.musicspeed.utils.g;
import com.smp.musicspeed.utils.t;
import com.wnafee.vector.compat.ResourcesCompat;
import f.u.l;
import f.z.d.k;
import java.util.Iterator;

public final class e
extends androidx.preference.g {
    private final void t() {
        Preference preference = this.findPreference((CharSequence)"consent");
        k.e((Object)preference);
        k.f((Object)preference, "findPreference<Preference>(\"consent\")!!");
        d d2 = c.e().d().a();
        d[] arrd = new d[]{d.i, d.h, d.f};
        if (!l.g((Object[])arrd).contains((Object)d2)) {
            preference.setVisible(false);
            return;
        }
        preference.setOnPreferenceClickListener((Preference.d)new a(this));
    }

    private static final boolean u(e e2, Preference preference) {
        k.g((Object)e2, "this$0");
        c.e().h();
        String string = e2.getString(2131820881);
        k.f(string, "getString(R.string.gdpr_withdraw_consent)");
        Context context = e2.requireContext();
        k.f((Object)context, "requireContext()");
        z.n(string, context, 0, 2, null);
        return true;
    }

    public static /* synthetic */ boolean w(e e2, Preference preference) {
        return e.u(e2, preference);
    }

    public static /* synthetic */ boolean x(SharedPreferences sharedPreferences, e e2, Preference preference) {
        return e.z(sharedPreferences, e2, preference);
    }

    private final void y() {
        SharedPreferences sharedPreferences = j.b((Context)this.requireContext());
        Preference preference = this.findPreference((CharSequence)"preferences_store_path");
        k.e((Object)preference);
        preference.setOnPreferenceClickListener((Preference.d)new b(sharedPreferences, this));
    }

    private static final boolean z(SharedPreferences sharedPreferences, e e2, Preference preference) {
        k.g((Object)e2, "this$0");
        c.h.a.a.P(sharedPreferences.getString("preferences_store_path", g.g(t.i(e2.requireContext())).getAbsolutePath())).M(e2.requireActivity().R(), "directoryDialog");
        return true;
    }

    public void onCreatePreferences(Bundle bundle, String string) {
        this.addPreferencesFromResource(2132017159);
        Preference preference = this.findPreference((CharSequence)"preferences_theme");
        k.e((Object)preference);
        k.f((Object)preference, "findPreference(Constants.PREF_THEME)!!");
        f.a(preference);
        Preference preference2 = this.findPreference((CharSequence)"preferences_seek");
        k.e((Object)preference2);
        k.f((Object)preference2, "findPreference(Constants.PREF_SEEK)!!");
        f.a(preference2);
        Preference preference3 = this.findPreference((CharSequence)"uiWaveform");
        k.e((Object)preference3);
        k.f((Object)preference3, "findPreference(Constants.PREF_WAVEFORM_MODE)!!");
        f.a(preference3);
        Preference preference4 = this.findPreference((CharSequence)"preferences_file_kbps");
        k.e((Object)preference4);
        k.f((Object)preference4, "findPreference(Constants.PREF_FILE_KBPS)!!");
        f.a(preference4);
        Preference preference5 = this.findPreference((CharSequence)"preferences_store_path");
        k.e((Object)preference5);
        k.f((Object)preference5, "findPreference(Constants.PREF_DIRECTORY)!!");
        f.a(preference5);
        Preference preference6 = this.findPreference((CharSequence)"preferences_file_type");
        k.e((Object)preference6);
        k.f((Object)preference6, "findPreference(Constants.PREF_FILE_TYPE)!!");
        f.a(preference6);
        Preference preference7 = this.findPreference((CharSequence)"preferences_recorder_kbps");
        k.e((Object)preference7);
        k.f((Object)preference7, "findPreference(Constants.PREF_RECORDER_KBPS)!!");
        f.a(preference7);
        this.y();
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.g((Object)view, "view");
        super.onViewCreated(view, bundle);
        if (t.w(this.requireContext())) {
            this.setDivider(ResourcesCompat.getDrawable((Context)this.requireActivity(), 2131231026));
        } else {
            this.setDivider(ResourcesCompat.getDrawable((Context)this.requireActivity(), 2131231027));
        }
        if (!z.c()) {
            CharSequence[] arrcharSequence = this.getResources().getStringArray(2130903055);
            k.f(arrcharSequence, "resources.getStringArray(R.array.entries_theme_old)");
            Preference preference = this.findPreference((CharSequence)"preferences_theme");
            k.e((Object)preference);
            k.f((Object)preference, "findPreference<ListPreference>(Constants.PREF_THEME)!!");
            ((ListPreference)preference).o(arrcharSequence);
            Preference preference2 = this.findPreference((CharSequence)"preferences_accent_color_dark");
            k.e((Object)preference2);
            k.f((Object)preference2, "findPreference<Preference>(PREF_ACCENT_COLOR_DARK)!!");
            Preference preference3 = this.findPreference((CharSequence)"preferences_accent_color");
            k.e((Object)preference3);
            k.f((Object)preference3, "findPreference<ColorPreferenceCompat>(PREF_ACCENT_COLOR)!!");
            ColorPreferenceCompat colorPreferenceCompat = (ColorPreferenceCompat)preference3;
            preference2.setVisible(false);
            colorPreferenceCompat.setTitle((CharSequence)this.getResources().getString(2131821193));
        }
        this.t();
        this.v();
    }

    public final void v() {
        Preference preference = this.findPreference((CharSequence)"preferences_file_type");
        k.e((Object)preference);
        boolean bl = k.c(((ListPreference)preference).m(), "mp3");
        Object[] arrobject = new Preference[2];
        Preference preference2 = this.findPreference((CharSequence)"preferences_file_kbps");
        k.e((Object)preference2);
        k.f((Object)preference2, "findPreference(Constants.PREF_FILE_KBPS)!!");
        arrobject[0] = preference2;
        Preference preference3 = this.findPreference((CharSequence)"preferences_maximum_file_quality");
        k.e((Object)preference3);
        k.f((Object)preference3, "findPreference(Constants.PREF_MAXIMUM_FILE_QUALITY)!!");
        arrobject[1] = preference3;
        Iterator iterator = l.g((Object[])arrobject).iterator();
        while (iterator.hasNext()) {
            ((Preference)iterator.next()).setEnabled(bl);
        }
    }
}

